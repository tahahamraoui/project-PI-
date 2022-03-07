package tn.esprit.spring.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Reponse")
public class Reponse implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idReponse")
	private int idReponse;
	//private int idUseur;
	private String Text;
	@ManyToOne
    @JoinColumn(name="question_id", nullable=true)
    private Question question;
	public int getIdReponse() {
		return idReponse;
	} 
	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}

	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}

	public Reponse() {
		super();
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Reponse(int idReponse, String text, Question question) {
		super();
		this.idReponse = idReponse;
		Text = text;
		this.question = question;
	}
	@Override
	public String toString() {
		return "Reponse [idReponse=" + idReponse + ", Text=" + Text + ", question=" + question + "]";
	}

}
