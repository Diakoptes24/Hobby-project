package com.qa.hobbyproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hobbyproject.dto.FantasyTeamsDTO;
import com.qa.hobbyproject.service.FantasyTeamsService;

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
	public FantasyTeamsDTO createFantasyTeam(@RequestBody FantasyTeamsDTO fantasyTeams) {
		return this.fantasyTeamsService.createFantasyTeam(fantasyTeams);
	}
	
	@GetMapping("/")
	public List<FantasyTeamsDTO> getFantasyTeams() {
		return this.fantasyTeamsService.getFantasyTeams();
	}
	
	@GetMapping("/find/{teamId}")
	public FantasyTeamsDTO find(@PathVariable Long teamId) {
		return this.fantasyTeamsService.findTeam(teamId);
	}
	
	
	@PutMapping("/update/{teamId}")
	public FantasyTeamsDTO updateTeam(@RequestBody FantasyTeamsDTO fantasyTeams, @PathVariable Long teamId) {
		return this.fantasyTeamsService.updateTeam(teamId, fantasyTeams);
	}
	
	@DeleteMapping("/remove/{teamId}")
	public boolean delete(@PathVariable Long teamId) {
		return this.fantasyTeamsService.deleteTeam(teamId);
	}
}
