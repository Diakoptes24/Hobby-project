package com.qa.Hobbyproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qa.Hobbyproject.domain.FantasyTeams;
import com.qa.Hobbyproject.domain.Players;
import com.qa.Hobbyproject.repo.FantasyTeamsRepo;
import com.qa.Hobbyproject.repo.PlayersRepo;

@SpringBootApplication
public class HobbyProjectApplication {
	
//	@Autowired
//    private PlayersRepo playersRepo;
//
//    @Autowired
//    private FantasyTeamsRepo fTeamsRepo;

	public static void main(String[] args) {
		SpringApplication.run(HobbyProjectApplication.class, args);
	}

//	@Override
//    public void run(String... args) throws Exception {
//        // Clean up database tables
//		fTeamsRepo.deleteAllInBatch();
//		playersRepo.deleteAllInBatch();
//
//        //=========================================
//
//        // Create a User instance
//        FantasyTeams fTeams = new FantasyTeams("Rajeev", "Singh", "rajeev@callicoder.com",
//                "MY_SUPER_SECRET_PASSWORD", "fdf", "dsfsf", "sdff");
//
////        Calendar dateOfBirth = Calendar.getInstance();
////        dateOfBirth.set(1992, 7, 21);
//
//        // Create a UserProfile instance
//        Players players = new Players("2nd Cross", "Golf View Road", "Kodihalli", "Bangalore");
//
//
//        // Set child reference(userProfile) in parent entity(user)
//        fTeams.setPlayers(players);
//
//        // Set parent reference(user) in child entity(userProfile)
//        players.setFantasyTeams(fTeams);
//
//        // Save Parent Reference (which will save the child as well)
//        fTeamsRepo.save(fTeams);
//}

}