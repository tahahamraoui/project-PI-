package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Quiz;
import tn.esprit.spring.entity.Reclamation;

public interface IQuizService {
	List<Quiz> retrieveAllQuiz();
	Quiz addQuiz(Quiz c);
	void deleteQuiz(int idQ);
	Quiz updateidQuiz(Quiz c);
	Quiz retrieveidQuiz(int idQ);
	
}
