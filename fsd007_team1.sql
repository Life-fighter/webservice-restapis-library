CREATE DATABASE IF NOT EXISTS fsd007_team1;
USE fsd007_team1;

CREATE TABLE Library(
	id int not null auto_increment,
    name varchar(100) not null,
    address varchar(45) not null,
    zip_code varchar(7) not null,
    phone_number varchar(12) not null,
    constraint pk_Library primary key clustered (id asc)
);

INSERT INTO Library(name,address,zip_code,phone_number)
VALUES
	('Grande Bibliothèque de BAnQ','475 Boulevard Maisonneuve Est','H2L 5C4','514-873-1100'),
	('Bibliothèque Benny','6400 Avenue de Monkland','H4B 1H3','514-872-4147'),
	('Bibliothèque de Côte-des-Neiges','5290 Chemin de la Côte-des-Neiges','H3T 1Y2','514-872-6603'),
	('Bibliothèque de La Petite-Patrie','6707 avenue De Lorimier','H2G 2P8','514-872-1733'),
	('Bibliothèque de Notre-Dame-de-Grâce','3755 Rue Botrel','H4A 3G8','514-872-2398'),
	('Bibliothèque de Parc-Extension','421 Rue Saint-Roch','H3N 1K2','514-872-6071'),
	('Bibliothèque de Rosemont','3131 Boulevard Rosemont','H1Y 1M4','514-872-4701'),
	('Bibliothèque de Saint-Michel','7601 Rue François-Perrault','H2A 3L6','514-872-3899'),
	('Bibliothèque du Plateau-Mont-Royal','465 Avenue du Mont-Royal Est','H2J 1W3','514-872-2271'),
	('Bibliothèque Frontenac','2550 Rue Ontario Est','H2K 1W7','514-872-7888'),
	('Bibliothèque Hochelaga','1870 Rue Davidson','H1W 2Y6','514-872-3666'),
	('Bibliothèque interculturelle','6767 Chemin de la Côte-des-Neiges','H3S 2T6','514-868-4715'),
	('Bibliothèque Jacqueline-De Repentigny','5955 Avenue Bannantyne','H4H 1H6','514-765-7172'),
	('Bibliothèque Langelier','6473 Rue Sherbrooke Est','H1N 1C5','514-872-2640'),
	('Bibliothèque Le Prévost','7355 Avenue Christophe-Colomb','H2R 2S5','514-872-1523'),
	('Bibliothèque Maisonneuve','4120 Rue Ontario Est','H1V 1J9','514-872-4213'),
	('Bibliothèque Marc-Favreau','500 Boulevard Rosemont','H2S 0C4','514-872-7272'),
	('Bibliothèque Mercier','8105 Rue Hochelaga','H1L 2K9','514-872-8738'),
	('Bibliothèque Mordecai-Richler','5434 Avenue du Parc','H2V 4G7','514-872-2141'),
	('Bibliothèque Père-Ambroise','2093 Rue de la Visitation','H2L 3C9','514-872-1633'),
	('Bibliothèque Robert-Bourassa','41 Avenue Saint-Just','H2V 4T7','514-495-6208')
;



SELECT * 
FROM Library;