# Lab 4
## Task:
1. The task is performed on the basis of the designed database model in laboratory works №1 and the developed script in №3.
2. The database must be deployed using SQL-script.
3. The Java client program is created as a Maven project with a connection to MySQL.
4. The structure of the project is created on the basis of MVC-pattern. Where the model must contain both Database Access Layer and Business Logic Layer. The implementation of the Database Access layer is based on the DAO pattern.
5. User Interface Layer is implemented in the form of a console menu. Thus the Program should provide work with data in a DB by means of JDBC:
• output of data from tables;
• insert data into the table;
• delete data from the table;
• updating data in tables.
6. Connect the following plugins to Maven:
❖ plugin FindBugs which automatically checks the quality of the code and searches for potential errors in the code
❖ PMD plugin
❖ Checkstyle plugin - checks compliance with the code convention
When finished, run the command mvn site and
view the results of its execution in the target / site folder
In the code it is necessary to correct all errors which will find plug-ins FindBugs,
PMD and Checkstyle (except for remoteness errors
comments).

# How To Run:
- Download and install mysql
- Clone repo and git checkout lab4
- Execute source REPO/sql/lab4.sql from mysql shell
