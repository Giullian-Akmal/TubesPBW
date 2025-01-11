CREATE TABLE Genre (
    Genre_id SERIAL PRIMARY KEY,  -- Menambahkan genre_id sebagai primary key
    genre VARCHAR(50) NOT NULL
);

CREATE TABLE Pengguna (
    user_id SERIAL PRIMARY KEY,   -- Memperbaiki urutan dan mendeklarasikan user_id sebagai PRIMARY KEY
    nama_lengkap VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    nomorTelepon VARCHAR(15),
      tanggalLahir DATE
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

CREATE TABLE Laporan_movie (
    laporan_id SERIAL PRIMARY KEY,      -- Menambahkan laporan_id sebagai primary key
    judul_film VARCHAR(50) NOT NULL,
	movie_id INT NOT NULL,    
    total_peminjaman INT NOT NULL,
    tanggal_peminjaman DATE,
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)  -- Menambahkan relasi ke Movies berdasarkan judul
);

CREATE TABLE Pinjam (
    id_pinjam SERIAL PRIMARY KEY,
    id_pelanggan INT NOT NULL,
    id_film INT NOT NULL,
    durasi_pinjam INT NOT NULL,
    tanggal_pinjam DATE DEFAULT NULL,
    FOREIGN KEY (id_pelanggan) REFERENCES Pengguna(user_id),
    FOREIGN KEY (id_film) REFERENCES Movies(movie_id)
);

CREATE TABLE Movie_Aktor (
    id_movie INT NOT NULL,
    id_aktor INT NOT NULL,
    FOREIGN KEY (id_movie) REFERENCES Movies(movie_id),
    FOREIGN KEY (id_aktor) REFERENCES Actors(actor_id ),
    PRIMARY KEY (id_movie, id_aktor)
);

