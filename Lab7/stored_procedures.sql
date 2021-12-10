-- 1. Забезпечити параметризовану вставку нових значень у таблицю medicine_list
DROP PROCEDURE IF EXISTS cteate_medicine_list;
DELIMITER //
CREATE PROCEDURE cteate_medicine_list(
    name VARCHAR(20),
    ministry_code  VARCHAR(10),
    is_narcotic TINYINT,
    require_recipe TINYINT
)
BEGIN
    INSERT INTO medicine_list(name, ministry_code, is_narcotic, require_recipe)
    VALUES (name, ministry_code, is_narcotic, require_recipe);
END //
DELIMITER ;

-- 2.  Створити пакет, який вставляє 10 стрічок в таблицю post у форматі < Noname+№> , 
-- наприклад: Noname5, Noname6, Noname7 і т.д.
drop procedure if exists insertion_into_post;
DELIMITER //
CREATE PROCEDURE insertion_into_post()
begin
	declare str VARCHAR(80);
	declare counter int;
	set counter=0, str='NoName';
while counter<10 do
	set counter = counter+1;
		insert into post(name) values (concat(str,counter), counter);
end while;
END //
DELIMITER ;

-- 3. Використовуючи курсор, забезпечити динамічне створення БД з іменами employee, 
-- з випадковою кількістю таблиць для кожної БД (від 1 до 9). 
-- Структура таблиць довільна. Імена таблиць відповідають імені Співробітника з порядковим номером від 1 до 9.
drop procedure if exists create_new_db_of_employee; 
DELIMITER //
CREATE PROCEDURE create_new_db_of_employee ()
BEGIN
	DECLARE surname varchar(90);
	DECLARE done int DEFAULT false;
    DECLARE random int;
	
    DECLARE cursor1 CURSOR FOR SELECT surname from employee;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;
	OPEN cursor1;
    loop1: LOOP 
		set random = (FLOOR( RAND() * (9-1) + 1));
		FETCH cursor1 INTO surname;
        IF done=true THEN LEAVE loop1;
        END IF;

		SET @tmp_query0 = CONCAT('drop database if exists ',surname,';');
        PREPARE myquery FROM @tmp_query0;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;
        
        SET @tmp_query = CONCAT('CREATE DATABASE IF NOT EXISTS ',surname,';');
        PREPARE myquery FROM @tmp_query;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;

        
       WHILE random > 0 do
            set random = random - 1;
            
			SET @tmp_query2 = CONCAT('use ',surname,';');
			PREPARE statement0 FROM @tmp_query2;
			EXECUTE statement0;
			DEALLOCATE PREPARE statement0;
            
            
            SET @tmp_query3 = CONCAT('drop table if exists ',surname,';');
			PREPARE statement1 FROM @tmp_query3;
			EXECUTE statement1;
			DEALLOCATE PREPARE statement1;
            
            
			SET @tmp_query4 = CONCAT(
            'CREATE TABLE IF NOT EXISTS `',CONCAT(surname,random), '` 
			(
			`id` INT,
			`name` VARCHAR(45), 
			PRIMARY KEY (`id`)
			);'
			);
			PREPARE statement FROM @tmp_query4;
			EXECUTE statement;
			DEALLOCATE PREPARE statement;
            
        end while;
    END LOOP;
    CLOSE cursor1;

END //
DELIMITER ;