package com.araujo.helpdesk.entity;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.araujo.helpdesk.enums.StatusTicketEnum;

@Document
public class ChangeStatus implements Serializable{

	private static final long serialVersionUID = 6564580069560474023L;

	@Id
	private String id;
	
	@DBRef
	private Ticket ticket;
	
	@DBRef
	private User userChange;
	
	private StatusTicketEnum status;

	public ChangeStatus() {
		
	}
	
	public ChangeStatus(String id, Ticket ticket, User userChange, StatusTicketEnum status) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.userChange = userChange;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getUserChange() {
		return userChange;
	}

	public void setUserChange(User userChange) {
		this.userChange = userChange;
	}

	public StatusTicketEnum getStatus() {
		return status;
	}

	public void setStatus(StatusTicketEnum status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChangeStatus other = (ChangeStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChangeStatus [id=" + id + ", ticket=" + ticket + ", userChange=" + userChange + ", status=" + status
				+ "]";
	}
	
}
