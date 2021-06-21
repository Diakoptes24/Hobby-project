package com.qa.hobbyproject.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import com.qa.hobbyproject.domain.FantasyTeams;



class FantasyTeamsTest {

	@Test
		void equalsHashCodeTest() {
			
			FantasyTeams firstTeam = new FantasyTeams(1L, "Philadelphia Fusion");
			FantasyTeams secondTeam = new FantasyTeams(1L, "Philadelphia Fusion");
		
			assertTrue(firstTeam.equals(secondTeam) && secondTeam.equals(firstTeam));

		    assertEquals(firstTeam.hashCode(), secondTeam.hashCode());
		    
		
	}

}
