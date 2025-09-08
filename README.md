# ECE Result Management System (Servlet + JDBC + Oracle)

# 3 tire architecture 

<img> 
This project is a mini-web application demonstrating how to build a Java Servlet-based system to fetch and display student results stored in an Oracle Database using JDBC. It covers the essential full-stack flow, from a simple HTML frontend to a Java backend interacting with a relational database.

## 🚀 Overview

The application allows users to input a roll number (student ID) via an HTML form. This input is then processed by a Java Servlet, which establishes a connection to an Oracle Database using JDBC. The servlet executes a SQL query to retrieve the corresponding student's name and marks, and finally renders this information dynamically as an HTML response back to the client.

This project is ideal for understanding fundamental concepts of Java EE web development, database connectivity, and secure query execution.


Technologies Used

Java (Servlet API): For handling HTTP requests and generating dynamic web responses.

JDBC (Java Database Connectivity): Standard API for database interaction from Java applications.

Oracle Database: Relational database used for persistent storage of student results.

Apache Tomcat (or any Java EE Server): To deploy and run the Servlet application.

HTML: For the simple frontend form to accept user input.

## creation of orale database :

install oracle for windows  --> create your password 

search for sql command line interface 

then enter :

```bash
system connect
```

enter your password *******

then start creating and adding elements into the table 

```bash

CREATE TABLE eceresult (
    id NUMBER ,
    grade VARCHAR2(50),
   
);
```
adding data into table 
```bash
INSERT INTO eceresult VALUES (1, 'A');
INSERT INTO eceresult VALUES (2, 'B');
INSERT INTO eceresult VALUES (3, 'C');
COMMIT;

```

### Backend Code Explanation

1. MyResultServlet.java

This Servlet is the core of the backend logic.

@WebServlet("/MyResultServlet"): This annotation maps the servlet to the URL /MyResultServlet, making it accessible via web requests.

doGet() Method:

Retrieves the id (roll number) parameter from the incoming HTTP request.

Loads the Oracle JDBC driver (Class.forName("oracle.jdbc.OracleDriver")).

Establishes a connection to the Oracle Database using DriverManager.getConnection().

Prepares and executes a SQL SELECT query using PreparedStatement to retrieve student data based on the provided roll number. This prevents SQL injection vulnerabilities.

Processes the ResultSet to extract student name and marks.

Generates an HTML response containing the student's result or a "not found" message, which is then sent back to the client.

doPost() Method:

For simplicity in this project, the doPost() method merely calls doGet(). In a production application, POST requests are typically used for data submission (e.g., adding or updating records) for better security and to handle larger
data payloads.

2. Frontend HTML Form
   
The index.html (or similar) file contains a simple form to collect the student's roll number.

```bash
<form action="MyResultServlet" method="get">
    Enter your Roll number <input type="text" name="id"><br>
    <input type="submit" value="Get My Result">
</form>
```

The action="MyResultServlet" attribute directs the form submission to our servlet.

method="get" indicates that the form data (the roll number) will be appended to the URL as a query parameter.

### Core Concepts Covered

Servlets: Fundamentals of building dynamic web applications with Java EE, handling HTTP requests, and generating responses.

JDBC (Java Database Connectivity): The standard API for connecting Java applications to relational databases, covering driver loading, connection establishment, statement execution, and result processing.

PreparedStatement: Essential for secure database interactions, using parameterized queries to prevent SQL Injection attacks.

Oracle Database: Practical usage of Oracle for data storage, including DDL (Data Definition Language) for table creation and DML (Data Manipulation Language) for data insertion and querying.

HTTP GET vs. POST: Understanding the differences and appropriate use cases for these common HTTP methods in web applications.

### How to Run the Project

--> Database setup 

Install Oracle Database: Ensure you have an Oracle Database (e.g., Oracle XE) installed and running.

Database Setup: Execute the SQL commands provided in the "Database Setup" section to create the eceresult table and insert sample data.

--> create html file :

** note : in form use the servlet name as the same name that you are going to create a java servlet class 
select method and use same in servlet file. 

--> creation of servlet class 

files --> dynamicweb project

if you are new and not yet installed any server then select a server over there and click on istall

Install Tomcat: Set up Apache Tomcat (or another Java EE server) in your IDE (e.g., Eclipse, IntelliJ IDEA).

use the same name you have used in html for creation of the file , this file will extends the properties of servlet and we will be having doGET and doPOST methods in this .

Add JDBC Driver: Download the ojdbc8.jar (or appropriate version for your Java/Oracle setup) and add it to your project's WEB-INF/lib directory. This driver is essential for connecting Java to Oracle.

then add jdbc driver in both the places 

1st right click on src --> build path --> configure build path --> libreries --> class path --> add external jar file --> select jar file from local 

2nd right click on main directory --> build path --> configure build path --> libreries --> class path --> add external jar file --> select jar file from local 

->now run the result.html file you will be navigated or a web page will be pop uped enter the any value you will be getting reultent result mapped to that number in database 


