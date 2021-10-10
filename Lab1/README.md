# Lab 1 (Variant 36)
## Task:
1. Create a database (DB).
2. In this database to create a scheme with a name that corresponds to the name of the student. All newly created
objects must belong to this scheme.
3. Build all necessary objects (tables, primary keys, secondary keys, foreign keys,
indices, test constraints) for the specified database.
4. Make at least 10 abstract records in each database table (if the number is known
not limited to logic).
5. Create a diagram for a fully designed database. Tables should be displayed on
chart in standard mode (column name, data type, allow null values) Relationships between
tables to adjust so that they indicate between which columns they are
establish a connection.
Designation: P.K. - primary key; U.I. - unique index;
I. - non-unique index; CHECK - test constraint.
# Variant:
Indeema. Create a relational database schema that allows you to save information about the elements of the user 's solar station (typespanels, power, battery capacity, duration of usebatteries, panels, etc.), installation address of the station, powerproduction of each panel hourly daily, battery charge leveleach hour, the current angles of each panel), the numberenergy sold on the energy market by the hour and the price of electricity, cdepending on the time of sale (price may vary). Predict that some panels can change the angle during the day for the better generation, and the number of farms where solar stations are installed - can be any. Similarly, one owner can have several solar stations, or the station may have multiple owners.

# How To Run:
- Download and install mysql
- Clone repo and git checkout lab1
- Execute source REPO/sql/create.sql from mysql shell
- Execute source REPO/sql/populate.sql from mysql shell