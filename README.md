# Lab 2(Variant 36)

## Task:
According to the variant of the task, write SQL-queries for
sampling of necessary data and statistical information from databases,
that are specified in the appendix, and to execute these inquiries to a DB in graphic
MySQL Workbench tool, check for functionality and
correctness of the received data.
### Variant:
1. DB "Comp. firm". Find the model number, speed and size
PC discs that have CD drives with a speed of '12 x 'or '24 x' and a price
less than $ 600 Output: model, speed, hd, cd, price. Output data
sort by descending speed column.
2. DB "Airport". From the Trip table display information about flights that
arrive in the time interval between 17 and 23 hours inclusive.
3. DB "Airport". For Boeing flight planes, provide names
companies to which they belong.
4. DB "Comp. firm". Find the number of computers available
released by the manufacturer 'A'.
5. DB "Comp. firm". List those laptop manufacturers that too
produce and printers.
6. DB "Airport". For the Pass_in_trip table, the value of the place column
split into two columns with comments, for example, the first - 'row: 2' and
the second is 'place: a'.
7. DB "Airport". Determine the days when the maximum was met
number of flights to Moscow. Output: date, number of flights.
8. DB "Comp. firm". Find the minimum price of manufactured PCs
by each manufacturer. Output: maker, maximum price. (Hint:
use subqueries as computational columns)
9. DB "Airport". For each flight (Trip table) determine the duration
leaf of his flight. Output: trip_no, company name, plane, town_from,
town_to, flight duration. (Hint: use the CASE statement
to check the conditions)
10. DB "Comp. firm". For each product model, print from the entire database
its lowest price. Output: type, model, lowest price. (Hint:
use the UNION operator)

## How to run:
- Clone the repo
- cd db_labs && git checkout lab2
- Run scripts under sql/ through any way that suits you (mysql prompt, mysql workbench etc)