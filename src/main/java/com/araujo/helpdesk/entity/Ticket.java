package com.araujo.helpdesk.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.araujo.helpdesk.enums.PriorityTicketEnum;
import com.araujo.helpdesk.enums.StatusTicketEnum;

@Document
public class Ticket implements Serializable{
	
	private static final long serialVersionUID = -7490555996917738522L;

	@Id
	private String id;
	
	private String title;
	
	private String description;
	
	private String image;
	
	private Integer number;
	
	private Date createdAt;
	
	@DBRef(lazy = true)
	private User user;
	
	private StatusTicketEnum status;
	
	private PriorityTicketEnum priority;
	
	@DBRef(lazy = true)
	private User assinedUser;
	
	private List<ChangeStatus> changes;
	
	public Ticket() {
	}

	public Ticket(String id, String title, String description, String image, Integer number, Date createdAt, User user,
			StatusTicketEnum status, PriorityTicketEnum priority, User assinedUser, List<ChangeStatus> changes) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.number = number;
		this.createdAt = createdAt;
		this.user = user;
		this.status = status;
		this.priority = priority;
		this.assinedUser = assinedUser;
		this.changes = changes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public StatusTicketEnum getStatus() {
		return status;
	}

	public void setStatus(StatusTicketEnum status) {
		this.status = status;
	}

	public PriorityTicketEnum getPriority() {
		return priority;
	}

	public void setPriority(PriorityTicketEnum priority) {
		this.priority = priority;
	}

	public User getAssinedUser() {
		return assinedUser;
	}

	public void setAssinedUser(User assinedUser) {
		this.assinedUser = assinedUser;
	}

	public List<ChangeStatus> getChanges() {
		return changes;
	}

	public void setChanges(List<ChangeStatus> changes) {
		this.changes = changes;
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
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", number=" + number + ", createdAt=" + createdAt + ", user=" + user + ", status=" + status
				+ ", priority=" + priority + ", assinedUser=" + assinedUser + ", changes=" + changes + "]";
	}
	
}
