# onlinebookshop
The *Online Book Shop* is a console-based Java application that allows customers to browse and purchase books while enabling admin users to manage the book inventory. It uses JDBC to interact with a PostgreSQL database and demonstrates core Java concepts such as OOP, multithreading, and abstraction.

---


## 🚀 Features

### 👨‍💼 Admin
- Add Book
- Remove Book
- View All Books

### 👩‍💻 Customer
- View Available Books
- Buy Book (uses multithreading)

---

## 🛠 Technologies Used

- Java (Core)
- JDBC (Java Database Connectivity)
- PostgreSQL
- Maven
- Object-Oriented Programming (Abstraction, Inheritance, Interface)
- Multithreading

---

---

## 🗃️ Database Schema

```sql
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL CHECK (quantity >= 0)
);

---
## Dependencies
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.1</version>
</dependency>
```
---
Prerequisites

Java JDK 17 or higher

Apache Maven 3.8.6 or higher

PostgreSQL 15 or higher

---
Contact

Name: Siddhi Joshi

GitHub: siddhijoshi-dotcom

Email: siddhijoshi0512@gmail.com
