-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 21, 2022 at 02:42 AM
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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminid`, `name`, `email`, `contact`, `username`, `password`) VALUES
(6, 'Fathima Aboobacker', 'fathimaaboobakkar@gmail.com', '746747', 'fathu2', '12356'),
(5, 'Fathima Sulaiman', 'fathimasulaiman@gmail.com', '746747', 'fathu', '123'),
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
  PRIMARY KEY (`customerid`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerid`, `name`, `username`, `phoneno`, `country`) VALUES
(2, 'elon musk', 'musk', 4646, 'america'),
(3, 'jeff bezos', 'jeff', 74747, 'america'),
(4, 'mukesh ambani', 'ambani', 73473, 'india'),
(5, 'gautam adani', 'adani', 784784, 'india'),
(10, 'Fathima Aneesh', 'fath', 83838, 'india'),
(7, 'ma yousuf ali', 'mayou', 34, 'uae'),
(8, 'mark zuckerberg', 'zuck', 1233, 'americaf'),
(9, 'vijay shekhar sharma', 'vss', 123, 'india'),
(11, 'shruthi', 'shr', 7474, 'india');

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
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pool`
--

INSERT INTO `pool` (`poolid`, `cusid`, `stockid`, `stockname`, `quantity`) VALUES
(5, 10, 6, 'tesla', 0),
(4, 2, 6, 'tesla', 30),
(6, 11, 8, 'twitter', 4),
(7, 2, 8, 'twitter', 284),
(8, 2, 10, 'instagram', 14),
(9, 2, 2, 'amazon', 170),
(10, 2, 7, 'spacex', 38),
(11, 2, 3, 'apple', 89),
(12, 2, 1, 'facebook', 108),
(13, 2, 5, 'google', 20),
(14, 2, 4, 'microsoft', 20);

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
) ENGINE=MyISAM AUTO_INCREMENT=115 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`id`, `customerid`, `stockid`, `stockname`, `date`, `time`, `price`, `quantity`, `total`) VALUES
(1, 2, 8, 'twitter', '2022/04/17', '12:08:27 pm', 474, 20, 9480),
(2, 2, 8, 'twitter', '2022/04/17', '12:08:34 pm', 474, 200, 94800),
(3, 2, 5, 'google', '2022/04/17', '12:08:47 pm', 757, 20, 15140),
(4, 3, 3, 'apple', '2022/04/17', '12:09:09 pm', 647, 50, 32350),
(5, 3, 2, 'amazon', '2022/04/17', '12:09:25 pm', 569, 18, 10242),
(6, 2, 8, 'twitter', '2022/04/17', '17:23:48 pm', 474, 20, 9480),
(7, 2, 8, 'twitter', '2022/04/17', '17:32:04 pm', 474, 20, 9480),
(8, 2, 8, 'twitter', '2022/04/17', '17:33:10 pm', 474, 20, 9480),
(9, 2, 8, 'twitter', '2022/04/17', '17:35:37 pm', 474, 20, 9480),
(10, 2, 8, 'twitter', '2022/04/17', '17:35:47 pm', 474, 20, 9480),
(11, 2, 5, 'google', '2022/04/18', '18:09:49 pm', 757, 40, 30280),
(12, 2, 5, 'google', '2022/04/18', '18:10:13 pm', 757, 100, 75700),
(13, 2, 5, 'google', '2022/04/18', '18:10:21 pm', 757, 100, 75700),
(14, 2, 8, 'twitter', '2022/04/18', '18:12:42 pm', 474, 20, 9480),
(15, 2, 8, 'twitter', '2022/04/18', '18:22:44 pm', 474, 20, 9480),
(16, 2, 8, 'twitter', '2022/04/18', '18:22:53 pm', 474, 200, 94800),
(17, 2, 7, 'spacex', '2022/04/18', '18:29:52 pm', 747, 59, 44073),
(18, 2, 8, 'twitter', '2022/04/18', '18:32:03 pm', 474, 30, 14220),
(19, 2, 8, 'twitter', '2022/04/18', '18:37:22 pm', 474, 20, 9480),
(20, 2, 8, 'twitter', '2022/04/18', '19:52:21 pm', 474, 30, 14220),
(21, 2, 8, 'twitter', '2022/04/18', '19:52:32 pm', 474, 300, 142200),
(22, 2, 8, 'twitter', '2022/04/18', '20:14:38 pm', 474, 200, 94800),
(23, 2, 8, 'twitter', '2022/04/18', '20:14:47 pm', 474, 200, 94800),
(24, 2, 8, 'twitter', '2022/04/18', '20:15:17 pm', 474, 20, 9480),
(25, 2, 8, 'twitter', '2022/04/18', '20:35:13 pm', 474, 20, 9480),
(26, 2, 8, 'twitter', '2022/04/18', '20:38:18 pm', 474, 20, 9480),
(27, 2, 8, 'twitter', '2022/04/18', '20:38:39 pm', 474, 20, 9480),
(28, 2, 8, 'twitter', '2022/04/18', '20:39:42 pm', 474, 20, 9480),
(29, 2, 8, 'twitter', '2022/04/18', '20:40:29 pm', 474, 90, 42660),
(30, 2, 8, 'twitter', '2022/04/18', '20:42:23 pm', 474, 20, 9480),
(31, 2, 8, 'twitter', '2022/04/18', '20:43:22 pm', 474, 78, 36972),
(32, 2, 1, 'facebook', '2022/04/18', '20:56:47 pm', 133, 2, 266),
(33, 2, 1, 'facebook', '2022/04/18', '20:59:11 pm', 133, 2, 266),
(34, 2, 2, 'amazon', '2022/04/18', '21:04:56 pm', 569, 2, 1138),
(35, 2, 2, 'amazon', '2022/04/18', '21:08:44 pm', 569, 50, 28450),
(36, 2, 3, 'apple', '2022/04/18', '21:37:50 pm', 647, 4, 2588),
(37, 2, 4, 'microsoft', '2022/04/18', '21:42:37 pm', 756, 20, 15120),
(38, 2, 5, 'google', '2022/04/19', '17:03:12 pm', 757, 10, 7570),
(39, 2, 5, 'google', '2022/04/19', '17:03:33 pm', 757, 10, 7570),
(40, 2, 5, 'google', '2022/04/19', '17:03:51 pm', 757, 100, 75700),
(41, 2, 4, 'microsoft', '2022/04/19', '17:04:51 pm', 756, 80, 60480),
(42, 8, 4, 'microsoft', '2022/04/19', '17:38:45 pm', 756, 50, 37800),
(43, 2, 6, 'tesla', '2022/04/19', '17:59:39 pm', 935, 50, 46750),
(44, 2, 3, 'apple', '2022/04/19', '17:59:50 pm', 647, 67, 43349),
(45, 8, 6, 'tesla', '2022/04/19', '17:59:39 pm', 935, 50, 46750),
(46, 8, 3, 'apple', '2022/04/19', '17:59:50 pm', 647, 67, 43349),
(47, 8, 3, 'apple', '2022/04/19', '18:00:17 pm', 647, 5, 3235),
(48, 8, 4, 'microsoft', '2022/04/19', '18:00:45 pm', 756, 50, 37800),
(49, 7, 8, 'twitter', '2022/04/19', '18:01:45 pm', 474, 89, 42186),
(50, 7, 4, 'microsoft', '2022/04/19', '18:02:04 pm', 756, 54, 40824),
(51, 2, 3, 'apple', '2022/04/19', '18:28:09 pm', 647, 20, 12940),
(52, 2, 3, 'apple', '2022/04/19', '18:28:20 pm', 647, 20, 12940),
(53, 2, 3, 'apple', '2022/04/19', '18:28:47 pm', 647, 20, 12940),
(54, 5, 4, 'microsoft', '2022/04/19', '18:29:11 pm', 756, 50, 37800),
(55, 5, 6, 'tesla', '2022/04/19', '18:31:13 pm', 935, 30, 28050),
(56, 5, 6, 'tesla', '2022/04/19', '18:32:39 pm', 935, 20, 18700),
(57, 4, 6, 'tesla', '2022/04/19', '18:33:41 pm', 935, 20, 18700),
(58, 4, 6, 'tesla', '2022/04/19', '18:33:55 pm', 935, 200, 187000),
(59, 2, 7, 'spacex', '2022/04/19', '18:45:52 pm', 747, 20, 14940),
(60, 2, 3, 'apple', '2022/04/19', '18:55:45 pm', 647, 20, 12940),
(61, 2, 3, 'apple', '2022/04/19', '18:56:41 pm', 647, 20, 12940),
(62, 2, 7, 'spacex', '2022/04/19', '18:59:04 pm', 747, 20, 14940),
(63, 2, 7, 'spacex', '2022/04/19', '19:10:01 pm', 747, 1, 747),
(64, 2, 7, 'spacex', '2022/04/19', '19:22:44 pm', 747, 39, 29133),
(65, 2, 7, 'spacex', '2022/04/19', '19:25:02 pm', 747, 800, 597600),
(66, 2, 7, 'spacex', '2022/04/19', '19:26:52 pm', 747, 700, 522900),
(67, 2, 7, 'spacex', '2022/04/19', '19:27:04 pm', 747, 2, 1494),
(68, 2, 7, 'spacex', '2022/04/19', '19:27:30 pm', 747, 502, 374994),
(69, 2, 7, 'spacex', '2022/04/19', '19:38:26 pm', 747, 20, 14940),
(70, 2, 7, 'spacex', '2022/04/19', '19:38:43 pm', 747, 20, 14940),
(71, 2, 7, 'spacex', '2022/04/19', '19:43:13 pm', 747, 40, 29880),
(72, 2, 7, 'spacex', '2022/04/19', '19:43:53 pm', 747, 40, 29880),
(73, 2, 7, 'spacex', '2022/04/19', '19:46:07 pm', 747, 15, 11205),
(74, 2, 7, 'spacex', '2022/04/19', '19:47:54 pm', 747, 1000, 747000),
(75, 2, 6, 'tesla', '2022/04/19', '20:14:19 pm', 935, 30, 28050),
(76, 10, 6, 'tesla', '2022/04/19', '21:50:09 pm', 935, 1, 935),
(77, 10, 6, 'tesla', '2022/04/19', '21:50:47 pm', 935, 1, 935),
(78, 11, 8, 'twitter', '2022/04/19', '22:29:46 pm', 474, 10, 4740),
(79, 11, 8, 'twitter', '2022/04/19', '22:31:15 pm', 474, 6, 2844),
(80, 2, 8, 'twitter', '2022/04/19', '22:48:11 pm', 474, 2, 948),
(81, 2, 10, 'instagram', '2022/04/19', '22:51:35 pm', 1, 2, 2),
(82, 2, 10, 'instagram', '2022/04/19', '22:54:40 pm', 1, 5, 5),
(83, 2, 10, 'instagram', '2022/04/19', '22:58:22 pm', 1, 7, 7),
(84, 2, 8, 'twitter', '2022/04/20', '20:01:59 pm', 474, 200, 94800),
(85, 2, 8, 'twitter', '2022/04/20', '20:46:02 pm', 474, 2, 948),
(86, 2, 8, 'twitter', '2022/04/20', '20:47:26 pm', 474, 2, 948),
(87, 2, 8, 'twitter', '2022/04/20', '21:08:32 pm', 474, 10, 4740),
(88, 2, 8, 'twitter', '2022/04/20', '21:10:32 pm', 474, 5, 2370),
(89, 2, 8, 'twitter', '2022/04/20', '21:11:34 pm', 474, 6, 2844),
(90, 2, 2, 'amazon', '2022/04/20', '21:16:19 pm', 569, 2, 1138),
(91, 2, 8, 'twitter', '2022/04/20', '22:00:28 pm', 474, 2, 948),
(92, 2, 8, 'twitter', '2022/04/20', '22:03:03 pm', 474, 5, 2370),
(93, 2, 8, 'twitter', '2022/04/20', '22:09:21 pm', 474, 4, 1896),
(94, 2, 8, 'twitter', '2022/04/20', '22:09:31 pm', 474, 9, 4266),
(95, 2, 3, 'apple', '2022/04/20', '22:12:50 pm', 647, 89, 57583),
(96, 2, 7, 'spacex', '2022/04/20', '22:13:04 pm', 747, 78, 58266),
(97, 2, 1, 'facebook', '2022/04/20', '22:13:19 pm', 133, 78, 10374),
(98, 2, 2, 'amazon', '2022/04/20', '22:14:33 pm', 569, 39, 22191),
(99, 2, 1, 'facebook', '2022/04/20', '22:14:43 pm', 133, 30, 3990),
(100, 2, 2, 'amazon', '2022/04/20', '22:14:53 pm', 569, 30, 17070),
(101, 2, 8, 'twitter', '2022/04/20', '22:15:57 pm', 474, 20, 9480),
(102, 2, 2, 'amazon', '2022/04/20', '22:16:09 pm', 569, 30, 17070),
(103, 2, 5, 'google', '2022/04/20', '22:17:34 pm', 757, 20, 15140),
(104, 2, 4, 'microsoft', '2022/04/20', '22:17:44 pm', 756, 20, 15120),
(105, 2, 8, 'twitter', '2022/04/20', '22:22:11 pm', 474, 3, 1422),
(106, 2, 8, 'twitter', '2022/04/20', '22:28:23 pm', 474, 20, 9480),
(107, 2, 2, 'amazon', '2022/04/20', '22:28:36 pm', 569, 67, 38123),
(108, 2, 2, 'amazon', '2022/04/20', '22:51:03 pm', 569, 2, 1138),
(109, 2, 8, 'twitter', '2022/04/21', '07:30:54 am', 474, 12, 5688),
(110, 2, 8, 'twitter', '2022/04/21', '08:01:05 am', 474, 10, 4740),
(111, 2, 7, 'spacex', '2022/04/21', '08:01:16 am', 747, 40, 29880),
(112, 2, 8, 'twitter', '2022/04/21', '08:02:35 am', 474, 20, 9480),
(113, 2, 8, 'twitter', '2022/04/21', '08:04:59 am', 474, 50, 23700),
(114, 2, 8, 'twitter', '2022/04/21', '08:07:10 am', 474, 78, 36972);

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
(1, 2, 8, 'twitter', '2022/04/17', '12:18:37 pm', 474, 2, 948),
(2, 2, 8, 'twitter', '2022/04/17', '12:18:44 pm', 474, 4, 1896);

-- --------------------------------------------------------

--
-- Table structure for table `sectors`
--

DROP TABLE IF EXISTS `sectors`;
CREATE TABLE IF NOT EXISTS `sectors` (
  `sectorid` int(11) NOT NULL AUTO_INCREMENT,
  `sector` varchar(30) NOT NULL,
  PRIMARY KEY (`sectorid`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sectors`
--

INSERT INTO `sectors` (`sectorid`, `sector`) VALUES
(1, 'Refineries'),
(2, 'Software'),
(4, 'Banking'),
(5, 'FMCG'),
(6, 'Automobile'),
(7, 'Personal Care'),
(8, 'entertainment'),
(9, 'agriculture'),
(10, 'pharmeceuticals'),
(16, 'technology'),
(12, 'streaming'),
(13, 'ecommerce'),
(14, 'social media'),
(15, 'robotics'),
(17, 'Metaverse'),
(18, 'brain surgery'),
(19, 'transportation'),
(20, 'space'),
(21, 'archeology');

-- --------------------------------------------------------

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
CREATE TABLE IF NOT EXISTS `stocks` (
  `stockid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `category` varchar(30) NOT NULL,
  PRIMARY KEY (`stockid`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stocks`
--

INSERT INTO `stocks` (`stockid`, `name`, `price`, `category`) VALUES
(1, 'facebook', 133, 'Metaverse'),
(2, 'amazon', 569, 'ecommerce'),
(3, 'apple', 647, 'technology'),
(4, 'microsoft', 756, 'technology'),
(5, 'google', 757, 'technology'),
(6, 'tesla', 935, 'technology'),
(7, 'spacex', 747, 'space'),
(8, 'twitter', 474, 'social media'),
(9, 'netflix', 783, 'entertainment'),
(10, 'instagram', 1, 'Refineries');

-- --------------------------------------------------------

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
CREATE TABLE IF NOT EXISTS `wallet` (
  `walletid` int(11) NOT NULL AUTO_INCREMENT,
  `cusid` int(11) NOT NULL,
  `cusname` varchar(30) NOT NULL,
  `balance` int(11) NOT NULL,
  PRIMARY KEY (`walletid`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wallet`
--

INSERT INTO `wallet` (`walletid`, `cusid`, `cusname`, `balance`) VALUES
(10, 2, 'elon musk', 9639010);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
