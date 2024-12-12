CREATE TABLE Genre(
	genre varchar(50) NOT NULL PRIMARY KEY,
	genre_id int NOT NULL,
);

CREATE TABLE User(
	username varchar(50) NOT NULL,
	password varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	role varchar(10) NOT NULL
	user_id int NOT NULL,
	PRIMARY KEY (user_id)
);


CREATE TABLE Movies(
	judul varchar(50) NOT NULL,
	movie_id int NOT NULL PRIMARY KEY,
	genre_id int FOREIGN KEY REFERENCES Genre(genre_id)
	status varchar(10) NOT NULL,--tersedia, habis
	stock int NOT NULL,
	harga int NOT NULL
);

CREATE TABLE Actors(
	nama_actor varchar(50) NOT NULL,
	movie_id int FOREIGN KEY REFERENCES Movies(movie_id)
);

CREATE TABLE Laporan_movie(
	judul_film varchar(50) FOREIGN KEY REFERENCES Movies(judul)
	total_peminjaman int NOT NULL,
	tanggal_peminjaman date,
);
