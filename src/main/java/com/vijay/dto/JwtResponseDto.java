package com.vijay.dto;

public class JwtResponseDto {
	
    private String token;
    
 

    public JwtResponseDto(String token) {
        this.token = token;
    }

    
    
    // Getter
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

  
    
}

