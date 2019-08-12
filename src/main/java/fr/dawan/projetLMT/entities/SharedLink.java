package fr.dawan.projetLMT.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="t_sharedlink")
public class SharedLink {
	
	enum Link {youtube, facebook, twitter, instagram, snapchat, other }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Version
	private int version;
	
	private String linkName;
	
	private String url;
	
	private Link linkType;
	
	

	public SharedLink() {
		super();
	}

	public SharedLink(long id, int version, String linkName, String url, Link linkType) {
		super();
		this.id = id;
		this.version = version;
		this.linkName = linkName;
		this.url = url;
		this.linkType = linkType;
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

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Link getLinkType() {
		return linkType;
	}

	public void setLinkType(Link linkType) {
		this.linkType = linkType;
	}

	
}
