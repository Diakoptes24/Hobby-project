package com.qa.Hobbyproject.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.Hobbyproject.domain.Players;
import com.qa.Hobbyproject.dto.PlayersDTO;
import com.qa.Hobbyproject.service.PlayersService;

@SpringBootTest
@ActiveProfiles("test")
public class PlayersControllerUnitTest {

	@Autowired
	private PlayersController controller;

	@MockBean
	private PlayersService service;

	@Test
	void testCreatePlayer() {
		//given
		Players testData = new Players("Haksal", "Flex DPS");
		PlayersDTO newDTO = new PlayersDTO(3L, "Haksal", "Flex DPS");
		
		//when
		Mockito.when(this.service.createPlayer(testData)).thenReturn(newDTO);
		
		//then
		assertThat(this.controller.createPlayer(testData)).isEqualTo(newDTO);
		
		Mockito.verify(this.service, Mockito.times(1)).createPlayer(testData);
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
		Players testData = new Players("Slime", "Main Support");
		PlayersDTO updatedDTO = new PlayersDTO(testId, "Slime", "Main Support");

		// WHEN
		
		Mockito.when(this.service.updatePlayer(testId, testData)).thenReturn(updatedDTO);

		// THEN
		assertThat(this.service.updatePlayer(testId, testData)).isEqualTo(updatedDTO);
		Mockito.verify(this.service, Mockito.times(1)).updatePlayer(testId, testData);
	}

}
