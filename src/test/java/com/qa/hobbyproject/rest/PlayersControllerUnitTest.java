package com.qa.hobbyproject.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hobbyproject.domain.Players;
import com.qa.hobbyproject.dto.PlayersDTO;
import com.qa.hobbyproject.rest.PlayersController;
import com.qa.hobbyproject.service.PlayersService;

@SpringBootTest
@ActiveProfiles("test")
class PlayersControllerUnitTest {

	@Autowired
	private PlayersController controller;

	@MockBean
	private PlayersService service;

	@Test
	void testCreatePlayer() {
		//given
		long testId = 3L;
		PlayersDTO testData = new PlayersDTO("Haksal", "Flex DPS");
		PlayersDTO newDTO = new PlayersDTO(3L, "Haksal", "Flex DPS");
		
		//when
		Mockito.when(this.service.createPlayer(testId, testData)).thenReturn(newDTO);
		
		//then
		assertThat(this.controller.createPlayer(testId, testData)).isEqualTo(newDTO);
		
		Mockito.verify(this.service, Mockito.times(1)).createPlayer(testId, testData);
	}
	
	@Test
	void testGetPlayer() {
		//given
		PlayersDTO currentDTO = new PlayersDTO(1L, "Yaki", "Flex DPS");
		List<PlayersDTO> showAll = List.of(currentDTO);
		//when
		Mockito.when(this.service.getPlayers()).thenReturn(showAll);
		//then
		assertThat(this.controller.getPlayers()).isEqualTo(showAll);
		Mockito.verify(this.service, Mockito.times(1)).getPlayers();
	}
	
	@Test
	void testUpdate() {
		// GIVEN
		Long testId = 1L;
		PlayersDTO testData = new PlayersDTO(1L, "Slime", "Main Support");
		PlayersDTO updatedPlayer = new PlayersDTO(testId, "Slime", "Main Support");
		PlayersDTO updatedDTO = new PlayersDTO(testId, "Slime", "Main Support");

		// WHEN
		
		Mockito.when(this.service.updatePlayer(testId, testData)).thenReturn(updatedDTO);

		// THEN
		assertThat(this.controller.updatePlayer(testData, testId)).isEqualTo(updatedDTO);
		Mockito.verify(this.service, Mockito.times(1)).updatePlayer(testId, updatedPlayer);
	}
	
	@Test
	void testDelete() {
		//given
		Long testId = 1L;
		
		//when
		Mockito.when(this.service.deletePlayer(testId)).thenReturn(true);

		//then
		assertThat(this.controller.delete(testId)).isTrue();

		Mockito.verify(this.service, Mockito.times(1)).deletePlayer(testId);
	}

}
