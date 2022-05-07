-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 07, 2022 at 01:30 PM
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
  `country` varchar(30) NOT NULL,
  `balance` varchar(11) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerid`, `name`, `username`, `phoneno`, `country`, `balance`) VALUES
(1, 'elon musk', 'musk', 871425674, 'america', '19000'),
(2, 'jeff bezos', 'jeff', 73737, 'america', '0'),
(3, 'athin soman', 'som', 9494, 'india', '4000');

-- --------------------------------------------------------

--
-- Table structure for table `pool`
--

DROP TABLE IF EXISTS `pool`;
CREATE TABLE IF NOT EXISTS `pool` (
  `poolid` int(11) NOT NULL AUTO_INCREMENT,
  `cusid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `stockname` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`poolid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pool`
--

INSERT INTO `pool` (`poolid`, `cusid`, `stockid`, `stockname`, `quantity`) VALUES
(1, 1, 1, 'Reliance', 0),
(2, 3, 1, 'Reliance', 3);

-- --------------------------------------------------------

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
CREATE TABLE IF NOT EXISTS `purchases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `stockname` varchar(30) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`id`, `customerid`, `stockid`, `stockname`, `date`, `time`, `price`, `quantity`, `total`) VALUES
(1, 1, 1, 'Reliance', '2022/05/07', '17:46:16 pm', 2000, 4, 8000),
(2, 1, 1, 'Reliance', '2022/05/07', '17:48:14 pm', 2000, 2, 4000),
(3, 3, 1, 'Reliance', '2022/05/07', '18:51:25 pm', 2000, 5, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `stockname` varchar(30) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `customerid`, `stockid`, `stockname`, `date`, `time`, `price`, `quantity`, `total`) VALUES
(1, 1, 1, 'Reliance', '2022/05/07', '17:59:30 pm', 2000, 6, 12000),
(2, 3, 1, 'Reliance', '2022/05/07', '18:58:18 pm', 2000, 2, 4000);

-- --------------------------------------------------------

--
-- Table structure for table `sectors`
--

DROP TABLE IF EXISTS `sectors`;
CREATE TABLE IF NOT EXISTS `sectors` (
  `sectorid` int(11) NOT NULL AUTO_INCREMENT,
  `sector` varchar(30) NOT NULL,
  PRIMARY KEY (`sectorid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sectors`
--

INSERT INTO `sectors` (`sectorid`, `sector`) VALUES
(1, 'Refineries'),
(2, 'Entertainment'),
(3, 'Metaverse'),
(4, 'Software'),
(5, 'Artificial Intelligence'),
(6, 'Blockchain'),
(7, 'Crptocurrency'),
(8, 'Virtual Reality'),
(9, 'Augmented Reality');

-- --------------------------------------------------------

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
CREATE TABLE IF NOT EXISTS `stocks` (
  `stockid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `NSE` varchar(10) NOT NULL,
  `price` int(11) NOT NULL,
  `category` varchar(30) NOT NULL,
  PRIMARY KEY (`stockid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stocks`
--

INSERT INTO `stocks` (`stockid`, `name`, `NSE`, `price`, `category`) VALUES
(1, 'Reliance', 'RIL', 2000, 'Blockchain');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
