package fr.dawan.projetLMT.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="t_instrument")
public class Instrument implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Version
	private int version;
	
	@Column(nullable = false, unique=true)
	private String nameInstru;
	
	@ManyToMany(mappedBy = "instruments")
    private List<Member> members;
	
	

	public Instrument() {
		super();
	}

	public Instrument(long id, int version, String nameInstru, List<Member> members) {
		super();
		this.id = id;
		this.version = version;
		this.nameInstru = nameInstru;
		this.members = members;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNameInstru() {
		return nameInstru;
	}

	public void setNameInstru(String nameInstru) {
		this.nameInstru = nameInstru;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
	
}
