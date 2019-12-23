-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 13 juin 2019 à 09:19
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+01:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `supermarche`
--

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `idfournisseur` int(10) NOT NULL,
  `nomfournisseur` varchar(150) NOT NULL,
  `prenomfournisseur` varchar(20) NOT NULL,
  `addresse` varchar(150) NOT NULL,
  `id_ville` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`idfournisseur`, `nomfournisseur`, `prenomfournisseur`, `addresse`, `id_ville`) VALUES
(1, 'Salim', 'Ali', '15 Villa Salim Alaa chriaa elsalam', 2),
(2, 'ELALAMI', 'Samir', 'N° 25 rue 45', 3),
(3, 'HAYTAM', 'Manal', '18 Rue azohor hay amnahil', 1),
(4, 'SOBHI', 'mohammed', 'charia lmanara', 1),
(5, 'ALALAMI', 'Ahmad', '06 Rue anajah', 1);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `idprod` int(11) NOT NULL,
  `nomprod` varchar(100) DEFAULT NULL,
  `prixunitaire` float DEFAULT NULL,
  `quantite` int(20) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `idfour` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idprod`, `nomprod`, `prixunitaire`, `quantite`, `description`, `idfour`) VALUES
(1, 'Tide 75g', 3, 50500, 'Pruit de menage Tide 75g', 2),
(3, 'Hp pc i5', 6, 1650, 'Pc Core I5', 1),
(4, 'Agenda  mini', 3, 1650, 'modakira', 4),
(5, 'Windows 10', 1200, 250, 'Os De Microsoft', 1),
(6, 'Cockacola 1L', 6, 500, 'boisan', 2),
(7, 'Chepakiya', 20, 2000, 'halawiya maghribiya', 3),
(8, 'Clear', 0.5, 5020, 'chompoint', 2),
(9, 'Carte SIM iam  10Dh', 10, 300, 'crate pres payeé de IAM', 1),
(11, 'Carte SIM INWI  10Dh', 10, 500, 'crate pres payeé de INWI', 1),
(12, 'Carte SIM iam  5Dh', 5, 5000, 'crate pres payeé de IAM', 1),
(13, 'Carte SIM iam  20Dh', 20, 3000, 'crate pres payeé de IAM', 1),
(14, 'Pc Accent i7 Ram 6Gb', 8000, 50, 'Pc accent i7 g5', 1),
(16, 'Pc Accent i7 Ram 8Gb', 8500, 250, 'Pc accent i7 g5 RAM 8 Gb', 1),
(17, 'Toshiba USB 16Gb', 70, 500, 'Toshiba USB 16Gb TransMemory', 5),
(18, 'Ice Cola 1.25L', 6.5, 1250, 'ice Cola 1.25L', 4);

-- --------------------------------------------------------

--
-- Structure de la table `user_info`
--

CREATE TABLE `user_info` (
  `iduser` int(11) NOT NULL,
  `nom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `post` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `login` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `user_info`
--

INSERT INTO `user_info` (`iduser`, `nom`, `prenom`, `post`, `login`, `password`) VALUES
(1, 'JOUETETE', 'Said', 'Admin', 'said', '123'),
(2, 'rbati', 'samir', 'asest', 'samir', '123456'),
(3, 'elalami', 'kamal', 'asest', 'kamal', '123');

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `id_ville` int(20) NOT NULL,
  `nom_ville` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`id_ville`, `nom_ville`) VALUES
(1, 'Safi'),
(2, 'Marrakech'),
(3, 'tanger');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`idfournisseur`),
  ADD KEY `id_ville` (`id_ville`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`idprod`),
  ADD KEY `FK_fournisseur_produit` (`idfour`);

--
-- Index pour la table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`iduser`),
  ADD UNIQUE KEY `login` (`login`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`id_ville`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `idfournisseur` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `idprod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT pour la table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `ville`
--
ALTER TABLE `ville`
  MODIFY `id_ville` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD CONSTRAINT `fournisseur_ibfk_1` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`id_ville`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK_VILLE_CLIENT` FOREIGN KEY (`idfour`) REFERENCES `fournisseur` (`idfournisseur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
