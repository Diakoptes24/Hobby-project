package com.qa.Hobbyproject.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Players {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;
	
	@Column
	private String playerIGN;
	
	@Column 
	private String role;
	
	@Column
	private String subRole;
	
	@Column
	private String currentTeam;
	
	@OneToOne
	@JoinColumn(name = "fantasy_teams_team_id", nullable = false)
	private FantasyTeams fantasyTeams;

	public Players() {
		super();
	}

	public Players(Long playerId, String playerIGN, String role, String subRole, String currentTeam) {
		super();
		this.playerId = playerId;
		this.playerIGN = playerIGN;
		this.role = role;
		this.subRole = subRole;
		this.currentTeam = currentTeam;
	}
	
	
	
	public Players(String playerIGN, String role, String subRole, String currentTeam) {
		super();
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

	
	public FantasyTeams getFantasyTeams() {
		return fantasyTeams;
	}

	public void setFantasyTeams(FantasyTeams fantasyTeams) {
		this.fantasyTeams = fantasyTeams;
	}

	@Override
	public String toString() {
		return "Players [playerId=" + playerId + ", playerIGN=" + playerIGN + ", role=" + role + ", subRole=" + subRole
				+ ", currentTeam=" + currentTeam + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentTeam == null) ? 0 : currentTeam.hashCode());
		result = prime * result + ((fantasyTeams == null) ? 0 : fantasyTeams.hashCode());
		result = prime * result + ((playerIGN == null) ? 0 : playerIGN.hashCode());
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((subRole == null) ? 0 : subRole.hashCode());
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
		Players other = (Players) obj;
		if (currentTeam == null) {
			if (other.currentTeam != null)
				return false;
		} else if (!currentTeam.equals(other.currentTeam))
			return false;
		if (fantasyTeams == null) {
			if (other.fantasyTeams != null)
				return false;
		} else if (!fantasyTeams.equals(other.fantasyTeams))
			return false;
		if (playerIGN == null) {
			if (other.playerIGN != null)
				return false;
		} else if (!playerIGN.equals(other.playerIGN))
			return false;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (subRole == null) {
			if (other.subRole != null)
				return false;
		} else if (!subRole.equals(other.subRole))
			return false;
		return true;
	}

	
	
	
	
	
}
