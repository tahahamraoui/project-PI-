package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//table mere
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//cette ligne n'est pas obligatoire  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	//@Column(name="user_id")
	private Long user_id;
	private String name;
	private String image;
	private String email; 
	private String password; 
	private Boolean connection;
	
	@Enumerated(EnumType.STRING)  
	Role role;
	
	public enum Role{
		ADMIN, EMPLOYEE, COMPANY
		}
	
	
	@ManyToOne
	private Domaine domaine;
	
	@ManyToOne
	private Profession profession;
}
