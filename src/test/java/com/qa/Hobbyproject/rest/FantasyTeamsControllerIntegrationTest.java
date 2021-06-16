package com.qa.Hobbyproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.qa.Hobbyproject.domain.FantasyTeams;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:teamsTest-schema.sql",
		"classpath:teamsTest-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class FantasyTeamsControllerIntegrationTest {

	@Autowired
	private MockMvc mvc; // allows us to send mock requests

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		FantasyTeams testFantasyTeams = new FantasyTeams("Dallas Fuel");
		String testTeamsAsJSON = this.mapper.writeValueAsString(testFantasyTeams);

		FantasyTeams testSavedTeam = new FantasyTeams("Dallas Fuel");
		testSavedTeam.setTeamId((long) 2);
		String testSavedTeamsAsJSON = this.mapper.writeValueAsString(testSavedTeam);

		RequestBuilder mockRequest = post("/fantasyteams/create").content(testTeamsAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(testSavedTeamsAsJSON);

		
		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
}
	
	@Test
	void testGetAll() throws Exception {
		FantasyTeams testTeam = new FantasyTeams(1L, "Surrey Stags");
		List<FantasyTeams> testTeams = List.of(testTeam);
		String testTeamsAsJSONArray = this.mapper.writeValueAsString(testTeams);

		this.mvc.perform(get("/fantasyteams/")).andExpect(status().isOk()).andExpect(content().json(testTeamsAsJSONArray));
	}
	
	@Test
	void testupdateTeam() throws Exception {
		FantasyTeams testTeams = new FantasyTeams(1L, "Dallas Fuel");
		String testTeamsAsJSON = this.mapper.writeValueAsString(testTeams);
		
		RequestBuilder mockRequest = put("/fantasyteams/update/1").content(testTeamsAsJSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		this.mvc.perform(mockRequest).andExpect(status().isOk()).andExpect(content().json(testTeamsAsJSON));
	}
	
	@Test
	void testDeleteTeam() throws Exception {
			RequestBuilder mockRequest = delete("/fantasyteams/remove/1");

			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().string("true");

			this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	
}
}
