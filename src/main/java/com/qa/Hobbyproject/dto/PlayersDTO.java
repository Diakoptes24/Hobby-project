package com.qa.Hobbyproject.dto;


public class PlayersDTO {
	
	private Long playerId;
	
	
	private String playerIGN;

	
	private String role;


	public PlayersDTO() {
		super();
	}

	public PlayersDTO(Long playerId, String playerIGN, String role) {
		super();
		this.playerId = playerId;
		this.playerIGN = playerIGN;
		this.role = role;
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

	@Override
	public String toString() {
		return "PlayersDTO [playerId=" + playerId + ", playerIGN=" + playerIGN + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		PlayersDTO other = (PlayersDTO) obj;
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
