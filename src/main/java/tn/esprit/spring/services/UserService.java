package tn.esprit.spring.services;





import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
	// PDF Personnalisé
	@Override
		public void userpdf(long User_Id) {
			try {
				User e = myRepository.findById(User_Id).get();
				System.out.println("aa"+e);
		
				List<User> cities = (List<User>) myRepository.findAll();

				System.out.println("ttttttttttttt" + cities);
				String file_name=null;
				file_name="C:/Users/tahat/Documents/GitHub/project-PIdiv/src/test/java/tn/esprit/spring/" + User_Id + ".pdf";
				Document document = new Document(PageSize.A4, 15, 15, 45, 30);

				PdfWriter.getInstance(document, new FileOutputStream(file_name));

				document.open();
			
				document.add(new Paragraph(
						"----------------------------------------------------------------------------------------------------------------------------------------"));
				//////////////////////////// pdf
				Font font = FontFactory.getFont("Cooper Black", 15, BaseColor.BLUE);
				
				Font mainFont = FontFactory.getFont("Cooper Black", 35, BaseColor.BLACK);
				Paragraph para = new Paragraph("Detail User N° " + e.getIdUser(), mainFont);
				para.setAlignment(Element.ALIGN_CENTER);
				para.setIndentationLeft(10);
				para.setIndentationRight(10);
				para.setSpacingAfter(10);
				document.add(para);
				document.add(new Paragraph(
						"----------------------------------------------------------------------------------------------------------------------------------------"));
				document.add(new Paragraph(" "));
				document.add(new Paragraph(" "));

				///////////////////
			
				PdfPTable table2 = new PdfPTable(6);
				Font tableHeader = FontFactory.getFont("Arial", 10, BaseColor.BLACK);
				Font tableBody = FontFactory.getFont("Arial", 9, BaseColor.BLACK);
				PdfPCell name = new PdfPCell(new Paragraph("Quantite", tableHeader));
				name.setBorderColor(BaseColor.BLACK);
				name.setPaddingLeft(10);
				name.setHorizontalAlignment(Element.ALIGN_CENTER);
				name.setVerticalAlignment(Element.ALIGN_CENTER);
				name.setBackgroundColor(BaseColor.LIGHT_GRAY);
				name.setExtraParagraphSpace(5f);
				

				

				

				
				/////////////////////////////
				/////////////////////////////
				/////////////////////////////
				////////////////////////////
				for (User c : cities) {
				;

					
				}

				/////////////////////////////////
				PdfPCell user_Id = new PdfPCell(new Paragraph("identifiant User", tableHeader));
				user_Id.setBorderColor(BaseColor.BLACK);
				user_Id.setPaddingLeft(10);
				user_Id.setHorizontalAlignment(Element.ALIGN_CENTER);
				user_Id.setVerticalAlignment(Element.ALIGN_CENTER);
				user_Id.setBackgroundColor(BaseColor.LIGHT_GRAY);
				user_Id.setExtraParagraphSpace(5f);
				table2.addCell(user_Id);

				PdfPCell UserName = new PdfPCell(new Paragraph("UserName", tableHeader));
				UserName.setBorderColor(BaseColor.BLACK);
				UserName.setPaddingLeft(10);
				UserName.setHorizontalAlignment(Element.ALIGN_CENTER);
				UserName.setVerticalAlignment(Element.ALIGN_CENTER);
				UserName.setBackgroundColor(BaseColor.LIGHT_GRAY);
				UserName.setExtraParagraphSpace(5f);
				table2.addCell(UserName);
				
				PdfPCell DateNaissance = new PdfPCell(new Paragraph("DateNaissance", tableHeader));
				DateNaissance.setBorderColor(BaseColor.BLACK);
				DateNaissance.setPaddingLeft(10);
				DateNaissance.setHorizontalAlignment(Element.ALIGN_CENTER);
				DateNaissance.setVerticalAlignment(Element.ALIGN_CENTER);
				DateNaissance.setBackgroundColor(BaseColor.LIGHT_GRAY);
				DateNaissance.setExtraParagraphSpace(5f);
				table2.addCell(DateNaissance);

				PdfPCell Email = new PdfPCell(new Paragraph("Email", tableHeader));
				Email.setBorderColor(BaseColor.BLACK);
				Email.setPaddingLeft(10);
				Email.setHorizontalAlignment(Element.ALIGN_CENTER);
				Email.setVerticalAlignment(Element.ALIGN_CENTER);
				Email.setBackgroundColor(BaseColor.LIGHT_GRAY);
				Email.setExtraParagraphSpace(5f);
				table2.addCell(Email);
				
				PdfPCell PhoneNumber = new PdfPCell(new Paragraph("PhoneNumber", tableHeader));
				PhoneNumber.setBorderColor(BaseColor.BLACK);
				PhoneNumber.setPaddingLeft(10);
				PhoneNumber.setHorizontalAlignment(Element.ALIGN_CENTER);
				PhoneNumber.setVerticalAlignment(Element.ALIGN_CENTER);
				PhoneNumber.setBackgroundColor(BaseColor.LIGHT_GRAY);
				PhoneNumber.setExtraParagraphSpace(5f);
				table2.addCell(PhoneNumber);
				
				
				PdfPCell Address = new PdfPCell(new Paragraph("Address", tableHeader));
				Address.setBorderColor(BaseColor.BLACK);
				Address.setPaddingLeft(10);
				Address.setHorizontalAlignment(Element.ALIGN_CENTER);
				Address.setVerticalAlignment(Element.ALIGN_CENTER);
				Address.setBackgroundColor(BaseColor.LIGHT_GRAY);
				Address.setExtraParagraphSpace(5f);
				table2.addCell(Address);

				PdfPCell User_Id1  = new PdfPCell(
						new Paragraph(String.valueOf(e.getIdUser()), tableHeader));
				User_Id1.setBorderColor(BaseColor.BLACK);
				User_Id1.setPaddingLeft(10);
				User_Id1.setHorizontalAlignment(Element.ALIGN_CENTER);
				User_Id1.setVerticalAlignment(Element.ALIGN_CENTER);
				User_Id1.setBackgroundColor(BaseColor.WHITE);
				User_Id1.setExtraParagraphSpace(5f);
				table2.addCell(User_Id1);

				PdfPCell UserName1 = new PdfPCell(
						new Paragraph(String.valueOf(e.getName()), tableHeader));
				UserName1.setBorderColor(BaseColor.BLACK);
				UserName1.setPaddingLeft(10);
				UserName1.setHorizontalAlignment(Element.ALIGN_CENTER);
				UserName1.setVerticalAlignment(Element.ALIGN_CENTER);
				UserName1.setBackgroundColor(BaseColor.WHITE);
				UserName1.setExtraParagraphSpace(5f);
				table2.addCell(UserName1);

				
				
				PdfPCell DateNaissance1 = new PdfPCell(
						new Paragraph(String.valueOf(e.getDatecreated()), tableHeader));
				DateNaissance1.setBorderColor(BaseColor.BLACK);
				DateNaissance1.setPaddingLeft(10);
				DateNaissance1.setHorizontalAlignment(Element.ALIGN_CENTER);
				DateNaissance1.setVerticalAlignment(Element.ALIGN_CENTER);
				DateNaissance1.setBackgroundColor(BaseColor.WHITE);
				DateNaissance1.setExtraParagraphSpace(5f);
				table2.addCell(DateNaissance1);
				
				
				PdfPCell Email1 = new PdfPCell(
						new Paragraph(String.valueOf(e.getEmail()), tableHeader));
				Email1.setBorderColor(BaseColor.BLACK);
				Email1.setPaddingLeft(10);
				Email1.setHorizontalAlignment(Element.ALIGN_CENTER);
				Email1.setVerticalAlignment(Element.ALIGN_CENTER);
				Email1.setBackgroundColor(BaseColor.WHITE);
				Email1.setExtraParagraphSpace(5f);
				table2.addCell(Email1);

			
				PdfPCell PhoneNumber1 = new PdfPCell(
						new Paragraph(String.valueOf(e.getTelephone()), tableHeader));
				 PhoneNumber1.setBorderColor(BaseColor.BLACK);
				 PhoneNumber1.setPaddingLeft(10);
				 PhoneNumber1.setHorizontalAlignment(Element.ALIGN_CENTER);
				 PhoneNumber1.setVerticalAlignment(Element.ALIGN_CENTER);
				 PhoneNumber1.setBackgroundColor(BaseColor.WHITE);
				 PhoneNumber1.setExtraParagraphSpace(5f);
				table2.addCell( PhoneNumber1);
				
				
				PdfPCell Address1 = new PdfPCell(
						new Paragraph(String.valueOf(e.getRole()), tableHeader));
				Address1.setBorderColor(BaseColor.BLACK);
				Address1.setPaddingLeft(10);
				Address1.setHorizontalAlignment(Element.ALIGN_CENTER);
				Address1.setVerticalAlignment(Element.ALIGN_CENTER);
				Address1.setBackgroundColor(BaseColor.WHITE);
				Address1.setExtraParagraphSpace(5f);
				table2.addCell(Address1);

				document.add(new Paragraph("  "));

				document.add(table2);
				document.add(new Paragraph("  "));
				document.add(new Paragraph("  "));

				document.add(new Paragraph(
						"----------------------------------------------------------------------------------------------------------------------------------------"));
				document.add(new Paragraph("  "));
				document.add(new Paragraph("  "));

				document.add(new Paragraph("Téléphone  :(+216) 72 000 000   "
						+ "                                                             Adresse : Ariana "));
				document.add(new Paragraph("Fax          :(+216) 72 000 000   "
						+ "                                                                                      Code Postal :4000  "));
				document.add(new Paragraph("Email       :travencycompanie@gmail.com  "));

				document.close();
			} catch (FileNotFoundException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	@Override
	public List<User> FindOfferBySujet(String email) {
		return myRepository.FindOfferBySujet(email);
		
	}
	@Override
	public List<Object[]> statistic() {
		return myRepository.countTotalTypeByYear();
	}
	

	}
	
	


