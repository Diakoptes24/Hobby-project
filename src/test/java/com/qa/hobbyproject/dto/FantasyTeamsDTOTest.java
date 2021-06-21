package com.qa.hobbyproject.dto;


import org.junit.jupiter.api.Test;

import com.qa.hobbyproject.dto.FantasyTeamsDTO;

import nl.jqno.equalsverifier.EqualsVerifier;

class FantasyTeamsDTOTest {

	@Test
	void equalsHashCodeTest() {
		
		//FantasyTeams teamOne = 
		
	    EqualsVerifier.simple().forClass(FantasyTeamsDTO.class).verify();
}


}
