package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Quiz")
public class Quiz implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idQ")
	private int idQ;
	
	@OneToOne(mappedBy="quiz")
	private Avis avis ;
	
    @OneToMany(mappedBy="quizzz")
    private Set<Question> questions;
	private String Titre;
	public int getIdQ() {
		return idQ;
	}
	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	@Override
	public String toString() {
		return "Quiz [idQ=" + idQ + ", Titre=" + Titre + "]";
	}
	public Quiz(int idQ, String titre) {
		super();
		this.idQ = idQ;
		Titre = titre;
	}
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//private int iduser;

}
