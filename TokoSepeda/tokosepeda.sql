-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2021 at 02:52 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tokosepeda`
--

-- --------------------------------------------------------

--
-- Table structure for table `toko_sepeda`
--

CREATE TABLE `toko_sepeda` (
  `kd_sepeda` varchar(5) NOT NULL,
  `harga` int(11) DEFAULT NULL,
  `jenis` varchar(20) DEFAULT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `merk` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `toko_sepeda`
--

INSERT INTO `toko_sepeda` (`kd_sepeda`, `harga`, `jenis`, `nama`, `merk`) VALUES
('001', 1000000, 'mountain bike', 'a2-002', 'united');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `toko_sepeda`
--
ALTER TABLE `toko_sepeda`
  ADD PRIMARY KEY (`kd_sepeda`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
