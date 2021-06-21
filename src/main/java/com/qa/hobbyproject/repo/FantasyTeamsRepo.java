package com.qa.hobbyproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hobbyproject.domain.FantasyTeams;

@Repository
public interface FantasyTeamsRepo extends JpaRepository<FantasyTeams, Long> {

	

}
