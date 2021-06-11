package com.qa.Hobbyproject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.Hobbyproject.domain.FantasyTeams;
import com.qa.Hobbyproject.dto.FantasyTeamsDTO;
import com.qa.Hobbyproject.service.FantasyTeamsService;

@RestController
@RequestMapping("/fantasyteams")
public class FantasyTeamsController {

	private FantasyTeamsService fTService;

	@Autowired
	public FantasyTeamsController(FantasyTeamsService fTService) {
		super();
		this.fTService = fTService;
	}
	
	@PostMapping("/create")
	public FantasyTeamsDTO createFantasyTeam(@RequestBody FantasyTeams fTeams) {
		return this.fTService.createFantasyTeam(fTeams);
	}
}
