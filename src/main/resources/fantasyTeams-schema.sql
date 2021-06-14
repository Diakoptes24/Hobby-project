DROP TABLE IF EXISTS `players` CASCADE;
DROP TABLE IF EXISTS `fantasy_teams` CASCADE;

CREATE TABLE fantasy_teams (
    team_id BIGINT AUTO_INCREMENT,
    team_name VARCHAR(255),
    main_tank VARCHAR(255),
    off_tank VARCHAR(255),
    hitscandps VARCHAR(255),
    flexdps VARCHAR(255),
    main_support VARCHAR(255),
    flex_support VARCHAR(255),
    PRIMARY KEY (team_id)
    );
    
    CREATE TABLE players (
    player_id BIGINT AUTO_INCREMENT,
    playerign VARCHAR(255) NOT NULL,
    `role` VARCHAR(255) NOT NULL,
    sub_role VARCHAR(255) NOT NULL,
    current_team VARCHAR(255) NOT NULL,
    fantasy_teams_team_id BIGINT,
    PRIMARY KEY (player_id),
    Foreign key (fantasy_teams_team_id) REFERENCES fantasy_teams(team_id)
);