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

	private FantasyTeamsService fantasyTeamsService;

	@Autowired
	public FantasyTeamsController(FantasyTeamsService fantasyTeamsService) {
		super();
		this.fantasyTeamsService = fantasyTeamsService;
	}
	
	@PostMapping("/create")
	public FantasyTeamsDTO createFantasyTeam(@RequestBody FantasyTeams fantasyTeams) {
		return this.fantasyTeamsService.createFantasyTeam(fantasyTeams);
	}
}
