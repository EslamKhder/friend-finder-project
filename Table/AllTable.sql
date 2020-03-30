create table `frind frinder`.log_in
(
	ID INT not null primary key,
	Name VARCHAR(225) not null,
	Email VARCHAR(255) not null,
	Password VARCHAR(225) not null,
	Job VARCHAR(255) not null,
	Distance INT not null
);
create table `frind frinder`.likepost
(
	IDEmail INT not null,
	IDPost INT not null
);
create table `frind frinder`.post
(
	IDUser INT not null,
	ID_Post INT not null primary key,
	Text VARCHAR(255),
	Attachment VARCHAR(255)
);
create table `frind frinder`.comment
(
	IDEmail INT not null,
	IDPost INT not null,
	Comment VARCHAR(255) not null
);
create table `frind frinder`.relation
(
	IDEmail INT not null,
	IDFriend INT not null
);