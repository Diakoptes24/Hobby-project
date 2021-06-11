package com.qa.Hobbyproject.utils;

import org.springframework.stereotype.Service;

import com.qa.Hobbyproject.domain.Players;
import com.qa.Hobbyproject.dto.PlayersDTO;

@Service
public class PlayersMapper implements Mapper<Players, PlayersDTO>{

	@Override
	public PlayersDTO mapToDTO(Players players) {
		PlayersDTO dto = new PlayersDTO();

		
		dto.setPlayerId(players.getPlayerId());
		dto.setPlayerIGN(players.getPlayerIGN());
		dto.setRole(players.getRole());
		dto.setSubRole(players.getSubRole());
		dto.setCurrentTeam(players.getCurrentTeam());

		return dto;
	}

	@Override
	public Players mapFromDTO(PlayersDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
