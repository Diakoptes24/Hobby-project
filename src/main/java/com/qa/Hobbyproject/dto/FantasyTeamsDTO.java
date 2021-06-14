package com.qa.Hobbyproject.dto;



public class FantasyTeamsDTO {

	private Long teamId;
	
	private String teamName;
	
	private String mainTank;
	
	private String offTank;
	
	private String hitscanDPS;
	
	private String flexDPS;
	
	private String mainSupport;
	
	private String flexSupport;

	public FantasyTeamsDTO() {
		super();
	}

	public FantasyTeamsDTO(Long teamId, String teamName, String mainTank, String offTank, String hitscanDPS,
			String flexDPS, String mainSupport, String flexSupport) {
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

	public String getMainTank() {
		return mainTank;
	}

	public void setMainTank(String mainTank) {
		this.mainTank = mainTank;
	}

	public String getOffTank() {
		return offTank;
	}

	public void setOffTank(String offTank) {
		this.offTank = offTank;
	}

	public String getHitscanDPS() {
		return hitscanDPS;
	}

	public void setHitscanDPS(String hitscanDPS) {
		this.hitscanDPS = hitscanDPS;
	}

	public String getFlexDPS() {
		return flexDPS;
	}

	public void setFlexDPS(String flexDPS) {
		this.flexDPS = flexDPS;
	}

	public String getMainSupport() {
		return mainSupport;
	}

	public void setMainSupport(String mainSupport) {
		this.mainSupport = mainSupport;
	}

	public String getFlexSupport() {
		return flexSupport;
	}

	public void setFlexSupport(String flexSupport) {
		this.flexSupport = flexSupport;
	}

	

	
	
	
}
