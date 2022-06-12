-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 12, 2022 at 01:21 PM
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
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminid`, `name`, `email`, `contact`, `username`, `password`) VALUES
(13, 'reshma babu', 'reshmababu@gmail.com', '8714267472', 'rbi', '123456'),
(12, 'Lahan Aluva', 'lahanaluva@gmail.com', '8714267455', 'lhn', '123456'),
(4, 'vishnu suresh', 'vishnusureshperumbavoor@gmail.com', '8714267479', 'vsp', '123456'),
(11, 'Vyshak Anand', 'vishnusureshperumbavoor@gmail.ccm', '8714267478', 'vyshu', '123456'),
(10, 'Fazeen Abu', 'fazeenabu@gmail.com', '8714267474', 'fabu', '123456'),
(14, 'Bhavana Joshy', 'bhavanajoshi@gmail.com', '8714267477', 'bhavu', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `phoneno` varchar(15) NOT NULL,
  `country` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `bank` varchar(20) NOT NULL,
  `demat` int(15) NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerid`, `name`, `username`, `phoneno`, `country`, `state`, `district`, `bank`, `demat`) VALUES
(1, 'elon musk', 'musk', '871425674', 'USA', 'Texas', 'Starbase', '776579010056789', 388300509),
(2, 'jeff bezos', 'jeff', '73737', '', '', '', '8856434234567', 506380),
(3, 'athin soman', 'som', '9494', 'India', 'Kerala', 'Ernakulam', '87544367865', 999320731),
(4, 'Nehala Hameed', 'nehu', '873563', '', '', '', '8745356786', 680428),
(5, 'Emina Eldhose', 'emina', '87363', '', '', '', '7854356789', 8993600),
(6, 'fazeen abu', 'fazeenabu', '74748', '', '', '', '8965432456', 8635),
(7, 'Aslam Suneer', 'aslu', '871425626', '', '', '', '8726737483', 10000),
(8, 'Binil Binoy', 'bny', '76267272', '', '', '', '987823892783789', 10003309),
(9, 'Anju Babu', 'anj', '84388', '', '', '', '737838383839939', 0),
(10, 'fathim aboobacker', 'aboo', '871425672', '', '', '', '747838383838348', 99969544),
(11, 'Aleena Babu', 'alu', '8714267', '', '', '', '653738494903737', 91400),
(12, 'David Warner', 'david', '8347467384', 'India', 'Andhra Pradesh', 'Anakapalli', '783747636378484', 95438);

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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pool`
--

INSERT INTO `pool` (`poolid`, `cusid`, `stockid`, `amount`, `shares`) VALUES
(1, 1, 1, 28483, 11),
(2, 2, 2, 13544, 8),
(3, 2, 4, 1450, 1),
(4, 3, 4, 1451, 1),
(5, 1, 2, 104810, 59),
(6, 12, 1, 8562, 3);

-- --------------------------------------------------------

--
-- Table structure for table `purchaseorder`
--

DROP TABLE IF EXISTS `purchaseorder`;
CREATE TABLE IF NOT EXISTS `purchaseorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL,
  `targetprice` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  `orderstatus` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseorder`
--

INSERT INTO `purchaseorder` (`id`, `customerid`, `stockid`, `date`, `time`, `targetprice`, `shares`, `orderstatus`) VALUES
(1, 1, 2, '2022/06/11', '13:15:31 pm', 1700, 10, 'failed'),
(2, 1, 2, '2022/06/11', '13:33:59 pm', 1700, 10, 'failed'),
(3, 1, 2, '2022/06/11', '13:34:07 pm', 1800, 10, 'success'),
(4, 1, 2, '2022/06/11', '13:35:52 pm', 1800, 10, 'success'),
(5, 1, 1, '2022/06/12', '15:17:50 pm', 2600, 10, 'successful'),
(6, 1, 1, '2022/06/12', '15:18:02 pm', 2000, 10, 'pending'),
(7, 1, 1, '2022/06/12', '15:18:32 pm', 3000, 20, 'pending'),
(8, 12, 1, '2022/06/12', '18:32:14 pm', 3000, 1, 'successful'),
(9, 12, 1, '2022/06/12', '18:37:48 pm', 2000, 1, 'pending'),
(10, 12, 1, '2022/06/12', '18:41:45 pm', 3000, 1, 'successful');

-- --------------------------------------------------------

--
-- Table structure for table `purchases`
--

DROP TABLE IF EXISTS `purchases`;
CREATE TABLE IF NOT EXISTS `purchases` (
  `purchaseid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL,
  `stockprice` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  PRIMARY KEY (`purchaseid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`purchaseid`, `customerid`, `stockid`, `date`, `time`, `stockprice`, `shares`) VALUES
(1, 1, 1, '2022/06/10', '22:47:31 pm', 2534, 1),
(2, 1, 1, '2022/06/10', '22:47:35 pm', 2537, 2),
(3, 2, 2, '2022/06/10', '22:47:45 pm', 1693, 12),
(4, 2, 4, '2022/06/10', '22:47:59 pm', 1450, 1),
(5, 3, 4, '2022/06/10', '22:58:49 pm', 1451, 1),
(6, 1, 2, '2022/06/11', '13:09:37 pm', 1707, 10),
(7, 1, 2, '2022/06/11', '13:30:21 pm', 1724, 10),
(8, 1, 2, '2022/06/11', '15:06:27 pm', 1800, 10),
(9, 1, 2, '2022/06/11', '15:07:29 pm', 1800, 10),
(10, 1, 1, '2022/06/12', '15:25:17 pm', 2600, 10),
(11, 12, 1, '2022/06/12', '18:29:13 pm', 2562, 1),
(12, 12, 1, '2022/06/12', '18:38:13 pm', 3000, 1),
(13, 12, 1, '2022/06/12', '18:41:52 pm', 3000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `salesid` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL,
  `puravg` int(11) NOT NULL,
  `sellavg` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  PRIMARY KEY (`salesid`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`salesid`, `customerid`, `stockid`, `date`, `time`, `puravg`, `sellavg`, `shares`) VALUES
(1, 1, 1, '2022/06/10', '23:09:35 pm', 2536, 2542, 1),
(2, 2, 2, '2022/06/10', '23:09:47 pm', 1693, 1713, 2),
(3, 2, 2, '2022/06/10', '23:09:50 pm', 1693, 1710, 2),
(4, 1, 1, '2022/06/12', '15:35:34 pm', 2589, 2565, 1),
(5, 1, 2, '2022/06/12', '16:20:43 pm', 1771, 1500, 1);

-- --------------------------------------------------------

--
-- Table structure for table `salesorder`
--

DROP TABLE IF EXISTS `salesorder`;
CREATE TABLE IF NOT EXISTS `salesorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `stockid` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL,
  `puravg` int(11) NOT NULL,
  `targetprice` int(11) NOT NULL,
  `shares` int(11) NOT NULL,
  `orderstatus` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salesorder`
--

INSERT INTO `salesorder` (`id`, `customerid`, `stockid`, `date`, `time`, `puravg`, `targetprice`, `shares`, `orderstatus`) VALUES
(1, 1, 2, '2022/06/12', '16:04:28 pm', 1771, 1500, 1, 'successful'),
(2, 1, 2, '2022/06/12', '16:04:34 pm', 1771, 2000, 1, 'failed'),
(3, 1, 2, '2022/06/12', '16:04:43 pm', 1771, 2000, 1, 'pending');

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
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stocks`
--

INSERT INTO `stocks` (`stockid`, `name`, `sector`, `price`, `shares`, `supply`) VALUES
(2, 'Reliance', 'Refinery', 1812, 1000, 122),
(3, 'Netflix', 'Streaming', 2562, 20000, 19998),
(4, 'Google', 'Software', 1452, 800, 697),
(7, 'Microsoft', 'Software', 1000, 10000, 10000),
(1, 'Amazon', 'Entertainment', 2571, 3000, 2674);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
