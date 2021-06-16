package com.qa.Hobbyproject.service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

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
	
	public List<PlayersDTO> getPlayers() {
		return this.playersRepo.findAll().stream().map(player -> this.playersMapper.mapToDTO(player)).collect(Collectors.toList());
	}
	
	public PlayersDTO updatePlayer(Long playerId, Players newData) {
		Players existing = this.playersRepo.findById(playerId).orElseThrow(() -> new EntityNotFoundException()); // fetch existing from
																								// db
		existing.setPlayerIGN(newData.getPlayerIGN()); // update the values
		existing.setRole(newData.getRole());

		Players updated = this.playersRepo.save(existing); // save it back to overwrite original

		return this.playersMapper.mapToDTO(updated);
	}
	
//	public PlayersDTO findPlayer(Long playerId) {
//		Optional<Players> optionalPlayers = this.playersRepo.findById(playerId);
//		Players found = optionalPlayers.orElseThrow(() -> new EntityNotFoundException());
//		return this.playersMapper.mapToDTO(found);
//	}
	
	public boolean deletePlayer(Long playerId) {
		this.playersRepo.deleteById(playerId);
		return !this.playersRepo.existsById(playerId);
	}
}
