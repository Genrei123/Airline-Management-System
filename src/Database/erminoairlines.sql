-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2023 at 02:10 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `erminoairlines`
--

-- --------------------------------------------------------

--
-- Table structure for table `flight_records`
--

CREATE TABLE `flight_records` (
  `flight_id` int(11) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `time_departure` date NOT NULL,
  `passenger_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `signin_users`
--

CREATE TABLE `signin_users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `question` varchar(50) NOT NULL,
  `answer` varchar(40) NOT NULL,
  `date` date NOT NULL,
  `update_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signin_users`
--

INSERT INTO `signin_users` (`user_id`, `username`, `password`, `question`, `answer`, `date`, `update_date`) VALUES
(1, 'Admin', 'test12345', 'Who is the most handsome prof?', 'Sir RR', '2023-10-22', '2023-10-24'),
(2, 'genrey', '32145678', 'Who is the most handsome prof?', 'rr', '2023-10-23', NULL),
(3, 'genrey123', 'ABC12345', 'What is OOP', 'rr', '2023-10-24', NULL),
(4, '20220456', 'testingtesting123', 'What is OOP', 'rr', '2023-10-28', '2023-10-29'),
(5, '202204567', '20220456', 'Who is the most handsome prof?', 'sir rr', '2023-10-28', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ticket_records`
--

CREATE TABLE `ticket_records` (
  `Name` varchar(255) NOT NULL,
  `flight_id` int(11) NOT NULL,
  `airplane_number` int(11) NOT NULL,
  `departure_time` datetime NOT NULL,
  `booking_date` date NOT NULL,
  `destination` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `seat_number` int(11) NOT NULL,
  `class` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `flight_records`
--
ALTER TABLE `flight_records`
  ADD PRIMARY KEY (`flight_id`);

--
-- Indexes for table `signin_users`
--
ALTER TABLE `signin_users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `ticket_records`
--
ALTER TABLE `ticket_records`
  ADD KEY `flight_id` (`flight_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `signin_users`
--
ALTER TABLE `signin_users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ticket_records`
--
ALTER TABLE `ticket_records`
  ADD CONSTRAINT `ticket_records_ibfk_1` FOREIGN KEY (`flight_id`) REFERENCES `flight_records` (`flight_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
