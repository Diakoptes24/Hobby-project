package com.qa.Hobbyproject.dto;

import java.util.List;

public class FantasyTeamsDTO {

	private Long teamId;
	
	private String teamName;
	
	private List<PlayersDTO> players;

	public FantasyTeamsDTO() {
		super();
	}


	public FantasyTeamsDTO(Long teamId, String teamName, List<PlayersDTO> players) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.players = players;
	}

	
	public FantasyTeamsDTO(Long teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}

	public FantasyTeamsDTO(String teamName) {
		super();
		this.teamName = teamName;
	}


	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public List<PlayersDTO> getPlayers() {
		return players;
	}


	public void setPlayers(List<PlayersDTO> players) {
		this.players = players;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FantasyTeamsDTO other = (FantasyTeamsDTO) obj;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

	
	

	
	
	
}
