package fr.dawan.projetLMT.entities;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
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
public class Member implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Instrument> instruments;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Genre> genres;
	
	@OneToMany(mappedBy="sender" ,cascade=CascadeType.ALL)
	private List<Message> sentMessages;
	
	@OneToMany(mappedBy="receiver",cascade=CascadeType.ALL)
	private List<Message> recievedMessages;

	
	
	public Member() {
		super();
	}

	public Member(int id, int version, String firstname, String lastname, LocalDate birthday, sex sexMember,
			String email, String password, level levelmMember, String adress, int zipCode, String city, String picture,
			String resume, List<Instrument> instruments, List<Genre> genres, List<Message> sentMessages,
			List<Message> recievedMessages) {
		super();
		this.id = id;
		this.version = version;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.sexMember = sexMember;
		this.email = email;
		this.password = password;
		this.levelmMember = levelmMember;
		this.adress = adress;
		this.zipCode = zipCode;
		this.city = city;
		this.picture = picture;
		this.resume = resume;
		this.instruments = instruments;
		this.genres = genres;
		this.sentMessages = sentMessages;
		this.recievedMessages = recievedMessages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public sex getSexMember() {
		return sexMember;
	}

	public void setSexMember(sex sexMember) {
		this.sexMember = sexMember;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public level getLevelmMember() {
		return levelmMember;
	}

	public void setLevelmMember(level levelmMember) {
		this.levelmMember = levelmMember;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Message> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Message> getRecievedMessages() {
		return recievedMessages;
	}

	public void setRecievedMessages(List<Message> recievedMessages) {
		this.recievedMessages = recievedMessages;
	}
	
	
	
	
}
