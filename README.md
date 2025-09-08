# ECE Result Management System (Servlet + JDBC + Oracle)

# 3 tire architecture 

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
