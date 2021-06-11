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
	private Integer teamId;
	
	@Column
	private String teamName;

	//Can do the roles like below with Players in list and variable named after each role like how it is now, I think
	@OneToMany(mappedBy = "fantasyTeams")
	@JsonIgnore
	private List<Players> mainTank;
	
	@OneToMany(mappedBy = "fantasyTeams")
	@JsonIgnore
	private List<Players> offTank;
	
	@OneToMany(mappedBy = "fantasyTeams")
	@JsonIgnore
	private List<Players> hitscanDPS;
	
	@OneToMany(mappedBy = "fantasyTeams")
	@JsonIgnore
	private List<Players> flexDPS;
	
	@OneToMany(mappedBy = "fantasyTeams")
	@JsonIgnore
	private List<Players> mainSupport;
	
	@OneToMany(mappedBy = "fantasyTeams")
	@JsonIgnore
	private List<Players> flexSupport;

	public FantasyTeams() {
		super();
	}

	public FantasyTeams(Integer teamId, String teamName, List<Players> mainTank, List<Players> offTank,
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

	@Override
	public String toString() {
		return "FantasyTeams [teamId=" + teamId + ", teamName=" + teamName + ", mainTank=" + mainTank + ", offTank="
				+ offTank + ", hitscanDPS=" + hitscanDPS + ", flexDPS=" + flexDPS + ", mainSupport=" + mainSupport
				+ ", flexSupport=" + flexSupport + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flexDPS == null) ? 0 : flexDPS.hashCode());
		result = prime * result + ((flexSupport == null) ? 0 : flexSupport.hashCode());
		result = prime * result + ((hitscanDPS == null) ? 0 : hitscanDPS.hashCode());
		result = prime * result + ((mainSupport == null) ? 0 : mainSupport.hashCode());
		result = prime * result + ((mainTank == null) ? 0 : mainTank.hashCode());
		result = prime * result + ((offTank == null) ? 0 : offTank.hashCode());
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
		if (flexDPS == null) {
			if (other.flexDPS != null)
				return false;
		} else if (!flexDPS.equals(other.flexDPS))
			return false;
		if (flexSupport == null) {
			if (other.flexSupport != null)
				return false;
		} else if (!flexSupport.equals(other.flexSupport))
			return false;
		if (hitscanDPS == null) {
			if (other.hitscanDPS != null)
				return false;
		} else if (!hitscanDPS.equals(other.hitscanDPS))
			return false;
		if (mainSupport == null) {
			if (other.mainSupport != null)
				return false;
		} else if (!mainSupport.equals(other.mainSupport))
			return false;
		if (mainTank == null) {
			if (other.mainTank != null)
				return false;
		} else if (!mainTank.equals(other.mainTank))
			return false;
		if (offTank == null) {
			if (other.offTank != null)
				return false;
		} else if (!offTank.equals(other.offTank))
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
	
	
//	@Column
//	private String mainTank;
//	
//	@Column
//	private String offTank;
//	
//	@Column
//	private String hitscanDPS;
//	
//	@Column
//	private String flexDPS;
//	
//	@Column
//	private String mainSupport;
//	
//	@Column
//	private String flexSupport;

	
	
}
