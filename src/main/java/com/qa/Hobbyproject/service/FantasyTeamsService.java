package com.qa.Hobbyproject.service;

import org.springframework.stereotype.Service;

import com.qa.Hobbyproject.domain.FantasyTeams;
import com.qa.Hobbyproject.dto.FantasyTeamsDTO;
import com.qa.Hobbyproject.repo.FantasyTeamsRepo;
import com.qa.Hobbyproject.utils.FantasyTeamsMapper;

@Service
public class FantasyTeamsService {

	private FantasyTeamsRepo fTeamsRepo;
	
	private FantasyTeamsMapper fTeamsMapper;

	public FantasyTeamsService(FantasyTeamsRepo fTeamsRepo, FantasyTeamsMapper fTeamsMapper) {
		super();
		this.fTeamsRepo = fTeamsRepo;
		this.fTeamsMapper = fTeamsMapper;
	}
	
	public FantasyTeamsDTO createFantasyTeam(FantasyTeams fTeams) {
		FantasyTeams saved = this.fTeamsRepo.save(fTeams);
		return this.fTeamsMapper.mapToDTO(saved);
	}
}
