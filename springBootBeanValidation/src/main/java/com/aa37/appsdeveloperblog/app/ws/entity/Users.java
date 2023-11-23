package com.aa37.appsdeveloperblog.app.ws.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="Name is mandatory")
	private String name;
	
	@NotBlank(message="Email is mandatory")
	private String email;
	
	

	public Users(@NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Email is mandatory") String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
