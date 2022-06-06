-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 06, 2022 at 10:20 AM
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
-- Database: `stock-market`
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
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminid`, `name`, `email`, `contact`, `username`, `password`) VALUES
(4, 'vishnu suresh', 'vishnusureshperumbavoor@gmail.com', '8714267479', 'vsp', '123456'),
(11, 'Vyshak Anand', 'vishnusureshperumbavoor@gmail.ccm', '8714267478', 'vyshu', '123456'),
(10, 'Fazeen Abu', 'fazeenabu@gmail.com', '8714267474', 'fabu', '123456');

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
  `bank` varchar(20) NOT NULL,
  `demat` int(15) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerid`, `name`, `username`, `phoneno`, `bank`, `demat`) VALUES
(1, 'elon musk', 'musk', 871425674, '776579010056789', 389814090),
(2, 'jeff bezos', 'jeff', 73737, '8856434234567', 521300),
(3, 'athin soman', 'som', 9494, '87544367865', 999322182),
(4, 'Nehala Hameed', 'nehu', 873563, '8745356786', 680428),
(5, 'Emina Eldhose', 'emina', 87363, '7854356789', 8993600),
(6, 'fazeen abu', 'fazeenabu', 74748, '8965432456', 8635),
(7, 'Aslam Suneer', 'aslu', 871425626, '8726737483', 10000);

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
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pool`
--

INSERT INTO `pool` (`poolid`, `cusid`, `stockid`, `amount`, `shares`) VALUES
(1, 1, 2, 0, 0);

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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`purchaseid`, `customerid`, `stockid`, `stockname`, `date`, `time`, `stockprice`, `shares`) VALUES
(1, 1, 2, 'Reliance', '2022/06/06', '15:38:02 pm', 926, 100),
(2, 1, 2, 'Reliance', '2022/06/06', '15:41:46 pm', 917, 100),
(3, 1, 2, 'Reliance', '2022/06/06', '15:42:24 pm', 908, 200);

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
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`salesid`, `customerid`, `stockid`, `stockname`, `date`, `time`, `stockprice`, `shares`) VALUES
(1, 1, 2, 'Reliance', '2022/06/06', '15:38:16 pm', 1019, 100),
(2, 1, 2, 'Reliance', '2022/06/06', '15:41:56 pm', 1009, 100),
(3, 1, 2, 'Reliance', '2022/06/06', '15:42:32 pm', 1090, 100),
(4, 1, 2, 'Reliance', '2022/06/06', '15:42:38 pm', 981, 100);

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
(2, 'Reliance', 'Refinery', 883, 1000, 1000),
(3, 'Tesla   ', 'Robotics', 40, 60, 60),
(5, 'Netflix', 'Streaming', 2563, 20000, 20000),
(4, 'Google', 'Software', 1342, 800, 800),
(6, 'Amazon', 'Entertainment', 1926, 3000, 3000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
