package com.qa.hobbyproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Players {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;
	
	@Column
	private String playerIGN;
	
	@Column 
	private String role;
	
//	@JoinColumn(name = "fantasy_teams_team_id", referencedColumnName = "teamId")
	@ManyToOne
	//@JsonIgnore
	private FantasyTeams fantasyTeams;

	public Players() {
		super();
	}

	

	public Players(Long playerId, String playerIGN, String role, FantasyTeams fantasyTeams) {
		super();
		this.playerId = playerId;
		this.playerIGN = playerIGN;
		this.role = role;
		this.fantasyTeams = fantasyTeams;
	}

	public Players(Long playerId, String playerIGN, String role) {
		super();
		this.playerId = playerId;
		this.playerIGN = playerIGN;
		this.role = role;
	}

	public Players(String playerIGN, String role) {
		super();
		this.playerIGN = playerIGN;
		this.role = role;
	}
	
	

	public Players(String playerIGN, String role, FantasyTeams fantasyTeams) {
		super();
		this.playerIGN = playerIGN;
		this.role = role;
		this.fantasyTeams = fantasyTeams;
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

	
	public FantasyTeams getFantasyTeams() {
		return fantasyTeams;
	}

	public void setFantasyTeams(FantasyTeams fantasyTeams) {
		this.fantasyTeams = fantasyTeams;
	}

	
	

	@Override
	public String toString() {
		return "Players [playerIGN=" + playerIGN + ", role=" + role + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fantasyTeams == null) ? 0 : fantasyTeams.hashCode());
		result = prime * result + ((playerIGN == null) ? 0 : playerIGN.hashCode());
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		return true;
	}

	
	
	
	
}
