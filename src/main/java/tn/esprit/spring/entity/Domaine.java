package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Domaine")
public class Domaine implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//cette ligne n'est pas obligatoire  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	//@Column(name="user_id")
	private Long id_d;
	private String name_d;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="domaine")
	private List <User> user;

}