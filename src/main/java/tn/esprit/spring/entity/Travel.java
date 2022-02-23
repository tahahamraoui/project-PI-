package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name="Travel")
public class Travel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idTravel")
	private Integer idTravel ; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date StartDate ; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date LastDate ;
	private String destination ;
	
	private String departurePlace ; 
	private boolean confirmationStatus ; 
	@JsonIgnore
	@Fetch(value=FetchMode.SELECT)
	@ManyToOne
	private TravelProgram tp ; 
	@JsonIgnore
	@Fetch(value=FetchMode.SELECT)
	@ManyToOne 
	private TravelAgency ta ; 
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	List<User> users ;
}
