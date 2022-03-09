package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="TravelProgram")
public class TravelProgram implements  Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idTravelProgram")
	private Integer idTravelProgram ; 
	@Enumerated(EnumType.STRING)
	private MeansOfTransport MeansOfTransport ; 
	
	private int maxTraveller ; 
	private float travelPrice ; 
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="tp")
	private List<Travel> travel ; 
	
	@ManyToOne
	private Hotel hotel ; 
	

}
