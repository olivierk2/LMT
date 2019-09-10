package fr.dawan.projetLMT.entities;

import java.io.Serializable;
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
@Table(name="t_genre")
public class Genre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Version
	private int version=5;

		
	private String genreName;
	 
	
	@ManyToMany(mappedBy = "genres")
    private List<Member> members;
	
	public Genre() {
		super();
	}

	public Genre(long id, int version, String genreName, List<Member> members) {
		super();
		this.id = id;
		this.version = version;
		this.genreName = genreName;
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

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		genreName = genreName;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
	
}
