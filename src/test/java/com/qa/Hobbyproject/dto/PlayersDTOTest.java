package com.qa.Hobbyproject.dto;


import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

class PlayersDTOTest {

	@Test
	public void equalsHashCodeTest() {
		
		//FantasyTeams teamOne = 
		
	    EqualsVerifier.simple().forClass(PlayersDTO.class).verify();
}

}
