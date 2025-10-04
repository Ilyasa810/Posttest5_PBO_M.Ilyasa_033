-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Okt 2025 pada 05.31
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_game_favorit`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobile_game`
--

CREATE TABLE `mobile_game` (
  `no` int(11) NOT NULL,
  `nama_game` varchar(100) NOT NULL,
  `genre_game` varchar(50) DEFAULT NULL,
  `tahun_rilis` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mobile_game`
--

INSERT INTO `mobile_game` (`no`, `nama_game`, `genre_game`, `tahun_rilis`) VALUES
(1, 'EA FC Mobile 26 Update', 'Sports', '2025'),
(2, 'BloodStrike', 'FPS', '2024'),
(3, 'Carrion', 'Horror Metroidvania', '2021');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pc_game`
--

CREATE TABLE `pc_game` (
  `no` int(11) NOT NULL,
  `nama_game` varchar(100) NOT NULL,
  `genre_game` varchar(50) DEFAULT NULL,
  `tahun_rilis` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pc_game`
--

INSERT INTO `pc_game` (`no`, `nama_game`, `genre_game`, `tahun_rilis`) VALUES
(1, 'EA FC 25', 'Sports', '2024'),
(2, 'Football Manager 25', 'Sports', '2024'),
(3, 'Stardew Valley', 'Simulation', '2016'),
(4, 'Undying', 'Survival Indie', '2021'),
(5, 'Hollow Knight', 'Metroidvania', '2017'),
(6, 'Project Zomboid', 'Survival Zombie', '2011'),
(7, 'Dave the Diver', 'Adventure Indie', '2023'),
(8, 'Assassins Creed IV: Black Flag', 'Action-Adventure, Stealth', '2013');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mobile_game`
--
ALTER TABLE `mobile_game`
  ADD PRIMARY KEY (`no`);

--
-- Indeks untuk tabel `pc_game`
--
ALTER TABLE `pc_game`
  ADD PRIMARY KEY (`no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
