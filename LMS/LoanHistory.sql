-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 31, 2018 at 07:56 AM
-- Server version: 5.7.23
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dblink`
--

-- --------------------------------------------------------

--
-- Table structure for table `LoanHistory`
--

CREATE TABLE `LoanHistory` (
  `itemid` varchar(30) NOT NULL,
  `userid` varchar(30) NOT NULL,
  `issueDate` date NOT NULL,
  `retDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LoanHistory`
--

INSERT INTO `LoanHistory` (`itemid`, `userid`, `issueDate`, `retDate`) VALUES
('1', 'haad144', '2018-10-29', '2018-11-12'),
('11111112', 'haad144', '2018-10-29', '2018-11-12'),
('9780743273565', 'haad144', '2018-10-29', '2018-11-12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `LoanHistory`
--
ALTER TABLE `LoanHistory`
  ADD PRIMARY KEY (`itemid`,`userid`) USING BTREE,
  ADD KEY `FK_4` (`userid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
