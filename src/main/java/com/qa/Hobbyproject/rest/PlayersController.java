package com.qa.Hobbyproject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.Hobbyproject.domain.Players;
import com.qa.Hobbyproject.dto.PlayersDTO;
import com.qa.Hobbyproject.service.PlayersService;

@RestController
@RequestMapping("/players")
public class PlayersController {
	
	private PlayersService playersService;

	@Autowired
	public PlayersController(PlayersService pService) {
		super();
		this.playersService = pService;
	}
	
	@PostMapping("/create")
	public PlayersDTO createPlayer(@RequestBody Players players) {
		return this.playersService.createPlayer(players);
	}
	
//	@GetMapping("/populate")
//	public String addOptions(Players players, Model model){
//	    model.addAttribute("players", PlayersRepo.findBySubRoleIgnoreCase(getSubRole()));
//	    return "addOptions";
//	}

	
	
}
