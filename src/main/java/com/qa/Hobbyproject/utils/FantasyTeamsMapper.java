package com.qa.Hobbyproject.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.Hobbyproject.domain.FantasyTeams;
import com.qa.Hobbyproject.dto.FantasyTeamsDTO;
import com.qa.Hobbyproject.domain.Players;
import com.qa.Hobbyproject.dto.PlayersDTO;

@Service
public class FantasyTeamsMapper implements Mapper<FantasyTeams, FantasyTeamsDTO> {
	
	private PlayersMapper playersMapper;
	

	public FantasyTeamsMapper(PlayersMapper playersMapper) {
		super();
		this.playersMapper = playersMapper;
	}

	@Override
	public FantasyTeamsDTO mapToDTO(FantasyTeams fTeams) {
		
		FantasyTeamsDTO dto = new FantasyTeamsDTO();
		
		dto.setTeamId(fTeams.getTeamId());
		dto.setTeamName(fTeams.getTeamName());
		
		List<PlayersDTO> mainTank = new ArrayList<>();
		for (Players players : fTeams.getMainTank()) {
			mainTank.add(this.playersMapper.mapToDTO(players));
		}
		dto.setMainTank(mainTank);
		
		List<PlayersDTO> offTank = new ArrayList<>();
		for (Players players : fTeams.getOffTank()) {
			offTank.add(this.playersMapper.mapToDTO(players));
		}
		dto.setOffTank(offTank);
		
		List<PlayersDTO> hitscanDPS = new ArrayList<>();
		for (Players players : fTeams.getHitscanDPS()) {
			hitscanDPS.add(this.playersMapper.mapToDTO(players));
		}
		dto.setHitscanDPS(hitscanDPS);
		
		List<PlayersDTO> flexDPS = new ArrayList<>();
		for (Players players : fTeams.getFlexDPS()) {
			flexDPS.add(this.playersMapper.mapToDTO(players));
		}
		dto.setFlexDPS(flexDPS);
		
		List<PlayersDTO> mainSupport = new ArrayList<>();
		for (Players players : fTeams.getMainSupport()) {
			mainSupport.add(this.playersMapper.mapToDTO(players));
		}
		dto.setMainSupport(mainSupport);
		
		List<PlayersDTO> flexSupport = new ArrayList<>();
		for (Players players : fTeams.getFlexSupport()) {
			flexSupport.add(this.playersMapper.mapToDTO(players));
		}
		dto.setFlexSupport(flexSupport);
		return dto;
	}

	@Override
	public FantasyTeams mapFromDTO(FantasyTeamsDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
