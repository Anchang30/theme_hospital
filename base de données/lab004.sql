-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 13 jan. 2023 à 10:39
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
-- Base de données : `lab004`
--

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `id_consultation` bigint NOT NULL,
  `date_rdv` date DEFAULT NULL,
  `heure_rdv` time DEFAULT NULL,
  `motif` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_medecin` bigint NOT NULL,
  `id_patient` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`id_consultation`, `date_rdv`, `heure_rdv`, `motif`, `id_medecin`, `id_patient`) VALUES
(1, '2023-01-24', '15:30:00', 'bilan annuelle', 6, 3),
(2, '2023-02-14', '08:00:00', 'Contrôle bras cassé', 8, 4),
(3, '2023-01-27', '12:00:00', 'maux de tete', 5, 1),
(4, '2023-01-31', '16:15:00', 'Rappel de Vaccin', 7, 2);

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `id` bigint NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `adresse_hospital` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tel_hospital` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`id`, `nom`, `prenom`, `adresse_hospital`, `tel_hospital`) VALUES
(5, 'PHILIPE', 'Julien', '25 route des malades', '06 45 78 94 24'),
(6, 'HEINZTEN', 'Rodrigue', '25 route des malades', '06 45 78 94 24'),
(7, 'BOUMI', 'Dalia', '65 route du fou', '06 45 87 54 64'),
(8, 'TROPINETTE', 'Delpina', '65 route du fou', '06 45 87 54 64');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id` bigint NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `adresse` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `num_secu` bigint DEFAULT NULL,
  `tel_patient` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `nom`, `prenom`, `adresse`, `date_naissance`, `num_secu`, `tel_patient`) VALUES
(1, 'BOU', 'Bill', '24 rue jean pierre', '1998-01-11', 12450645721, '06 24 51 74 45'),
(2, 'TITOUNE', 'Alfred', '12 rue a l\'improvise', '1960-05-19', 12454125435, '07 24 54 87 97'),
(3, 'LOUNES', 'Maria', '45 route d\'espagne', '1985-10-11', 24587451254, '06 21 51 48 65'),
(4, 'PIMIENTO', 'Rosalinda', '14 chemin de la salade', '1992-04-12', 24578461202, '06 65 87 94 24');

-- --------------------------------------------------------

--
-- Structure de la table `personne_seq`
--

CREATE TABLE `personne_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `personne_seq`
--

INSERT INTO `personne_seq` (`next_val`) VALUES
(1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`id_consultation`),
  ADD KEY `FKjigvs3m15lrwc7vgdhf4usmcs` (`id_medecin`),
  ADD KEY `FKme8knc07uub8x2g6r6fxxh96y` (`id_patient`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `id_consultation` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `FKjigvs3m15lrwc7vgdhf4usmcs` FOREIGN KEY (`id_medecin`) REFERENCES `medecin` (`id`),
  ADD CONSTRAINT `FKme8knc07uub8x2g6r6fxxh96y` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
