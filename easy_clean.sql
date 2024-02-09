-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : mar. 06 fév. 2024 à 08:17
-- Version du serveur : 5.7.33
-- Version de PHP : 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `easy_clean`
--

-- --------------------------------------------------------

--
-- Structure de la table `litige`
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
-- Structure de la table `mission`
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

-- --------------------------------------------------------

--
-- Structure de la table `propriete`
--

CREATE TABLE `propriete` (
  `propriete_id` int(10) UNSIGNED NOT NULL,
  `adress` varchar(50) NOT NULL,
  `code_entrer` int(10) DEFAULT NULL,
  `proprietaire_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `statut_mission`
--

CREATE TABLE `statut_mission` (
  `statut_id` int(10) UNSIGNED NOT NULL,
  `nom` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id_user` int(10) UNSIGNED NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `second_name` varchar(70) NOT NULL,
  `username` varchar(35) NOT NULL,
  `mail` varchar(25) NOT NULL,
  `password` varchar(40) NOT NULL,
  `profil_picture` varchar(50) DEFAULT NULL,
  `age` int(150) NOT NULL,
  `bio` text,
  `phone_nulber` bigint(20) NOT NULL,
  `date_of_birth` date NOT NULL,
  `date_creation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `note` float DEFAULT NULL,
  `nb_mission` int(30) DEFAULT NULL,
  `perimeter` int(35) DEFAULT NULL,
  `tarif_horaire` float NOT NULL,
  `role` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `litige`
--
ALTER TABLE `litige`
  ADD PRIMARY KEY (`litige_id`),
  ADD KEY `id_autor` (`id_autor`),
  ADD KEY `id_mission` (`id_mission`);

--
-- Index pour la table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`mission_id`),
  ADD KEY `id_cleaner` (`id_cleaner`),
  ADD KEY `id_proprietaire` (`id_proprietaire`),
  ADD KEY `statut` (`statut`),
  ADD KEY `id_propriete` (`id_propriete`);

--
-- Index pour la table `propriete`
--
ALTER TABLE `propriete`
  ADD PRIMARY KEY (`propriete_id`),
  ADD KEY `proprietaire_id` (`proprietaire_id`);

--
-- Index pour la table `statut_mission`
--
ALTER TABLE `statut_mission`
  ADD PRIMARY KEY (`statut_id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `litige`
--
ALTER TABLE `litige`
  MODIFY `litige_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `mission`
--
ALTER TABLE `mission`
  MODIFY `mission_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `propriete`
--
ALTER TABLE `propriete`
  MODIFY `propriete_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `statut_mission`
--
ALTER TABLE `statut_mission`
  MODIFY `statut_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `litige`
--
ALTER TABLE `litige`
  ADD CONSTRAINT `litige_ibfk_2` FOREIGN KEY (`id_mission`) REFERENCES `mission` (`mission_id`),
  ADD CONSTRAINT `litige_ibfk_3` FOREIGN KEY (`id_autor`) REFERENCES `users` (`id_user`);

--
-- Contraintes pour la table `mission`
--
ALTER TABLE `mission`
  ADD CONSTRAINT `mission_ibfk_3` FOREIGN KEY (`statut`) REFERENCES `statut_mission` (`statut_id`),
  ADD CONSTRAINT `mission_ibfk_4` FOREIGN KEY (`id_propriete`) REFERENCES `propriete` (`propriete_id`),
  ADD CONSTRAINT `mission_ibfk_5` FOREIGN KEY (`id_cleaner`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `mission_ibfk_6` FOREIGN KEY (`id_proprietaire`) REFERENCES `users` (`id_user`);

--
-- Contraintes pour la table `propriete`
--
ALTER TABLE `propriete`
  ADD CONSTRAINT `propriete_ibfk_1` FOREIGN KEY (`proprietaire_id`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
