package tn.esprit.spring.entity;

import java.util.List;

public class QuestionsWithReponses {
private Question question;
private List<Reponse> reponses;
public Question getQuestion() {
	return question;
}
public void setQuestion(Question question) {
	this.question = question;
}
public List<Reponse> getReponses() {
	return reponses;
}
public void setReponses(List<Reponse> reponses) {
	this.reponses = reponses;
}
@Override
public String toString() {
	return "QuestionsWithReponses [question=" + question + ", reponses=" + reponses + "]";
}
public QuestionsWithReponses(Question question, List<Reponse> reponses) {
	super();
	this.question = question;
	this.reponses = reponses;
}
public QuestionsWithReponses() {
	super();
	// TODO Auto-generated constructor stub
}

}
