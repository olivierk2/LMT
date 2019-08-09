package fr.dawan.projetLMT.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.dawan.projetLMT.entities.Genre;
import fr.dawan.projetLMT.entities.Instrument;
import fr.dawan.projetLMT.entities.Message;
import fr.dawan.projetLMT.entities.Member.level;
import fr.dawan.projetLMT.entities.Member.sex;

public class MemberForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String firstname;
		
	private String lastname;
	
	private String birthday;
	
	private String sexMember ;
	
	private String email;
	
	private String password;
	
	private String levelMember;
	
	private String adress;
	
	private String zipCode;
	
	private String city;
	
	private String picture;
	
	private String resume;

	
	
	public MemberForm() {
		super();
	}

	public MemberForm(String id, String firstname, String lastname, String birthday, String sexMember, String email,
			String password, String levelMember, String adress, String zipCode, String city, String picture,
			String resume) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.sexMember = sexMember;
		this.email = email;
		this.password = password;
		this.levelMember = levelMember;
		this.adress = adress;
		this.zipCode = zipCode;
		this.city = city;
		this.picture = picture;
		this.resume = resume;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSexMember() {
		return sexMember;
	}

	public void setSexMember(String sexMember) {
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

	public String getLevelMember() {
		return levelMember;
	}

	public void setLevelMember(String levelMember) {
		this.levelMember = levelMember;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
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
	
	


	
	
	
}
