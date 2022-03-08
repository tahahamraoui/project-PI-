package tn.esprit.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Chat;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ChatRepository;
import tn.esprit.spring.repository.UserRepository;



@Service
public class ChatService implements IChatService {
	@Autowired
	ChatRepository myRepository ;
	@Autowired
	UserRepository myRepositoryuser ;
	
	@Override
	public List<Chat> retrieveAllChats() {
		List<Chat> c = (List<Chat>) myRepository.findAll();
		return c;
	}
	//@Override
	//public Chat addChat(Chat c){
		//return myRepository.save(c);
		
	//}
	
	@Override
	public Chat addChat(Chat c , long idUser){
		
		List<String> content = new ArrayList<String>();
		BufferedReader reader;
		String line = null ;
		
		try {
			reader = new BufferedReader(new FileReader("C:/Users/tahat/Documents/GitHub/project-PIdiv/src/test/java/tn/esprit/spring/bad_word.txt"));
			line = reader.readLine();
			while ( line != null){
				if (c.getMessage().contains(line)){
					content.add(line);
					System.out.println("you are using bad words");
					System.out.println(content);
				}
				// read next line 
				line = reader.readLine();
			}
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
			
		if (content.size() > 0 ){
			return null ;
			
		}
		else {
			User p=myRepositoryuser.findById(idUser).orElse(null);
			
			Chat C=myRepository.save(c);
			
			C.setDatecreated(LocalDateTime.now());
			C.setUser(p);
			return myRepository.save(C); 
		}
		}
	
	@Override
	public void deleteChat(Long id){
		myRepository.deleteById(id);
	}
	@Override
	public Chat updateChat(Chat c){
		return myRepository.save(c);
	}
	
	@Override
	public Chat retrieveChat(Long id){
		Optional<Chat> c = myRepository.findById(id);
		Chat c1 = c.get();
		return c1;
	}

}
