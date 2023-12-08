-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2023 at 10:04 PM
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
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
-- Table structure for table `flight_manager`
--

CREATE TABLE `flight_manager` (
  `airplane_id` varchar(255) DEFAULT NULL,
  `flight_no` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `origin_date` datetime DEFAULT NULL,
  `destination_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`ticket_no`, `flight_no`, `seat`, `name`, `payment_date`, `status`, `ticket_agent`, `price`) VALUES
(NULL, 'ERM818', '1A', 'asdsads  asdsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '1A', 'asdsads  asdsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '2A', 'asdsad  sadsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '2A', 'asdsad  sadsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '37D', 'sadsad  sadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '37D', 'sadsad  sadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '41D', 'asdsadsa  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '41D', 'asdsadsa  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '45D', 'asdsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '45D', 'asdsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '49D', 'asdsadsasad  asdsadasdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '49D', 'asdsadsasad  asdsadasdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '53D', 'asdsadsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '53D', 'asdsadsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '57D', 'asdsadsa  sadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '57D', 'asdsadsa  sadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '61D', 'asdsadsa  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '61D', 'asdsadsa  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '65D', 'asdsadsadsa  asdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '65D', 'asdsadsadsa  asdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '69D', 'sadsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '69D', 'sadsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '73D', 'asdsadsad  sadsadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '73D', 'asdsadsad  sadsadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '77D', 'asdsadsadsad  asdsadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '77D', 'asdsadsadsad  asdsadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '38D', 'asdasdsad  xzcxzc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '38D', 'asdasdsad  xzcxzc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '42D', 'asdsadsad  sadsads', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '42D', 'asdsadsad  sadsads', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '46D', 'asdsadsad  zxczxcxz', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '46D', 'asdsadsad  zxczxcxz', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '50D', 'asdsadasd  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '50D', 'asdsadasd  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '54D', 'sadzxc  xzczxc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '54D', 'sadzxc  xzczxc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '58D', 'asdsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '58D', 'asdsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '62D', 'asdsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '62D', 'asdsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '66D', 'asdsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '66D', 'asdsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '70D', 'asdsadsadsad  sadsadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '70D', 'asdsadsadsad  sadsadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '74D', 'asdsadsadsa  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '74D', 'asdsadsadsa  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '78D', 'asdsadsads  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '78D', 'asdsadsads  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '39D', 'asdsadsad  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '39D', 'asdsadsad  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '43D', 'sadsadsad  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '43D', 'sadsadsad  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '47D', 'asdsadsadsa  asdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '47D', 'asdsadsadsa  asdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '51D', 'asdsadsad  sadsadas', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '51D', 'asdsadsad  sadsadas', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '55D', 'asdsadsadsa  sad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '55D', 'asdsadsadsa  sad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '59D', 'asdsadsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '59D', 'asdsadsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '63D', 'asdsadsad  asdsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '63D', 'asdsadsad  asdsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '67D', 'sadsadsadssa  sadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '67D', 'sadsadsadssa  sadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '71D', 'asdsadsads  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '71D', 'asdsadsads  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '75D', 'sadsadsadsad  asdasd', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '75D', 'sadsadsadsad  asdasd', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '79D', 'asdsadsadsa  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '79D', 'asdsadsadsa  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '40D', 'asdsadsax  xzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '40D', 'asdsadsax  xzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '44D', 'asdasd  zxcxzc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '44D', 'asdasd  zxcxzc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '48D', 'xzcxzcxzcasdsad  sadasdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '48D', 'xzcxzcxzcasdsad  sadasdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '52D', 'asdasdsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '52D', 'asdasdsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '56D', 'asdsadsad  zxcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '56D', 'asdsadsad  zxcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '60D', 'sadsadsads  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '60D', 'sadsadsads  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '64D', 'asdsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '64D', 'asdsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '68D', 'asdsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '68D', 'asdsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '72D', 'asdsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '72D', 'asdsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '76D', 'asdsadsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '76D', 'asdsadsadsad  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '80D', 'asdasd  asdasdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '80D', 'asdasd  asdasdsad', '2023-12-09', 'PAID', 'CASHIER', 1000),
(NULL, 'ERM818', '5A', 'sadsadsad  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '5A', 'sadsadsad  sadsadsa', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '6A', 'asdsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '6A', 'asdsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '3A', 'asdsadsadasd  sadsadas', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '3A', 'asdsadsadasd  sadsadas', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '7A', 'asdsadsa  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '7A', 'asdsadsa  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '4A', 'asdasd  sadasd', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '4A', 'asdasd  sadasd', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '8A', 'asdsad  asdsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '8A', 'asdsad  asdsad', '2023-12-09', 'PAID', 'CASHIER', 5999),
(NULL, 'ERM818', '9B', 'dsadsad  sadsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '9B', 'dsadsad  sadsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '13B', 'asdsadsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '13B', 'asdsadsadsad  asdsadsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '17B', 'sadsadsadxzd  zxdxzdxzd', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '17B', 'sadsadsadxzd  zxdxzdxzd', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '21B', 'asdasdasd  zxcxzxz', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '21B', 'asdasdasd  zxcxzxz', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '10B', 'asdsadsad  asdsadsa', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '10B', 'asdsadsad  asdsadsa', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '14B', 'zcxzcxzcxzc  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '14B', 'zcxzcxzcxzc  sadsadsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '18B', 'sadsadsa  dasdsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '18B', 'sadsadsa  dasdsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '22B', 'asdsadsad  asdsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '22B', 'asdsadsad  asdsad', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '11B', 'asdsadzxdzxd  zxdzxdxz', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '11B', 'asdsadzxdzxd  zxdzxdxz', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '15B', 'zxcxzcxzcxz  zxcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '15B', 'zxcxzcxzcxz  zxcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '19B', 'zxczxczx  cxzczxcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '19B', 'zxczxczx  cxzczxcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '23B', 'xzczxczxc  zxcxzcxz', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '23B', 'xzczxczxc  zxcxzcxz', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '12B', 'zxcvxzvzxv  zxvxzvxzv', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '12B', 'zxcvxzvzxv  zxvxzvxzv', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '16B', 'xzczxcxzc  zxczxcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '16B', 'xzczxcxzc  zxczxcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '20B', 'zxcxzcxzc  xzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '20B', 'zxcxzcxzc  xzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '24B', 'xzcxzcxzc  xzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '24B', 'xzcxzcxzc  xzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5499),
(NULL, 'ERM818', '25C', 'xzvxzvxzv  zxvxzvxzv', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '25C', 'xzvxzvxzv  zxvxzvxzv', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '29C', 'xzvzxvxzv  xzvzxvxz', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '29C', 'xzvzxvxzv  xzvzxvxz', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '33C', 'xzcxzcxzc  xzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '33C', 'xzcxzcxzc  xzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '26C', 'xzcxzcxz  cxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '26C', 'xzcxzcxz  cxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '30C', 'xzvxzvxzv  xzvxzvxzv', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '30C', 'xzvxzvxzv  xzvxzvxzv', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '34C', 'xzvxzvzxvxz  xzvxzvxzv', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '34C', 'xzvxzvzxvxz  xzvxzvxzv', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '27C', 'cxzasdsadsa  zxcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '27C', 'cxzasdsadsa  zxcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '31C', 'asdasdsadxzdzxd  xzdxzdxzd', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '31C', 'asdasdsadxzdzxd  xzdxzdxzd', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '35C', 'xzcxzcxzc  xzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '35C', 'xzcxzcxzc  xzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '28C', 'xzczxcxzcxz  xzcxzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '28C', 'xzczxcxzcxz  xzcxzcxzcxzc', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '32C', 'xzcxzcxz  zxcxzcxz', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'ERM818', '32C', 'xzcxzcxz  zxcxzcxz', '2023-12-09', 'PAID', 'CASHIER', 5000),
(NULL, 'sadsad', 'AVAILABILITY', 'sadsad', '2023-12-09', 'PAID', 'CASHIER', 123213);

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
