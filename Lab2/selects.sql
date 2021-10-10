/* 1. БД «Комп. фірма». Знайдіть номер моделі, швидкість та розмір
диску ПК, що мають CD-приводи зі швидкістю '12х' чи '24х' та ціну
меншу 600 дол. Вивести: model, speed, hd, cd, price. Вихідні дані
впорядкувати за спаданням за стовпцем speed.
*/
select model, speed, hd, cd, price from pc
where cd in ('12x' '24x') or price < 600
order by speed desc;
/* 
2. БД «Аеропорт». З таблиці Trip вивести інформацію про рейси, що
прилітають в інтервалі часу між 17 та 23 годинами включно.
*/
select time_in from trip
where time_in between '1900-01-01 17:00:00' and '1900-01-01 23:00:00';
/*
3. БД «Аеропорт». Для рейсових літаків 'Boeing' вказати назви
компаній, яким вони належать.
*/
select trip.plane, company.name from company
inner join trip on company.ID_comp = trip.ID_comp
where trip.plane = 'Boeing';
/*
4. БД «Комп. фірма». Знайти наявну кількість комп’ютерів, що
випущені виробником 'A'.
*/
select pc.model, product.maker from product
inner join pc on pc.model = product.model
where product.maker = 'A';
/*
5. БД «Комп. фірма». Виведіть тих виробників ноутбуків, які також
випускають і принтери.
*/
select printer.model, product.maker from product
inner join printer on printer.model = product.model;
/*
6. БД «Аеропорт». Для таблиці Pass_in_trip значення стовпця place
розбити на два стовпці з коментарями, наприклад, перший – 'ряд: 2' та
другий – 'місце: a'.
*/
select CONCAT("row: ",SUBSTRING(place, 1, 1)), CONCAT("place: ",SUBSTRING(place, 2, 1)) from pass_in_trip;
/*
7. БД «Аеропорт». Визначіть дні, коли було виконано максимальну
кількість рейсів до міста 'Moscow'. Вивести: date, число рейсів.
*/
select pass_in_trip.date, count(trip.town_to)  from trip
inner join pass_in_trip on trip.trip_no = pass_in_trip.trip_no
where trip.town_to = 'Moscow' 
group by pass_in_trip.date having count(pass_in_trip.date) > 1;
/*
8. БД «Комп. фірма». Знайдіть мінімальну ціну ПК, що випускаються
кожним виробником. Вивести: maker, максимальна ціна. (Підказка:
використовувати підзапити в якості обчислювальних стовпців)
*/
select product.maker, min(price) from pc join product on product.model = pc.model
group by product.maker;
/*
9. БД «Аеропорт». Для кожного рейсу (таблиця Trip) визначити трива-
лість його польоту. Вивести: trip_no, назва компанії, plane, town_from,
town_to, тривалість польоту. (Підказка: використати оператор CASE
для перевірки умов)
*/
select trip.trip_no, trip.plane, trip.town_from, trip.town_to, company.name as company_name,
case 
	when time_in<trip.time_out then TIMESTAMPDIFF(minute, time_out, DATE_ADD(time_in, INTERVAL 24 HOUR)) 
    else TIMESTAMPDIFF(minute, time_out, time_in) 
end as time_in_trip_min
from trip
inner join company on company.ID_comp = trip.ID_comp;
/*
10. БД «Комп. фірма». Для кожної моделі продукції з усієї БД виведіть
її найменшу ціну. Вивести: type, model, найменша ціна. (Підказка:
використовувати оператор UNION)
*/
select product.type, product.model, min(selecion.price) from Product
join (select model, price from PC
		union
		select model, price from Printer
		union
		select model, price from Laptop
) as selecion on product.model = selecion.model
group by 2;