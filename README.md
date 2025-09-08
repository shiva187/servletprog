# ECE Result Management System (Servlet + JDBC + Oracle)

# 3 tire architecture 

<img src = "blog-3-tier-application.webp" >

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




## How to Run the Project

## 1. Database Setup

- **Install Oracle Database:**  
  Ensure that Oracle Database (for example, Oracle XE) is installed and running on your system.

- **Create the Database Table:**  
  Execute the SQL commands provided in the "Database Setup" section to create the `eceresult` table and insert sample data.

---

## 2. Create the HTML File

- **Form Configuration:**  
  - In the HTML form, use the same servlet name as the one you are going to create in the Java Servlet class.  
  - Select the appropriate method (`GET` or `POST`) and ensure it matches the method implemented in the servlet.

---

## 3. Create the Servlet Class

- **Dynamic Web Project:**  
  - In your IDE, create a **Dynamic Web Project**.  
  - If you are new and have not installed any server, select a server at this stage and proceed with the installation.

- **Install Tomcat:**  
  - Set up **Apache Tomcat** (or another Java EE server) in your IDE (e.g., Eclipse, IntelliJ IDEA).

- **Servlet File Creation:**  
  - Use the same servlet name that you provided in the HTML form.  
  - This file extends the properties of `HttpServlet` and contains the `doGet()` and `doPost()` methods.

- **Add JDBC Driver:**  
  - Download the `ojdbc8.jar` (or the appropriate version for your Java/Oracle setup).  
  - Add it to your project’s `WEB-INF/lib` directory. This driver is essential for connecting Java to Oracle.

- **Configure JDBC Driver in Build Path (Two Steps):**  
  1. Right-click on the **src** folder → Build Path → Configure Build Path → Libraries → Classpath → Add External JARs → select the JAR file.  
  2. Right-click on the **main project directory** → Build Path → Configure Build Path → Libraries → Classpath → Add External JARs → select the JAR file.

---

## 4. Run the Application

- Run the `result.html` file.  
- A web page will open where you can enter a roll number.  
- The servlet will fetch and display the corresponding result from the database.  


