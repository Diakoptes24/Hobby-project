package com.qa.Hobbyproject.rest;

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

import com.qa.Hobbyproject.domain.Players;
import com.qa.Hobbyproject.dto.PlayersDTO;
import com.qa.Hobbyproject.service.PlayersService;

@RestController
@RequestMapping("/players")
public class PlayersController {
	
	private PlayersService playersService;

	@Autowired
	public PlayersController(PlayersService playersService) {
		super();
		this.playersService = playersService;
	}
	
	@PostMapping("/create")
	public PlayersDTO createPlayer(@RequestBody Players players) {
		return this.playersService.createPlayer(players);
	}
	
	@GetMapping("/")
	public List<PlayersDTO> getPlayers() {
		return this.playersService.getPlayers();
	}
	
	@GetMapping("/find/{id}")
	public PlayersDTO find(@PathVariable Long playerId) {
		return this.playersService.findPlayer(playerId);
	}
	
	@PutMapping("/update/{playerId}")
	public PlayersDTO updatePlayer(@RequestBody Players players, @PathVariable Long playerId) {
		return this.playersService.updatePlayer(playerId, players);
	}
	
	@DeleteMapping("/remove/{playerId}")
	public boolean delete(@PathVariable Long playerId) {
		return this.playersService.delete(playerId);
	}
//	@GetMapping("/populate")
//	public String addOptions(Players players, Model model){
//	    model.addAttribute("players", PlayersRepo.findBySubRoleIgnoreCase(getSubRole()));
//	    return "addOptions";
//	}

	
	
}
