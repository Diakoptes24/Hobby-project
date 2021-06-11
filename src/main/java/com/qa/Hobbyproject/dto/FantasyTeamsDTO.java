package com.qa.Hobbyproject.dto;

import java.util.List;


public class FantasyTeamsDTO {

	private Integer teamId;
	
	private String teamName;
	
	private List<PlayersDTO> mainTank;
	
	private List<PlayersDTO> offTank;
	
	private List<PlayersDTO> hitscanDPS;
	
	private List<PlayersDTO> flexDPS;
	
	private List<PlayersDTO> mainSupport;
	
	private List<PlayersDTO> flexSupport;

	public FantasyTeamsDTO() {
		super();
	}

	public FantasyTeamsDTO(Integer teamId, String teamName, List<PlayersDTO> mainTank, List<PlayersDTO> offTank,
			List<PlayersDTO> hitscanDPS, List<PlayersDTO> flexDPS, List<PlayersDTO> mainSupport,
			List<PlayersDTO> flexSupport) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.mainTank = mainTank;
		this.offTank = offTank;
		this.hitscanDPS = hitscanDPS;
		this.flexDPS = flexDPS;
		this.mainSupport = mainSupport;
		this.flexSupport = flexSupport;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<PlayersDTO> getMainTank() {
		return mainTank;
	}

	public void setMainTank(List<PlayersDTO> mainTank) {
		this.mainTank = mainTank;
	}

	public List<PlayersDTO> getOffTank() {
		return offTank;
	}

	public void setOffTank(List<PlayersDTO> offTank) {
		this.offTank = offTank;
	}

	public List<PlayersDTO> getHitscanDPS() {
		return hitscanDPS;
	}

	public void setHitscanDPS(List<PlayersDTO> hitscanDPS) {
		this.hitscanDPS = hitscanDPS;
	}

	public List<PlayersDTO> getFlexDPS() {
		return flexDPS;
	}

	public void setFlexDPS(List<PlayersDTO> flexDPS) {
		this.flexDPS = flexDPS;
	}

	public List<PlayersDTO> getMainSupport() {
		return mainSupport;
	}

	public void setMainSupport(List<PlayersDTO> mainSupport) {
		this.mainSupport = mainSupport;
	}

	public List<PlayersDTO> getFlexSupport() {
		return flexSupport;
	}

	public void setFlexSupport(List<PlayersDTO> flexSupport) {
		this.flexSupport = flexSupport;
	}

	
	
	
}
