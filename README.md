# **Library Management System - REST API with Spring Boot**

This is a Spring Boot-based RESTful API for managing a library of books and their categories. The API allows users to create, read, update, and delete both books and categories. The application uses an H2 in-memory database to store data, with manual validation implemented in the service layer.

## **Technologies Used**

- **Spring Boot** - for building the REST API.
- **Spring Data JPA** - for database operations.
- **H2 Database** - for in-memory database support.
- **Lombok** - to reduce boilerplate code.
- **cURL** - to test and interact with the API.
- **JUnit/MockMvc** - for testing the application.

---

## **How to Run the Project**

### **Prerequisites**

- Java 17+ installed
- Maven installed

### **Steps to Run**

1. Clone the repository:

    ```bash
    git clone <repository-url>
    cd library-management
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Run the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

4. Once the application is running, the REST API will be available at `http://localhost:8080`.

5. You can access the H2 console (for checking the database) at `http://localhost:8080/h2-console` using the following credentials:
    - **JDBC URL:** `jdbc:h2:mem:testdb`
    - **Username:** `sa`
    - **Password:** (leave it empty)

---

## **API Endpoints**

### **Category Endpoints**

1. **Create a Category**

    - **URL:** `POST /api/categories`
    - **Request Body:** (JSON)

    ```json
    {
        "name": "Fiction",
        "description": "A category for fictional books"
    }
    ```

    - **cURL Example:**

    ```bash
    curl -X POST http://localhost:8080/api/categories \
    -H "Content-Type: application/json" \
    -d '{
        "name": "Fiction",
        "description": "A category for fictional books"
    }'
    ```

2. **Get All Categories**

    - **URL:** `GET /api/categories`
    - **cURL Example:**

    ```bash
    curl -X GET http://localhost:8080/api/categories
    ```

### **Book Endpoints**

1. **Create a Book (with category)**

    - **URL:** `POST /api/books?categoryId={categoryId}`
    - **Request Body:** (JSON)

    ```json
    {
        "title": "1984",
        "author": "George Orwell",
        "isbn": "9780451524935",
        "publishedDate": "1949-06-08",
        "quantity": 5
    }
    ```

    - **cURL Example:**

    ```bash
    curl -X POST http://localhost:8080/api/books?categoryId=1 \
    -H "Content-Type: application/json" \
    -d '{
        "title": "1984",
        "author": "George Orwell",
        "isbn": "9780451524935",
        "publishedDate": "1949-06-08",
        "quantity": 5
    }'
    ```

2. **Get All Books**

    - **URL:** `GET /api/books`
    - **cURL Example:**

    ```bash
    curl -X GET http://localhost:8080/api/books
    ```

---

## **cURL Commands to Test the API**

### **Step-by-Step Example to Create Categories and Books**

1. **Create a "Fiction" Category**

    ```bash
    curl -X POST http://localhost:8080/api/categories \
    -H "Content-Type: application/json" \
    -d '{
        "name": "Fiction",
        "description": "A category for fictional books"
    }'
    ```

2. **Create a "Non-fiction" Category**

    ```bash
    curl -X POST http://localhost:8080/api/categories \
    -H "Content-Type: application/json" \
    -d '{
        "name": "Non-fiction",
        "description": "A category for non-fictional books"
    }'
    ```

3. **Create a Book under the "Fiction" Category**

    Assuming the `Fiction` category has `categoryId=1`:

    ```bash
    curl -X POST http://localhost:8080/api/books?categoryId=1 \
    -H "Content-Type: application/json" \
    -d '{
        "title": "To Kill a Mockingbird",
        "author": "Harper Lee",
        "isbn": "9780061120084",
        "publishedDate": "1960-07-11",
        "quantity": 10
    }'
    ```

4. **Create Another Book under the "Fiction" Category**

    ```bash
    curl -X POST http://localhost:8080/api/books?categoryId=1 \
    -H "Content-Type: application/json" \
    -d '{
        "title": "1984",
        "author": "George Orwell",
        "isbn": "9780451524935",
        "publishedDate": "1949-06-08",
        "quantity": 5
    }'
    ```

5. **Create a Book under the "Non-fiction" Category**

    Assuming the `Non-fiction` category has `categoryId=2`:

    ```bash
    curl -X POST http://localhost:8080/api/books?categoryId=2 \
    -H "Content-Type: application/json" \
    -d '{
        "title": "Sapiens: A Brief History of Humankind",
        "author": "Yuval Noah Harari",
        "isbn": "9780062316110",
        "publishedDate": "2011-01-01",
        "quantity": 8
    }'
    ```

---

## **How to View Data in H2 Database**

1. Navigate to `http://localhost:8080/h2-console` in your browser.
2. Use the following credentials:
    - **JDBC URL:** `jdbc:h2:mem:testdb`
    - **Username:** `sa`
    - **Password:** (leave empty)
3. Run the following SQL query to view all books:

    ```sql
    SELECT * FROM BOOK;
    ```

4. Run the following SQL query to view all categories:

    ```sql
    SELECT * FROM CATEGORY;
    ```
