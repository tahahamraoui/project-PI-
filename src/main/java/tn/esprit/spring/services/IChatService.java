package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;
import tn.esprit.spring.entity.Chat;

public interface IChatService {
	List<Chat> retrieveAllChats();
	Chat addChat(Chat c, long idUser);
	void deleteChat(Long id);
	Chat updateChat(Chat c);
	Chat retrieveChat(Long id); 


}
