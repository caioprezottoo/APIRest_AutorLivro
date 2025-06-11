# 📚 AuthorBook API

A RESTful API to manage authors and their books, built with Spring Boot, JPA, and a relational database.

---

## 🔧 Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Flyway (for database migrations)
- MySQL
- Maven

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── autor_livro/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── application.properties
│       └── db/migration/
```

---

## 🚀 API Endpoints

### 📘 Books

- `POST /livros` — Create a new book  
  **Request body:**
  ```json
  {
    "titulo": "Don Quixote",
    "autorId": 1
  }
  ```

- `GET /livros` — List all books

- `GET /livros/{id}` — Get a book by ID

---

### ✍️ Authors

- `POST /autores` — Create a new author  
  **Request body:**
  ```json
  {
    "nome": "Miguel de Cervantes",
    "nacionalidade": "Spanish"
  }
  ```

- `GET /autores` — List all authors

---

## 🛠️ Database Migrations with Flyway

- All migrations go in:  
  `src/main/resources/db/migration`

- Example migration file (V1__create_tables.sql):

```sql
CREATE TABLE autor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(100) NOT NULL
);

CREATE TABLE livro (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    autor_id BIGINT NOT NULL,
    CONSTRAINT fk_livro_autor FOREIGN KEY (autor_id) REFERENCES autor(id)
);
```
