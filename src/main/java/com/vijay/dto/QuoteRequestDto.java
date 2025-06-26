package com.vijay.dto;

public class QuoteRequestDto {

    private Long id;          // ✅ Add this for identification
    private String name;
    private String email;
    private String phone;
    private String service;
    private String message;

    public QuoteRequestDto() {
        super();
    }

    public QuoteRequestDto(Long id, String name, String email, String phone, String service, String message) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.service = service;
        this.message = message;
    }

    // Getters and Setters
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
}
