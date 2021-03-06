package com.qa.hobbyproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.hobbyproject.domain.FantasyTeams;
import com.qa.hobbyproject.dto.FantasyTeamsDTO;
import com.qa.hobbyproject.repo.FantasyTeamsRepo;

@Service
public class FantasyTeamsService {

	private FantasyTeamsRepo fantasyTeamsRepo;
	
	private ModelMapper fantasyTeamsMapper;

	public FantasyTeamsService(FantasyTeamsRepo fantasyTeamsRepo, ModelMapper fantasyTeamsMapper) {
		super();
		this.fantasyTeamsRepo = fantasyTeamsRepo;
		this.fantasyTeamsMapper = fantasyTeamsMapper;
	}
	
	public FantasyTeamsDTO createFantasyTeam(FantasyTeamsDTO fantasyTeamsDTO) {
		var fantasyTeam = this.fantasyTeamsMapper.map(fantasyTeamsDTO, FantasyTeams.class);
		FantasyTeams saved = this.fantasyTeamsRepo.save(fantasyTeam);
		return this.fantasyTeamsMapper.map(saved, FantasyTeamsDTO.class);
	}
	
	public List<FantasyTeamsDTO> getFantasyTeams() {
		return this.fantasyTeamsRepo.findAll().stream().map(fantasyTeam -> this.fantasyTeamsMapper.map(fantasyTeam, FantasyTeamsDTO.class)).collect(Collectors.toList());
	}
	
	public FantasyTeamsDTO updateTeam(Long teamId, FantasyTeamsDTO newData) {
		FantasyTeams existing = this.fantasyTeamsRepo.findById(teamId).orElseThrow(() -> new EntityNotFoundException()); // fetch existing from
																								// db
		existing.setTeamName(newData.getTeamName()); 

		FantasyTeams updated = this.fantasyTeamsRepo.save(existing); // save it back to overwrite original

		return this.fantasyTeamsMapper.map(updated, FantasyTeamsDTO.class);
	}
	
	public FantasyTeamsDTO findTeam(Long teamId) {
		Optional<FantasyTeams> optionalTeams = this.fantasyTeamsRepo.findById(teamId);
		FantasyTeams found = optionalTeams.orElseThrow(() -> new EntityNotFoundException());
		return this.fantasyTeamsMapper.map(found, FantasyTeamsDTO.class);
	}
	
	public boolean deleteTeam(Long teamId) {
		this.fantasyTeamsRepo.deleteById(teamId);
		return !this.fantasyTeamsRepo.existsById(teamId);
	}
}
