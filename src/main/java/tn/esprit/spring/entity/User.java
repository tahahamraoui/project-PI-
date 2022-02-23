package tn.esprit.spring.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
//import java.sql.Date; not this
//import java.util.Date;

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
	private String user_firstName;
	private String user_lastName;
	private String user_email; 
	private String user_password; 
	
	
}
