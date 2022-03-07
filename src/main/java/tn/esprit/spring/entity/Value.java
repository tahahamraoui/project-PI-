package tn.esprit.spring.entity;

import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Value {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public String id ; 
	public String url ;
	public String description ;
	public String body	;
	public String snippet ;
	public String keywords ;
	public String language ;
	public boolean isSafe ; 
	public String datePublished ;
	private Map<String,String>  provider ;
	private Map<String,String>  image ;
}
