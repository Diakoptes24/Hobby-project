package com.qa.Hobbyproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
		Players testPlayers = new Players("Fearless", "Tank", "Main Tank", "Dallas Fuel");
		String testPlayersAsJSON = this.mapper.writeValueAsString(testPlayers);

		Players testSavedPlayer = new Players("Fearless", "Tank", "Main Tank", "Dallas Fuel");
		testSavedPlayer.setPlayerId((long) 2);
		String testSavedPlayersAsJSON = this.mapper.writeValueAsString(testSavedPlayer);

		RequestBuilder mockRequest = post("/players/create").content(testPlayersAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(testSavedPlayersAsJSON);

		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

	}
}
