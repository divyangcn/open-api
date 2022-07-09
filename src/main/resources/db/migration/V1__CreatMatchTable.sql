CREATE TABLE match_details (
	id INT NOT NULL AUTO_INCREMENT,
	match_start_date Date NOT NULL,
	home_team VARCHAR(100) NOT NULL,
	away_team VARCHAR(100) NOT NULL,
	home_team_score INT,
	away_team_score INT,
	PRIMARY KEY (id)
);