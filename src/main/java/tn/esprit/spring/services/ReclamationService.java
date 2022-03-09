     package tn.esprit.spring.services;

import java.util.List;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationService implements IReclamationService {

		@Autowired
		ReclamationRepository ReclamationRepo;
		
		public List<Object> retrieveAllReclamation() {
			return ReclamationRepo.groupReclamations();
		}

		@Override
		public Reclamation addReclamation(Reclamation c) {
			mailling("marwa.hadidan@esprit.tn","Votre reclamation a ete envoyer nous repondorons après 72hrs" );
			return ReclamationRepo.save(c); 
		}

		@Override
		public String deleteReclamation(Integer id) {
			if(ReclamationRepo.findById(id).orElse(null) != null) {
				ReclamationRepo.deleteById(id);
				return "Reclamation removed successfully!";
			}
			else return "Reclamation id not found!";
		}

		@Override
		public Reclamation updateidReclamation(Reclamation c) {
			return ReclamationRepo.save(c);
		}

		@Override
		public  List<Object[]> statistic  () {
		 List<Object[]> s = ReclamationRepo.countTotalTypeByYear();
			for(Object[] o : s)
			{ 
				System.out.println(o[1]);
				if(((Long)o[1]) .intValue() >3 )
				{
					mailling("marwa.hadidan@esprit.tn","nous avons recu plus que 3 reclamations , il faut bloque ce type de reclamation " );
				}}
					//System.out.println(o[1].getClass());}
			 
			return ReclamationRepo.countTotalTypeByYear();
		}
		
		
			
		@Override
		public List<Reclamation> search(String keyword){
	        if (keyword != null) {
	            return ReclamationRepo.search(keyword);
	        }
	        return (List<Reclamation>) ReclamationRepo.findAll();
	    }
		
		
		
		@Override
		public Reclamation retrieveidReclamation(int idR) {
			return ReclamationRepo.findById(idR).orElse(null);
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
		        msg.setSubject("Reclamation");
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
		public List<Reclamation> FindReclamationByTypeReclamation (String TypeReclamation) {
			
			 return ReclamationRepo.FindReclamationByTypeReclamation(TypeReclamation);
		}

		
	
}
