use humanfriendsdb;
 --	Создание таблиц Pets и PackAnimal
CREATE TABLE Pets (
    ID INT PRIMARY KEY,
    Name VARCHAR(255),
    Type VARCHAR(255),
    BirthDate DATE,
    Commands VARCHAR(255)
);

CREATE TABLE PackAnimals (
    ID INT PRIMARY KEY,
    Name VARCHAR(255),
    Type VARCHAR(255),
    BirthDate DATE,
    Commands VARCHAR(255)
);
 -- Заполнение таблиц данными
INSERT INTO Pets (ID, Name, Type, BirthDate, Commands) VALUES
(1, 'Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
(2, 'Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
(3, 'Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
(4, 'Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
(5, 'Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
(6, 'Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
(7, 'Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
(8, 'Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

INSERT INTO PackAnimals (ID, Name, Type, BirthDate, Commands) VALUES
(1, 'Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
(2, 'Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
(3, 'Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
(4, 'Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
(5, 'Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
(6, 'Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
(7, 'Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
(8, 'Sahara', 'Camel', '2015-08-14', 'Walk, Run');

-- Удаление записей о верблюдах

DELETE FROM PackAnimals WHERE Type = 'Camel';

-- Создание новой таблицы для животных в возрасте от 1 до 3 лет
CREATE TABLE YoungAnimals AS
SELECT * FROM Pets WHERE BirthDate BETWEEN DATE_SUB(CURRENT_DATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURRENT_DATE(), INTERVAL 1 YEAR)
UNION
SELECT * FROM PackAnimals WHERE BirthDate BETWEEN DATE_SUB(CURRENT_DATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURRENT_DATE(), INTERVAL 1 YEAR);

-- Объединение всех созданных таблиц в одну

CREATE TABLE AllAnimals AS
SELECT * FROM Pets
UNION
SELECT * FROM PackAnimals
UNION
SELECT * FROM YoungAnimals;







select * from  AllAnimals;



