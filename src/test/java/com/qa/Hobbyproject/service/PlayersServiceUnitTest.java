package com.qa.Hobbyproject.service;

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
import com.qa.Hobbyproject.repo.PlayersRepo;

@SpringBootTest
@ActiveProfiles("test")
class PlayersServiceUnitTest {

	
	@Autowired
	private PlayersService service;

	@MockBean
	private PlayersRepo repo;
	
	@Test
	void testCreate() {
		//given
		Players testData = new Players("Haksal", "Flex DPS");
		Players newPlayer = new Players(3L, "Haksal", "Flex DPS");
		PlayersDTO newPlayerDTO = new PlayersDTO(3L, "Haksal", "Flex DPS");

		//when
		Mockito.when(this.repo.save(testData)).thenReturn(newPlayer);
		
		
//		System.out.println(testData);
//		System.out.println(newPlayerDTO);
		//then
		assertThat(this.service.createPlayer(testData)).isEqualTo(newPlayerDTO);
		
		
	
		Mockito.verify(this.repo, Mockito.times(1)).save(testData);
		
	}
	
	@Test
	void testGetPlayer() {
		//given
		Players current = new Players(1L, "Yaki", "Flex DPS");
		List<Players> showAll = List.of(current);
		PlayersDTO currentDTO = new PlayersDTO(1L, "Yaki", "Flex DPS");
		List<PlayersDTO> showAllDTO = List.of(currentDTO);
		//when
		Mockito.when(this.repo.findAll()).thenReturn(showAll);
		//then
		assertThat(this.service.getPlayers()).isEqualTo(showAllDTO);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

}
