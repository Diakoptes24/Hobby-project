package com.qa.Hobbyproject.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
class PlayerTest {

//	@Test
//	public void equalsHashCodeContracts() {
//		
//		FantasyTeams teamOne = new FantasyTeams();
//		teamOne.setTeamName("Paris Eternal");
//		
//		FantasyTeams teamTwo = new FantasyTeams();
//		teamTwo.setTeamName("Boston Uprising");
//		
//	    EqualsVerifier.simple().suppress(Warning.STRICT_HASHCODE).forClass(Players.class).withPrefabValues(FantasyTeams.class, teamOne, teamTwo).verify();
//	
//	}
	
	@Test
	void testEqualsHash() {
		FantasyTeams team = new FantasyTeams(2L, null);
		Players firstPlayer = new Players(1L, "Eqo", "Flex DPS", team);
		Players secondPlayer = new Players(1L, "Eqo", "Flex DPS", team);
	
		assertTrue(firstPlayer.equals(secondPlayer) && secondPlayer.equals(firstPlayer));

	    assertEquals(firstPlayer.hashCode(), secondPlayer.hashCode());
	    
	}
}
