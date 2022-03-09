package tn.esprit.spring.controller;
import java.util.ArrayList;
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

import tn.esprit.spring.entity.Question;
import tn.esprit.spring.entity.QuestionsWithReponses;
import tn.esprit.spring.services.QuestionService;

@RequestMapping("Question/")
@RestController
public class QuestionController {
    @Autowired
    QuestionService avServ;

    @PostMapping("/addQuestion")
    public Question addQuestion(@RequestBody Question b) {
    	return avServ.addQuestion(b);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deletQuestion(@PathVariable String id) {
    	
       return avServ.deleteQuestion(Integer.parseInt(id));
    }

    @PutMapping("/updateQuestion")
    public Question updateQuestion(@RequestBody Question b) {
        return avServ.updateidQuestion(b);
    }

    @GetMapping("/getQuestionList")
    public ArrayList<Question> getQuestionList() {
        return (ArrayList<Question>) avServ.retrieveAllQuestion();
    }


    @GetMapping("/getQuestion/{id}")
    public QuestionsWithReponses getQuestionbyId(@PathVariable int id) {
        return avServ.questionsAndReponses(id);
    }
    
    @GetMapping("/getQuestionsList")
	@ResponseBody
    public List<Object[]> getQuestionsAndResponseNumbers() {
        return avServ.ListerLesReponseByQuestions();
    }
/* 
    @GetMapping("/getQuantity/{id}")
    public int getQuantity(@PathVariable int id) {
        return avServ.getQuantity(id);
    }*/ 

}