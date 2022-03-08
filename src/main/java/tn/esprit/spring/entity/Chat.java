package tn.esprit.spring.entity;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Chat")
public class Chat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idchat;
	
	
	@Column(name="message")
	private String message;
	
	@Column(name="reaction")
	private int reaction;
	
	@Column(name="datecreated")
	private LocalDateTime datecreated ;
	
	@Column(name="emoji")
	private String emoji;
	
	@Column(name="vocal")
	private String vocal;

	
	@JsonIgnore
	@Fetch(value=FetchMode.SELECT)
	@ManyToOne
	User User;
}