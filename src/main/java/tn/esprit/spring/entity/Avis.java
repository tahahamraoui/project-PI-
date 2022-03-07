package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "Avis")
public class Avis implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idAvis")
	private int idAvis;
	private int  Nombre;
	private String descriptionAvis ; 
	//private int iduser;
	@Override
	public String toString() {
		return "Avis [idAvis=" + idAvis + ", Nombre=" + Nombre + ",descriptionAvis"+ descriptionAvis + "]";
	}
	public String getDescriptionAvis() {
		return descriptionAvis;
	}
	public void setDescriptionAvis(String descriptionAvis) {
		this.descriptionAvis = descriptionAvis;
	}
	public int getIdAvis() {
		return idAvis;
	}
	public void setIdAvis(int idAvis) {
		this.idAvis = idAvis;
	}
	public int getNombre() {
		return Nombre;
	}
	public void setNombre(int nombre) {
		Nombre = nombre;
	}
	public Avis(int idAvis, int nombre) {
		super();
		this.idAvis = idAvis;
		Nombre = nombre;
	}
	public Avis() {
		super();
	}
	

	

}
