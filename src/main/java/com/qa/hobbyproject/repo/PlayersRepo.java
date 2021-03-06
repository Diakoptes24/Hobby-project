package com.qa.hobbyproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobbyproject.domain.Players;
import com.qa.hobbyproject.dto.PlayersDTO;

@Repository
public interface PlayersRepo extends JpaRepository<Players, Long> {
	
	//List<Players> findAllByTeamId(Long teamId);

	List<PlayersDTO> findAllByFantasyTeamsTeamId(Long teamId);


}
