package com.qa.Hobbyproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.Hobbyproject.domain.Players;

@Repository
public interface PlayersRepo extends JpaRepository<Players, Long> {
	
	List<Players> findByRoleIgnoreCase(String role);

}
