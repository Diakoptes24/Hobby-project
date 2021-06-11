package com.qa.Hobbyproject.dto;


public class PlayersDTO {
	
	private Long playerId;
	
	
	private String playerIGN;

	
	private String role;
	
	
	private String subRole;
	
	
	private String currentTeam;


	public PlayersDTO() {
		super();
	}


	public PlayersDTO(Long playerId, String playerIGN, String role, String subRole, String currentTeam) {
		super();
		this.playerId = playerId;
		this.playerIGN = playerIGN;
		this.role = role;
		this.subRole = subRole;
		this.currentTeam = currentTeam;
	}


	public Long getPlayerId() {
		return playerId;
	}


	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}


	public String getPlayerIGN() {
		return playerIGN;
	}


	public void setPlayerIGN(String playerIGN) {
		this.playerIGN = playerIGN;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getSubRole() {
		return subRole;
	}


	public void setSubRole(String subRole) {
		this.subRole = subRole;
	}


	public String getCurrentTeam() {
		return currentTeam;
	}


	public void setCurrentTeam(String currentTeam) {
		this.currentTeam = currentTeam;
	}

	
}
