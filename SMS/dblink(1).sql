-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2019 at 05:50 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

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
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `attendanceID` int(11) NOT NULL,
  `courseID` varchar(255) NOT NULL,
  `section` varchar(255) NOT NULL,
  `AttenDate` date NOT NULL,
  `Attend` varchar(10) DEFAULT 'A',
  `userID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`attendanceID`, `courseID`, `section`, `AttenDate`, `Attend`, `userID`) VALUES
(1, 'CS-403', 'CS-G', '2019-03-29', 'P', 'l164001'),
(2, 'CS-403', 'CS-G', '2019-03-29', 'P', 'l164002'),
(3, 'CS-403', 'CS-G', '2019-03-29', 'P', 'l164003'),
(4, 'CS-403', 'CS-G', '2019-03-29', 'P', 'l164028'),
(5, 'CS-403', 'CS-G', '2019-03-29', 'P', 'l164150'),
(11, 'CS-403', 'CS-G', '2019-04-03', 'P', 'l164001'),
(12, 'CS-403', 'CS-G', '2019-04-03', 'P', 'l164002'),
(13, 'CS-403', 'CS-G', '2019-04-03', 'P', 'l164003'),
(14, 'CS-403', 'CS-G', '2019-04-03', 'P', 'l164028'),
(15, 'CS-403', 'CS-G', '2019-04-03', 'P', 'l164150'),
(16, 'CS-403', 'CS-G', '2019-04-21', 'P', 'l164001'),
(17, 'CS-403', 'CS-G', '2019-04-21', 'P', 'l164002'),
(18, 'CS-403', 'CS-G', '2019-04-21', 'P', 'l164003'),
(19, 'CS-403', 'CS-G', '2019-04-21', 'P', 'l164028'),
(20, 'CS-403', 'CS-G', '2019-04-21', 'P', 'l164150'),
(21, 'CS-403', 'CS-G', '2019-04-23', 'P', 'l164001'),
(22, 'CS-403', 'CS-G', '2019-04-23', 'P', 'l164002'),
(23, 'CS-403', 'CS-G', '2019-04-23', 'P', 'l164003'),
(24, 'CS-403', 'CS-G', '2019-04-23', 'P', 'l164028'),
(25, 'CS-403', 'CS-G', '2019-04-23', 'P', 'l164150'),
(71, 'CS-403', 'CS-G', '2019-04-24', 'P', 'l164001'),
(72, 'CS-403', 'CS-G', '2019-04-24', 'A', 'l164002'),
(73, 'CS-403', 'CS-G', '2019-04-24', 'P', 'l164003'),
(74, 'CS-403', 'CS-G', '2019-04-24', 'A', 'l164028'),
(75, 'CS-403', 'CS-G', '2019-04-24', 'A', 'l164150'),
(81, 'CS-403', 'CS-G', '2019-04-26', 'P', 'l164001'),
(82, 'CS-403', 'CS-G', '2019-04-26', 'A', 'l164002'),
(83, 'CS-403', 'CS-G', '2019-04-26', 'P', 'l164003'),
(84, 'CS-403', 'CS-G', '2019-04-26', 'A', 'l164028'),
(85, 'CS-403', 'CS-G', '2019-04-26', 'A', 'l164150');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `courseID` varchar(255) NOT NULL,
  `courseName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`courseID`, `courseName`) VALUES
('BBA-600', 'Accounting and finance'),
('CE-100', 'English'),
('CS-122', 'OOAD'),
('CS-170', 'Algorithms'),
('CS-403', 'Automata');

-- --------------------------------------------------------

--
-- Table structure for table `evaluationcriteria`
--

CREATE TABLE `evaluationcriteria` (
  `evalid` int(11) NOT NULL,
  `sectionID` varchar(250) NOT NULL,
  `courseID` varchar(255) NOT NULL,
  `evaltype` int(11) NOT NULL,
  `evalWeight` int(11) NOT NULL,
  `evalno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sections`
--

CREATE TABLE `sections` (
  `section` varchar(10) DEFAULT NULL,
  `isOpen` int(11) DEFAULT NULL,
  `seatsFilled` int(11) DEFAULT NULL,
  `courseID` varchar(255) DEFAULT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `teacherName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sections`
--

INSERT INTO `sections` (`section`, `isOpen`, `seatsFilled`, `courseID`, `courseName`, `teacherName`) VALUES
('CS-G', 1, 20, 'CS-403', 'Automata', 'Sarim Baig'),
('CE-F', 1, 15, 'CE-100', 'English', 'Farwa Batool'),
('BBA-A', 1, 39, 'BBA-600', 'Accounting and finance', 'Kamran Lodhi'),
('CS-H', 1, 49, 'CS-403', 'Automata', 'Sidra Basharat');

-- --------------------------------------------------------

--
-- Table structure for table `semdata`
--

CREATE TABLE `semdata` (
  `uniqueid` int(11) NOT NULL,
  `SemesterID` int(11) NOT NULL,
  `rollno` varchar(255) NOT NULL,
  `courseName` varchar(255) NOT NULL,
  `Grade` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semdata`
--

INSERT INTO `semdata` (`uniqueid`, `SemesterID`, `rollno`, `courseName`, `Grade`) VALUES
(1, 1, 'l164150', 'English', 'A'),
(2, 2, 'l164150', 'Theory of Automata', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `uniqueid` int(11) NOT NULL,
  `SemesterID` int(11) DEFAULT NULL,
  `UserID` varchar(255) DEFAULT NULL,
  `sgpa` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`uniqueid`, `SemesterID`, `UserID`, `sgpa`) VALUES
(1, 1, 'l164028', 3.5),
(2, 1, 'l164150', 4),
(3, 1, 'l164119', 2.1),
(4, 1, 'l164007', 3.3),
(5, 2, 'l164150', 2.67);

-- --------------------------------------------------------

--
-- Table structure for table `studentevaluations`
--

CREATE TABLE `studentevaluations` (
  `uniqueid` int(11) NOT NULL,
  `courseID` varchar(255) NOT NULL,
  `studentid` varchar(255) NOT NULL,
  `sectionID` varchar(255) NOT NULL,
  `teachername` varchar(255) NOT NULL,
  `evaltype` int(11) NOT NULL,
  `evalno` int(11) NOT NULL,
  `evalmarks` int(11) NOT NULL,
  `grade` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `studentsection`
--

CREATE TABLE `studentsection` (
  `studyID` int(11) NOT NULL,
  `courseID` varchar(255) DEFAULT NULL,
  `section` varchar(10) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `UserID` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentsection`
--

INSERT INTO `studentsection` (`studyID`, `courseID`, `section`, `userName`, `UserID`) VALUES
(1, 'CS-403', 'CS-G', 'Robert De Niro', 'l164001'),
(2, 'CS-403', 'CS-G', 'Al Pacino', 'l164002'),
(3, 'CS-403', 'CS-G', 'Marlon Brando', 'l164003'),
(4, 'CS-403', 'CS-G', 'Noor Fatima', 'l164028'),
(5, 'CS-403', 'CS-G', 'Minahil Ahmad', 'l164150');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  `userType` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `age`, `pass`, `userName`, `userType`) VALUES
('007', 53, '007', 'James Bond 007', 3),
('farwaaa', 25, '12345678910', 'Farwa Batool', 2),
('kamran1', 40, '12345678', 'Kamran Lodhi', 2),
('l164001', 21, '123456', 'Robert De Niro', 1),
('l164002', 21, '123456', 'Al Pacino', 1),
('l164003', 21, '123456', 'Marlon Brando', 1),
('l164007', 20, '123456', 'Khabib Nurmagamedov', 1),
('l164028', 20, 'pass', 'Noor Fatima', 1),
('l164119', 23, '123456', 'Saad Farooq', 1),
('l164150', 21, 'password', 'Minahil Ahmed', 1),
('l164223', 19, '123456', 'James Franco', 1),
('sarim1', 40, '1234567', 'Sarim Baig', 2),
('sidra1', 29, '12345678', 'Sidra Basharat', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`attendanceID`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`courseID`);

--
-- Indexes for table `evaluationcriteria`
--
ALTER TABLE `evaluationcriteria`
  ADD PRIMARY KEY (`evalid`);

--
-- Indexes for table `sections`
--
ALTER TABLE `sections`
  ADD KEY `FK_1` (`courseID`);

--
-- Indexes for table `semdata`
--
ALTER TABLE `semdata`
  ADD PRIMARY KEY (`uniqueid`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`uniqueid`);

--
-- Indexes for table `studentevaluations`
--
ALTER TABLE `studentevaluations`
  ADD PRIMARY KEY (`uniqueid`);

--
-- Indexes for table `studentsection`
--
ALTER TABLE `studentsection`
  ADD PRIMARY KEY (`studyID`),
  ADD KEY `FK_3` (`courseID`),
  ADD KEY `FK_4` (`UserID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`,`userName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `attendanceID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;

--
-- AUTO_INCREMENT for table `evaluationcriteria`
--
ALTER TABLE `evaluationcriteria`
  MODIFY `evalid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=391;

--
-- AUTO_INCREMENT for table `semdata`
--
ALTER TABLE `semdata`
  MODIFY `uniqueid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `semester`
--
ALTER TABLE `semester`
  MODIFY `uniqueid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `studentevaluations`
--
ALTER TABLE `studentevaluations`
  MODIFY `uniqueid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1495;

--
-- AUTO_INCREMENT for table `studentsection`
--
ALTER TABLE `studentsection`
  MODIFY `studyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sections`
--
ALTER TABLE `sections`
  ADD CONSTRAINT `FK_1` FOREIGN KEY (`courseID`) REFERENCES `courses` (`courseID`),
  ADD CONSTRAINT `FK_S` FOREIGN KEY (`courseID`) REFERENCES `courses` (`courseID`);

--
-- Constraints for table `studentsection`
--
ALTER TABLE `studentsection`
  ADD CONSTRAINT `FK_3` FOREIGN KEY (`courseID`) REFERENCES `courses` (`courseID`),
  ADD CONSTRAINT `FK_4` FOREIGN KEY (`UserID`) REFERENCES `users` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
