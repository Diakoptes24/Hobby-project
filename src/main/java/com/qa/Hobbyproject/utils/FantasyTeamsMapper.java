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
	public FantasyTeamsDTO mapToDTO(FantasyTeams fantasyTeams) {
		
		FantasyTeamsDTO dto = new FantasyTeamsDTO();
		
		dto.setTeamId(fantasyTeams.getTeamId());
		dto.setTeamName(fantasyTeams.getTeamName());
		
//		List<PlayersDTO> players = new ArrayList<>();
//		for (Players player : fantasyTeams.getPlayers()) {
//			players.add(this.playersMapper.mapToDTO(player));
//		}
//		dto.setPlayers(players);
		

		
//		dto.setMainTank(fTeams.getMainTank());
//		dto.setOffTank(fTeams.getOffTank());
//		dto.setHitscanDPS(fTeams.getHitscanDPS());
//		dto.setFlexDPS(fTeams.getFlexDPS());
//		dto.setMainSupport(fTeams.getMainSupport());
//		dto.setFlexSupport(fTeams.getFlexSupport());
		return dto;
	}

	@Override
	public FantasyTeams mapFromDTO(FantasyTeamsDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
