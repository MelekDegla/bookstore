-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 11 déc. 2020 à 19:52
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
  `nbLivres` int(20) NOT NULL,
  `birthdate` varchar(20) DEFAULT NULL,
  `photo` varchar(6000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `author`
--

INSERT INTO `author` (`id`, `name`, `lastname`, `nbLivres`, `birthdate`, `photo`) VALUES
(1, 'victor', 'hugo', 42, '1969-11-06', ''),
(5, 'hhhhhslqsl', 'shjkslmkdj', 5, '2020-12-30', 'file:/C:/Users/nouha/Downloads/119583880_1124168758356060_2525078994597041254_n.jpg'),
(6, 'gbdcd', 'fdddss', 4, '2020-12-17', 'file:/C:/Users/nouha/Downloads/119583880_1124168758356060_2525078994597041254_n.jpg'),
(7, 'dmdsmdssd', 'dbssdjksjk', 5, '2020-12-24', ''),
(9, 'ddssssqqq', 'aaaaaaaa', 22, '2020-12-16', 'file:/C:/Users/Degla/Desktop/12109187_982648181786964_2559160210961625536_n.jpg'),
(10, 'Victor', 'Hugo', 0, '2020-12-12', '220px-Bonnat_Hugo001z');

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
  `quantity` int(11) DEFAULT NULL,
  `author` int(11) NOT NULL,
  `nbr_pages` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `isbn`, `title`, `description`, `photo`, `price`, `quantity`, `author`, `nbr_pages`) VALUES
(30, 'yyyyyyyyy', 'The subtle art of not giving a fuck', 'ghjkl', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '77', 44, 77, 0),
(45, 'ged', 'Self love challenge', 'dmo,', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '4', 5, 54, 4),
(50, '8', 'Learn How To love', '8', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '8', 8, 8, 0),
(49, '7', 'The Notebook', '7', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '7', 7, 7, 0),
(56, '444', 'Anger Management', 'vbnk,ml', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '30', 50, 444, 0),
(59, '4ZZ52SDDCFF', 'Angular Services', 'to learn angular', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '10', 10, 201, 900),
(24, '54jjjjDQFHNQKLS', 'Marie', '', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '444', 2, 0, 0),
(22, '54q54DQFooooNQKLS', 'ggg', '', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '444', 2, 0, 0),
(21, '54jjjjDQFHNQKLS', 'ggg', '', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '444', 2, 0, 0),
(31, '54q54DQFooooNQKLS', 'ggg', '', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '444', 2, 0, 0),
(18, '54jjjjDQFHNQKLS', 'ggg', '', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\resources\\51a0k07h-wL.jpg', '444', 2, 0, 0),
(60, 'test8', 'test validation', 'test', 'null', '100', 18, 1, 5);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `libelle` varchar(100) NOT NULL,
  `description` varchar(4000) NOT NULL,
  `dateajout` varchar(20) DEFAULT NULL,
  `datemodif` varchar(20) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`libelle`, `description`, `dateajout`, `datemodif`, `id`) VALUES
('tesssssst', 'Aventure', '2020-12-07', '2020-12-07', 14),
('Horror', 'test', '2020-12-09', '2020-12-09', 18),
('testtt', 'testt', '2020-12-02', '2020-12-10', 19),
('Horror', 'test', '2020-12-09', '2020-12-09', 20);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `text` mediumtext NOT NULL,
  `id_book` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `text`, `id_book`, `id_user`, `created_at`, `updated_at`) VALUES
(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ultricies neque sed nibh imperdiet malesuada. Maecenas molestie tortor pellentesque arcu pulvinar malesuada. Suspendisse sit amet aliquam arcu. Sed fringilla tincidunt varius. Curabitur in augue nec augue tincidunt rhoncus. Proin ac dui nec nibh ultrices mattis semper non urna. Etiam euismod mollis leo sit amet efficitur.', 25, 15, '2020-12-09 14:47:42', '2020-12-09 14:47:42'),
(7, 'aaa', 25, 15, '2020-12-09 21:11:29', '2020-12-09 22:00:55'),
(12, 'a\n', 25, 15, '2020-12-09 21:17:41', '2020-12-09 21:17:41'),
(14, 'qsdq', 25, 15, '2020-12-10 17:01:43', '2020-12-10 17:01:43'),
(15, 'sqsdqsd', 25, 15, '2020-12-10 17:02:22', '2020-12-10 17:02:22'),
(17, 'sqdqsdqsdqsd', 25, 16, '2020-12-10 17:46:39', '2020-12-10 17:46:39'),
(18, 'qsd', 25, 16, '2020-12-10 17:47:14', '2020-12-10 17:47:14');

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
(1, 'The zen art ', 'looooool', 'C:\\Users\\Degla\\Desktop\\fatma\\bookstoreDesktop\\src\\com\\vermeg\\bookstore\\Images\\Pdf test.pdf', 'the zen art book.png', 3500, 1),
(2, 'The art of plein air panting', 'hahaha', 'https://www.penguinrandomhouse.com/the-read-down/22-unforgettable-love-stories-in-fiction', 'the art of plein air panting.jpg', 4320, 2),
(3, 'The ultimate concept art', 'hihih', 'https://www.penguinrandomhouse.com/the-read-down/22-unforgettable-love-stories-in-fiction', 'the ultimate concept art.jpg', 680, 3),
(5, 'Sports in society', 'coucou', 'https://www.penguinrandomhouse.com/the-read-down/22-unforgettable-love-stories-in-fiction', 't.jpg', 945, 5),
(6, 'Sport hypnosis', 'kiwi', 'https://www.penguinrandomhouse.com/the-read-down/22-unforgettable-love-stories-in-fiction', 't.jpg', 1203, 6),
(7, 'The spirit of christ', 'creme', 'https://www.penguinrandomhouse.com/the-read-down/22-unforgettable-love-stories-in-fiction', 't.jpg', 8960, 7),
(8, 'The meaning of god', 'amour', 'https://www.penguinrandomhouse.com/the-read-down/22-unforgettable-love-stories-in-fiction', 't.jpg', 1548, 8),
(9, 'Me before you', 'jeunesse ', 'https://www.penguinrandomhouse.com/the-read-down/22-unforgettable-love-stories-in-fiction', 't.jpg', 4587, 9),
(10, 'Love beyond hope', 'tessssssssstttt', 'https://www.penguinrandomhouse.com/the-read-down/22-unforgettable-love-stories-in-fiction', 't.jpg', 4998, 10),
(11, 'Act like we\'re in love', 'hello', 'https://sites.google.com/site/brrqush/Act-Like-Were-In-Love', 't.jpg', 2364, 11);

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
(6, 'hackfest', 'hackhaton', '2020-05-11', 1, 'ezzahra'),
(7, 'testttttt', 'hackhaton2', '2020-10-03', 50, 'mars');

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
  `subject` varchar(250) NOT NULL,
  `message` varchar(250) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `is_answered` tinyint(1) NOT NULL,
  `answer` mediumtext NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `feedback`
--

INSERT INTO `feedback` (`id`, `name`, `lastname`, `email`, `phone`, `subject`, `message`, `created_at`, `is_answered`, `answer`, `id_user`) VALUES
(27, 'BATTIKH', 'Anis', 'anis.isetjb@gmail.com', '93829700', 'Thank you ', 'Merci beacoup pour cette application ', '2020-12-06 20:29:01', 0, 'qsd', 15),
(28, 'qsd', 'qsd', 'q', '55555555', 'qsd', 'qsd', '2020-12-06 22:34:25', 0, '', 0),
(29, 'FERJANI', 'Iheb', 'ihebferjani04@gmail.com', '55888999', 'Amazing', 'thank you', '2020-12-06 22:42:35', 1, 'youre welcome', 0),
(30, 'qsdqsd', 'qsddqs', 'qsd@qsd.com', '55888693', 'Merci', 'qsdf', '2020-12-08 11:56:37', 1, 'dfsfsdfsd', 0),
(31, 'ben aissia', 'sami', 'samibenaissia6@gmail.com', '55888999', 'Hello', 'jkfsdlkhjmfds', '2020-12-08 19:30:47', 1, 'qsdqsd', 0),
(32, 'degla', 'melek', 'melek.degla@esprit.tn', '55888999', 'sqsqsq', 'qssqsq', '2020-12-09 09:29:50', 1, 'dsd', 0),
(33, 'FERJANI', 'MAHDI', 'mehdiferjani7@gmail.com', '55668826', 'Hello', 'dsfsdfsdfsfsd', '2020-12-09 21:03:20', 1, 'bonsoir si mehdi', 0),
(34, 'tetets', 'teetts', 'melek.degla@esprit.tn', '55612719', 'tetd', 'lkhcbjhb', '2020-12-11 09:27:37', 0, 'null', 15);

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
  `password` varchar(999) DEFAULT NULL,
  `username` varchar(52) DEFAULT NULL,
  `photo` varchar(999) DEFAULT NULL,
  `isadmin` tinyint(1) DEFAULT NULL,
  `birthdate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `name`, `lastname`, `phone`, `email`, `password`, `username`, `photo`, `isadmin`, `birthdate`) VALUES
(16, 'feriel', 'jridi', '24432724', ' feriel.jridi@esprit.tn', ' $2y$12$6Q9Qy2ZZY3XD76Roo8CTgeO2aRJaaSE03xWp9POJf1ir5z.j74Fby', 'feryel', 'null', 1, '1998-08-13'),
(17, 'wiem', 'rekik2', '54857754', '   wiem.rekik@esprit.tn', '  $2y$12$6Q9Qy2ZZY3XD76Roo8CTgeO2aRJaaSE03xWp9POJf1ir5z.j74Fby', 'wiem', NULL, 1, '2020-12-09'),
(20, 'test', 'test', '12345678', ' melek.degla@esprit.tn', ' $2y$12$1qHsA86vp74sOi3zPfWYQumYDiEBJLobbDn6LAjFjh6Um6NC4n7vW', 'melek', 'question-mark-icomputer-mac-and-pc-repair-mind-png-clip-art.png', NULL, '2020-12-09');

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
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `ebook`
--
ALTER TABLE `ebook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `events`
--
ALTER TABLE `events`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT pour la table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

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
