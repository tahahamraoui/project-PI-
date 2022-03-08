package tn.esprit.spring.services;
import com.itextpdf.text.BaseColor;
import java.io.IOException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import java.io.FileOutputStream;
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
import java.io.FileNotFoundException;
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
	
	
	@Override
	public void Userpdf(long idUser) {
		try {
			User f = myRepository.findById(idUser).get();
			System.out.println("aa"+f);
	
			List<User> cities = (List<User>) myRepository.findAll();

			System.out.println("ttttttttttttt" + cities);
			String file_name=null;
			file_name="C:/Users/tahat/Documents/GitHub/project-PIdiv/src/test/java/tn/esprit/spring" + idUser + ".pdf";
			Document document = new Document(PageSize.A4, 15, 15, 45, 30);

			PdfWriter.getInstance(document, new FileOutputStream(file_name));

			document.open();
		
			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------------"));
			//////////////////////////// pdfDetailFournisseur
			Font font = FontFactory.getFont("Cooper Black", 15, BaseColor.BLUE);
			
			Font mainFont = FontFactory.getFont("Cooper Black", 35, BaseColor.BLACK);
			Paragraph para = new Paragraph("Detail Fournisseur N° " + f.getIdUser(), mainFont);
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
		
			PdfPTable table2 = new PdfPTable(4);
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
			PdfPCell Idfournisseur = new PdfPCell(new Paragraph("identifiant Fournisseur", tableHeader));
			Idfournisseur.setBorderColor(BaseColor.BLACK);
			Idfournisseur.setPaddingLeft(10);
			Idfournisseur.setHorizontalAlignment(Element.ALIGN_CENTER);
			Idfournisseur.setVerticalAlignment(Element.ALIGN_CENTER);
			Idfournisseur.setBackgroundColor(BaseColor.LIGHT_GRAY);
			Idfournisseur.setExtraParagraphSpace(5f);
			table2.addCell(Idfournisseur);

			PdfPCell Codefournisseur = new PdfPCell(new Paragraph("Code Fournisseur", tableHeader));
			Codefournisseur.setBorderColor(BaseColor.BLACK);
			Codefournisseur.setPaddingLeft(10);
			Codefournisseur.setHorizontalAlignment(Element.ALIGN_CENTER);
			Codefournisseur.setVerticalAlignment(Element.ALIGN_CENTER);
			Codefournisseur.setBackgroundColor(BaseColor.LIGHT_GRAY);
			Codefournisseur.setExtraParagraphSpace(5f);
			table2.addCell(Codefournisseur);
			
			PdfPCell numerofournisseur = new PdfPCell(new Paragraph("Numéro Fournisseur", tableHeader));
			numerofournisseur.setBorderColor(BaseColor.BLACK);
			numerofournisseur.setPaddingLeft(10);
			numerofournisseur.setHorizontalAlignment(Element.ALIGN_CENTER);
			numerofournisseur.setVerticalAlignment(Element.ALIGN_CENTER);
			numerofournisseur.setBackgroundColor(BaseColor.LIGHT_GRAY);
			numerofournisseur.setExtraParagraphSpace(5f);
			table2.addCell(numerofournisseur);

			PdfPCell Libellefournisseur = new PdfPCell(new Paragraph("Libelle Fournisseur", tableHeader));
			Libellefournisseur.setBorderColor(BaseColor.BLACK);
			Libellefournisseur.setPaddingLeft(10);
			Libellefournisseur.setHorizontalAlignment(Element.ALIGN_CENTER);
			Libellefournisseur.setVerticalAlignment(Element.ALIGN_CENTER);
			Libellefournisseur.setBackgroundColor(BaseColor.LIGHT_GRAY);
			Libellefournisseur.setExtraParagraphSpace(5f);
			table2.addCell(Libellefournisseur);

			PdfPCell Idfournisseur1 = new PdfPCell(
					new Paragraph(String.valueOf(f.getIdUser()), tableHeader));
			Idfournisseur1.setBorderColor(BaseColor.BLACK);
			Idfournisseur1.setPaddingLeft(10);
			Idfournisseur1.setHorizontalAlignment(Element.ALIGN_CENTER);
			Idfournisseur1.setVerticalAlignment(Element.ALIGN_CENTER);
			Idfournisseur1.setBackgroundColor(BaseColor.WHITE);
			Idfournisseur1.setExtraParagraphSpace(5f);
			table2.addCell(Idfournisseur1);

			PdfPCell Codefournisseur1 = new PdfPCell(
					new Paragraph(String.valueOf(f.getEmail()), tableHeader));
			Codefournisseur1.setBorderColor(BaseColor.BLACK);
			Codefournisseur1.setPaddingLeft(10);
			Codefournisseur1.setHorizontalAlignment(Element.ALIGN_CENTER);
			Codefournisseur1.setVerticalAlignment(Element.ALIGN_CENTER);
			Codefournisseur1.setBackgroundColor(BaseColor.WHITE);
			Codefournisseur1.setExtraParagraphSpace(5f);
			table2.addCell(Codefournisseur1);

			
			
			PdfPCell numerofournisseur1 = new PdfPCell(
					new Paragraph(String.valueOf(f.getName()), tableHeader));
			numerofournisseur1.setBorderColor(BaseColor.BLACK);
			numerofournisseur1.setPaddingLeft(10);
			numerofournisseur1.setHorizontalAlignment(Element.ALIGN_CENTER);
			numerofournisseur1.setVerticalAlignment(Element.ALIGN_CENTER);
			numerofournisseur1.setBackgroundColor(BaseColor.WHITE);
			numerofournisseur1.setExtraParagraphSpace(5f);
			table2.addCell(numerofournisseur1);
			
			
			PdfPCell Libellefournisseur1 = new PdfPCell(
					new Paragraph(String.valueOf(f.getTelephone()), tableHeader));
			Libellefournisseur1.setBorderColor(BaseColor.BLACK);
			Libellefournisseur1.setPaddingLeft(10);
			Libellefournisseur1.setHorizontalAlignment(Element.ALIGN_CENTER);
			Libellefournisseur1.setVerticalAlignment(Element.ALIGN_CENTER);
			Libellefournisseur1.setBackgroundColor(BaseColor.WHITE);
			Libellefournisseur1.setExtraParagraphSpace(5f);
			table2.addCell(Libellefournisseur1);

		

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
	}
	
	


