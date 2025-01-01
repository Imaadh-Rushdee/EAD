-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 01, 2025 at 08:22 AM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `education`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
CREATE TABLE IF NOT EXISTS `attendance` (
  `attendance_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `course_id` varchar(50) DEFAULT NULL,
  `date` date NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`attendance_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`attendance_id`, `student_id`, `course_id`, `date`, `status`) VALUES
(1, 1, '1', '0000-00-00', 'Present'),
(0, 1, 'Software', '2024-12-30', 'Present '),
(2, 1, 'Software', '2024-12-30', 'Present '),
(3, 2, 'Software', '2024-12-30', 'Absent '),
(4, 2, 'Network', '2024-12-30', 'Absent'),
(5, 3, 'Network', '2024-12-30', 'Absent'),
(6, 1, 'Network', '2024-12-30', 'Present'),
(20, 1, 'Marketing', '2024-12-31', 'Absent'),
(8, 1, 'Software', '2024-12-30', 'Present'),
(9, 2, 'Software', '2024-12-30', 'Absent'),
(10, 3, 'Marketing', '2024-12-30', 'Present'),
(11, 2, 'Network', '2024-12-30', 'Absent'),
(12, 3, 'Network', '2024-12-30', 'Present'),
(13, 1, 'Network', '2024-12-30', 'Absent'),
(22, 1, 'Marketing', '2024-12-31', 'Absent'),
(21, 3, 'Marketing', '2024-12-31', 'Present'),
(18, 1, 'Network', '2024-12-31', 'Present'),
(19, 3, 'Marketing', '2024-12-31', 'Present'),
(17, 3, 'Network', '2024-12-31', 'Present'),
(16, 2, 'Network', '2024-12-31', 'Present'),
(14, 1, 'Software', '2024-12-31', 'Present'),
(15, 2, 'Software', '2024-12-31', 'Absent'),
(23, 5, 'Designing', '2024-12-31', 'Present'),
(24, 2, 'Designing', '2024-12-31', 'Absent'),
(25, 5, 'Designing', '2024-12-31', 'Present'),
(26, 2, 'Designing', '2024-12-31', 'Absent'),
(27, 5, 'Designing', '2024-12-31', 'Present'),
(28, 2, 'Designing', '2024-12-31', 'Absent'),
(29, 5, 'Designing', '2024-12-31', 'Present'),
(30, 2, 'Designing', '2024-12-31', 'Absent');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int NOT NULL,
  `course_name` varchar(50) NOT NULL,
  `course_category` varchar(50) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_id`, `course_name`, `course_category`) VALUES
(1, 'Software', 'Computing'),
(2, 'Network', 'Computing'),
(3, 'Marketing', 'Business'),
(4, 'Designing', 'Computing');

-- --------------------------------------------------------

--
-- Table structure for table `course_student`
--

DROP TABLE IF EXISTS `course_student`;
CREATE TABLE IF NOT EXISTS `course_student` (
  `csid` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`csid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `course_student`
--

INSERT INTO `course_student` (`csid`, `student_id`, `course_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 2, 2),
(4, 3, 2),
(5, 3, 3),
(6, 1, 2),
(7, 1, 3),
(8, 5, 4),
(9, 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
CREATE TABLE IF NOT EXISTS `result` (
  `result_id` int NOT NULL,
  `course_result` int DEFAULT NULL,
  `student_id` varchar(10) NOT NULL,
  `course_id` varchar(50) NOT NULL,
  `test_type` varchar(50) NOT NULL,
  PRIMARY KEY (`result_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`result_id`, `course_result`, `student_id`, `course_id`, `test_type`) VALUES
(0, 100, '1', 'Software', 'Exam '),
(3, 100, '3', 'Network', 'Exam '),
(4, 100, '1', 'Network', 'Exam '),
(5, 20, '3', 'Marketing', 'Exam '),
(6, 100, '1', 'Software', 'Exam ');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `student_adress` varchar(50) NOT NULL,
  `student_password` varchar(50) NOT NULL,
  `student_age` int NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `student_name`, `student_adress`, `student_password`, `student_age`) VALUES
(1, 'Imaadh', 'Ratnapura', 'imaadh', 16),
(2, 'Nishen', 'Balangoda', 'nishen', 20),
(3, 'Iyaadh', 'Ratnapura', 'iyaadh', 11),
(4, 'Student', 'Ratnapura', '2020', 16),
(5, 'Imaadh', 'Adress', '20202', 20);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_type` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_type`, `user_password`) VALUES
(1, 'ex', 'admin', 'ex'),
(2, 'Imaadh', 'Admin', 'ok'),
(3, 'kkmd', 'Admin', 'as'),
(4, 'imaadh', 'Admin', 'wd'),
(5, 'User', 'Student', 'user');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
