package com.mh453Uol.masjidma.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Embeddable
public class Audit {
	@NotNull
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@NotNull
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@NotNull
	@Column(name="modified_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedAt;
    
	@JoinColumn(name="modified_by")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedByUser;
	
	@JoinColumn(name="created_by")
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdByUser;
	

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public User getModifiedByUser() {
		return modifiedByUser;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}
	
	public void create(User user) {
		this.createdAt = new Date();
		this.createdByUser = user;
	}
	
	public void modify(User user) {
		this.createdAt = new Date();
		this.modifiedByUser = user;
	}
	
	public void delete(User user) {
		this.isDeleted = true;
		this.modify(user);
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
