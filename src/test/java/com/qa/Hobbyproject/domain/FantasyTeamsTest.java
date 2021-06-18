package com.qa.Hobbyproject.domain;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;



class FantasyTeamsTest {

	@Test
		public void equalsHashCodeTest() {
			
			FantasyTeams firstTeam = new FantasyTeams(1L, "Philadelphia Fusion");
			FantasyTeams secondTeam = new FantasyTeams(1L, "Philadelphia Fusion");
		
			assertTrue(firstTeam.equals(secondTeam) && secondTeam.equals(firstTeam));

		    assertTrue(firstTeam.hashCode() == secondTeam.hashCode());
		    
		
	}

}
