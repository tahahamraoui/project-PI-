package tn.esprit.spring.entity;

import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="User")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image")
	private String image;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telephone")
	private long telephone;
	
	@Column(name="datecreated")
	private LocalDateTime datecreated ;

	@Column(name="password")
	private String password;
	
	@Column(name="confirmpassword")
	private String confirmpassword;
	
	@Column(name="connection")
	private Boolean connection;
	
	@Column(name="emailVerificationStatus")
	private boolean emailVerificationStatus;
	
	@Enumerated(EnumType.STRING)  
	Role role;
	
	
	
	@ManyToOne
	//@Column(name="domaine")
	private Domaine domaine;
	
	@ManyToOne
	private Profession profession;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="User")
	private List<Chat> Chat;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="User")
	private List<Forum> Forum;
}