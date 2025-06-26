package com.vijay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String service;
    
    @Column(length = 1000)
    private String message;

	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quote(Long id, String name, String email, String phone, String service, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.service = service;
		this.message = message;
	}

		public Quote( String name, String email, String phone, String service, String message) {
		super();
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.service = service;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", service=" + service
				+ ", message=" + message + "]";
	}

	
    
    
}
