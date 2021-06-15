package com.qa.Hobbyproject.service;

import static org.assertj.core.api.Assertions.assertThat;

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

}
