package com.qa.Hobbyproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.Hobbyproject.domain.FantasyTeams;

@Repository
public interface FantasyTeamsRepo extends JpaRepository<FantasyTeams, Long> {

}
