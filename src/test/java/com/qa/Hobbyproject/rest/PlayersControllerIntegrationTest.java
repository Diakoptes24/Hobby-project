package com.qa.Hobbyproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.qa.Hobbyproject.domain.Players;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:fantasyTeams-schema.sql",
		"classpath:fantasyTeams-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PlayersControllerIntegrationTest {

	@Autowired
	private MockMvc mvc; // allows us to send mock requests

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Players testPlayers = new Players("Fearless", "Main Tank");
		String testPlayersAsJSON = this.mapper.writeValueAsString(testPlayers);

		Players testSavedPlayer = new Players("Fearless", "Main Tank");
		testSavedPlayer.setPlayerId((long) 2);
		String testSavedPlayersAsJSON = this.mapper.writeValueAsString(testSavedPlayer);

		RequestBuilder mockRequest = post("/players/create").content(testPlayersAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(testSavedPlayersAsJSON);

//		System.out.println(checkBody);
//		System.out.println(checkStatus);
//		System.out.println(mockRequest);
		
		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	
	}
	
	@Test
	void testGetAll() throws Exception {
		Players testPlayer = new Players(1L, "Yaki", "Flex DPS");
		List<Players> testPlayers = List.of(testPlayer);
		String testPlayersAsJSONArray = this.mapper.writeValueAsString(testPlayers);

		this.mvc.perform(get("/players/")).andExpect(status().isOk()).andExpect(content().json(testPlayersAsJSONArray));

	}
	
	@Test
	void testupdatePlayer() throws Exception {
		Players testPlayers = new Players(1L, "Fearless", "Main Tank");
		String testPlayersAsJSON = this.mapper.writeValueAsString(testPlayers);
		
		RequestBuilder mockRequest = put("/players/update/1").content(testPlayersAsJSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		this.mvc.perform(mockRequest).andExpect(status().isOk()).andExpect(content().json(testPlayersAsJSON));
	}
	
}
