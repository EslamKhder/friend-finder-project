CREATE DATABASE frindfrinder;
create table `frindfrinder`.log_in
(
	ID int NOT NULL AUTO_INCREMENT,
	Name VARCHAR(225) not null,
	Email VARCHAR(255) not null,
	Password VARCHAR(225) not null,
	Job VARCHAR(255) not null,
	Distance INT not null,
	PRIMARY KEY (ID)
);
create table `frindfrinder`.likepost
(
	IDEmail INT not null,
	IDPost INT not null
);
create table `frindfrinder`.post
(
	IDUser INT not null,
	ID_Post int NOT NULL AUTO_INCREMENT,
	Text VARCHAR(255),
	Attachment VARCHAR(255),
	PRIMARY KEY (ID_Post)
);
create table `frindfrinder`.comment
(
	IDEmail INT not null,
	IDPost INT not null,
	Comment VARCHAR(255) not null
);
create table `frindfrinder`.relation
(
	IDEmail INT not null,
	IDFriend INT not null
);