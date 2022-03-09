package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "Question")
public class Question implements Serializable {
	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idQuestion")
	private int idQuestion;
	private String Text;
	@OneToMany(mappedBy="question")
	private Set<Reponse> responses;
    @ManyToOne
    @JoinColumn(name="quiz_id", nullable=true)
    private Quiz quizzz;

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", Text=" + Text + "]";
	}
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public Question(int idQuestion, String text) {
		super();
		this.idQuestion = idQuestion;
		Text = text;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

}
