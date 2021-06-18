package com.qa.Hobbyproject.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FantasyTeams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	
	@Column
	private String teamName;

	@OneToMany(mappedBy = "fantasyTeams")
	@JsonIgnore
	private List<Players> players;

	public FantasyTeams() {
		super();
	}

	public FantasyTeams(Long teamId, String teamName, List<Players> players) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.players = players;
	}
	
	
	

	public FantasyTeams(Long teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}

	public FantasyTeams(String teamName) {
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

//	public List<Players> getPlayers() {
//		return players;
//	}
//
//	public void setPlayers(List<Players> players) {
//		this.players = players;
//	}

	@Override
	public String toString() {
		return "FantasyTeams [teamId=" + teamId + ", teamName=" + teamName + "]";
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
		FantasyTeams other = (FantasyTeams) obj;
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
