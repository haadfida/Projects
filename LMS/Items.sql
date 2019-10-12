-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 31, 2018 at 07:57 AM
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
-- Table structure for table `Items`
--

CREATE TABLE `Items` (
  `id` varchar(30) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(30) NOT NULL,
  `genre` varchar(20) NOT NULL,
  `itemtype` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Items`
--

INSERT INTO `Items` (`id`, `title`, `author`, `genre`, `itemtype`) VALUES
('1', 'no work', 'Haad', 'physics', 1),
('11111112', 'Fifa montage', 'Saif', 'video games', 2),
('1234', 'How to program', 'Saif', 'Computer Science', 2),
('123456', 'Fortnite montage', 'Saif', 'video games', 2),
('9780007525546', 'Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', 1),
('9780262033848', 'Introduction to Algorithims', 'Charles E.Leiserson', 'Computer Science', 1),
('9780545010221', 'Harry Potter and the Deathly Hallows', 'J.K.Rowling', 'Fantasy', 1),
('9780743273565', 'The Great Gatsby', 'F. Scott Fitzgerald', 'Novel', 1),
('XYZ01', 'Lord of the Rings: The Fellowship of the Ring', 'J.R.R. Tolkien', 'Fantasy', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Items`
--
ALTER TABLE `Items`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
