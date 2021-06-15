package com.qa.Hobbyproject.service;

import java.util.List;
import java.util.stream.Collectors;

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
}
