package fr.dawan.projetLMT.entities;
import java.time.LocalDate;

public class Member {

	private int id;
	
	private String firstname;
		
	private String lastname;
	
	private LocalDate birthday;
	
	 private enum sex {			  
			    m,
			    f,
			    other
			  }
	
	
	private String email;
	
	private String password;
	
	private enum level{
			beginner,
			intermediate,
			advanced,
			professional
	};
	
	private String adress;
	
	private int zipCode;
	
	private String city;
	
	private String picture;
	
	private String resume;
	
	private int version;
	
}
