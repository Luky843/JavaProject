-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Hostiteľ: 127.0.0.1
-- Čas generovania: Pi 24.Nov 2017, 07:20
-- Verzia serveru: 5.7.14
-- Verzia PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáza: `skola`
--

-- --------------------------------------------------------

--
-- Štruktúra tabuľky pre tabuľku `tasksystem`
--

CREATE TABLE IF NOT EXISTS `tasksystem` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf16 COLLATE utf16_slovak_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_slovak_ci DEFAULT NULL,
  `deadline` varchar(255) DEFAULT NULL,
  `is_finished` tinyint(1) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Sťahujem dáta pre tabuľku `tasksystem`
--

INSERT INTO `tasksystem` (`id`, `name`, `description`, `deadline`, `is_finished`) VALUES
(12, 'Nová úloha', 'Popis novej ulohy', '12.10.2017', 0),
(4, 'Kakaka', 'bbbbccc', '', 1);

--
-- Kľúče pre exportované tabuľky
--

--
-- Indexy pre tabuľku `tasksystem`
--
ALTER TABLE `tasksystem`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pre exportované tabuľky
--

--
-- AUTO_INCREMENT pre tabuľku `tasksystem`
--
ALTER TABLE `tasksystem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
