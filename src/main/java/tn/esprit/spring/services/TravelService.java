package tn.esprit.spring.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import tn.esprit.spring.entity.Hotel;
import tn.esprit.spring.entity.News;
import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.entity.TravelProgram;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Value;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.repository.TravelAgencyRep;
import tn.esprit.spring.repository.TravelProgramRep;
import tn.esprit.spring.repository.TravelRep;
@Service
public class TravelService implements ITravelService {
@Autowired
TravelRep tR;
@Autowired
TravelAgencyRep taR ; 
@Autowired
TravelProgramRep tpR;
@Autowired
IUserRepository uR ;
	@Override
	public void addTravel(Travel h) {
		// TODO Auto-generated method stub
		
		tR.save(h);
	}

	@Override
	public void updateTravel(Travel h) {
		// TODO Auto-generated method stub
		tR.save(h);
	}

	@Override
	public void deleteTravel(Integer h) {
		// TODO Auto-generated method stub
		tR.deleteById(h);
	}

	@Override
	public List<Travel> afficherTravel() {
		// TODO Auto-generated method stub
		return (List<Travel>) tR.findAll();
	}

	@Override
	public void addTravelAgencyToTravel(Integer taID, Integer t) {
		// TODO Auto-generated method stub
		Travel t2 = tR.findById(t).orElse(null);
		TravelAgency ta = taR.findById(taID).orElse(null);
		t2.setTa(ta);
		tR.save(t2);
	}

	@Override
	public void addTravelProgramToTravel(Integer tpId , Integer t) {
		// TODO Auto-generated method stub
	Travel t2 = tR.findById(t).orElse(null);
	TravelProgram tp = tpR.findById(tpId).orElse(null);
	t2.setTp(tp);
	tR.save(t2); 
	}

	@Override
	public List<Travel> findTravelsByTravelAgency(Integer travelAgencyID) {
		// TODO Auto-generated method stub
		TravelAgency ta = taR.findById(travelAgencyID).orElse(null);
		return tR.findByTravelAgency(ta); 
	}

	@Override
	public List<Travel> findTravelsByTravelProgram(Integer travelProgramID) {
		// TODO Auto-generated method stub
		TravelProgram tp = tpR.findById(travelProgramID).orElse(null);
		return tR.findByTravelProgram(tp);
	}

	@Override
	public List<Travel> findTravelsByUser(Long UserID) {
		// TODO Auto-generated method stub
		User u = uR.findById(UserID).orElse(null);
		return tR.findTravelsByUser(u);
	}

	@Override
	public void addUserToTravel(Long UserId, Integer t) {
		Travel t2 = tR.findById(t).orElse(null);
		User u = uR.findById(UserId).orElse(null);
		List<User> lu = t2.getUsers();
		lu.add(u);
		t2.setUsers(lu);
		tR.save(t2);
		
	}

	@Override
	public Travel findTravelsByID(Integer travelID) {
		// TODO Auto-generated method stub
		return tR.findById(travelID).orElse(null);
	}

	@Override
	public HashSet<User> findTravelPartner(Long UserID , Integer travelID ) {
		User u = uR.findById(UserID).orElse(null);
		Travel t1 = tR.findById(travelID).orElse(null);
	
		List<Travel> t = tR.findTravelPartner(u.getDomaine().getName_d(),t1.getStartDate(), t1.getDestination());
		HashSet<User> partners = new HashSet<User>();
		for(Travel i : t )
		{
			
			partners.addAll(i.getUsers()); 
		}
		partners.remove(u);
		// TODO Auto-generated method stub
		return partners;
	}

	@Override
	public Long  Discount(Integer travelAgency) {
		// TODO Auto-generated method stub
	
		LocalDate localDate = LocalDate.now();
		LocalDate localDate2 =localDate.minusDays(30);
		LocalDate localDate3 =localDate2.minusDays(30);
		TravelAgency ta = taR.findById(travelAgency).orElse(null);
		int n1 = tR.findByTravelAgencyInMonthAgo(ta, localDate, localDate2).size();
		int n2 = tR.findByTravelAgencyInMonthAgo(ta,localDate2, localDate3).size();
		System.out.println(localDate);
		System.out.println(localDate2);
		System.out.println(localDate3);
		System.out.println(n1); 
		System.out.println(n2); 
		
		if(n1<(n2-(n2*30/100)))
		{
			mailling("abir.halouani@esprit.tn"," the number of travels of the Travel Agency "+ ta.getNomTravelAgency() + " is reduced more than 30% "
					+ "make a discount is a good idea to solve this problem ");
			//ta.setDiscount((long) -30);
			//taR.save(ta);
			return (long) -30 ;
			
		}
		else return (long) 0 ; 
		
	
	}

	@Override
	public String blockDestination() {
		
		HashSet<String> destinations = new HashSet<String>();
		for (Travel t : (List<Travel>) tR.findAll()) {
			destinations.add(t.getDestination());
		}
		
		 String url2 ="https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/search/TrendingNewsAPI?pageNumber=1&pageSize=10&withThumbnails=false&location=us";
		    RestTemplate restTemplate = new RestTemplate();
		    HttpHeaders headers=new HttpHeaders();
		    headers.add("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com");
		    headers.add("x-rapidapi-key", "77870dab2cmsh950e7229bf17507p158e87jsne665edaf9905");
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity=new HttpEntity<String>(headers);
		    for(Value i:restTemplate.exchange(url2,HttpMethod.GET,entity,News.class).getBody().getValue())
		    {
		    	if(i.body.toLowerCase().contains("war"));
		    	
		    	{

			    	for(String d : destinations)
			    	{ if(i.body.toLowerCase().contains(d.toLowerCase()))
			    	{
		    		//System.out.println(i.body);
		    		mailling("abir.halouani@esprit.tn","there is a war in "+d +" please block this destination ");
		    		return "war in "+d;
			    	}
			    	}
		    		
		    	}
		    	
		    
		    }
		    return "ok";
	

}
	
	
	
	

	public void mailling(String mail,String message) {
	    final String username = "noreplypidev4@gmail.com";
	    final String password = "Pidev123456";
	    String fromEmail = "noreplypidev4@gmail.com";
	    Properties properties = new Properties();
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "587");
	    Session session = Session.getInstance(properties,new Authenticator() {
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username,password);
	        }
	    });
	    MimeMessage msg = new MimeMessage(session);
	    try {
	        msg.setFrom(new InternetAddress(fromEmail));
	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
	        msg.setSubject("Information");
	        Multipart emailContent = new MimeMultipart();
	        MimeBodyPart textBodyPart = new MimeBodyPart();
	        textBodyPart.setText(message);
	        emailContent.addBodyPart(textBodyPart);
	        msg.setContent(emailContent);
	        Transport.send(msg);
	        System.out.println("Sent message");
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void block(String destination2)
	{
		List<Travel> t = tR.block(destination2);
		for(Travel t2 : t)
		{
			t2.setStatus("Canceled");
			tR.save(t2);
			for(User u : t2.getUsers())
			{
				mailling(u.getEmail()," your travel is canceled for security problem in the destination ");
			}
			
		}
		
	}
	
	@Override
	public  List<Object[]> statistic  () {
		
		 List<Object[]> s = tR.countDestinationByDomainUser();
		
		
		return s;
	}

}
