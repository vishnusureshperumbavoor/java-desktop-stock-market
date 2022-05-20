-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 20, 2022 at 11:07 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stock`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(12) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminid`, `name`, `email`, `contact`, `username`, `password`) VALUES
(4, 'vishnu suresh', 'vishnusureshperumbavoor@gmail.com', '8714267479', 'vsp', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `phoneno` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `demat` varchar(11) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerid`, `name`, `username`, `phoneno`, `email`, `demat`) VALUES
(1, 'elon musk', 'musk', 871425674, 'america', '389892290'),
(2, 'jeff bezos', 'jeff', 73737, 'america', '521300'),
(3, 'athin soman', 'som', 9494, 'india', '999322182'),
(4, 'Nehala Hameed', 'nehu', 873563, 'nehu@gmail.com', '680428'),
(5, 'Emina Eldhose', 'emina', 87363, 'emi@gamial.com', '8993600');

-- --------------------------------------------------------

--
-- Table structure for table `pool`
--

DROP TABLE IF EXISTS `pool`;
CREATE TABLE IF NOT EXISTS `pool` (
  `poolid` int(11) NOT NULL AUTO_INCREMENT,
  `cusid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  PRIMARY KEY (`poolid`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pool`
--

INSERT INTO `pool` (`poolid`, `cusid`, `stockid`, `amount`, `shares`) VALUES
(1, 1, 3, -201000, 30),
(2, 1, 2, -14280, 0),
(3, 4, 2, 152448, 144),
(4, 4, 3, 168660, 12),
(5, 1, 4, 23513180, 160),
(6, 1, 5, 1053270, 638),
(7, 5, 4, -5100, 0),
(8, 5, 5, 405600, 200),
(9, 5, 6, 1615900, 1000),
(10, 1, 6, 9441600, 5000),
(11, 2, 6, 184200, 100);

-- --------------------------------------------------------

--
-- Table structure for table `purchaseorder`
--

DROP TABLE IF EXISTS `purchaseorder`;
CREATE TABLE IF NOT EXISTS `purchaseorder` (
  `porderid` int(11) NOT NULL AUTO_INCREMENT,
  `stockid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  `orderprize` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(20) NOT NULL,
  PRIMARY KEY (`porderid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseorder`
--

INSERT INTO `purchaseorder` (`porderid`, `stockid`, `customerid`, `shares`, `orderprize`, `date`, `time`) VALUES
(1, 5, 1, 30, 1800, '2022-05-20', '13:43:22 pm'),
(2, 5, 1, 10, 1900, '2022-05-20', '13:45:12 pm');

-- --------------------------------------------------------

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
CREATE TABLE IF NOT EXISTS `purchases` (
  `purchaseid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `stockname` varchar(30) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL,
  `stockprice` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  PRIMARY KEY (`purchaseid`)
) ENGINE=MyISAM AUTO_INCREMENT=118 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`purchaseid`, `customerid`, `stockid`, `stockname`, `date`, `time`, `stockprice`, `shares`) VALUES
(1, 2, 2, 'Reliance', '2022/05/12', '22:17:01 pm', 1200, 2),
(2, 2, 2, 'Reliance', '2022/05/12', '22:32:27 pm', 1200, 3),
(3, 2, 2, 'Reliance', '2022/05/12', '22:39:51 pm', 1200, 15),
(4, 1, 2, 'Reliance', '2022/05/12', '22:51:16 pm', 1200, 3),
(5, 2, 2, 'Reliance', '2022/05/12', '23:00:19 pm', 1200, 9),
(6, 1, 2, 'Reliance', '2022/05/12', '23:09:24 pm', 1200, 7),
(7, 1, 2, 'Reliance', '2022/05/12', '23:11:19 pm', 1200, 3),
(8, 2, 2, 'Reliance', '2022/05/12', '23:13:44 pm', 1200, 4),
(9, 2, 2, 'Reliance', '2022/05/12', '23:17:05 pm', 950, 2),
(10, 1, 2, 'Reliance', '2022/05/13', '05:34:04 am', 950, 3),
(11, 1, 2, 'Reliance', '2022/05/13', '05:34:30 am', 1300, 3),
(12, 1, 2, 'Reliance', '2022/05/13', '05:34:52 am', 1475, 3),
(13, 1, 2, 'Reliance', '2022/05/13', '05:59:52 am', 1182, 2),
(14, 1, 2, 'Reliance', '2022/05/13', '06:04:09 am', 1194, 4),
(15, 2, 3, 'Tesla', '2022/05/13', '06:23:49 am', 4600, 50),
(16, 3, 2, 'Reliance', '2022/05/13', '06:30:15 am', 909, 2),
(17, 3, 3, 'Tesla', '2022/05/13', '06:33:26 am', 6900, 100),
(18, 1, 3, 'Tesla', '2022/05/13', '11:00:34 am', 13800, 20),
(19, 1, 3, 'Tesla', '2022/05/13', '11:00:42 am', 13800, 20),
(20, 1, 3, 'Tesla', '2022/05/13', '11:02:38 am', 13800, 40),
(21, 1, 2, 'Reliance', '2022/05/13', '11:04:29 am', 927, 20),
(22, 1, 2, 'Reliance', '2022/05/13', '11:06:03 am', 927, 40),
(23, 1, 2, 'Reliance', '2022/05/13', '11:07:33 am', 927, 23),
(24, 1, 2, 'Reliance', '2022/05/13', '11:09:38 am', 927, 20),
(25, 1, 3, 'Tesla', '2022/05/13', '14:22:35 pm', 13122, 50),
(26, 1, 2, 'Reliance', '2022/05/13', '15:03:52 pm', 1001, 10),
(27, 1, 2, 'Reliance', '2022/05/13', '15:10:13 pm', 1011, 10),
(28, 1, 2, 'Reliance', '2022/05/13', '15:24:14 pm', 1021, 10),
(29, 1, 2, 'Reliance', '2022/05/13', '15:24:28 pm', 1031, 10),
(30, 1, 2, 'Reliance', '2022/05/13', '15:24:39 pm', 1041, 10),
(31, 1, 2, 'Reliance', '2022/05/13', '15:24:55 pm', 1051, 10),
(32, 1, 2, 'Reliance', '2022/05/13', '15:26:05 pm', 1062, 10),
(33, 1, 2, 'Reliance', '2022/05/13', '15:27:36 pm', 1073, 20),
(34, 1, 2, 'Reliance', '2022/05/13', '15:27:47 pm', 1094, 20),
(35, 1, 3, 'Tesla', '2022/05/13', '15:29:59 pm', 13778, 10),
(36, 1, 2, 'Reliance', '2022/05/13', '15:32:14 pm', 1116, 10),
(37, 1, 2, 'Reliance', '2022/05/13', '16:11:32 pm', 1127, 10),
(38, 1, 2, 'Reliance', '2022/05/13', '16:15:59 pm', 1138, 10),
(39, 1, 2, 'Reliance', '2022/05/13', '16:48:29 pm', 1138, 10),
(40, 1, 2, 'Reliance', '2022/05/13', '16:53:02 pm', 1138, 45),
(41, 1, 2, 'Reliance', '2022/05/13', '17:43:21 pm', 995, 10),
(42, 1, 2, 'Reliance', '2022/05/13', '17:54:53 pm', 1004, 10),
(43, 1, 2, 'Reliance', '2022/05/13', '18:05:06 pm', 1014, 10),
(44, 1, 2, 'Reliance', '2022/05/13', '18:06:34 pm', 1024, 10),
(45, 1, 3, 'Tesla', '2022/05/13', '18:06:43 pm', 13916, 10),
(46, 4, 2, 'Reliance', '2022/05/13', '18:54:32 pm', 1022, 100),
(47, 4, 3, 'Tesla', '2022/05/13', '18:56:36 pm', 14055, 12),
(48, 4, 2, 'Reliance', '2022/05/13', '18:57:11 pm', 1124, 56),
(49, 1, 2, 'Reliance', '2022/05/18', '12:07:10 pm', 1172, 200),
(50, 1, 2, 'Reliance', '2022/05/18', '12:10:35 pm', 1406, 200),
(51, 1, 2, 'Reliance', '2022/05/18', '12:11:22 pm', 1687, 200),
(52, 1, 2, 'Reliance', '2022/05/18', '12:13:13 pm', 2024, 200),
(53, 1, 2, 'Reliance', '2022/05/18', '12:15:26 pm', 2428, 200),
(54, 1, 2, 'Reliance', '2022/05/18', '12:16:56 pm', 2913, 200),
(55, 1, 2, 'Reliance', '2022/05/18', '12:17:26 pm', 3495, 200),
(56, 1, 3, 'Tesla', '2022/05/18', '12:17:52 pm', 14223, 20),
(57, 1, 2, 'Reliance', '2022/05/18', '12:19:23 pm', 4194, 200),
(58, 1, 3, 'Tesla', '2022/05/18', '12:19:39 pm', 14507, 20),
(59, 1, 2, 'Reliance', '2022/05/18', '14:03:33 pm', 1000, 20),
(60, 1, 2, 'Reliance', '2022/05/19', '12:51:03 pm', 1000, 20),
(61, 1, 3, 'Tesla', '2022/05/19', '13:18:50 pm', 26634, 60),
(62, 1, 3, 'Tesla', '2022/05/19', '13:20:21 pm', 0, 60),
(63, 1, 4, 'Google', '2022/05/19', '15:46:16 pm', 1200, 20),
(64, 1, 2, 'Reliance', '2022/05/19', '15:47:51 pm', 476, 30),
(65, 1, 4, 'Google', '2022/05/19', '17:23:57 pm', 1224, 20),
(66, 1, 4, 'Google', '2022/05/19', '17:27:30 pm', 1224, 20),
(67, 1, 4, 'Google', '2022/05/19', '17:33:50 pm', 1224, 20),
(68, 1, 4, 'Google', '2022/05/19', '17:34:03 pm', 1224, 20),
(69, 1, 4, 'Google', '2022/05/19', '17:34:10 pm', 1224, 20),
(70, 1, 4, 'Google', '2022/05/19', '17:34:16 pm', 1224, 20),
(71, 1, 4, 'Google', '2022/05/19', '17:34:24 pm', 1224, 20),
(72, 1, 5, 'Netflix', '2022/05/19', '17:40:03 pm', 2000, 20),
(73, 1, 5, 'Netflix', '2022/05/19', '17:50:16 pm', 2000, 20),
(74, 1, 5, 'Netflix', '2022/05/19', '17:50:28 pm', 2000, 20),
(75, 1, 5, 'Netflix', '2022/05/19', '17:50:38 pm', 2000, 20),
(76, 1, 5, 'Netflix', '2022/05/19', '17:52:15 pm', 2000, 20),
(77, 1, 5, 'Netflix', '2022/05/19', '17:53:23 pm', 2000, 20),
(78, 1, 5, 'Netflix', '2022/05/19', '17:54:18 pm', 2000, 20),
(79, 1, 5, 'Netflix', '2022/05/20', '08:54:41 am', 2000, 20),
(80, 1, 5, 'Netflix', '2022/05/20', '10:45:08 am', 2000, 20),
(81, 1, 5, 'elon musk', '2022/05/20', '10:45:18 am', 2000, 20),
(82, 1, 5, 'elon musk', '2022/05/20', '10:47:18 am', 2000, 20),
(83, 1, 5, 'elon musk', '2022/05/20', '10:50:22 am', 2000, 20),
(84, 1, 5, 'elon musk', '2022/05/20', '10:55:46 am', 2000, 20),
(85, 1, 5, 'elon musk', '2022/05/20', '10:57:39 am', 2000, 20),
(86, 1, 5, 'elon musk', '2022/05/20', '11:02:11 am', 2000, 20),
(87, 1, 5, 'Netflix', '2022/05/20', '11:04:12 am', 2000, 20),
(88, 1, 5, 'Netflix', '2022/05/20', '11:04:32 am', 2000, 20),
(89, 1, 5, 'Netflix', '2022/05/20', '11:07:23 am', 2000, 20),
(90, 1, 5, 'Netflix', '2022/05/20', '11:55:52 am', 2000, 20),
(91, 1, 5, 'Netflix', '2022/05/20', '11:56:05 am', 2000, 20),
(92, 1, 5, 'Netflix', '2022/05/20', '11:56:15 am', 2000, 20),
(93, 1, 5, 'Netflix', '2022/05/20', '11:56:20 am', 2000, 20),
(94, 1, 5, 'Netflix', '2022/05/20', '11:56:29 am', 2000, 20),
(95, 1, 5, 'Netflix', '2022/05/20', '12:01:38 pm', 2000, 20),
(96, 1, 5, 'Netflix', '2022/05/20', '12:01:41 pm', 2000, 20),
(97, 1, 5, 'Netflix', '2022/05/20', '12:01:43 pm', 2000, 20),
(98, 1, 5, 'Netflix', '2022/05/20', '12:03:00 pm', 2000, 20),
(99, 1, 5, 'Netflix', '2022/05/20', '12:57:14 pm', 2000, 20),
(100, 1, 5, 'Netflix', '2022/05/20', '13:55:01 pm', 2000, 40),
(101, 1, 5, 'Netflix', '2022/05/20', '13:56:17 pm', 2000, 200),
(102, 1, 5, 'Netflix', '2022/05/20', '13:58:51 pm', 2400, 300),
(103, 1, 5, 'Netflix', '2022/05/20', '15:05:03 pm', 2053, 10),
(104, 1, 5, 'Netflix', '2022/05/20', '15:06:05 pm', 2074, 20),
(105, 1, 5, 'Netflix', '2022/05/20', '15:06:13 pm', 2115, 20),
(106, 5, 4, 'Google', '2022/05/20', '15:17:34 pm', 1224, 80),
(107, 5, 5, 'Netflix', '2022/05/20', '15:22:32 pm', 2157, 100),
(108, 5, 6, 'Amazon', '2022/05/20', '15:26:51 pm', 1200, 100),
(109, 5, 6, 'Amazon', '2022/05/20', '15:32:07 pm', 1188, 900),
(110, 5, 5, 'Netflix', '2022/05/20', '16:25:00 pm', 2136, 200),
(111, 5, 6, 'Amazon', '2022/05/20', '16:25:14 pm', 2257, 600),
(112, 1, 6, 'Amazon', '2022/05/20', '16:29:51 pm', 1806, 200),
(113, 1, 6, 'Amazon', '2022/05/20', '16:30:15 pm', 1824, 200),
(114, 2, 6, 'Amazon', '2022/05/20', '16:30:41 pm', 1842, 100),
(115, 1, 6, 'Amazon', '2022/05/20', '16:32:39 pm', 1860, 200),
(116, 1, 6, 'Amazon', '2022/05/20', '16:32:48 pm', 1879, 400),
(117, 1, 6, 'Amazon', '2022/05/20', '16:32:53 pm', 1898, 4000);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `salesid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `stockname` varchar(30) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL,
  `stockprice` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  PRIMARY KEY (`salesid`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`salesid`, `customerid`, `stockid`, `stockname`, `date`, `time`, `stockprice`, `shares`) VALUES
(1, 1, 2, 'Reliance', '2022/05/13', '06:20:52 am', 1242, 5),
(2, 1, 2, 'Reliance', '2022/05/13', '06:21:07 am', 1180, 23),
(3, 1, 2, 'Reliance', '2022/05/13', '13:00:13 pm', 1112, 100),
(4, 1, 3, 'Tesla', '2022/05/13', '13:36:53 pm', 13800, 20),
(5, 1, 3, 'Tesla', '2022/05/13', '13:43:26 pm', 13524, 10),
(6, 1, 3, 'Tesla', '2022/05/13', '13:52:22 pm', 13389, 10),
(7, 1, 3, 'Tesla', '2022/05/13', '13:54:11 pm', 13255, 10),
(8, 1, 2, 'Reliance', '2022/05/13', '16:42:52 pm', 1149, 10),
(9, 1, 2, 'Reliance', '2022/05/13', '16:49:54 pm', 1149, 10),
(10, 1, 2, 'Reliance', '2022/05/13', '16:53:53 pm', 1189, 100),
(11, 1, 2, 'Reliance', '2022/05/13', '17:03:30 pm', 1070, 70),
(12, 1, 2, 'Reliance', '2022/05/13', '18:09:06 pm', 1034, 12),
(13, 4, 2, 'Reliance', '2022/05/13', '18:58:59 pm', 1186, 12),
(14, 1, 2, 'Reliance', '2022/05/18', '13:40:51 pm', 5032, 200),
(15, 1, 2, 'Reliance', '2022/05/18', '13:43:08 pm', 4026, 200),
(16, 1, 2, 'Reliance', '2022/05/18', '13:44:18 pm', 3221, 200),
(17, 1, 2, 'Reliance', '2022/05/18', '13:44:26 pm', 2577, 200),
(18, 1, 3, 'Tesla', '2022/05/18', '13:44:54 pm', 14797, 100),
(19, 1, 2, 'Reliance', '2022/05/18', '14:17:44 pm', 1400, 20),
(20, 1, 2, 'Reliance', '2022/05/19', '12:51:55 pm', 1400, 20),
(21, 1, 3, 'Tesla', '2022/05/19', '12:59:04 pm', 13317, 20),
(22, 1, 3, 'Tesla', '2022/05/19', '13:00:08 pm', 26634, 20),
(23, 1, 3, 'Tesla', '2022/05/19', '13:19:39 pm', 53268, 60),
(24, 1, 5, 'Netflix', '2022/05/19', '17:57:56 pm', 2000, 20),
(25, 1, 5, 'Netflix', '2022/05/19', '17:58:02 pm', 2000, 20),
(26, 1, 5, 'Netflix', '2022/05/19', '17:58:07 pm', 2000, 20),
(27, 1, 5, 'Netflix', '2022/05/19', '18:03:36 pm', 2000, 32),
(28, 1, 5, 'Netflix', '2022/05/20', '12:08:53 pm', 2000, 20),
(29, 1, 5, 'Netflix', '2022/05/20', '12:09:00 pm', 2000, 20),
(30, 1, 5, 'Netflix', '2022/05/20', '12:09:07 pm', 2000, 20),
(31, 1, 5, 'Netflix', '2022/05/20', '12:09:31 pm', 2000, 20),
(32, 1, 5, 'Netflix', '2022/05/20', '12:09:38 pm', 2000, 20),
(33, 1, 5, 'Netflix', '2022/05/20', '12:09:44 pm', 2000, 20),
(34, 1, 5, 'Netflix', '2022/05/20', '12:09:57 pm', 2000, 20),
(35, 1, 5, 'Netflix', '2022/05/20', '12:11:48 pm', 2000, 20),
(36, 1, 5, 'Netflix', '2022/05/20', '12:11:59 pm', 2000, 20),
(37, 1, 5, 'Netflix', '2022/05/20', '12:12:51 pm', 2000, 20),
(38, 1, 5, 'Netflix', '2022/05/20', '14:06:08 pm', 3120, 300),
(39, 1, 2, 'Reliance', '2022/05/20', '14:36:21 pm', 952, 30),
(40, 1, 3, 'Tesla', '2022/05/20', '14:42:13 pm', 6700, 30),
(41, 1, 5, 'Netflix', '2022/05/20', '14:59:42 pm', 2184, 60),
(42, 5, 4, 'Google', '2022/05/20', '15:19:48 pm', 1322, 40),
(43, 5, 4, 'Google', '2022/05/20', '15:20:04 pm', 1269, 20),
(44, 5, 4, 'Google', '2022/05/20', '15:20:14 pm', 1244, 10),
(45, 5, 4, 'Google', '2022/05/20', '15:22:00 pm', 1232, 10),
(46, 5, 5, 'Netflix', '2022/05/20', '15:22:50 pm', 2373, 100),
(47, 5, 6, 'Amazon', '2022/05/20', '15:30:57 pm', 1320, 100),
(48, 5, 6, 'Amazon', '2022/05/20', '16:27:07 pm', 3611, 500);

-- --------------------------------------------------------

--
-- Table structure for table `sectors`
--

DROP TABLE IF EXISTS `sectors`;
CREATE TABLE IF NOT EXISTS `sectors` (
  `sectorid` int(11) NOT NULL AUTO_INCREMENT,
  `sector` varchar(20) NOT NULL,
  PRIMARY KEY (`sectorid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sectors`
--

INSERT INTO `sectors` (`sectorid`, `sector`) VALUES
(1, 'Entertainment'),
(3, 'Refinery'),
(4, 'Robotics'),
(5, 'Streaming'),
(6, 'Software');

-- --------------------------------------------------------

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
CREATE TABLE IF NOT EXISTS `stocks` (
  `stockid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `sector` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  `supply` int(11) NOT NULL,
  PRIMARY KEY (`stockid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stocks`
--

INSERT INTO `stocks` (`stockid`, `name`, `sector`, `price`, `shares`, `supply`) VALUES
(2, 'Reliance', 'Refinery', 923, 50, -30),
(3, 'Tesla   ', 'Robotics', 6499, 60, -30),
(5, 'Netflix', 'Streaming', 2563, 20000, 18542),
(4, 'Google', 'Software', 1220, 1000, 820),
(6, 'Amazon', 'Entertainment', 1917, 200000, 192700);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
