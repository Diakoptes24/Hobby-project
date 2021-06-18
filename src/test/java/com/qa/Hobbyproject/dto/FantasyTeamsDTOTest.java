package com.qa.Hobbyproject.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.qa.Hobbyproject.domain.FantasyTeams;

import nl.jqno.equalsverifier.EqualsVerifier;

class FantasyTeamsDTOTest {

	@Test
	public void equalsHashCodeTest() {
		
		//FantasyTeams teamOne = 
		
	    EqualsVerifier.simple().forClass(FantasyTeamsDTO.class).verify();
}


}
