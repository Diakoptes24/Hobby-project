package com.qa.hobbyproject.service;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.hobbyproject.domain.FantasyTeams;
import com.qa.hobbyproject.domain.Players;
import com.qa.hobbyproject.dto.PlayersDTO;
import com.qa.hobbyproject.repo.PlayersRepo;

@Service
public class PlayersService {

	private PlayersRepo playersRepo;
	
	private ModelMapper playersMapper;

	public PlayersService(PlayersRepo playersRepo, ModelMapper playersMapper) {
		super();
		this.playersRepo = playersRepo;
		this.playersMapper = playersMapper;
	}
	
	public PlayersDTO createPlayer(Long teamId, PlayersDTO playersDTO) {
		var player = this.playersMapper.map(playersDTO, Players.class);
		player.setFantasyTeams(new FantasyTeams(teamId, ""));
		Players saved = this.playersRepo.save(player);
		return this.playersMapper.map(saved, PlayersDTO.class);
	}
	
	public List<PlayersDTO> getPlayers() {
		return this.playersRepo.findAll().stream().map(player -> this.playersMapper.map(player, PlayersDTO.class)).collect(Collectors.toList());
		
	}
	
	public PlayersDTO updatePlayer(Long playerId, PlayersDTO newData) {
		Players existing = this.playersRepo.findById(playerId).orElseThrow(() -> new EntityNotFoundException()); // fetch existing from
																								// db
		existing.setPlayerIGN(newData.getPlayerIGN()); // update the values
		existing.setRole(newData.getRole());

		Players updated = this.playersRepo.save(existing); // save it back to overwrite original

		return this.playersMapper.map(updated,PlayersDTO.class);
	}
	
	public boolean deletePlayer(Long playerId) {
		this.playersRepo.deleteById(playerId);
		return !this.playersRepo.existsById(playerId);
	}
}
