# Lab 7. 
Database of pharmacy institutions in Novosilky.
SAVED PROCEDURES
1. Ensure parameterized insertion of new values ​​in
table List of drugs.
2. Create a package that inserts 10 rows into the Position table in
format <Noname + No>, for example: Noname5, Noname6,
Noname7, etc.
3. Using the cursor, ensure the dynamic creation of the database
with the names of the Employees, with a random number of tables for
each database (from 1 to 9). The structure of the tables is arbitrary. Names
tables correspond to the name of the Employee with ordinal
number from 1 to 9.
CUSTOM FUNCTIONS
1. For the Employees table, write the function as it will be

form values ​​from the first letters of the columns Last name, First name, Last name
father. Then make a data sample (SELECT) from this table,

using this function.
2. Write a function that extracts the key between the tables
Street and Pharmacy value of the Street name field. Then
make a sample of all data (SELECT) from the table Pharmacy
institution using this feature.
TRIGGERS
1. Ensure the integrity of the values ​​for the database structure.
2. for Employees → Identification number to provide
format: '10 digits';
3. First letter List of medicines → Ministry code should
match the first letter List of medicines → Name.
4. Provide cardinality (min = 2, max = 6) tapes for
street table.альність (min=2, max=6) стрічок для
таблиці Вулиця.