package fr.dawan.projetLMT.entities;

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
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Version
	private int version;
	
	private String content;
	
	private LocalDate dateMessage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Member sender;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Member receiver;
	
	

	public Message() {
		super();
	}

	public Message(long id, int version, String content, LocalDate dateMessage, Member sender, Member receiver) {
		super();
		this.id = id;
		this.version = version;
		this.content = content;
		this.dateMessage = dateMessage;
		this.sender = sender;
		this.receiver = receiver;
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

	public Member getSender() {
		return sender;
	}

	public void setSender(Member sender) {
		this.sender = sender;
	}

	public Member getReceiver() {
		return receiver;
	}

	public void setReceiver(Member receiver) {
		this.receiver = receiver;
	}
	
	

}
