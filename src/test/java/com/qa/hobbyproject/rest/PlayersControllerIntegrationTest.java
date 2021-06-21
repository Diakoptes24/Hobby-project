package com.qa.hobbyproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hobbyproject.domain.FantasyTeams;
import com.qa.hobbyproject.domain.Players;
import com.qa.hobbyproject.dto.PlayersDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:fantasyTeams-schema.sql",
		"classpath:fantasyTeams-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
class PlayersControllerIntegrationTest {

	@Autowired
	private MockMvc mvc; 

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		FantasyTeams team = new FantasyTeams(1L, null);
		Players testPlayers = new Players("Fearless", "Main Tank", team);
		String testPlayersAsJSON = this.mapper.writeValueAsString(testPlayers);

		PlayersDTO testSavedPlayer = new PlayersDTO("Fearless", "Main Tank");
		testSavedPlayer.setPlayerId((long) 2);
		String testSavedPlayersAsJSON = this.mapper.writeValueAsString(testSavedPlayer);

		RequestBuilder mockRequest = post("/players/create/1").content(testPlayersAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(testSavedPlayersAsJSON);

		
		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	
	}
	
	@Test
	void testGetAll() throws Exception {
		PlayersDTO testPlayer = new PlayersDTO(1L, "Yaki", "Flex DPS");
		List<PlayersDTO> testPlayers = new ArrayList<>(); //List.of(testPlayer);
		testPlayers.add(testPlayer);
		String testPlayersAsJSONArray = this.mapper.writeValueAsString(testPlayers);

		this.mvc.perform(get("/players/")).andExpect(status().isOk()).andExpect(content().json(testPlayersAsJSONArray));

	}
	
	@Test
	void testUpdatePlayer() throws Exception {
		FantasyTeams team = new FantasyTeams(1L, null);
		Players testPlayers = new Players(1L, "Fearless", "Main Tank", team);
		String testPlayersAsJSON = this.mapper.writeValueAsString(testPlayers);
		
		PlayersDTO testPlayersDTO = new PlayersDTO(1L, "Fearless", "Main Tank");
		String testPlayersDTOAsJSON = this.mapper.writeValueAsString(testPlayersDTO);
		
		RequestBuilder mockRequest = put("/players/update/1").content(testPlayersAsJSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		this.mvc.perform(mockRequest).andExpect(status().isOk()).andExpect(content().json(testPlayersDTOAsJSON));
	}
	
	@Test
	void testDeletePlayer() throws Exception {
			RequestBuilder mockRequest = delete("/players/remove/1");

			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().string("true");

			this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}
}
