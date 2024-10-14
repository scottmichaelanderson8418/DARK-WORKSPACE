package com.pokemonreview.api.dto;

import lombok.Data;

@Data
public class RegisterDto {
	private String password;

	private String username;

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
