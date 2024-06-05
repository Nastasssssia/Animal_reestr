-- создали БД 
CREATE DATABASE HumanFriends;

USE HumanFriends;

-- Создание таблицы Pets
CREATE TABLE  IF NOT EXISTS Pets (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Type VARCHAR(50),
    BirthDate DATE,
    Commands VARCHAR(255)
);

-- Создание таблицы PackAnimals
CREATE TABLE IF NOT EXISTS PackAnimals (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Type VARCHAR(50),
    BirthDate DATE,
    Commands VARCHAR(255)
);

-- Вставка данных в таблицу Pets
INSERT INTO Pets (ID, Name, Type, BirthDate, Commands) VALUES
(1, 'Fido', 'Dog', '2020-01-01', 'Sit, Stay'),
(2, 'Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
(3, 'Hammy', 'Hamster', '2021-03-10', 'Roll, Hide'),
(4, 'Buddy', 'Dog', '2018-12-10', 'Sit, Paw, Bark'),
(5, 'Smudge', 'Cat', '2020-02-20', 'Sit, Pounce, Scratch'),
(6, 'Peanut', 'Hamster', '2021-08-01', 'Roll, Spin'),
(7, 'Bella', 'Dog', '2019-11-11', 'Sit, Stay, Roll'),
(8, 'Oliver', 'Cat', '2020-06-30', 'Meow, Scratch, Jump');

-- Вставка данных в таблицу PackAnimals
INSERT INTO PackAnimals (ID, Name, Type, BirthDate, Commands) VALUES
(1, 'Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
(2, 'Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
(3, 'Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
(4, 'Storm', 'Horse', '2014-05-05', 'Trot, Canter'),
(5, 'Dune', 'Camel', '2018-12-12', 'Walk, Sit'),
(6, 'Burro', 'Donkey', '2019-01-23', 'Walk, Bray, Kick'),
(7, 'Blaze', 'Horse', '2016-02-29', 'Trot, Jump, Gallop'),
(8, 'Sahara', 'Camel', '2015-08-14', 'Walk, Run');

-- удаление верблюдов
DELETE FROM PackAnimals WHERE Type = 'Camel';

-- проверка
select * FROM PackAnimals;

-- Создание объединенной таблицы для лошадей и ослов
CREATE TABLE IF NOT EXISTS HorsesAndDonkeys AS
SELECT * FROM PackAnimals WHERE Type IN ('Horse', 'Donkey');
-- не совсем поняла смысл, если мы и так удалили верблюдов и там остались лошади и ослы. Но в самом задании был такой пример структуры БД.
select * FROM HorsesAndDonkeys;

-- Создание таблицы для животных в возрасте от 1 до 3 лет
CREATE TABLE IF NOT EXISTS YoungAnimals AS
SELECT * FROM (
    SELECT ID, Name, Type, BirthDate, Commands, 
           TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeMonths
    FROM Pets
    UNION
    SELECT ID, Name, Type, BirthDate, Commands, 
           TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeMonths
    FROM PackAnimals
) AS AllAnimals
WHERE AgeMonths BETWEEN 12 AND 36;

-- проверка 
select * FROM YoungAnimals;

-- Создание объединенной таблицы с указанием исходной таблицы
CREATE TABLE IF NOT EXISTS AllAnimals AS 
SELECT 'Pets' AS SourceTable, ID, Name, Type, BirthDate, Commands 
FROM Pets 
UNION ALL 
SELECT 'PackAnimals' AS SourceTable, ID, Name, Type, BirthDate, Commands 
FROM PackAnimals 
UNION ALL 
SELECT 'HorsesAndDonkeys' AS SourceTable, ID, Name, Type, BirthDate, Commands 
FROM HorsesAndDonkeys 
UNION ALL 
SELECT 'YoungAnimals' AS SourceTable, ID, Name, Type, BirthDate, Commands 
FROM YoungAnimals;

-- проверка 
select * FROM AllAnimals;


