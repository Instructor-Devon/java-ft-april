package com.devon.app.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2, max=30, message="Names must be between 2 and 30 characters")
	private String firstName;
	@Size(min=2, max=30, message="Names must be between 2 and 30 characters")
	private String lastName;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToOne(mappedBy="resident", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Address address;
	
	// One to Many
	@OneToMany(mappedBy="creator", fetch=FetchType.LAZY)
	private List<Idea> ideas;
	
	public User() {
		
	}
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Idea> getIdeas() {
		return ideas;
	}
	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}
	public String getCreatedAtFormatted() {
		SimpleDateFormat dateformat = new SimpleDateFormat("EEEEEEEEE, 'the' dd, 'of' MMMMMMMMM, YYYY");
		return dateformat.format(this.createdAt);
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
