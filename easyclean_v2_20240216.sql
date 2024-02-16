-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 16 fév. 2024 à 13:30
-- Version du serveur : 8.0.30
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `easyclean_v2_20240216`
--

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `idCommentaire` int NOT NULL,
  `idDestinataire` int NOT NULL,
  `idAuteur` int NOT NULL,
  `text` varchar(500) NOT NULL,
  `note` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`idCommentaire`, `idDestinataire`, `idAuteur`, `text`, `note`) VALUES
(1, 23, 1122, 'Le boulot est trop chiant, je préfère plutôt le chômage et les aides caf du coup c\'était ma première et ma dernière mission, alors au revoir les riches bourgeois méchants, ciao.', 0),
(3, 24, 1121, 'Trop dur le taff, j\'ai mal au dos du coup arrêt maladie, merci.', 1);

-- --------------------------------------------------------

--
-- Structure de la table `litige`
--

CREATE TABLE `litige` (
  `litige_id` int UNSIGNED NOT NULL,
  `text_litige` text NOT NULL,
  `image1` varchar(35) DEFAULT NULL,
  `image2` varchar(35) DEFAULT NULL,
  `image3` varchar(25) DEFAULT NULL,
  `id_autor` int UNSIGNED NOT NULL,
  `id_mission` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE `mission` (
  `mission_id` int UNSIGNED NOT NULL,
  `date_mission` date NOT NULL,
  `time_mission` double NOT NULL,
  `instruction` text NOT NULL,
  `is_achive` tinyint(1) NOT NULL,
  `id_cleaner` int UNSIGNED NOT NULL,
  `id_proprietaire` int UNSIGNED NOT NULL,
  `statut` int UNSIGNED NOT NULL,
  `id_propriete` int UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `mission`
--

INSERT INTO `mission` (`mission_id`, `date_mission`, `time_mission`, `instruction`, `is_achive`, `id_cleaner`, `id_proprietaire`, `statut`, `id_propriete`) VALUES
(1, '2024-03-06', 1.5, 'laver le water closed.', 0, 4, 3, 1, 3),
(2, '2024-02-22', 2, 'nioooonnnnn', 0, 4, 3, 2, 3),
(3, '2024-02-22', 3.5, 'kk', 0, 5, 6, 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `propriete`
--

CREATE TABLE `propriete` (
  `propriete_id` int UNSIGNED NOT NULL,
  `adress` varchar(50) NOT NULL,
  `code_entrer` int DEFAULT NULL,
  `proprietaire_id` int UNSIGNED NOT NULL,
  `surface` int NOT NULL,
  `ville` varchar(50) NOT NULL,
  `code_postal` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `propriete`
--

INSERT INTO `propriete` (`propriete_id`, `adress`, `code_entrer`, `proprietaire_id`, `surface`, `ville`, `code_postal`) VALUES
(1, '4 rue de Simon le con', 152, 3, 0, '', 0),
(2, '5 avenue du pipi au lait', 123, 3, 0, '', 0),
(3, '61 route de quimper', 152, 3, 180, 'landerneau', 29800),
(4, '16 Rue Izar', NULL, 6, 50, 'plouedern', 29800);

-- --------------------------------------------------------

--
-- Structure de la table `statut_mission`
--

CREATE TABLE `statut_mission` (
  `statut_id` int UNSIGNED NOT NULL,
  `nom` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `statut_mission`
--

INSERT INTO `statut_mission` (`statut_id`, `nom`) VALUES
(1, 'available'),
(2, 'not_available'),
(3, 'waiting'),
(4, 'cancelled'),
(5, 'finished');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id_user` int UNSIGNED NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `second_name` varchar(70) NOT NULL,
  `username` varchar(35) NOT NULL,
  `mail` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `profil_picture` varchar(50) DEFAULT NULL,
  `age` int NOT NULL,
  `bio` text,
  `phone_number` bigint NOT NULL,
  `date_of_birth` date NOT NULL,
  `date_creation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `note` float DEFAULT NULL,
  `nb_mission` int DEFAULT NULL,
  `perimeter` int DEFAULT NULL,
  `tarif_horaire` float NOT NULL,
  `role` varchar(35) NOT NULL,
  `adresse` varchar(70) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `code_postal` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id_user`, `first_name`, `second_name`, `username`, `mail`, `password`, `profil_picture`, `age`, `bio`, `phone_number`, `date_of_birth`, `date_creation`, `note`, `nb_mission`, `perimeter`, `tarif_horaire`, `role`, `adresse`, `ville`, `code_postal`) VALUES
(1, 'Francis', 'triple monstre', 'mortadon', 'coucou@gmail.com', 'doublemonstre', NULL, 34, NULL, 695781245, '1937-04-20', '2024-02-06 09:50:42', NULL, NULL, NULL, 24, 'cleaner', '', '', 0),
(2, 'Simon', 'Le Golmon', 'mrlechieur', 'gtjrsraison@gmail.com', 'FUCKSIMON', NULL, 5, NULL, 65175165, '2010-02-06', '2024-02-06 09:58:56', NULL, NULL, NULL, 1.1, 'cleaner', '', '', 0),
(3, 'michel', 'Vroumvroum', 'labagnole', 'fan2peugeot207hdi@gmail.com', 'fuckcitroen', NULL, 69, NULL, 54218832, '1969-07-06', '2024-02-06 10:06:30', NULL, NULL, NULL, 1.111, 'proprietaire', '', '', 0),
(4, 'danielle', 'jaqueline', 'danidan', 'zebi@gmail.com', 'frout', NULL, 88, NULL, 75148235516, '1938-11-15', '2024-02-12 13:50:10', NULL, NULL, NULL, 1000, 'cleaner', '6 les hauts du pontois', 'la roche maurice', 29800),
(5, 'dam', 'legrosbg', 'big zgeg', 'ptitfilou@crepe.wahou.fr', 'mickeline', NULL, 121, NULL, 651785512, '2000-03-04', '2024-02-15 14:33:55', NULL, NULL, NULL, 100, 'cleaner', '1 rue amiral cosmao', 'Quimper', 29000),
(6, 'philippe', 'lecul', 'mrteub', 'poupipou@hot.com', 'kedulov', NULL, 47, NULL, 541630514, '1937-04-20', '2024-02-15 15:25:31', NULL, NULL, NULL, 5, 'proprietaire', '5 avenue herve de guebriant', 'landerneau', 29800);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`idCommentaire`);

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
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `idCommentaire` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `litige`
--
ALTER TABLE `litige`
  MODIFY `litige_id` int UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `mission`
--
ALTER TABLE `mission`
  MODIFY `mission_id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `propriete`
--
ALTER TABLE `propriete`
  MODIFY `propriete_id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `statut_mission`
--
ALTER TABLE `statut_mission`
  MODIFY `statut_id` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
