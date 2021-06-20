package com.qa.Hobbyproject.dto;


import org.junit.jupiter.api.Test;


import nl.jqno.equalsverifier.EqualsVerifier;

class FantasyTeamsDTOTest {

	@Test
	public void equalsHashCodeTest() {
		
		//FantasyTeams teamOne = 
		
	    EqualsVerifier.simple().forClass(FantasyTeamsDTO.class).verify();
}


}
