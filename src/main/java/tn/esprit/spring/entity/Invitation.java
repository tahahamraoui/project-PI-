package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Entity
@Getter
@Setter
@ToString
@Table(name="Invitation")
public class Invitation implements Serializable{
	public Invitation() {
		super();
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idinvitation;

	@Column(name="dateinvitation")
	private Date dateinvitation;
	
	@Column(name="objet")
	private String objet;
	
	@Column(name="contenue")
	private String contenue;
	
	@Column(name="statutenvoie")
	private boolean statutenvoie;
	
	@Column(name="statusacceptation")
	private boolean statusacceptation;
	
	@Column(name="email")
	private String email;
	
	public Invitation( Date dateinvitation, String objet, String contenue, boolean statutenvoie,
			boolean statusacceptation, String email) {
		super();
		this.dateinvitation = dateinvitation;
		this.objet = objet;
		this.contenue = contenue;
		this.statutenvoie = statutenvoie;
		this.statusacceptation = statusacceptation;
		this.email = email;
	}

	public int getIdinvitation() {
		return idinvitation;
	}

	public void setIdinvitation(int idinvitation) {
		this.idinvitation = idinvitation;
	}

	public Date getDateinvitation() {
		return dateinvitation;
	}

	public void setDateinvitation(Date dateinvitation) {
		this.dateinvitation = dateinvitation;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	public boolean isStatutenvoie() {
		return statutenvoie;
	}

	public void setStatutenvoie(boolean statutenvoie) {
		this.statutenvoie = statutenvoie;
	}
	
	public boolean isStatusacceptation() {
		return statusacceptation;
	}

	public void setStatusacceptation(boolean statusacceptation) {
		this.statusacceptation = statusacceptation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Invitation(int idinvitation, Date dateinvitation, String objet, String contenue, boolean statutenvoie,
			boolean statusacceptation, String email) {
		super();
		this.idinvitation = idinvitation;
		this.dateinvitation = dateinvitation;
		this.objet = objet;
		this.contenue = contenue;
		this.statutenvoie = statutenvoie;
		this.statusacceptation = statusacceptation;
		this.email = email;
	}

	



}
