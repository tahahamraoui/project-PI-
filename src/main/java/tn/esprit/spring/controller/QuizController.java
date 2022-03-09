package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Quiz;
import tn.esprit.spring.services.QuizService;


@Api(tags = "Quiz management")
@RestController
@RequestMapping("/Quiz")
public class QuizController {
	@Autowired 
	QuizService QuizService;
	
	@ApiOperation(value = "Récupérer la liste des Quizs")
	@GetMapping("/retrieve-all-Quiz")
	@ResponseBody
	public List<Quiz> getQuiz(){
		return QuizService.retrieveAllQuiz();
	} 
	 
	@ApiOperation(value = "Récupérer un ")
	@GetMapping("/retrieve-Quiz/{Quiz-id}")
	@ResponseBody
	public Quiz getClient(@PathVariable("Quiz-id") int idQuiz){
		return QuizService.retrieveidQuiz(idQuiz);
	}
	
	@ApiOperation(value = "Ajouter un Quiz")
	@PostMapping("/add-Quiz")
	@ResponseBody
	public Quiz addQuizt(@RequestBody Quiz c){
		return QuizService.addQuiz(c);
	}
	
	@ApiOperation(value = "Supprimer un Quizt")
	@DeleteMapping("/delete-Quiz/{id-Quiz}")
	@ResponseBody
	public void deleteQuiz(@PathVariable("id-Quiz") int idQuiz){
		QuizService.deleteQuiz(idQuiz);
	}
	
	@ApiOperation(value = "Modifier un Quiz")
	@PutMapping("/modify-Quiz")
	@ResponseBody
	public Quiz modQuiz (@RequestBody Quiz c){
		return QuizService.addQuiz(c);
	}
	

}
