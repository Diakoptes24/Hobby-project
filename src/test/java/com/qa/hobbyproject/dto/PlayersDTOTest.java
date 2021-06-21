package com.qa.hobbyproject.dto;


import org.junit.jupiter.api.Test;

import com.qa.hobbyproject.dto.PlayersDTO;

import nl.jqno.equalsverifier.EqualsVerifier;

class PlayersDTOTest {

	@Test
	void equalsHashCodeTest() {
		
		//FantasyTeams teamOne = 
		
	    EqualsVerifier.simple().forClass(PlayersDTO.class).verify();
}

}
