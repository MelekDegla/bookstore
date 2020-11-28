-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : Dim 22 nov. 2020 à 18:57
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `photo` varchar(6000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `author`
--

INSERT INTO `author` (`id`, `name`, `lastname`, `birthdate`, `photo`) VALUES
(10, 'Victor', 'Hugo', '2020-12-12', '220px-Bonnat_Hugo001z'),
(11, 'bla bla', 'Hba', '2020-12-11', '220px-Bonnat_Hugo001z');

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `price` decimal(11,0) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `isbn`, `title`, `description`, `photo`, `price`, `quantity`) VALUES
(25, '54q54DQFooooNQKLS', 'ggg', '', '', '444', 2),
(24, '54jjjjDQFHNQKLS', 'ggg', '', '', '444', 2),
(22, '54q54DQFooooNQKLS', 'ggg', '', '', '444', 2),
(21, '54jjjjDQFHNQKLS', 'ggg', '', '', '444', 2),
(31, '54q54DQFooooNQKLS', 'ggg', '', '', '444', 2),
(18, '54jjjjDQFHNQKLS', 'ggg', '', '', '444', 2),
(30, '54jjjjDQFHNQKLS', 'ggg', '', '', '444', 2),
(27, '54jjjjDQFHNQKLS', 'ggg', '', '', '444', 2),
(28, '54q54DQFooooNQKLS', 'ggg', '', '', '444', 2);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `title` varchar(100) NOT NULL,
  `description` varchar(4000) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`title`, `description`, `id`) VALUES
('Horror', 'An horror film is one that seeks to elicit fear in its audience for entertainment purposes. Horror films additionally aim to evoke viewers nightmares, fears, revulsions and terror of the unknown and macabre.', 1),
('Comedy moviesss', 'This category is reserved for films that make people laugh. The judges are looking for films that have funny moments, comedic situations, fun dialogue, humorous acting, and great characters. This event has screened great musicals, sketch comedy, stand-up comedy, family comedy, silent comedy, slapstick comedy, romantic comedy, action comedy, student comedy, mockumentary, web series episodes, comedy TV pilots, fake commercials and more at our past events.', 5),
('Romantic', 'Romance films or romance movies are romantic love stories recorded in visual media for broadcast in theaters and on TV that focus on passion, emotion, and the affectionate romantic involvement of the main characters and the journey that their love takes them through dating, courtship or marriage. Romance films make the romantic love story or the search for strong and pure love and romance the main plot focus', 6),
('Adventure', 'Adventure films are a genre of film whose plots feature elements of travel. They typically involve protagonists who must leave their home or place of comfort and go to far away lands to fulfill a goal. Settings play an important role in Adventure films, sometimes as big as the characters themselves.', 7),
('Romantic', 'Romance films or romance movies are romantic love stories recorded in visual media for broadcast in theaters and on TV that focus on passion, emotion, and the affectionate romantic involvement of the main characters and the journey that their love takes them through dating, courtship or marriage. Romance films make the romantic love story or the search for strong and pure love and romance the main plot focus', 8),
('Romantic', 'Romance films or romance movies are romantic love stories recorded in visual media for broadcast in theaters and on TV that focus on passion, emotion, and the affectionate romantic involvement of the main characters and the journey that their love takes them through dating, courtship or marriage. Romance films make the romantic love story or the search for strong and pure love and romance the main plot focus', 10),
('Adventure', 'Adventure films are a genre of film whose plots feature elements of travel. They typically involve protagonists who must leave their home or place of comfort and go to far away lands to fulfill a goal. Settings play an important role in Adventure films, sometimes as big as the characters themselves.', 11);

-- --------------------------------------------------------

--
-- Structure de la table `ebook`
--

CREATE TABLE `ebook` (
  `id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `file_url` varchar(100) NOT NULL,
  `photo` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `author_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ebook`
--

INSERT INTO `ebook` (`id`, `title`, `description`, `file_url`, `photo`, `price`, `author_id`) VALUES
(1, 'fatma w al pc al meskin ', 'looooool', 'jakglo:aj!z', 'qhgkzuyegm', 432, 2),
(2, 'akjzblfhazùo', 'hohohh', '', '', 432, 289),
(4, 'kljhabdmzefz', 'hahaha', 'mlgh:', 'ftsyrdyfgl', 432, 589),
(5, 'akjzblfhazùo', 'hohohh', '', '', 432, 289),
(6, 'hgkiaglabflor', 'hihih', '', '', 432, 980),
(7, 'kljhabdmzefz', 'hahaha', 'mlgh:', 'ftsyrdyfgl', 432, 589),
(8, 'akjzblfhazùo', 'hohohh', '', '', 432, 289),
(9, 'hgkiaglabflor', 'hihih', '', '', 432, 980),
(10, 'kljhabdmzefz', 'hahaha', 'mlgh:', 'ftsyrdyfgl', 432, 589),
(11, 'akjzblfhazùo', 'hohohh', '', '', 432, 289),
(12, 'hgkiaglabflor', 'hihih', '', '', 432, 980),
(13, 'kljhabdmzefz', 'hahaha', 'mlgh:', 'ftsyrdyfgl', 432, 589),
(14, 'akjzblfhazùo', 'hohohh', '', '', 432, 289),
(15, 'hgkiaglabflor', 'hihih', '', '', 432, 980),
(16, 'kljhabdmzefz', 'hahaha', 'mlgh:', 'ftsyrdyfgl', 432, 589),
(17, 'akjzblfhazùo', 'hohohh', '', '', 432, 289),
(18, 'hgkiaglabflor', 'hihih', '', '', 432, 980),
(19, 'kljhabdmzefz', 'hahaha', 'mlgh:', 'ftsyrdyfgl', 432, 589),
(20, 'akjzblfhazùo', 'hohohh', '', '', 432, 289),
(21, 'hgkiaglabflor', 'hihih', '', '', 432, 980),
(22, 'kljhabdmzefz', 'hahaha', 'mlgh:', 'ftsyrdyfgl', 432, 589),
(23, 'akjzblfhazùo', 'hohohh', '', '', 432, 289),
(24, 'hgkiaglabflor', 'hihih', '', '', 432, 980);

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

CREATE TABLE `events` (
  `ID` int(100) NOT NULL,
  `title` varchar(64) NOT NULL,
  `description` varchar(64) NOT NULL,
  `date` date DEFAULT NULL,
  `MAX_PARTICIPANTS` int(200) NOT NULL,
  `lieu` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `events`
--

INSERT INTO `events` (`ID`, `title`, `description`, `date`, `MAX_PARTICIPANTS`, `lieu`) VALUES
(6, 'hackfest', 'hackhaton', '2020-05-11', 50, 'ezzahra'),
(7, 'hackfest2', 'hackhaton2', '2020-10-03', 50, 'marsa');

-- --------------------------------------------------------

--
-- Structure de la table `feedback`
--

CREATE TABLE `feedback` (
  `id` int(10) NOT NULL,
  `name` varchar(250) NOT NULL,
  `lastname` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `phone` varchar(250) NOT NULL,
  `message` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `feedback`
--

INSERT INTO `feedback` (`id`, `name`, `lastname`, `email`, `phone`, `message`) VALUES
(8, 'BATTIKH', 'Anis', 'anis.battikh@esprit.tn', '93829700', 'Merci beaucoup!'),
(9, 'FERJANI', 'Iheb', 'ferjani.iheb@esprit.tn', '99555666', 'bkojqbs'),
(10, 'ALI', 'Mohamed', 'ali.mohamed@esprit.tn', '25889963', 'bkojqbs'),
(11, 'BATTIKH', 'Anis', 'anis.battikh@esprit.tn', '93829700', 'Merci beaucoup!'),
(12, 'AHMeeeeED', 'Kamel', 'kamel.ahmed@esprit.tn', '99665887', 'qsdqsd'),
(13, 'ALI', 'Mohamed', 'ali.mohamed@esprit.tn', '25889963', 'bkojqbs'),
(14, 'BATTIKH', 'Anis', 'anis.battikh@esprit.tn', '93829700', 'Merci beaucoup!'),
(15, 'FERJANI', 'Iheb', 'ferjani.iheb@esprit.tn', '99555666', 'bkojqbs'),
(16, 'ALI', 'Mohamed', 'ali.mohamed@esprit.tn', '25889963', 'bkojqbs'),
(17, 'BATTIKH', 'Anis', 'anis.battikh@esprit.tn', '93829700', 'Merci beaucoup!'),
(18, 'FERJANI', 'Iheb', 'ferjani.iheb@esprit.tn', '99555666', 'bkojqbs'),
(19, 'ALI', 'Mohamed', 'ali.mohamed@esprit.tn', '25889963', 'bkojqbs'),
(20, 'BATTIKH', 'Anis', 'anis.battikh@esprit.tn', '93829700', 'Merci beaucoup!'),
(21, 'FERJANI', 'Iheb', 'ferjani.iheb@esprit.tn', '99555666', 'bkojqbs');

-- --------------------------------------------------------

--
-- Structure de la table `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `order`
--

INSERT INTO `order` (`id`, `status`, `user_id`) VALUES
(2, 105998, 5),
(6, 5, 6),
(7, 5, 8),
(8, 5, 6),
(9, 5, 8),
(10, 5, 6),
(11, 5, 8);

-- --------------------------------------------------------

--
-- Structure de la table `order_details`
--

CREATE TABLE `order_details` (
  `order_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `order_details`
--

INSERT INTO `order_details` (`order_id`, `book_id`, `quantity`) VALUES
(6, 6, 6),
(7, 6, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(52) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `phone` varchar(8) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `username` varchar(52) DEFAULT NULL,
  `photo` blob DEFAULT NULL,
  `isadmin` tinyint(1) DEFAULT NULL,
  `birthdate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `name`, `lastname`, `phone`, `email`, `password`, `username`, `photo`, `isadmin`, `birthdate`) VALUES
(15, 'null', 'null', 'null', ' null', ' null', 'null', NULL, NULL, '2020-11-11');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ebook`
--
ALTER TABLE `ebook`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`order_id`,`book_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `ebook`
--
ALTER TABLE `ebook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT pour la table `events`
--
ALTER TABLE `events`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
