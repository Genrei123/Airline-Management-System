-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2024 at 05:37 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

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
-- Table structure for table `airplane_manager`
--

CREATE TABLE `airplane_manager` (
  `airplane_id` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `airplane_manager`
--

INSERT INTO `airplane_manager` (`airplane_id`, `origin`, `destination`, `status`) VALUES
('ERM101', 'CEBU', 'MANILA', 'RESERVED'),
('YT101', 'MANILA', 'BRUNEI', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `booked_flights`
--

CREATE TABLE `booked_flights` (
  `flight_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `suffix` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `seat` varchar(255) DEFAULT NULL,
  `flight_no` varchar(255) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `departure` date DEFAULT NULL,
  `arrival` date DEFAULT NULL,
  `book_date` date DEFAULT NULL,
  `ticket_no` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booked_flights`
--

INSERT INTO `booked_flights` (`flight_id`, `first_name`, `middle_name`, `last_name`, `suffix`, `age`, `destination`, `origin`, `class`, `seat`, `flight_no`, `amount`, `departure`, `arrival`, `book_date`, `ticket_no`, `status`, `username`) VALUES
('ERM818', 'Genrey', '', 'Cristobal', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '37D', 'ERM818', 1000, NULL, NULL, '2023-12-09', '2023-12-09ER', 'PAID', ''),
('ERM818', 'Genrey', '', 'Cristobal', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '37D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'Genrey', '', 'Cristobal', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '37D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'Genrey', '', 'Cristobal', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '41D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasd', '', 'xzcz', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '45D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasd', '', 'xzcz', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '45D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'sadsad', '', 'asdasd', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '49D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'sadsad', '', 'asdasd', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '49D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'sadasd', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '53D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'sadasd', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '53D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsad', '', 'asdsad', '', 21, 'PALAWAN', 'BORACAY', 'ECONOMY', '57D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsad', '', 'asdsad', '', 21, 'PALAWAN', 'BORACAY', 'ECONOMY', '57D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'sadasdsad', '', 'asdsadsa', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '61D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'sadasdsad', '', 'asdsadsa', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '61D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasdsa', '', 'sadsad', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '65D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasdsa', '', 'sadsad', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '65D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsa', '', 'sadsad', '', 21, 'PALAWAN', 'BORACAY', 'ECONOMY', '69D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsa', '', 'sadsad', '', 21, 'PALAWAN', 'BORACAY', 'ECONOMY', '69D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsad', '', 'asdsad', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '73D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsad', '', 'asdsad', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '73D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'zxczxcxz', '', 'xzcxzcxz', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '77D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'zxczxcxz', '', 'xzcxzcxz', '', 22, 'PALAWAN', 'BORACAY', 'ECONOMY', '77D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasdsa', '', 'asdasda', '', 213, 'PALAWAN', 'BORACAY', 'ECONOMY', '38D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasdsa', '', 'asdasda', '', 213, 'PALAWAN', 'BORACAY', 'ECONOMY', '38D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsad', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '42D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsad', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '42D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsa', '', 'sadsadsa', '', 232, 'PALAWAN', 'BORACAY', 'ECONOMY', '46D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsa', '', 'sadsadsa', '', 232, 'PALAWAN', 'BORACAY', 'ECONOMY', '46D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadawsd', '', 'asdsadsad', '', 232, 'PALAWAN', 'BORACAY', 'ECONOMY', '50D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadawsd', '', 'asdsadsad', '', 232, 'PALAWAN', 'BORACAY', 'ECONOMY', '50D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasd', '', 'asdasd', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '54D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasd', '', 'asdasd', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '54D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'sadsadsad', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '58D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'sadsadsad', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '58D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsad', '', 'sadsadsa', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '62D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsad', '', 'sadsadsa', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '62D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsada', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '66D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsada', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '66D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsad', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '70D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsad', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '70D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasd', '', 'asdasd', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '74D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdasd', '', 'asdasd', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '74D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsad', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '78D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsad', '', 'asdsad', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '78D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'Genrey', 'Omisol', 'Cristobal', '', 20, 'PALAWAN', 'BORACAY', 'ECONOMY', '39D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'Genrey', 'Omisol', 'Cristobal', '', 20, 'PALAWAN', 'BORACAY', 'ECONOMY', '39D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'Genrey', 'Omisol', 'Cristobal', '', 20, 'PALAWAN', 'BORACAY', 'ECONOMY', '43D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'Genrey', 'Omisol', 'Cristobal', '', 20, 'PALAWAN', 'BORACAY', 'ECONOMY', '43D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'Genrey', '', 'asdsad', '', 123, 'PALAWAN', 'BORACAY', 'ECONOMY', '47D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'Genrey', '', 'asdsad', '', 123, 'PALAWAN', 'BORACAY', 'ECONOMY', '47D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsad', '', 'asdsads', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '51D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'asdsadsad', '', 'asdsads', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '51D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'genre', '', 'cr', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '55D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM818', 'genre', '', 'cr', '', 23, 'PALAWAN', 'BORACAY', 'ECONOMY', '55D', 'ERM818', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM567', 'asdsad', '', 'sadsad', '', 22, 'DAVAO', 'BORACAY', 'ECONOMY', '37D', 'ERM567', 1000, NULL, NULL, '2023-12-09', '2023-12-09ER', 'PAID', ''),
('ERM567', 'asdsad', '', 'sadsad', '', 22, 'DAVAO', 'BORACAY', 'ECONOMY', '37D', 'ERM567', 1000, NULL, NULL, '2023-12-09', NULL, NULL, ''),
('ERM168', 'test', '', 'test', '', 20, 'BRUNEI', 'MANILA', 'FIRST CLASS', '1A', 'ERM168', 500, '2024-07-01', '2024-07-02', '2024-05-17', '2024-05-17ER', 'BOOKED', 'Admin'),
('ERM168', 'test', '', 'test', '', 20, 'BRUNEI', 'MANILA', 'FIRST CLASS', '2A', 'ERM168', 500, '2024-07-01', '2024-07-02', '2024-05-17', '2024-05-17ER', 'BOOKED', 'Admin'),
('ERM168', 'test', '', 'test', '', 20, 'BRUNEI', 'MANILA', 'FIRST CLASS', '2A', 'ERM168', 500, '2024-07-01', '2024-07-02', '2024-05-17', '2024-05-17ER', 'BOOKED', 'Admin');

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

-- --------------------------------------------------------

--
-- Table structure for table `destination_price`
--

CREATE TABLE `destination_price` (
  `origin` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `seat_class` varchar(255) NOT NULL,
  `fare_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
('ERM102', 'ERM1020219', 'CEBU', 'MANILA', 'Boarding', '2023-12-09 22:14:00', '2023-12-09 22:15:00'),
('YT101', 'YT101', 'BRUNEI', 'MANILA', 'Boarding', '2024-07-01 22:14:00', '2024-07-02 22:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `flight_records`
--

CREATE TABLE `flight_records` (
  `flight_id` varchar(11) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `time_departure` date DEFAULT NULL,
  `passenger_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight_records`
--

INSERT INTO `flight_records` (`flight_id`, `destination`, `origin`, `time_departure`, `passenger_number`) VALUES
('ERM567', 'DAVAO', 'BORACAY', NULL, 1),
('ERM818', 'PALAWAN', 'BORACAY', NULL, 53);

-- --------------------------------------------------------

--
-- Table structure for table `price_manager`
--

CREATE TABLE `price_manager` (
  `airplane_id` varchar(255) NOT NULL,
  `origin` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `class` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `carousel` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `price_manager`
--

INSERT INTO `price_manager` (`airplane_id`, `origin`, `destination`, `class`, `price`, `carousel`) VALUES
('ERM103', 'MANILA', 'DAVAO', 'First Class', 10000, 0),
('ERM103', 'MANILA', 'DAVAO', 'First Class', 10000, 0),
('ERM104', 'MANILA', 'TONDO', 'First Class', 121212, 0),
('ERM104', 'MANILA', 'TONDO', 'First Class', 121212, 0),
('12312', '21321', '12321', NULL, NULL, NULL),
('ERM101', 'CEBU', 'MANILA', NULL, NULL, NULL),
('ERM101', 'CEBU', 'MANILA', NULL, NULL, NULL),
('ERM101', 'CEBU', 'MANILA', 'FIRST CLASS', 121212, 0),
('YT101', 'MANILA', 'BRUNEI', 'FIRST CLASS', 500, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `ticket_no` varchar(255) DEFAULT NULL,
  `flight_no` varchar(255) NOT NULL,
  `seat` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `payment_date` date NOT NULL,
  `status` varchar(255) NOT NULL,
  `ticket_agent` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`ticket_no`, `flight_no`, `seat`, `name`, `payment_date`, `status`, `ticket_agent`, `price`, `username`) VALUES
('2024-05-17ER', 'ERM168', '2A', 'test', '2024-05-17', 'BOOKED', 'ONLINE', 500, 'Admin');

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
  `flight_no` varchar(255) DEFAULT NULL,
  `airplane_no` varchar(255) DEFAULT NULL,
  `departure` datetime DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `seat_no` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket_records`
--

INSERT INTO `ticket_records` (`flight_no`, `airplane_no`, `departure`, `destination`, `origin`, `seat_no`, `class`) VALUES
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '45D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '45D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '49D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '49D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '53D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '53D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '57D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '57D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '61D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '61D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '65D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '65D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '69D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '69D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '73D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '73D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '77D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '77D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '38D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '38D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '42D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '42D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '46D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '46D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '50D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '50D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '54D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '54D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '58D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '58D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '62D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '62D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '66D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '66D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '70D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '70D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '74D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '74D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '78D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '78D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '39D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '39D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '43D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '43D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '47D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '47D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '51D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '51D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '55D', 'ECONOMY'),
('ERM818', NULL, NULL, 'PALAWAN', 'BORACAY', '55D', 'ECONOMY'),
('ERM567', NULL, NULL, 'DAVAO', 'BORACAY', '37D', 'ECONOMY'),
('ERM567', NULL, NULL, 'DAVAO', 'BORACAY', '37D', 'ECONOMY');

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
