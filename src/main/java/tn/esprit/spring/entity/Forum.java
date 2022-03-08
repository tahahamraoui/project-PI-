package tn.esprit.spring.entity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Forum")

public class Forum implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long idForum;
	private String sujet ;
	private LocalDateTime datecreated ;
	private String description ;
	private String author;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Forum")
	private List<Commentaire> Commentaires;
	
	@JsonIgnore
	@Fetch(value=FetchMode.SELECT)
	@ManyToOne
	User User;
	
	
	
}


