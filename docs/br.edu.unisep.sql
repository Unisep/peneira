CREATE DATABASE peneira;

CREATE TABLE athletes (
	id_athlete SERIAL PRIMARY KEY,
	name VARCHAR(40) NOT NULL,
	mail VARCHAR(90) NOT NULL,
	image VARCHAR(200),
	pass VARCHAR(255) NOT NULL,
	state VARCHAR(30),
	phone CHAR(16),
	city VARCHAR(50),
	born DATE NOT NULL,
	bio TEXT,
	position VARCHAR(30),
	height NUMERIC(2, 2),
	weight NUMERIC(3, 2),
	good_feet VARCHAR(10),
	player VARCHAR(25),
	club VARCHAR(100) DEFAULT 'Jogador amador!'
);

CREATE TABLE scouts (
	id_scout SERIAL PRIMARY KEY,
	name VARCHAR(40) NOT NULL,
	mail VARCHAR(90) NOT NULL,
	state VARCHAR(30) NOT NULL,
	phone CHAR(16),
	city VARCHAR(50),
	bio TEXT,
	club VARCHAR(100) NOT NULL
);


CREATE TABLE messages(
	id_message SERIAL PRIMARY KEY,
	id_scout INTEGER,
	id_athlete INTEGER,
	CONSTRAINT fk_scout_messages FOREIGN KEY(id_scout) REFERENCES scouts(id_scout) ON DELETE CASCADE,
	CONSTRAINT fk_athletes_messages FOREIGN KEY(id_athlete) REFERENCES athletes(id_athlete) ON DELETE CASCADE
);


CREATE TABLE videos(
	id_video SERIAL PRIMARY KEY,
	id_athlete INTEGER,
	description VARCHAR(300) DEFAULT 'Sem descrição!' NOT NULL,
	view_count INTEGER DEFAULT 1 NOT NULL,
	reputation NUMERIC(2, 2),
	CONSTRAINT fk_athletes_videos FOREIGN KEY(id_athlete) REFERENCES athletes(id_athlete) ON DELETE CASCADE
);




