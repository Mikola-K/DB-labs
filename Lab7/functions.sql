USE `pharmacy_db`;
SET GLOBAL log_bin_trust_function_creators = 1;
-- №1 Для таблиці employee написати функцію як буде формувати значення з перших літер стовпців Прізвище, Ім’я, По-батькові.
DROP function IF EXISTS `info_about_user`;
DELIMITER $$

CREATE FUNCTION `info_about_user` (
	name VARCHAR(45),
    surname VARCHAR(45),
    middle_name VARCHAR(45))
RETURNS VARCHAR(3)
DETERMINISTIC
BEGIN
RETURN CONCAT(
	LEFT(name, 1),
    LEFT(surname, 1),
    LEFT(middle_name, 1));
END$$
DELIMITER ;
-- №2: витягує за ключем між таблицями street та pharmacy значення поля street_name
DROP FUNCTION IF EXISTS get_street_name;
DELIMITER //	
CREATE FUNCTION get_street_name(
street_id INT
)
RETURNS VARCHAR(25)
BEGIN	
RETURN(
	select name from street where id =(select street_id from pharmacy where id = street_id)
);
END //
DELIMITER ;

-- вибірка даних 
SELECT info_about_user(name, surname, middle_name) from employee;
 SELECT name, work_time_open , is_open_sunday, get_street_name(id) from pharmacy;


