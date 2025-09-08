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
