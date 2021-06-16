package com.qa.Hobbyproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.Hobbyproject.domain.FantasyTeams;
import com.qa.Hobbyproject.dto.FantasyTeamsDTO;
import com.qa.Hobbyproject.repo.FantasyTeamsRepo;
import com.qa.Hobbyproject.utils.FantasyTeamsMapper;

@Service
public class FantasyTeamsService {

	private FantasyTeamsRepo fantasyTeamsRepo;
	
	private FantasyTeamsMapper fantasyTeamsMapper;

	public FantasyTeamsService(FantasyTeamsRepo fantasyTeamsRepo, FantasyTeamsMapper fantasyTeamsMapper) {
		super();
		this.fantasyTeamsRepo = fantasyTeamsRepo;
		this.fantasyTeamsMapper = fantasyTeamsMapper;
	}
	
	public FantasyTeamsDTO createFantasyTeam(FantasyTeams fantasyTeams) {
		FantasyTeams saved = this.fantasyTeamsRepo.save(fantasyTeams);
		return this.fantasyTeamsMapper.mapToDTO(saved);
	}
	
	public List<FantasyTeamsDTO> getFantasyTeams() {
		return this.fantasyTeamsRepo.findAll().stream().map(fantasyTeam -> this.fantasyTeamsMapper.mapToDTO(fantasyTeam)).collect(Collectors.toList());
	}
	
	public FantasyTeamsDTO updateTeam(Long fantasyTeamId, FantasyTeams newData) {
		FantasyTeams existing = this.fantasyTeamsRepo.findById(fantasyTeamId).orElseThrow(() -> new EntityNotFoundException()); // fetch existing from
																								// db
		existing.setTeamName(newData.getTeamName()); 

		FantasyTeams updated = this.fantasyTeamsRepo.save(existing); // save it back to overwrite original

		return this.fantasyTeamsMapper.mapToDTO(updated);
	}
	
//	public FantasyTeamsDTO findTeam(Long teamId) {
//		Optional<FantasyTeams> optionalTeams = this.fantasyTeamsRepo.findById(teamId);
//		FantasyTeams found = optionalTeams.orElseThrow(() -> new EntityNotFoundException());
//		return this.fantasyTeamsMapper.mapToDTO(found);
//	}
	
	public boolean deleteTeam(Long teamId) {
		this.fantasyTeamsRepo.deleteById(teamId);
		return !this.fantasyTeamsRepo.existsById(teamId);
	}
}
