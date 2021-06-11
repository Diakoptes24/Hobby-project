package com.qa.Hobbyproject.service;



import org.springframework.stereotype.Service;

import com.qa.Hobbyproject.domain.Players;
import com.qa.Hobbyproject.dto.PlayersDTO;
import com.qa.Hobbyproject.repo.PlayersRepo;
import com.qa.Hobbyproject.utils.PlayersMapper;

@Service
public class PlayersService {

	private PlayersRepo playersRepo;
	
	private PlayersMapper playersMapper;

	public PlayersService(PlayersRepo playersRepo, PlayersMapper playersMapper) {
		super();
		this.playersRepo = playersRepo;
		this.playersMapper = playersMapper;
	}
	
	public PlayersDTO createPlayer(Players players) {
		Players saved = this.playersRepo.save(players);
		return this.playersMapper.mapToDTO(saved);
	}
	
	
}
