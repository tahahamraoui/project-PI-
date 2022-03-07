package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table( name = "Reclamation")


public class Reclamation implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idR")
	private int idR;
	//private int iduser;
	private String  Discription;
	
	private int user_id;
	@Temporal(TemporalType.DATE)
	private Date date;
	//private int Photo;
	@Enumerated(EnumType.STRING)
	private TypeReclamation TypeReclamation;
	public int getIdR() {
		return idR;
	}
	public void setIdR(int idR) {
		this.idR = idR;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TypeReclamation getTypeReclamation() {
		return TypeReclamation;
	}
	public void setTypeReclamation(TypeReclamation typeReclamation) {
		TypeReclamation = typeReclamation;
	}
	@Override
	public String toString() {
		return "Reclamation [idR=" + idR + ", Discription=" + Discription + ", user_id=" + user_id + ", date=" + date
				+ ", TypeReclamation=" + TypeReclamation + "]";
	}
	public Reclamation(int idR, String discription, int user_id, Date date,
			tn.esprit.spring.entity.TypeReclamation typeReclamation) {
		super();
		this.idR = idR;
		Discription = discription;
		this.user_id = user_id;
		this.date = date;
		TypeReclamation = typeReclamation;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
