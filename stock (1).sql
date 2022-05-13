-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 13, 2022 at 01:31 PM
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
  `balance` varchar(11) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerid`, `name`, `username`, `phoneno`, `email`, `balance`) VALUES
(1, 'elon musk', 'musk', 871425674, 'america', '9831778'),
(2, 'jeff bezos', 'jeff', 73737, 'america', '705500'),
(3, 'athin soman', 'som', 9494, 'india', '999322182'),
(4, 'Nehala Hameed', 'nehu', 873563, 'nehu@gmail.com', '680428');

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
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pool`
--

INSERT INTO `pool` (`poolid`, `cusid`, `stockid`, `amount`, `shares`) VALUES
(1, 1, 3, 1347040, 100),
(2, 1, 2, 36797, 36),
(3, 4, 2, 152448, 144),
(4, 4, 3, 168660, 12);

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
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

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
(48, 4, 2, 'Reliance', '2022/05/13', '18:57:11 pm', 1124, 56);

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
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

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
(13, 4, 2, 'Reliance', '2022/05/13', '18:58:59 pm', 1186, 12);

-- --------------------------------------------------------

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
CREATE TABLE IF NOT EXISTS `stocks` (
  `stockid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  PRIMARY KEY (`stockid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stocks`
--

INSERT INTO `stocks` (`stockid`, `name`, `price`, `shares`) VALUES
(2, 'Reliance', 1172, 200000),
(3, 'Tesla', 14223, 60);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
