package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Invitation")
public class Invitation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idinvitation;

	@Column(name="dateinvitation")
	private Date dateinvitation;
	
	@Column(name="statutenvoie")
	private boolean statutenvoie;
	
	@Column(name="listeemails")
	private String listeemails;



}
