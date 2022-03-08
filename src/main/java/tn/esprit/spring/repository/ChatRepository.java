package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Chat;

public interface ChatRepository extends CrudRepository <Chat, Long> {


}
