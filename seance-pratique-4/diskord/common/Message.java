package common;

import java.io.Serializable;

public class Message implements Serializable {

	// Class Attributes
	
	public static final long serialVersionUID = 12;

	// Attributes
	
	private String sender;

	private String content;

	// Constructor

	public Message(String sender, String content) {
		this.sender = sender;
		this.content = content;
	}

	// Format

	public String toString() {
		return this.sender + " : " + this.content;
	}

	// Getters

	public String getSender() {
		return this.sender;
	}

	public String getContent() {
		return this.content;
	}

	// Setters

	public void setSender(String sender) {
		if(sender != null)
			this.sender = sender;
	}

	public void setContent(String content) {
		if(content != null)
			this.content = content;
	}
}
