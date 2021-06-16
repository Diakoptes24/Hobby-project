package com.qa.Hobbyproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.Hobbyproject.domain.FantasyTeams;
import com.qa.Hobbyproject.dto.FantasyTeamsDTO;
import com.qa.Hobbyproject.repo.FantasyTeamsRepo;

@SpringBootTest
@ActiveProfiles("test")
class FantasyTeamsServiceUnitTest {

	@Autowired
	private FantasyTeamsService service;

	@MockBean
	private FantasyTeamsRepo repo;
	
	@Test
	void testCreate() {
		
		//given
		
		
		FantasyTeams testData = new FantasyTeams("Washington Justice");
		FantasyTeams newTeam = new FantasyTeams(2L, "Washington Justice");
		FantasyTeamsDTO newTeamDTO = new FantasyTeamsDTO(2L, "Washington Justice");

		//when
		Mockito.when(this.repo.save(testData)).thenReturn(newTeam);

		//then
		assertThat(this.service.createFantasyTeam(testData)).isEqualTo(newTeamDTO);

		Mockito.verify(this.repo, Mockito.times(1)).save(testData);
	}
	
	@Test
	void testGetFantasyTeams() {
		//given
		FantasyTeams current = new FantasyTeams(1L, "Surrey Stags");
		List<FantasyTeams> showAll = List.of(current);
		FantasyTeamsDTO currentDTO = new FantasyTeamsDTO(1L, "Surrey Stags");
		List<FantasyTeamsDTO> showAllDTO = List.of(currentDTO);
		//when
		Mockito.when(this.repo.findAll()).thenReturn(showAll);
		//then
		assertThat(this.service.getFantasyTeams()).isEqualTo(showAllDTO);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testUpdate() {
		// GIVEN
		Long testId = 1L;
		FantasyTeams testData = new FantasyTeams("Florida Mayhem");
		FantasyTeams current = new FantasyTeams(1L, "Surrey Stags");
		FantasyTeams updatedTeam = new FantasyTeams(testId, "Florida Mayhem");
		FantasyTeamsDTO updatedDTO = new FantasyTeamsDTO(testId, "Florida Mayhem");

		// WHEN
		Mockito.when(this.repo.findById(testId)).thenReturn(Optional.of(current));
		Mockito.when(this.repo.save(updatedTeam)).thenReturn(updatedTeam);

		// THEN
		assertThat(this.service.updateTeam(testId, testData)).isEqualTo(updatedDTO);

		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
		Mockito.verify(this.repo, Mockito.times(1)).save(updatedTeam);
	}
}
