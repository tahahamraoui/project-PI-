package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

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
@Table(name="Profession")
public class Profession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//cette ligne n'est pas obligatoire  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	//@Column(name="user_id")
	private Long id_p;
	private String name_p;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="profession")
	private Set <User> user;

}
