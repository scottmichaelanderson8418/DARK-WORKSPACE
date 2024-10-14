
package com.review.project;

public class Tenant {

	private String teamName;//
	private String sport;//
	private String league;//
	pr

	public Tenant() {
		this.teamName = "";
		this.sport = "";
		this.league = "";

	}

	public Tenant(String teamName, String sport, String league) {
		super();
		this.teamName = teamName;
		this.sport = sport;
		this.league = league;
	}

	public Tenant(Tenant obj) {
		this.teamName = obj.teamName;
		this.sport = obj.sport;
		this.league = obj.league;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "Tenant [teamName=" + teamName + ", sport=" + sport + ", league=" + league + "]";
	}

}
