package fr.dawan.projetLMT.entities;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
@Entity
@Table(name="t_member")
public class Member {
	
	 public enum sex{			  
		    m,
		    f,
		    other
		  }
	 public enum level{
			beginner,
			intermediate,
			advanced,
			professional
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Version
	private int version;
	
	private String firstname;
		
	private String lastname;
	
	private LocalDate birthday;
	
	 private sex sexMember ;
	
	private String email;
	
	private String password;
	
	private level levelmMember;
	
	private String adress;
	
	private int zipCode;
	
	private String city;
	
	private String picture;
	
	private String resume;
	
	@ManyToMany
	private List<Instrument> instruments;
	
	@ManyToMany
	private List<Genre> genres;
	
	@OneToMany
	private List<Message> sentMessages;
	
	@OneToMany
	private List<Message> recievedMessages;
	
	
}
