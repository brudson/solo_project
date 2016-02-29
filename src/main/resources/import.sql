SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;



INSERT INTO enclosure VALUES (1, 'Tiger', 		'Good', 	 'Terrys Tigers', '1:00 PM',  '1');
INSERT INTO enclosure VALUES (2, 'Polar Bear',	'Bad', 		 'Petes Polar Bears', '2:04 PM',  '12');
INSERT INTO enclosure VALUES (3, 'Bees', 		'Great', 	 'Brads Bees', '4:23 AM',  '44');
INSERT INTO enclosure VALUES (4, 'Flamingos', 	'Fantastic', 'Freddys Flamingos', '8:30 PM',  '4');
INSERT INTO enclosure VALUES (5, 'Parrots', 	'Poor', 	 'Parrys Parrots', '12:00 AM', '8');

SELECT pg_catalog.setval('enclosure_enclosurerid_seq', 5, true);

INSERT INTO animals VALUES (1, 'Meat', 		'https://en.wikipedia.org/wiki/Tiger', 		'Tiger', 		'Panthera tigris');
INSERT INTO animals VALUES (2, 'Meat', 		'https://en.wikipedia.org/wiki/Polar_bear', 'Polar Bear', 	'Ursus maritimus');
INSERT INTO animals VALUES (3, 'Honey', 	'https://en.wikipedia.org/wiki/Bee', 		'Bee', 			'Anthophila');
INSERT INTO animals VALUES (4, 'Vegtables', 'https://en.wikipedia.org/wiki/Flamingo', 	'Flamingo', 	'Phoenicopteridae');
INSERT INTO animals VALUES (5, 'Seeds', 	'https://en.wikipedia.org/wiki/Parrot', 	'Parrot', 		'Psittaciformes');

SELECT pg_catalog.setval('animals_animalid_seq', 5, true);

INSERT INTO food VALUES (1, 'Meat', 		'Steak', 			'Billys Butcher House');
INSERT INTO food VALUES (2, 'Meat', 		'Steak', 			'Billys Butcher House');
INSERT INTO food VALUES (3, 'Fruit', 	'Honey', 			'Hillarys Honey Factory');
INSERT INTO food VALUES (4, 'Vegtable', 	'Celery', 			'Gregs Garden');
INSERT INTO food VALUES (5, 'Grain', 	'Sunflower Seeds', 	'Sauls Sunflower Seeds');


SELECT pg_catalog.setval('food_foodid_seq', 5, true);