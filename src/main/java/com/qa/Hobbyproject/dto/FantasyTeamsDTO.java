package com.qa.Hobbyproject.dto;

import java.util.List;

import com.qa.Hobbyproject.domain.Players;

public class FantasyTeamsDTO {

	private Integer teamId;
	
	private String teamName;
	
	private List<Players> mainTank;
	
	private List<Players> offTank;
	
	private List<Players> hitscanDPS;
	
	private List<Players> flexDPS;
	
	private List<Players> mainSupport;
	
	private List<Players> flexSupport;

	public FantasyTeamsDTO() {
		super();
	}

	public FantasyTeamsDTO(Integer teamId, String teamName, List<Players> mainTank, List<Players> offTank,
			List<Players> hitscanDPS, List<Players> flexDPS, List<Players> mainSupport, List<Players> flexSupport) {
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

	public List<Players> getMainTank() {
		return mainTank;
	}

	public void setMainTank(List<Players> mainTank) {
		this.mainTank = mainTank;
	}

	public List<Players> getOffTank() {
		return offTank;
	}

	public void setOffTank(List<Players> offTank) {
		this.offTank = offTank;
	}

	public List<Players> getHitscanDPS() {
		return hitscanDPS;
	}

	public void setHitscanDPS(List<Players> hitscanDPS) {
		this.hitscanDPS = hitscanDPS;
	}

	public List<Players> getFlexDPS() {
		return flexDPS;
	}

	public void setFlexDPS(List<Players> flexDPS) {
		this.flexDPS = flexDPS;
	}

	public List<Players> getMainSupport() {
		return mainSupport;
	}

	public void setMainSupport(List<Players> mainSupport) {
		this.mainSupport = mainSupport;
	}

	public List<Players> getFlexSupport() {
		return flexSupport;
	}

	public void setFlexSupport(List<Players> flexSupport) {
		this.flexSupport = flexSupport;
	}
	
	
}
