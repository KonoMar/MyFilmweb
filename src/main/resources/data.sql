INSERT INTO category (id, name) VALUES
  (1, 'Komedia'),
  (2, 'Kryminal'),
  (3, 'Horror'),
  (4, 'Sci-Fi'),
  (5, 'Dramat'),
  (6, 'Przygodowy'),
  (7, 'Film akcji'),
  (8, 'Historyczny'),
  (9, 'Dokumentalny'),
  (10, 'Musical'),
  (11, 'Sensacyjny');

INSERT INTO User(id, username, password, enabled, role) VALUES (1, 'user', 'USER', 1, 'ROLE_USER');
INSERT INTO User(id, username, password, enabled, role) VALUES (2, 'admin', 'ADMIN', 1, 'ROLE_ADMIN');

INSERT INTO movie (id, title, year, description, category_id, photo, author_id) VALUES
  (1, 'Życie jest piękne', 1997, 'Zamknięty w obozie koncentracyjnym wraz z synem Guido próbuje przekonać chłopca, że okrutna rzeczywistość jest jedynie formą zabawy dla dorosłych.', 1, 'img1.jpg', 1),
  (2, 'Rain Man', 1998, 'Karierowicz Charlie dostaje informację o śmierci ojca, z którym od lat nie miał kontaktu. Z testamentu dowiaduje się, że ma starszego brata chorego na autyzm.', 4, 'img2.jpg', 1),
  (3, 'Dunkierka', 2017, 'Wojska alianckie zostają przyparte do morza pod Dunkierką. Bitwa staje się sprawdzianem dla młodych żołnierzy, pilota RAF-u oraz załogi cywilnej łodzi płynącej przez Kanał La Manche. ', 7, 'img3.jpg', 1),
  (4, 'Mroczny Rycerz', 2008, 'Batman, z pomocą porucznika Gordona oraz prokuratora Harveya Denta, występuje przeciwko przerażającemu i nieobliczalnemu Jokerowi, który chce pogrążyć Gotham City w chaosie.', 6, 'img4.jpg', 1),
  (5, 'Nie ma mocnych', 1974, 'Pawlak i Kargul szukają męża dla swojej wnuczki, chcąc w ten sposób zdobyć spadkobiercę. ', 1, 'img5.jpg', 1),
  (6, 'Czarnobyl', 1982, 'Po wybuchu elektrowni jądrowej w Czarnobylu ratownicy poświęcają zdrowie i życie, by ratować Europę przed skutkami katastrofy.', 7, 'img6.jpg', 1),
  (7, 'Gra o tron', 2011, 'Adaptacja sagi George''a R.R. Martina. W królestwie Westeros walka o władzę, spiski oraz zbrodnie są na porządku dziennym.', 1, 'img7.jpg', 1);


INSERT INTO comment (id,author_id, content,movie_id) VALUES
  (1,1,'Super komedia!',1),
  (2,1,'Przyznam, że moje oczekiwania co do tego filmu były ogromne, ale ten film je całkowicie spełnił.',2),
  (3,1,'Genialne efekty specjalne,pięknie zrobiony, ale mimo wszystko wyjątkowo idiotyczny...',2),
  (4,1,'Singh przyzwyczaił nas swoimi dziełami do wizualnej perfekcji. Przepiękne, przepiękne zdjęcia, wspaniała scenografia, oryginalne kostiumy, malownicze plenery jako trafnie dobrane tło dla baśni.',4),
  (5,1,'Super komedia!',5),
  (6,1,'Nie wiem?',5),
  (7,1,'Kumpel w 98 r przyniósł kasetę z tym fimem. Oglądaliśmy z zapartym tchem. Człowiek nie spuścił oczu z telewizora, a na widok efektów szczena opadała do ziemi. Dlaczego te czasy minely bezpowrotnie...',7),
  (8,1,'Strasznie nudy',7);
