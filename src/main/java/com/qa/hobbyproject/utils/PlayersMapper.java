package com.qa.hobbyproject.utils;

import org.springframework.stereotype.Service;

import com.qa.hobbyproject.domain.Players;
import com.qa.hobbyproject.dto.PlayersDTO;

@Service
public class PlayersMapper implements Mapper<Players, PlayersDTO>{

	@Override
	public PlayersDTO mapToDTO(Players players) {
		PlayersDTO dto = new PlayersDTO();

		
		dto.setPlayerId(players.getPlayerId());
		dto.setPlayerIGN(players.getPlayerIGN());
		dto.setRole(players.getRole());
		

		return dto;
	}

	@Override
	public Players mapFromDTO(PlayersDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
