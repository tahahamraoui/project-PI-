package tn.esprit.spring.services;





import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository myRepository ;
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public List<User> retrieveAllUsers() {
		List<User> c = (List<User>) myRepository.findAll();
		return c;
	}
	@Override
	public User addUser(User c) throws UnsupportedEncodingException, MessagingException{
		sendVerificationEmail(c);
		c.setDatecreated(LocalDateTime.now());
		return myRepository.save(c);
	}
	@Override
	public void deleteUser(Long id){
		myRepository.deleteById(id);
	}
	@Override
	public User updateUser(User c){
		//c.setDatecreated(LocalDateTime.now());
		return myRepository.save(c);
	}
	
	@Override
	public User retrieveUser(Long id){
		Optional<User> c = myRepository.findById(id);
		User c1 = c.get();
		return c1;
	}
	@Override
	public boolean verifyEmailToken(Long id) {
		boolean returnValue = false;
		// find user by token
		User userEntity = myRepository.findById(id).orElse(null);
		
		if(userEntity!=null) {
			
			
			
				userEntity.setEmailVerificationStatus(Boolean.TRUE);
				myRepository.save(userEntity);
				returnValue= true;
			}
		
		return returnValue;
	}
	
	public void sendVerificationEmail (User user) throws UnsupportedEncodingException, MessagingException{
		String subject = "Please Verify your registration";
		String senderName = "travencycompanie App Team";
		String mailContent = "<p>Dear " + user.getName()  + ",</p>";
		mailContent += "<p> please check the link below to verify your email : </p>";
		String verifyURL = "http://localhost:8089/SpringMVC/User/email-verification?id="+user.getIdUser();
		
		mailContent += "<h2><a href=" + verifyURL + ">Verify your account</a></h2>";
		
		mailContent += "<p> Thank you<br> travencycompanie App Team</p>";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("travencycompanie@gmail.com", senderName);
		helper.setTo(user.getEmail());
		helper.setSubject(subject);
		helper.setText(mailContent, true);
		
		mailSender.send(message);
		System.out.println("email sent");
		
	}
	}
	
	


