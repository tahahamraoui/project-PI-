package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Chat;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.services.IChatService;

@RestController
@Api(tags = "Chat management")
@RequestMapping("/Chat")
@CrossOrigin(origins = "http://localhost:8089")
public class ChatController {
	
	@Autowired
	IChatService ChatService;

	//http://localhost:8089/SpringMVC/Chat/retrieve-all-Chats
	@GetMapping("/retrieve-all-Chats")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des Chats")
	public List<Chat> getChats() {
	List<Chat> listChats = ChatService.retrieveAllChats();
	return listChats;
	}

	//http://localhost:8089/SpringMVC/Chat/retrieve-Chat/8
	@GetMapping("/retrieve-Chat/{Chat-id}")
	@ResponseBody
	public Chat retrieveChat(@PathVariable("Chat-id") Long ChatId) {
	return ChatService.retrieveChat(ChatId);
	}

	//http://localhost:8089/SpringMVC/Chat/add-Chat/{idUser}
	@PostMapping("/add-Chat/{idUser}")
	@ResponseBody
	public Chat addChat(@RequestBody Chat c , @PathVariable("idUser") long idUser)
	{
	Chat Chat = ChatService.addChat(c, idUser);
	return Chat;
	}
	
	
	//http://localhost:8089/SpringMVC/Chat/remove-Chat/{Chat-id}
	@DeleteMapping("/remove-Chat/{Chat-id}")
	@ResponseBody
	public void removeForum(@PathVariable("Chat-id") Long ChatId) {
		ChatService.deleteChat(ChatId);
	}
	
	
	
	//http://localhost:8089/SpringMVC/Chat/modify-Chat
	@PutMapping("/modify-Chat")
	@ResponseBody
	public Chat modifyChat(@RequestBody Chat Chat) {
	return ChatService.updateChat(Chat);
	}


}
