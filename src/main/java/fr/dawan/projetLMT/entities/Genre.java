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
@Table(name="t_genre")
public class Genre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Version
	private int version;
	
	@Column(nullable = false, unique=true)
	private String nameGenre;
	
	@ManyToMany(mappedBy = "genres")
    private List<Member> members;
	
	

	public Genre() {
		super();
	}

	public Genre(long id, int version, String nameGenre, List<Member> members) {
		super();
		this.id = id;
		this.version = version;
		this.nameGenre = nameGenre;
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

	public String getNameGenre() {
		return nameGenre;
	}

	public void setNameGenre(String nameGenre) {
		this.nameGenre = nameGenre;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	
	
}
