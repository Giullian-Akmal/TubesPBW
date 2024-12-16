CREATE TABLE Genre (
    Genre_id INT NOT NULL PRIMARY KEY,  -- Menambahkan genre_id sebagai primary key
    genre VARCHAR(50) NOT NULL
);

CREATE TABLE Pengguna (
    user_id INT NOT NULL PRIMARY KEY,   -- Memperbaiki urutan dan mendeklarasikan user_id sebagai PRIMARY KEY
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    role VARCHAR(10) NOT NULL
);

CREATE TABLE Movies (
    movie_id INT NOT NULL PRIMARY KEY,    -- Memperbaiki urutan dan mendeklarasikan movie_id sebagai PRIMARY KEY
    judul VARCHAR(50) NOT NULL,
    genre_id INT NOT NULL,                -- Menambahkan foreign key untuk genre_id
    status VARCHAR(10) NOT NULL,          -- "tersedia" atau "habis"
    stock INT NOT NULL,
    harga INT NOT NULL,
    FOREIGN KEY (genre_id) REFERENCES Genre(genre_id)  -- Menambahkan relasi ke tabel Genre
);

CREATE TABLE Actors (
    actor_id INT NOT NULL PRIMARY KEY,      -- Menambahkan primary key untuk Actors
    nama_actor VARCHAR(50) NOT NULL,
    movie_id INT NOT NULL,                  -- Menambahkan foreign key untuk movie_id
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)  -- Menambahkan relasi ke tabel Movies
);

CREATE TABLE Laporan_movie (
    laporan_id INT NOT NULL PRIMARY KEY,      -- Menambahkan laporan_id sebagai primary key
    judul_film VARCHAR(50) NOT NULL,
	movie_id INT NOT NULL,    
    total_peminjaman INT NOT NULL,
    tanggal_peminjaman DATE,
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)  -- Menambahkan relasi ke Movies berdasarkan judul
);
