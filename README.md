# Data-Loading-CSV-To-Database-mysql-
Loading CSV to mysql database using JAVA 8
Procedure:

Make the Plain Old Java Object(POJO) with the attributes same as columns
Make the POJO class with the attribute same as columns.
We then make the object of POJO class whose object(pushing the data) will have attributes same as columns, Hence collecting the data of one row of CSV
Make a array list of object of POJO class type and push the above object to the list
Iterating through and making same number of object as number of rows will read the entires CSV
We then push data in array list to database by construting a query.
