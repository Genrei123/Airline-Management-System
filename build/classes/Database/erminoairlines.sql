-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2023 at 03:05 AM
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
  `book_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booked_flights`
--

INSERT INTO `booked_flights` (`flight_id`, `first_name`, `middle_name`, `last_name`, `suffix`, `age`, `birth_date`, `destination`, `origin`, `class`, `seat`, `flight_no`, `amount`, `departure`, `arrival`, `book_date`) VALUES
('test', '123', '123', '123', '123', 123, '2003-01-01', '', '', '', '', 'test', 0, NULL, NULL, NULL),
('test', 'wdadw', 'wdad', 'wdawd', '', 12, '2023-11-16', 'Boracay', 'Manila', 'Premium Economy', 'A4', 'test', 0, NULL, NULL, NULL),
('test', 'Ervhyne', 'R', 'Daludog', '', 19, '2023-11-21', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'Genrey', 'Omsiol', 'Cristobal', 'NA', 12, '2023-12-13', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'Genrey', 'Omisol', 'Cristobal', 'sadsa', 12, '2023-12-28', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'Genrey', 'Omisol', 'Cristobal', 'NA', 123, '2023-12-15', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'genrey', 'genrey', 'gernye', '123', 123, '2023-12-05', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asdsad', 'asdsad', 'sadsad', 'sadsad', 123, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asdsad', 'asdsad', 'sadsad', 'sadsad', 123, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asdsadsa', 'sadasdsad', 'asdasdsad', 'sadsadsad', 19, '2023-12-06', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'genrey', 'genrey', 'genrey', 'NA', 19, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'gennrey', 'gerer', 'gegeg', 'ge', 19, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asad', 'asd', 'asd', 'asd', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asd', 'asd', 'asd', 'asd', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'sadsa', 'asdasd', 'asdasd', 'asdsad', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'genrey', 'genrey', 'gerneyt', 'genrey', 19, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asad', 'asda', 'asd', 'asd', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asdsa', 'sadasd', 'sadsad', 'asdsa', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'gege', 'gege', 'gege', 'gege', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asdsa', 'sadasd', 'asdsad', 'asd', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'sag', 'sagasg', 'asg', 'asg', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('test', 'asdasdsa', 'asdsadsa', 'asdsad', 'asdsa', 12, '2023-12-01', 'Boracay', 'Manila', 'Economy', 'A1', 'test', 0, NULL, NULL, NULL),
('123123', '123213', '123213', '213213', '12312321', 12, '2023-12-02', '123213', '123213', '12321', '213213', '213213', 123, '2023-12-01 23:37:10', '2023-12-01 23:37:10', '2023-12-02 23:37:10'),
('asdsad', 'sadsad', 'sad', 'asd', 'asd', 1, '2023-12-01', 'asdsad', 'asdas', 'asd', '1A', 'asdsad', 123, '2023-12-01 02:16:39', '2023-12-01 02:16:39', '2023-12-01 02:16:39'),
('ERM101', 'Genrey', 'Omisol', 'Cristobal', 'NA', 20, '2003-09-19', 'Boracay', 'Manila', 'Economy', '5A', 'ERM101', 1000, NULL, NULL, NULL),
('ERM101', 'Genrey', 'Omisol', 'Cristobal', 'NA', 20, '2003-09-19', 'Boracay', 'Manila', 'Economy', '2A', '2023-12-03ERM101-1272598877', 1000, NULL, NULL, NULL),
('ERM101', 'Genrey', 'Omisol', 'Cristobal', 'NA', 20, '2003-09-19', 'Boracay', 'Manila', 'Economy', '6A', '2023-12-03ERM101-1272598877', 1000, NULL, NULL, NULL),
('ERM101', 'Genrey', 'Omisol', 'Cristobal', 'NA', 20, '2003-09-19', 'Boracay', 'Manila', 'Economy', '21B', '2023-12-03ERM101-1272598877', 1000, NULL, NULL, NULL),
('ERM101', 'Genrey', 'Omisol', 'Cristobal', 'NA', 20, '2003-09-19', 'Boracay', 'Manila', 'Economy', '9B', '2023-12-03ERM101-1272598877', 1000, NULL, NULL, NULL),
('ERM101', 'Jhon', 'Bahay', 'Namias', '', 20, '2003-09-19', 'Boracay', 'Manila', 'Economy', '24B', '2023-12-03ERM101691781918', 1000, NULL, NULL, NULL);

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
('tststs', 'tststs', 'tstst', 'ststs', 'tststs', '2023-12-01 00:00:00', '2023-12-02 00:00:00'),
('tststs', 'tststs', 'tstst', 'ststs', 'tststs', '2023-12-01 00:00:00', '2023-12-02 00:00:00'),
('gerer', 'rewre', 'airplane_id', 'rere', 'ere', '2023-12-22 00:00:00', '2023-12-08 00:00:00');

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

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`ticket_no`, `flight_no`, `seat`, `name`, `payment_date`, `status`, `ticket_agent`, `ticket_branch`, `price`) VALUES
('test', 'test', 'test', 'test', '2023-11-01', 'test', 'test', 'test', 21),
('2023-12-03ERM101691781918', 'ERM101', '24B', 'Jhon', '2023-12-03', 'ON', 'ONLINE', 'ONLINE', 1000);

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
(6, 'test', 'test1234', 'Who is the most handsome prof?', '123', '2023-11-23', NULL, 0);

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
-- Dumping data for table `ticket_records`
--

INSERT INTO `ticket_records` (`flight_no`, `airplane_no`, `initial_depart`, `departure`, `destination`, `origin`, `seat_no`, `class`) VALUES
(1, 1, '2023-11-19 14:28:13', '2023-11-19 14:28:13', 'PALAWAN', 'MNL', 1, 'BUSINESS'),
(0, 0, '2023-11-20 08:00:00', '2023-11-20 10:00:00', 'New York', 'Los Angeles', 1, 'Business'),
(0, 0, '2023-11-21 09:30:00', '2023-11-21 12:00:00', 'Chicago', 'Miami', 2, 'Economy'),
(0, 0, '2023-11-22 11:15:00', '2023-11-22 13:30:00', 'San Francisco', 'Seattle', 3, 'First Class'),
(0, 0, '2023-11-23 13:45:00', '2023-11-23 16:00:00', 'Denver', 'New York', 4, 'Economy'),
(0, 0, '2023-11-24 15:30:00', '2023-11-24 18:00:00', 'Miami', 'Chicago', 5, 'Business'),
(0, 0, '2023-11-25 17:00:00', '2023-11-25 19:30:00', 'Los Angeles', 'San Francisco', 6, 'Economy'),
(0, 0, '2023-11-26 18:45:00', '2023-11-26 21:00:00', 'Seattle', 'Boston', 7, 'First Class'),
(0, 0, '2023-11-27 20:15:00', '2023-11-27 22:30:00', 'New York', 'Denver', 8, 'Business'),
(0, 0, '2023-11-28 22:00:00', '2023-11-29 01:00:00', 'Chicago', 'Miami', 9, 'Economy'),
(0, 0, '2023-11-30 23:30:00', '2023-12-01 02:00:00', 'San Francisco', 'Los Angeles', 10, 'First Class'),
(0, 0, '2023-12-02 01:45:00', '2023-12-02 04:00:00', 'Boston', 'Seattle', 11, 'Business'),
(0, 0, '2023-12-03 03:30:00', '2023-12-03 06:00:00', 'Denver', 'New York', 12, 'Economy'),
(0, 0, '2023-12-04 05:00:00', '2023-12-04 07:30:00', 'Miami', 'Chicago', 13, 'First Class'),
(0, 0, '2023-12-05 06:45:00', '2023-12-05 09:00:00', 'Los Angeles', 'San Francisco', 14, 'Business'),
(0, 0, '2023-12-06 08:15:00', '2023-12-06 10:30:00', 'Seattle', 'Boston', 15, 'Economy'),
(0, 0, '2023-12-07 10:00:00', '2023-12-07 12:00:00', 'New York', 'Denver', 16, 'First Class'),
(0, 0, '2023-12-08 11:30:00', '2023-12-08 14:00:00', 'Chicago', 'Miami', 17, 'Business'),
(0, 0, '2023-12-09 13:15:00', '2023-12-09 15:30:00', 'San Francisco', 'Los Angeles', 18, 'Economy'),
(0, 0, '2023-12-10 15:00:00', '2023-12-10 17:00:00', 'Boston', 'Seattle', 19, 'First Class'),
(0, 0, '2023-12-11 16:30:00', '2023-12-11 19:00:00', 'Denver', 'New York', 20, 'Business'),
(0, 0, '2023-12-12 18:15:00', '2023-12-12 21:30:00', 'Miami', 'Chicago', 21, 'Economy'),
(0, 0, '2023-12-13 20:00:00', '2023-12-13 22:00:00', 'Los Angeles', 'San Francisco', 22, 'First Class'),
(0, 0, '2023-12-14 21:30:00', '2023-12-14 23:45:00', 'Seattle', 'Boston', 23, 'Business'),
(0, 0, '2023-12-15 23:15:00', '2023-12-16 02:00:00', 'New York', 'Denver', 24, 'Economy'),
(0, 0, '2023-12-17 01:00:00', '2023-12-17 03:30:00', 'Chicago', 'Miami', 25, 'First Class'),
(0, 0, '2023-12-18 02:30:00', '2023-12-18 05:00:00', 'San Francisco', 'Los Angeles', 26, 'Business'),
(0, 0, '2023-12-19 04:15:00', '2023-12-19 07:00:00', 'Boston', 'Seattle', 27, 'Economy'),
(0, 0, '2023-12-20 06:00:00', '2023-12-20 08:15:00', 'Denver', 'New York', 28, 'First Class'),
(0, 0, '2023-12-21 07:30:00', '2023-12-21 09:45:00', 'Miami', 'Chicago', 29, 'Business');

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
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
