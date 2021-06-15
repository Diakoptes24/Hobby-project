DROP TABLE IF EXISTS `players` CASCADE;
DROP TABLE IF EXISTS `fantasy_teams` CASCADE;

CREATE TABLE players (
    player_id BIGINT AUTO_INCREMENT,
    playerign VARCHAR(255) NOT NULL,
    `role` VARCHAR(255) NOT NULL,
    fantasy_teams_team_id BIGINT,
    PRIMARY KEY (player_id)
	foreign key (fantasy_teams_team_id) REFERENCES fantasy_teams(team_id)
	);

CREATE TABLE fantasy_teams (
    team_id BIGINT AUTO_INCREMENT,
    team_name VARCHAR(255),
    player VARCHAR(255),
    PRIMARY KEY (team_id)
    );
    



    
 -- alter table players add constraint FKi0srta2txld7n4e6jew5lr6k2 foreign key (fantasy_teams_team_id) references fantasy_teams;