CREATE TABLE Genre (
    Genre_id INT NOT NULL PRIMARY KEY,  -- Menambahkan genre_id sebagai primary key
    genre VARCHAR(50) NOT NULL
);

CREATE TABLE Pengguna (
    user_id SERIAL PRIMARY KEY,   -- Memperbaiki urutan dan mendeklarasikan user_id sebagai PRIMARY KEY
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    nomorTelepon VARCHAR(15),
);

CREATE TABLE Admin (
    user_id SERIAL PRIMARY KEY,   -- Memperbaiki urutan dan mendeklarasikan user_id sebagai PRIMARY KEY
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE Movies (
    movie_id SERIAL PRIMARY KEY,    -- Memperbaiki urutan dan mendeklarasikan movie_id sebagai PRIMARY KEY
    judul VARCHAR(50) NOT NULL,
	genre VARCHAR(50) NOT NULL,
	aktor VARCHAR(50) NOT NULL
);

CREATE TABLE Actors (
    actor_id SERIAL PRIMARY KEY,      -- Menambahkan primary key untuk Actors
    nama_actor VARCHAR(50) NOT NULL
);

CREATE TABLE Peminjaman (                   --mencatat informasi transaksi peminjaman
    peminjaman_id SERIAL PRIMARY KEY,
    judulfilm VARCHAR(50) NOT NULL,
    durasi INT NOT NULL
);


