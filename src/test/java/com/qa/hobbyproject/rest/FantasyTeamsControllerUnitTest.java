package com.qa.hobbyproject.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hobbyproject.dto.FantasyTeamsDTO;
import com.qa.hobbyproject.service.FantasyTeamsService;

@SpringBootTest
@ActiveProfiles("test")
class FantasyTeamsControllerUnitTest {

	@Autowired
	private FantasyTeamsController controller;

	@MockBean
	private FantasyTeamsService service;
	
	@Test
	void testCreatePlayer() {
		//given
		//FantasyTeams testData = new FantasyTeams("Florida Mayhem");
		FantasyTeamsDTO newDTO1 = new FantasyTeamsDTO("Florida Mayhem");
		FantasyTeamsDTO newDTO = new FantasyTeamsDTO(3L, "Florida Mayhem");
		
		//when
		Mockito.when(this.service.createFantasyTeam(newDTO1)).thenReturn(newDTO);
		
		//then
		assertThat(this.controller.createFantasyTeam(newDTO1)).isEqualTo(newDTO);
		
		Mockito.verify(this.service, Mockito.times(1)).createFantasyTeam(newDTO1);
	}
	
	@Test
	void testGetFantasyTeams() {
		//given
		FantasyTeamsDTO currentDTO = new FantasyTeamsDTO(1L, "Surrey Stags");
		List<FantasyTeamsDTO> showAll = List.of(currentDTO);
		//when
		Mockito.when(this.service.getFantasyTeams()).thenReturn(showAll);
		//then
		assertThat(this.controller.getFantasyTeams()).isEqualTo(showAll);
		Mockito.verify(this.service, Mockito.times(1)).getFantasyTeams();
	}
	
	@Test
	void testUpdateTeams() {
		// GIVEN
		Long testId = 1L;
		//FantasyTeams testData = new FantasyTeams("Florida Mayhem");
		FantasyTeamsDTO DTO = new FantasyTeamsDTO("Florida Mayhem");
		FantasyTeamsDTO updatedDTO = new FantasyTeamsDTO(testId, "Florida Mayhem");

		// WHEN
		
		Mockito.when(this.service.updateTeam(testId, DTO)).thenReturn(updatedDTO);

		// THEN
		assertThat(this.service.updateTeam(testId, DTO)).isEqualTo(updatedDTO);
		Mockito.verify(this.service, Mockito.times(1)).updateTeam(testId, DTO);
	}
	
	@Test
	void testDelete() {
		//given
		Long testId = 1L;
		
		//when
		Mockito.when(this.service.deleteTeam(testId)).thenReturn(true);

		//then
		assertThat(this.controller.delete(testId)).isTrue();

		Mockito.verify(this.service, Mockito.times(1)).deleteTeam(testId);
	}
}
