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
@Table(name="t_message")
public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Version
	private int version;
	
	private String content;
	
	private LocalDate dateMessage;
	
	@ManyToOne
	private Member sender;
	
	@ManyToOne
	private Member reciever;
	

	
	

	public Message() {
		super();
	}

	public Message(long id, int version, String content, LocalDate dateMessage) {
		super();
		this.id = id;
		this.version = version;
		this.content = content;
		this.dateMessage = dateMessage;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(LocalDate dateMessage) {
		this.dateMessage = dateMessage;
	}

}
