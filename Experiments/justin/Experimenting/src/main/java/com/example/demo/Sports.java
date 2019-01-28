package com.example.demo;


public class Sports {
	private String season;
	private String name;
	private String teamName;
	
	public Sports(String season, String name, String teamName) {
		super();
		this.season = season;
		this.name = name;
		this.teamName = teamName;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
	
	
}
