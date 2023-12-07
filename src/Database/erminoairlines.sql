-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2023 at 11:44 AM
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
-- Table structure for table `booked_flights`
--

CREATE TABLE `booked_flights` (
  `flight_id` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `suffix` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `destination` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  `seat` varchar(255) NOT NULL,
  `flight_no` varchar(255) NOT NULL,
  `amount` double NOT NULL,
  `departure` datetime DEFAULT NULL,
  `arrival` datetime DEFAULT NULL,
  `book_date` datetime DEFAULT NULL,
  `ticket_no` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booked_flights`
--

INSERT INTO `booked_flights` (`flight_id`, `first_name`, `middle_name`, `last_name`, `suffix`, `age`, `birth_date`, `destination`, `origin`, `class`, `seat`, `flight_no`, `amount`, `departure`, `arrival`, `book_date`, `ticket_no`, `status`) VALUES
('111', 'Genrey', 'Omisol', 'Cristobal', '', 20, '2003-09-19', 'Boracay', 'Manila', 'First Class', '8A', 'ERM101', 5000, '2023-12-07 00:00:00', '2023-12-09 03:10:49', '2023-12-06 03:10:49', '2020456-N', 'Booked');

-- --------------------------------------------------------

--
-- Table structure for table `customer_support`
--

CREATE TABLE `customer_support` (
  `name` varchar(11) NOT NULL,
  `ticket_no` varchar(255) NOT NULL,
  `reason` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `feedback` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `preferred_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_support`
--

INSERT INTO `customer_support` (`name`, `ticket_no`, `reason`, `contact`, `feedback`, `status`, `preferred_date`) VALUES
('Cristobal', '2020456-N', 'Move Departure Date', 'tsts', 'TEsts', 'Approved', '2023-12-07'),
('Cristobal', '2020456-N', 'Move Departure Date', 'tsts', 'test', 'Approved', '2023-12-07'),
('Cristobal', '2312321321', 'Move Departure Date', 'tsts', 'test', 'Pending', '2023-12-07'),
('Cristobal', '2312321321', 'Move Departure Date', 'tsts', 'test', 'Pending', '2023-12-07'),
('sadsad', 'asdsadsads', 'Move Departure Date', 'asdsad', 'asdsad', 'Pending', '2023-12-07'),
('sadasd', 'asdsadsa', 'Move Departure Date', 'sadsad', 'asdsad', 'Pending', '2023-12-08'),
('12213', '231', 'Move Departure Date', '213', '213', 'Pending', '2023-12-07'),
('213213', '123213', 'Move Departure Date', '21321', '213', 'Pending', '2023-12-06'),
('213213', '20220456-N', 'Move Departure Date', '21321', '213', 'Pending', '2023-12-06'),
('Cristobal', '20220456-N', 'Move Departure Date', 'asdsad', '213', 'Pending', '2023-12-06'),
('Cristobal', '2020456-N', 'Move Departure Date', '09682345489', 'Tests', 'Approved', '2023-12-07');

-- --------------------------------------------------------

--
-- Table structure for table `flight_manager`
--

CREATE TABLE `flight_manager` (
  `airplane_id` varchar(255) NOT NULL,
  `flight_no` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `origin_date` datetime NOT NULL,
  `destination_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight_manager`
--

INSERT INTO `flight_manager` (`airplane_id`, `flight_no`, `destination`, `origin`, `status`, `origin_date`, `destination_date`) VALUES
('test', 'test', 'tsts', 'tsts', 'sts', '2023-12-07 03:52:36', '2023-12-07 03:52:36'),
('ststs', 'sts', 'st', 'st', 'st', '2023-12-07 03:52:36', '2023-12-07 03:52:36'),
('ERM101', 'test', 'Manila', 'Cebu', 'On Time', '2023-12-07 03:52:36', '2023-12-07 03:52:36');

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
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `ticket_no` varchar(255) NOT NULL,
  `flight_no` varchar(255) NOT NULL,
  `seat` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `payment_date` date NOT NULL,
  `status` varchar(255) NOT NULL,
  `ticket_agent` varchar(255) NOT NULL,
  `ticket_branch` varchar(255) NOT NULL,
  `price` int(11) NOT NULL
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
  `update_date` date DEFAULT NULL,
  `admin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signin_users`
--

INSERT INTO `signin_users` (`user_id`, `username`, `password`, `question`, `answer`, `date`, `update_date`, `admin`) VALUES
(1, 'Admin', 'test12345', 'Who is the most handsome prof?', 'Sir RR', '2023-10-22', '2023-10-24', 0),
(2, 'genrey', '32145678', 'Who is the most handsome prof?', 'rr', '2023-10-23', NULL, 0),
(3, 'genrey123', 'ABC12345', 'What is OOP', 'rr', '2023-10-24', NULL, 0),
(4, '20220456', 'testingtesting123', 'What is OOP', 'rr', '2023-10-28', '2023-10-29', 0),
(5, '202204567', '20220456', 'Who is the most handsome prof?', 'sir rr', '2023-10-28', NULL, 0),
(6, 'test', 'test1234', 'Who is the most handsome prof?', '123', '2023-11-23', NULL, 0),
(7, 'tststst', '12345678', 'Who is the most handsome prof?', '12321321', '2023-12-05', NULL, 1),
(8, 'asdsadsad', '123213', 'Who is the most handsome prof?', '123123', '2023-12-05', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ticket_records`
--

CREATE TABLE `ticket_records` (
  `flight_no` int(11) NOT NULL,
  `airplane_no` int(11) NOT NULL,
  `initial_depart` datetime NOT NULL,
  `departure` datetime NOT NULL,
  `destination` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `seat_no` int(11) NOT NULL,
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
  ADD KEY `flight_id` (`flight_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `signin_users`
--
ALTER TABLE `signin_users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
