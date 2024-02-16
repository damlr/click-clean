-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 16, 2024 at 08:15 AM
-- Server version: 5.7.24
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `easyclean_v2`
--

-- --------------------------------------------------------

--
-- Table structure for table `litige`
--

CREATE TABLE `litige` (
  `litige_id` int(10) UNSIGNED NOT NULL,
  `text_litige` text NOT NULL,
  `image1` varchar(35) DEFAULT NULL,
  `image2` varchar(35) DEFAULT NULL,
  `image3` varchar(25) DEFAULT NULL,
  `id_autor` int(10) UNSIGNED NOT NULL,
  `id_mission` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mission`
--

CREATE TABLE `mission` (
  `mission_id` int(10) UNSIGNED NOT NULL,
  `date_mission` date NOT NULL,
  `time_mission` double NOT NULL,
  `instruction` text NOT NULL,
  `is_achive` tinyint(1) NOT NULL,
  `id_cleaner` int(10) UNSIGNED NOT NULL,
  `id_proprietaire` int(10) UNSIGNED NOT NULL,
  `statut` int(11) UNSIGNED NOT NULL,
  `id_propriete` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mission`
--

INSERT INTO `mission` (`mission_id`, `date_mission`, `time_mission`, `instruction`, `is_achive`, `id_cleaner`, `id_proprietaire`, `statut`, `id_propriete`) VALUES
(1, '2024-03-06', 1.5, 'laver le water closed.', 0, 4, 3, 1, 3),
(2, '2024-02-22', 2, 'nioooonnnnn', 0, 4, 3, 2, 3),
(3, '2024-02-22', 3.5, 'kk', 0, 5, 6, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `propriete`
--

CREATE TABLE `propriete` (
  `propriete_id` int(10) UNSIGNED NOT NULL,
  `adress` varchar(50) NOT NULL,
  `code_entrer` int(10) DEFAULT NULL,
  `proprietaire_id` int(10) UNSIGNED NOT NULL,
  `surface` int(20) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `code_postal` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `propriete`
--

INSERT INTO `propriete` (`propriete_id`, `adress`, `code_entrer`, `proprietaire_id`, `surface`, `ville`, `code_postal`) VALUES
(1, '4 rue de Simon le con', 152, 3, 0, '', 0),
(2, '5 avenue du pipi au lait', 123, 3, 0, '', 0),
(3, '61 route de quimper', 152, 3, 180, 'landerneau', 29800),
(4, '16 Rue Izar', NULL, 6, 50, 'plouedern', 29800);

-- --------------------------------------------------------

--
-- Table structure for table `statut_mission`
--

CREATE TABLE `statut_mission` (
  `statut_id` int(10) UNSIGNED NOT NULL,
  `nom` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `statut_mission`
--

INSERT INTO `statut_mission` (`statut_id`, `nom`) VALUES
(1, 'available'),
(2, 'not_available'),
(3, 'waiting'),
(4, 'cancelled'),
(5, 'finished');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(10) UNSIGNED NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `second_name` varchar(70) NOT NULL,
  `username` varchar(35) NOT NULL,
  `mail` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `profil_picture` varchar(50) DEFAULT NULL,
  `age` int(150) NOT NULL,
  `bio` text,
  `phone_number` bigint(20) NOT NULL,
  `date_of_birth` date NOT NULL,
  `date_creation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `note` float DEFAULT NULL,
  `nb_mission` int(30) DEFAULT NULL,
  `perimeter` int(35) DEFAULT NULL,
  `tarif_horaire` float NOT NULL,
  `role` varchar(35) NOT NULL,
  `adresse` varchar(70) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `code_postal` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `first_name`, `second_name`, `username`, `mail`, `password`, `profil_picture`, `age`, `bio`, `phone_number`, `date_of_birth`, `date_creation`, `note`, `nb_mission`, `perimeter`, `tarif_horaire`, `role`, `adresse`, `ville`, `code_postal`) VALUES
(1, 'Francis', 'triple monstre', 'mortadon', 'coucou@gmail.com', 'doublemonstre', NULL, 34, NULL, 695781245, '1937-04-20', '2024-02-06 09:50:42', NULL, NULL, NULL, 24, 'cleaner', '', '', 0),
(2, 'Simon', 'Le Golmon', 'mrlechieur', 'gtjrsraison@gmail.com', 'FUCKSIMON', NULL, 5, NULL, 65175165, '2010-02-06', '2024-02-06 09:58:56', NULL, NULL, NULL, 1.1, 'cleaner', '', '', 0),
(3, 'michel', 'Vroumvroum', 'labagnole', 'fan2peugeot207hdi@gmail.com', 'fuckcitroen', NULL, 69, NULL, 54218832, '1969-07-06', '2024-02-06 10:06:30', NULL, NULL, NULL, 1.111, 'proprietaire', '', '', 0),
(4, 'danielle', 'jaqueline', 'danidan', 'zebi@gmail.com', 'frout', NULL, 88, NULL, 75148235516, '1938-11-15', '2024-02-12 13:50:10', NULL, NULL, NULL, 1000, 'cleaner', '6 les hauts du pontois', 'la roche maurice', 29800),
(5, 'dam', 'legrosbg', 'big zgeg', 'ptitfilou@crepe.wahou.fr', 'mickeline', NULL, 121, NULL, 651785512, '2000-03-04', '2024-02-15 14:33:55', NULL, NULL, NULL, 100, 'cleaner', '1 rue amiral cosmao', 'Quimper', 29000),
(6, 'philippe', 'lecul', 'mrteub', 'poupipou@hot.com', 'kedulov', NULL, 47, NULL, 541630514, '1937-04-20', '2024-02-15 15:25:31', NULL, NULL, NULL, 5, 'proprietaire', '5 avenue herve de guebriant', 'landerneau', 29800);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `litige`
--
ALTER TABLE `litige`
  ADD PRIMARY KEY (`litige_id`),
  ADD KEY `id_autor` (`id_autor`),
  ADD KEY `id_mission` (`id_mission`);

--
-- Indexes for table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`mission_id`),
  ADD KEY `id_cleaner` (`id_cleaner`),
  ADD KEY `id_proprietaire` (`id_proprietaire`),
  ADD KEY `statut` (`statut`),
  ADD KEY `id_propriete` (`id_propriete`);

--
-- Indexes for table `propriete`
--
ALTER TABLE `propriete`
  ADD PRIMARY KEY (`propriete_id`),
  ADD KEY `proprietaire_id` (`proprietaire_id`);

--
-- Indexes for table `statut_mission`
--
ALTER TABLE `statut_mission`
  ADD PRIMARY KEY (`statut_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `litige`
--
ALTER TABLE `litige`
  MODIFY `litige_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mission`
--
ALTER TABLE `mission`
  MODIFY `mission_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `propriete`
--
ALTER TABLE `propriete`
  MODIFY `propriete_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `statut_mission`
--
ALTER TABLE `statut_mission`
  MODIFY `statut_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `litige`
--
ALTER TABLE `litige`
  ADD CONSTRAINT `litige_ibfk_2` FOREIGN KEY (`id_mission`) REFERENCES `mission` (`mission_id`),
  ADD CONSTRAINT `litige_ibfk_3` FOREIGN KEY (`id_autor`) REFERENCES `users` (`id_user`);

--
-- Constraints for table `mission`
--
ALTER TABLE `mission`
  ADD CONSTRAINT `mission_ibfk_3` FOREIGN KEY (`statut`) REFERENCES `statut_mission` (`statut_id`),
  ADD CONSTRAINT `mission_ibfk_4` FOREIGN KEY (`id_propriete`) REFERENCES `propriete` (`propriete_id`),
  ADD CONSTRAINT `mission_ibfk_5` FOREIGN KEY (`id_cleaner`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `mission_ibfk_6` FOREIGN KEY (`id_proprietaire`) REFERENCES `users` (`id_user`);

--
-- Constraints for table `propriete`
--
ALTER TABLE `propriete`
  ADD CONSTRAINT `propriete_ibfk_1` FOREIGN KEY (`proprietaire_id`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
