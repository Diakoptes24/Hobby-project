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
import com.qa.hobbyproject.domain.Players;
import com.qa.hobbyproject.dto.FantasyTeamsDTO;
import com.qa.hobbyproject.dto.PlayersDTO;
import com.qa.hobbyproject.repo.PlayersRepo;
import com.qa.hobbyproject.service.PlayersService;

@SpringBootTest
@ActiveProfiles("test")
class PlayersServiceUnitTest {

	
	@Autowired
	private PlayersService service;

	@MockBean
	private PlayersRepo repo;
	
	@MockBean
	private ModelMapper mapper;
	
	@Test
	void testCreate() {
		//given
		Players testData = new Players("Haksal", "Flex DPS");
		PlayersDTO testDTO = new PlayersDTO("Haksal", "Flex DPS");
		Players newPlayer = new Players(3L, "Haksal", "Flex DPS");
		PlayersDTO newDTO = new PlayersDTO(3L, "Haksal", "Flex DPS");

		//when
		Mockito.when(this.repo.save(testData)).thenReturn(newPlayer);
		Mockito.when(this.mapper.map(testDTO, Players.class)).thenReturn(testData);
		Mockito.when(this.mapper.map(newPlayer, PlayersDTO.class)).thenReturn(newDTO);
		
//		System.out.println(testData);
//		System.out.println(newPlayerDTO);
		//then
		assertThat(this.service.createPlayer(1L, testDTO)).isEqualTo(newDTO);
		
		
		
		Mockito.verify(this.repo, Mockito.times(1)).save(testData);
		Mockito.verify(this.mapper, Mockito.times(1)).map(newPlayer, PlayersDTO.class);
		
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
		Mockito.when(this.mapper.map(current, PlayersDTO.class)).thenReturn(currentDTO);
		//then
		
		System.out.println(service.getPlayers());
		
		assertThat(this.service.getPlayers()).isEqualTo(showAllDTO);
		Mockito.verify(this.repo, Mockito.times(2)).findAll();
		Mockito.verify(this.mapper, Mockito.times(2)).map(current, PlayersDTO.class);
		
	}
	
	@Test
	void testUpdate() {
		//given
		Long testId = 1L;
		Players testData = new Players(testId, "Slime", "Main Support");
		PlayersDTO testDTO = new PlayersDTO(testId, "Slime", "Main Support");
		Players current = new Players(testId, "Yaki", "Flex DPS");
		Players updatedPlayer = new Players(testId, "Yaki", "Flex DPS");
		PlayersDTO updatedDTO = new PlayersDTO(testId, "Yaki", "Flex DPS");

		//when
		Mockito.when(this.repo.findById(testId)).thenReturn(Optional.of(current));
		Mockito.when(this.repo.save(testData)).thenReturn(updatedPlayer);
		Mockito.when(this.mapper.map(updatedPlayer, PlayersDTO.class)).thenReturn(updatedDTO);

		//then
		assertThat(this.service.updatePlayer(testId, testDTO)).isEqualTo(updatedDTO);

		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
		Mockito.verify(this.repo, Mockito.times(1)).save(testData);
		Mockito.verify(this.mapper, Mockito.times(1)).map(updatedPlayer, PlayersDTO.class);
	}
	
	@Test
	void testDelete() {
		//given
		Long testId = 1L;
		boolean exists = false;
		//when
		Mockito.when(this.repo.existsById(testId)).thenReturn(exists);

		//then
		assertThat(this.service.deletePlayer(testId)).isEqualTo(!exists);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(testId);
	}


}
