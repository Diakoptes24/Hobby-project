package com.qa.hobbyproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hobbyproject.domain.FantasyTeams;
import com.qa.hobbyproject.dto.FantasyTeamsDTO;
import com.qa.hobbyproject.repo.FantasyTeamsRepo;

@SpringBootTest
@ActiveProfiles("test")
class FantasyTeamsServiceUnitTest {

	@Autowired
	private FantasyTeamsService service;

	@MockBean
	private FantasyTeamsRepo repo;
	
	@MockBean
	private ModelMapper mapper;
	
	@Test
	void testCreate() {
		
		//given
		
		
		FantasyTeams testData = new FantasyTeams("Washington Justice");
		FantasyTeamsDTO testDTO = new FantasyTeamsDTO("Washington Justice");
		FantasyTeams newTeam = new FantasyTeams(2L, "Washington Justice");
		FantasyTeamsDTO newTeamDTO = new FantasyTeamsDTO(2L, "Washington Justice");

		//when
		Mockito.when(this.repo.save(testData)).thenReturn(newTeam);
		Mockito.when(this.mapper.map(testDTO, FantasyTeams.class)).thenReturn(testData);
		Mockito.when(this.mapper.map(newTeam, FantasyTeamsDTO.class)).thenReturn(newTeamDTO);
		

		//then
		assertThat(this.service.createFantasyTeam(testDTO)).isEqualTo(newTeamDTO);

		Mockito.verify(this.repo, Mockito.times(1)).save(testData);
		Mockito.verify(this.mapper, Mockito.times(1)).map(newTeam, FantasyTeamsDTO.class);
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
		Mockito.when(this.mapper.map(current, FantasyTeamsDTO.class)).thenReturn(currentDTO);
		//then
		assertThat(this.service.getFantasyTeams()).isEqualTo(showAllDTO);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		Mockito.verify(this.mapper, Mockito.times(1)).map(current, FantasyTeamsDTO.class);
	}

	@Test
	void testUpdate() {
		// GIVEN
		Long testId = 1L;
		FantasyTeams testData = new FantasyTeams(testId, "Florida Mayhem");
		FantasyTeamsDTO testDTO = new FantasyTeamsDTO(testId, "Florida Mayhem");
		FantasyTeams current = new FantasyTeams(testId, "Surrey Stags");
		FantasyTeams updatedTeam = new FantasyTeams(testId, "Surrey Stags");
		FantasyTeamsDTO updatedDTO = new FantasyTeamsDTO(testId, "Surrey Stags");

		// WHEN
		Mockito.when(this.repo.findById(testId)).thenReturn(Optional.of(current));
		Mockito.when(this.repo.save(testData)).thenReturn(updatedTeam);
		Mockito.when(this.mapper.map(updatedTeam, FantasyTeamsDTO.class)).thenReturn(updatedDTO);

		// THEN
		assertThat(this.service.updateTeam(testId, testDTO)).isEqualTo(updatedDTO);

		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
		Mockito.verify(this.repo, Mockito.times(1)).save(testData);
		Mockito.verify(this.mapper, Mockito.times(1)).map(updatedTeam, FantasyTeamsDTO.class);
	}
	
	@Test
	void testDelete() {
		//given
		Long testId = 1L;
		boolean exists = false;
		//when
		Mockito.when(this.repo.existsById(testId)).thenReturn(exists);

		//then
		assertThat(this.service.deleteTeam(testId)).isEqualTo(!exists);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(testId);
	}
}
