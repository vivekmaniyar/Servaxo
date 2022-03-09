-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2022 at 03:51 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vehicleservice_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `groupmaster`
--

CREATE TABLE `groupmaster` (
  `group_id` int(11) NOT NULL COMMENT 'group ID',
  `group_name` varchar(30) NOT NULL COMMENT 'Name of the group',
  `created_at` text NOT NULL COMMENT 'Time of Creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `groupmaster`
--

INSERT INTO `groupmaster` (`group_id`, `group_name`, `created_at`, `updated_at`) VALUES
(1, 'user', 'sample', 'sample'),
(2, 'admin', '28-02-2022 15:26:00', '28-02-2022 15:26:00');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cart`
--

CREATE TABLE `tbl_cart` (
  `cart_id` int(11) NOT NULL COMMENT 'Cart ID',
  `user_id` int(11) NOT NULL COMMENT 'User ID of user',
  `part_id` int(11) NOT NULL COMMENT 'Part ID of part table',
  `qty` int(11) NOT NULL COMMENT 'Quantity of order',
  `created_at` text NOT NULL COMMENT 'Time of creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information about user cart';

--
-- Dumping data for table `tbl_cart`
--

INSERT INTO `tbl_cart` (`cart_id`, `user_id`, `part_id`, `qty`, `created_at`, `updated_at`) VALUES
(14, 3, 2, 1, '08-03-2022 18:39:03', '08-03-2022 18:39:03');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_city`
--

CREATE TABLE `tbl_city` (
  `city_id` int(11) NOT NULL COMMENT 'City ID',
  `state_id` int(11) NOT NULL COMMENT 'State ID',
  `city_name` varchar(30) NOT NULL COMMENT 'Name of city',
  `city_code` varchar(5) NOT NULL COMMENT 'Code for each city',
  `created_at` text NOT NULL COMMENT 'Time of creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information about various cities of each state';

--
-- Dumping data for table `tbl_city`
--

INSERT INTO `tbl_city` (`city_id`, `state_id`, `city_name`, `city_code`, `created_at`, `updated_at`) VALUES
(1, 1, 'Surat', 'GJ05', '21-01-2022 09:54:46', '21-01-2022 09:58:30'),
(2, 5, 'Ranchi', 'MP-45', '06-03-2022 15:04:42', '06-03-2022 15:05:21');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_company`
--

CREATE TABLE `tbl_company` (
  `company_id` int(11) NOT NULL COMMENT 'Company ID',
  `company_name` varchar(30) NOT NULL COMMENT 'Name of the company',
  `company_logo` text DEFAULT NULL COMMENT 'Logo of the company(Stores path)',
  `company_type` varchar(11) NOT NULL COMMENT 'Type of the comapny(car/bike)',
  `created_at` text NOT NULL COMMENT 'Time of creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information about various vehicle companies';

--
-- Dumping data for table `tbl_company`
--

INSERT INTO `tbl_company` (`company_id`, `company_name`, `company_logo`, `company_type`, `created_at`, `updated_at`) VALUES
(1, 'Suzuki', '16143133603448.jpg', 'bike', '21-01-2022 13:01:29', '02-03-2022 22:58:43'),
(2, 'Honda', '16143019226435.png', 'car', '02-03-2022 17:38:05', '02-03-2022 22:57:29'),
(3, 'Chevrolet', 'b5.jpg', 'car', '02-03-2022 22:51:54', '02-03-2022 22:51:54'),
(4, 'Nissan', '16143024345340.jpg', 'car', '02-03-2022 22:55:52', '02-03-2022 22:55:52'),
(5, 'Kia', '16143023305660.jpg', 'car', '02-03-2022 22:55:52', '02-03-2022 22:55:52'),
(6, 'KTM', '16178937292011.png', 'bike', '02-03-2022 22:55:52', '02-03-2022 22:55:52'),
(7, 'Suzuki', '16143021371143.png', 'car', '02-03-2022 22:59:12', '02-03-2022 22:59:12'),
(8, 'Audi', '16143026134961.png', 'car', '02-03-2022 22:59:12', '02-03-2022 22:59:12'),
(9, 'BMW', '16143026299236.png', 'car', '02-03-2022 22:59:12', '02-03-2022 22:59:12'),
(10, 'Hyundai', '16143028468603.png', 'car', '02-03-2022 22:59:12', '02-03-2022 22:59:12'),
(11, 'Jaguar', '16143032961506.png', 'bike', '02-03-2022 22:59:12', '02-03-2022 22:59:12'),
(12, 'Ford', '16143033316798.jpg', 'car', '02-03-2022 22:59:12', '02-03-2022 22:59:12'),
(13, 'Skoda', '16143034499297.png', 'car', '02-03-2022 22:59:12', '02-03-2022 22:59:12'),
(14, 'Toyota', '16143035445884.png', 'car', '02-03-2022 22:59:12', '02-03-2022 22:59:12'),
(15, 'Harley Davidson', '16143147843148.png', 'bike', '06-03-2022 15:05:28', '06-03-2022 15:05:28');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_feedback`
--

CREATE TABLE `tbl_feedback` (
  `feedback_id` int(11) NOT NULL COMMENT 'Feedback ID',
  `name` text NOT NULL COMMENT 'Name of the user',
  `contact_no` text NOT NULL COMMENT 'Contact no of user',
  `email` text NOT NULL COMMENT 'E-mail ID of user',
  `feedback_text` text NOT NULL COMMENT 'Feedback of user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='User feedbacks';

--
-- Dumping data for table `tbl_feedback`
--

INSERT INTO `tbl_feedback` (`feedback_id`, `name`, `contact_no`, `email`, `feedback_text`) VALUES
(1, 'Vivek Maniyar', '9601128501', 'vivekmaniyar9601@gmail.com', 'Excellent Service provided by Servaxo');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_model`
--

CREATE TABLE `tbl_model` (
  `model_id` int(11) NOT NULL COMMENT 'Model ID',
  `model_name` varchar(30) NOT NULL COMMENT 'Name of the model',
  `company_id` int(11) NOT NULL COMMENT 'Company of the model',
  `model_img` text DEFAULT NULL COMMENT 'Image of the model',
  `created_at` text NOT NULL COMMENT 'Time of creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information about various models of each company';

--
-- Dumping data for table `tbl_model`
--

INSERT INTO `tbl_model` (`model_id`, `model_name`, `company_id`, `model_img`, `created_at`, `updated_at`) VALUES
(1, 'Gixxer', 1, '16143989894153.jpg', '21-01-2022 13:07:11', '02-03-2022 23:10:41'),
(2, 'Activa', 2, '16143968886191.png', '02-03-2022 23:03:26', '02-03-2022 23:03:26'),
(3, 'Seal', 3, '16166573777936.jpg', '02-03-2022 23:03:26', '02-03-2022 23:03:26'),
(4, 'Micra', 4, '16143936051322.jpg', '02-03-2022 23:03:26', '02-03-2022 23:03:26'),
(5, 'Sonet', 5, '16143962412373.jpg', '02-03-2022 23:03:26', '02-03-2022 23:03:26'),
(6, 'Cruze', 6, '16143977089003.jpg', '02-03-2022 23:03:26', '02-03-2022 23:03:26'),
(7, 'Jupiter', 7, '16143991115986.jpg', '02-03-2022 23:03:26', '02-03-2022 23:03:26'),
(8, 'AWZ21', 8, '16143931104656.jpg', '02-03-2022 23:03:26', '02-03-2022 23:07:13'),
(9, 'J12', 9, '16143924903454.jpg', '02-03-2022 23:03:26', '02-03-2022 23:03:26'),
(10, 'Brezza', 10, '16143950398903.jpg', '02-03-2022 23:03:26', '02-03-2022 23:03:26'),
(11, 'Thunder-550CC', 15, '16144001168226.png', '06-03-2022 15:08:26', '06-03-2022 15:10:47');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_order`
--

CREATE TABLE `tbl_order` (
  `order_id` int(11) NOT NULL COMMENT 'Order ID',
  `user_id` int(11) NOT NULL COMMENT 'User ID the user',
  `city_id` int(11) NOT NULL COMMENT 'City of delivery',
  `total_payment` varchar(30) NOT NULL COMMENT 'Total amount payable',
  `ispay` varchar(3) NOT NULL COMMENT 'Paid or not',
  `paymode` varchar(30) NOT NULL COMMENT 'Payment Mode',
  `addressline1` text NOT NULL COMMENT 'Address of delivery',
  `addressline2` text DEFAULT NULL COMMENT 'Address of delivery',
  `landmark` text DEFAULT NULL COMMENT 'Landmark of delivery',
  `pincode` int(11) NOT NULL COMMENT 'Pincode of delivery area',
  `status` varchar(30) NOT NULL COMMENT 'Order Status',
  `order_datetime` text NOT NULL COMMENT 'Time of order',
  `updates_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information about order of parts';

--
-- Dumping data for table `tbl_order`
--

INSERT INTO `tbl_order` (`order_id`, `user_id`, `city_id`, `total_payment`, `ispay`, `paymode`, `addressline1`, `addressline2`, `landmark`, `pincode`, `status`, `order_datetime`, `updates_at`) VALUES
(3, 1, 1, '3650', 'yes', 'paytm', 'Address 1', 'Address 2', 'Landmark', 395005, 'cancelled', '02-02-2022 17:39:11', '02-02-2022 17:39:11'),
(6, 3, 1, '3345', 'N', 'COD', 'Test', 'Test', 'Test', 123456, 'pending', 'test', 'test'),
(7, 3, 2, '3345', 'N', 'COD', 'test', 'test', 'test', 395005, 'Pending', '06-03-2022 17:01:48', '06-03-2022 17:01:48'),
(8, 3, 2, '1520', 'N', 'COD', 'test', 'test', 'test', 395005, 'Pending', '07-03-2022 18:42:54', '07-03-2022 18:42:54'),
(9, 3, 2, '1825', 'N', 'COD', 'test', 'test', 'test', 395005, 'Pending', '08-03-2022 17:59:13', '08-03-2022 17:59:13');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_orderdetail`
--

CREATE TABLE `tbl_orderdetail` (
  `order_id` int(11) NOT NULL COMMENT 'Order ID',
  `part_id` int(11) NOT NULL COMMENT 'Part ID',
  `qty` int(11) NOT NULL COMMENT 'Quantity',
  `created_at` text NOT NULL COMMENT 'Time of creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Details of order of parts';

--
-- Dumping data for table `tbl_orderdetail`
--

INSERT INTO `tbl_orderdetail` (`order_id`, `part_id`, `qty`, `created_at`, `updated_at`) VALUES
(3, 1, 2, '02-02-2022 17:39:11', '02-02-2022 17:39:11'),
(6, 1, 1, 'test', 'test'),
(6, 2, 1, 'test', 'test'),
(7, 1, 1, '06-03-2022 17:01:48', '06-03-2022 17:01:48'),
(7, 2, 1, '06-03-2022 17:01:48', '06-03-2022 17:01:48'),
(8, 2, 1, '07-03-2022 18:42:54', '07-03-2022 18:42:54'),
(9, 1, 1, '08-03-2022 17:59:13', '08-03-2022 17:59:13');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_partcategory`
--

CREATE TABLE `tbl_partcategory` (
  `partcategory_id` int(11) NOT NULL COMMENT 'Category ID',
  `category_name` varchar(30) NOT NULL COMMENT 'Name of category',
  `vehicle_type` varchar(4) NOT NULL COMMENT 'Type of Vehicle(Car/bike)',
  `category_img` varchar(100) NOT NULL COMMENT 'Image of category',
  `category_description` text DEFAULT NULL COMMENT 'Description of category',
  `created_at` text NOT NULL COMMENT 'Time of creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Category of parts';

--
-- Dumping data for table `tbl_partcategory`
--

INSERT INTO `tbl_partcategory` (`partcategory_id`, `category_name`, `vehicle_type`, `category_img`, `category_description`, `created_at`, `updated_at`) VALUES
(1, 'Tyres', 'bike', '16179583917897.jpeg', 'Tyres for bikes', '21-01-2022 13:12:31', '02-03-2022 23:15:34'),
(2, 'Headlights', 'car', '16164889115856.png', 'Headlights for cars', '02-03-2022 23:16:12', '02-03-2022 23:16:12'),
(3, 'Electronic Accessories', 'car', '16164888142221.jpg', 'Accessories like cameras and feetlights', '02-03-2022 23:16:12', '02-03-2022 23:16:12'),
(4, 'Bearings', 'bike', '16164899966715.png', 'SS Bearings for bikes', '02-03-2022 23:16:12', '02-03-2022 23:16:12'),
(5, 'Music System', 'car', '16164910701123.jpg', 'Music Systems ', '02-03-2022 23:16:12', '02-03-2022 23:16:12'),
(6, 'Wirings', 'bike', '16164910025247.png', 'Wiring materials for bikes', '02-03-2022 23:16:12', '06-03-2022 15:11:21');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_parts`
--

CREATE TABLE `tbl_parts` (
  `part_id` int(11) NOT NULL COMMENT 'Part ID',
  `model_id` int(11) NOT NULL COMMENT 'Vehicle model',
  `partcategory_id` int(11) NOT NULL COMMENT 'Category of part',
  `part_name` varchar(30) NOT NULL COMMENT 'Name of the part',
  `price` int(11) NOT NULL COMMENT 'Price of the part',
  `part_description` text DEFAULT NULL COMMENT 'Description of part',
  `img1` text DEFAULT NULL COMMENT 'Image of the part(Stores path)',
  `img2` text DEFAULT NULL COMMENT 'Image of the part(Stores path)',
  `img3` text DEFAULT NULL COMMENT 'Image of the part(Stores path)',
  `part_manual_pdf` text DEFAULT NULL COMMENT 'Manual of the part (Stores path)',
  `video_url` text DEFAULT NULL COMMENT 'Video URL to install part',
  `isactive` varchar(5) NOT NULL COMMENT 'Availability of the part',
  `addeddatetime` text NOT NULL COMMENT 'Time of adding the part',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information about various parts';

--
-- Dumping data for table `tbl_parts`
--

INSERT INTO `tbl_parts` (`part_id`, `model_id`, `partcategory_id`, `part_name`, `price`, `part_description`, `img1`, `img2`, `img3`, `part_manual_pdf`, `video_url`, `isactive`, `addeddatetime`, `updated_at`) VALUES
(1, 1, 1, 'actizip f5', 1825, 'Actizip F5 front tyre by Apollo tyres for suzuki gixxer', 'Screenshot(1).png', NULL, NULL, NULL, '', 'yes', '21-01-2022 13:15:35', '02-03-2022 23:42:23'),
(2, 1, 1, 'CT-0154', 1520, 'High Quality CEAT Tyres for best grip. 4 Years warrenty', '1.jpg', '5.jpg', NULL, NULL, '', 'yes', '58-02-2022 14:55:17', '58-02-2022 14:55:17');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_servicecart`
--

CREATE TABLE `tbl_servicecart` (
  `servicecart_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `created_at` text NOT NULL,
  `updated_at` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_servicelist`
--

CREATE TABLE `tbl_servicelist` (
  `user_vehicle_id` int(11) NOT NULL COMMENT 'Service_order ID',
  `service_id` int(11) NOT NULL COMMENT 'Service ID of service',
  `created_at` text NOT NULL COMMENT 'Time of creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information about services selected by user';

--
-- Dumping data for table `tbl_servicelist`
--

INSERT INTO `tbl_servicelist` (`user_vehicle_id`, `service_id`, `created_at`, `updated_at`) VALUES
(2, 1, '02-02-2022 17:59:41', '02-02-2022 17:59:41'),
(3, 1, '08-03-2022 18:59:54', '08-03-2022 18:59:54'),
(3, 2, '08-03-2022 18:59:54', '08-03-2022 18:59:54');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_serviceorder`
--

CREATE TABLE `tbl_serviceorder` (
  `serviceorder_id` int(11) NOT NULL COMMENT 'User Vehicle ID',
  `user_id` int(11) NOT NULL COMMENT 'User ID of user',
  `model_id` int(11) NOT NULL COMMENT 'Model of user''s vehicle',
  `vehicle_no` varchar(30) NOT NULL COMMENT 'Vehicle number of user''s vehicle',
  `remark` text DEFAULT NULL COMMENT 'Issues to be repaired of vehicle',
  `total_payment` varchar(30) NOT NULL COMMENT 'Total payment of user''s service',
  `pick_up_date` text NOT NULL COMMENT 'Date of pickup of user''s vehicle',
  `addressline1` text NOT NULL COMMENT 'Address for pickup',
  `addressline2` text DEFAULT NULL COMMENT 'Address for pickup',
  `pincode` int(11) NOT NULL COMMENT 'Area code for pickup',
  `landmark` varchar(30) NOT NULL COMMENT 'Landmark for pickup',
  `status` varchar(30) NOT NULL COMMENT 'Status of service(pending/processed/done)',
  `orderdatetime` text NOT NULL COMMENT 'Time of service order',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information of user''s vehicle services and total invoice';

--
-- Dumping data for table `tbl_serviceorder`
--

INSERT INTO `tbl_serviceorder` (`serviceorder_id`, `user_id`, `model_id`, `vehicle_no`, `remark`, `total_payment`, `pick_up_date`, `addressline1`, `addressline2`, `pincode`, `landmark`, `status`, `orderdatetime`, `updated_at`) VALUES
(2, 1, 1, 'GJ-05 1314', 'Bearing Replacement', '1799', '02-02-2022 17:59:41', 'Address 1', 'Address 2', 395005, 'Landmark', 'cancelled', '02-02-2022 17:59:41', '02-02-2022 17:59:41'),
(3, 3, 4, 'GJ-05 1312', 'Oil Change', '2549', '08-03-2022 18:59:54', 'test', 'test', 395005, 'tesdt', 'Pending', '08-03-2022 18:59:54', '08-03-2022 18:59:54');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_services`
--

CREATE TABLE `tbl_services` (
  `service_id` int(11) NOT NULL COMMENT 'Service ID',
  `service_name` varchar(30) NOT NULL COMMENT 'Name of the service',
  `service_description` text DEFAULT NULL COMMENT 'Description of the service',
  `service_price` int(11) NOT NULL COMMENT 'Price of the service',
  `isactive` varchar(5) NOT NULL COMMENT 'Availability of the service',
  `type` varchar(5) NOT NULL COMMENT 'Type of vehicle(car/bike)',
  `created_at` text NOT NULL COMMENT 'Time of creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Details of each service provided by the website';

--
-- Dumping data for table `tbl_services`
--

INSERT INTO `tbl_services` (`service_id`, `service_name`, `service_description`, `service_price`, `isactive`, `type`, `created_at`, `updated_at`) VALUES
(1, 'Car Interior Spa', 'Car Wash, Interior Vacuum Cleaning, Interior Wet Shampooing and Detailing, Anti Viral and Bacterial Treatment', 1799, 'yes', 'Car', '21-01-2022 13:23:01', '02-03-2022 23:59:14'),
(2, 'Full Bike Service', 'Test', 750, 'yes', 'car', '02-03-2022 23:54:51', '02-03-2022 23:54:51');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_state`
--

CREATE TABLE `tbl_state` (
  `state_id` int(11) NOT NULL COMMENT 'State ID',
  `state_name` varchar(30) NOT NULL COMMENT 'Name of states',
  `state_code` varchar(5) NOT NULL COMMENT 'Code for each state',
  `created_at` text NOT NULL COMMENT 'Time of Creation',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Information about various states';

--
-- Dumping data for table `tbl_state`
--

INSERT INTO `tbl_state` (`state_id`, `state_name`, `state_code`, `created_at`, `updated_at`) VALUES
(1, 'Gujarat', 'GJ', '21-01-2022 09:25:25', '21-01-2022 09:29:15'),
(2, 'Maharashtra', 'MH', '28-02-2022 15:41:11', '28-02-2022 15:41:11'),
(5, 'Madhya Pradesh', 'MP', '06-03-2022 15:03:09', '06-03-2022 15:03:09');

-- --------------------------------------------------------

--
-- Table structure for table `usermaster`
--

CREATE TABLE `usermaster` (
  `user_id` int(11) NOT NULL COMMENT 'user ID',
  `group_id` int(11) NOT NULL COMMENT 'Id for a particular group of users',
  `username` varchar(50) NOT NULL COMMENT 'username of the user',
  `password` text NOT NULL COMMENT 'password of the user(In encrypted format)',
  `name` varchar(30) NOT NULL COMMENT 'Name of the user',
  `contact` varchar(10) NOT NULL COMMENT 'Contact number of the user',
  `reg_datetime` text NOT NULL COMMENT 'Time of user registration',
  `updated_at` text NOT NULL COMMENT 'Time of updation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Credentials of various users of the website';

--
-- Dumping data for table `usermaster`
--

INSERT INTO `usermaster` (`user_id`, `group_id`, `username`, `password`, `name`, `contact`, `reg_datetime`, `updated_at`) VALUES
(1, 1, 'vivekm93', 'vivek1234', 'Vivek', '9601128501', 'sample', 'sample'),
(2, 2, 'adminDeep.servaxo@gmail.com', 'PBKDF2WithHmacSHA256:2048:9CCgqQXG9a9QQ6GuCPtllv7gmsPc/QyJfR/Kadi0rVs=:z0Tq2lvr+5pINt3YOA6/owRHWbMIlfxA/2BbpOmv04A=', 'Admin Deep', '8780443963', '28-02-2022 15:31:03', '28-02-2022 15:31:03'),
(3, 1, 'sureshUser@gmail.com', 'PBKDF2WithHmacSHA256:2048:qXv6XI/etpDXfNtc6N4OxLTxxGJAJz7t3vp7+wB1w7s=:gvdbnoN5KWf1Lm8VB1TjZ2QhtGywcpeTm5xFg/FKedA=', 'Suresh Prasad', '1234567890', '03-03-2022 00:58:08', '03-03-2022 00:58:08'),
(4, 2, 'adminDeep@gmail.com', 'PBKDF2WithHmacSHA256:2048:I4X8+WtW+o5tutko+pjw5XsQoFsQ0nTmbiqTSzgA6rQ=:2CsbruRhPoNswlRMCv62BnkaYLHi1VKHYu5NHnkHjE0=', 'Deep Kansara', '8780443963', '08-03-2022 17:25:48', '08-03-2022 17:25:48'),
(5, 2, 'admin@gmail.com', 'PBKDF2WithHmacSHA256:2048:alLIfw+UrvcHkUtThSPQPQHVhhdPSggkyxfXGY705BA=:ZqlksbCgsWwDt9c9jt48p1+TR3pkIERXdu2X1FC2joo=', 'adminTest', '1234567890', '08-03-2022 18:17:32', '08-03-2022 18:17:32');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `groupmaster`
--
ALTER TABLE `groupmaster`
  ADD PRIMARY KEY (`group_id`);

--
-- Indexes for table `tbl_cart`
--
ALTER TABLE `tbl_cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `part_id` (`part_id`);

--
-- Indexes for table `tbl_city`
--
ALTER TABLE `tbl_city`
  ADD PRIMARY KEY (`city_id`),
  ADD KEY `state_id` (`state_id`);

--
-- Indexes for table `tbl_company`
--
ALTER TABLE `tbl_company`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `tbl_feedback`
--
ALTER TABLE `tbl_feedback`
  ADD PRIMARY KEY (`feedback_id`);

--
-- Indexes for table `tbl_model`
--
ALTER TABLE `tbl_model`
  ADD PRIMARY KEY (`model_id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indexes for table `tbl_orderdetail`
--
ALTER TABLE `tbl_orderdetail`
  ADD PRIMARY KEY (`order_id`,`part_id`),
  ADD KEY `part_id` (`part_id`);

--
-- Indexes for table `tbl_partcategory`
--
ALTER TABLE `tbl_partcategory`
  ADD PRIMARY KEY (`partcategory_id`);

--
-- Indexes for table `tbl_parts`
--
ALTER TABLE `tbl_parts`
  ADD PRIMARY KEY (`part_id`),
  ADD KEY `tbl_parts_ibfk_1` (`model_id`),
  ADD KEY `partcategory_id` (`partcategory_id`);

--
-- Indexes for table `tbl_servicecart`
--
ALTER TABLE `tbl_servicecart`
  ADD PRIMARY KEY (`servicecart_id`),
  ADD KEY `service_id` (`service_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tbl_servicelist`
--
ALTER TABLE `tbl_servicelist`
  ADD PRIMARY KEY (`user_vehicle_id`,`service_id`),
  ADD KEY `service_id` (`service_id`);

--
-- Indexes for table `tbl_serviceorder`
--
ALTER TABLE `tbl_serviceorder`
  ADD PRIMARY KEY (`serviceorder_id`),
  ADD KEY `model_id` (`model_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tbl_services`
--
ALTER TABLE `tbl_services`
  ADD PRIMARY KEY (`service_id`);

--
-- Indexes for table `tbl_state`
--
ALTER TABLE `tbl_state`
  ADD PRIMARY KEY (`state_id`);

--
-- Indexes for table `usermaster`
--
ALTER TABLE `usermaster`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `group_id` (`group_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `groupmaster`
--
ALTER TABLE `groupmaster`
  MODIFY `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'group ID', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_cart`
--
ALTER TABLE `tbl_cart`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Cart ID', AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbl_city`
--
ALTER TABLE `tbl_city`
  MODIFY `city_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'City ID', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_company`
--
ALTER TABLE `tbl_company`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Company ID', AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tbl_feedback`
--
ALTER TABLE `tbl_feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Feedback ID', AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_model`
--
ALTER TABLE `tbl_model`
  MODIFY `model_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Model ID', AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbl_order`
--
ALTER TABLE `tbl_order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Order ID', AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_partcategory`
--
ALTER TABLE `tbl_partcategory`
  MODIFY `partcategory_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Category ID', AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_parts`
--
ALTER TABLE `tbl_parts`
  MODIFY `part_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Part ID', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_servicecart`
--
ALTER TABLE `tbl_servicecart`
  MODIFY `servicecart_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_serviceorder`
--
ALTER TABLE `tbl_serviceorder`
  MODIFY `serviceorder_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'User Vehicle ID', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_services`
--
ALTER TABLE `tbl_services`
  MODIFY `service_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Service ID', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_state`
--
ALTER TABLE `tbl_state`
  MODIFY `state_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'State ID', AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `usermaster`
--
ALTER TABLE `usermaster`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user ID', AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_cart`
--
ALTER TABLE `tbl_cart`
  ADD CONSTRAINT `tbl_cart_ibfk_2` FOREIGN KEY (`part_id`) REFERENCES `tbl_parts` (`part_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_cart_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `usermaster` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_city`
--
ALTER TABLE `tbl_city`
  ADD CONSTRAINT `tbl_city_ibfk_1` FOREIGN KEY (`state_id`) REFERENCES `tbl_state` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_model`
--
ALTER TABLE `tbl_model`
  ADD CONSTRAINT `tbl_model_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `tbl_company` (`company_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_order`
--
ALTER TABLE `tbl_order`
  ADD CONSTRAINT `tbl_order_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `tbl_city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_order_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `usermaster` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_orderdetail`
--
ALTER TABLE `tbl_orderdetail`
  ADD CONSTRAINT `tbl_orderdetail_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_orderdetail_ibfk_4` FOREIGN KEY (`part_id`) REFERENCES `tbl_parts` (`part_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_parts`
--
ALTER TABLE `tbl_parts`
  ADD CONSTRAINT `tbl_parts_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `tbl_model` (`model_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_parts_ibfk_2` FOREIGN KEY (`partcategory_id`) REFERENCES `tbl_partcategory` (`partcategory_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_servicecart`
--
ALTER TABLE `tbl_servicecart`
  ADD CONSTRAINT `tbl_servicecart_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `tbl_services` (`service_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_servicecart_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `usermaster` (`user_id`);

--
-- Constraints for table `tbl_servicelist`
--
ALTER TABLE `tbl_servicelist`
  ADD CONSTRAINT `tbl_servicelist_ibfk_3` FOREIGN KEY (`user_vehicle_id`) REFERENCES `tbl_serviceorder` (`serviceorder_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_servicelist_ibfk_4` FOREIGN KEY (`service_id`) REFERENCES `tbl_services` (`service_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_serviceorder`
--
ALTER TABLE `tbl_serviceorder`
  ADD CONSTRAINT `tbl_serviceorder_ibfk_3` FOREIGN KEY (`model_id`) REFERENCES `tbl_model` (`model_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_serviceorder_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `usermaster` (`user_id`);

--
-- Constraints for table `usermaster`
--
ALTER TABLE `usermaster`
  ADD CONSTRAINT `usermaster_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groupmaster` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
