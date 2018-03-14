package com.entrance.bean;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String name;
	private Integer jurisdiction;
	private String place;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", jurisdiction=" + jurisdiction + ", place=" + place + "]";
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(Integer jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
}
