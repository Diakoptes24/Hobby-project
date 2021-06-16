DROP TABLE IF EXISTS fantasy_teams CASCADE;

CREATE TABLE fantasy_teams (
    team_id BIGINT AUTO_INCREMENT,
    team_name VARCHAR(255),
    player VARCHAR(255),
    PRIMARY KEY (team_id)
    );