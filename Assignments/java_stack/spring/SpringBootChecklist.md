# Spring Boot Checklist

## Step 0 - Starting the project

1. Create a workspace
2. Inside of `Package Explorer` right click -> new -> Spring Starter Project
3. Inside of the Pop-up we need to:
    * Create a unique project name, example `first`
    * Make sure the type is `Maven`
    * Set Java Version to `11`
    * Set Packaging to `War`
    * Artifact name as project name `first`
    * Group name convention... `com.username` <-- your username here
    * Package name convention... `com.username.first` <-- your project name here!
4. Once these are set choose `Next`
5. Select/Search for the following packages:
    * Spring Boot DevTools
    * Spring Web
6. Last, click `Finish`

## Step 1 - pom.xml

* Add these to the `<dependencies></dependencies>` tag in the file and save it

    ```xml
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>bootstrap</artifactId>
        <version>4.5.0</version>
    </dependency>
    <dependency>
        <groupId>org.webjars.bower</groupId>
        <artifactId>jquery</artifactId>
        <version>3.5.1</version>
    </dependency>
    ```

## Step 2 - Create our first View

* Add this line to the `src/main/resources/application.properties` file

    ```properties
    spring.mvc.view.prefix=/WEB-INF/
    ```

* Create the folder `src/main/webapp/WEB-INF`
* Create the file `src/main/webapp/WEB-INF/index.jsp`
* Add this code in `index.jsp`

    ```html
    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Pandas</title>
        <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
        <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="container">
        <h1>Hello World!</h1>
    </div>
    </body>
    </html>
    ```

## Step 3 - Make our Controllers

* Go to `/src/main/java/` and add a new package inside your project example `com.username.first.controllers`

* Inside the new `...controllers` package create a new `Java Class` called `HomeController`

* In our `HomeController.java` file add the following...

    ```java
    package com.username.first.controllers;

    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class HomeController {

        @GetMapping("/")
        public String index() {
            return "index.jsp";
        }

    }
    ```

## Step 4 - running the server

Right click on the `Project Name` -> run as -> Spring Boot App

Check our server at `http://localhost:8080`

## Step 5 - Connect to database (MySql)

* Add dependencies to pom.xml

    Add these to the `<dependencies></dependencies>` tag in the file and save it

    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```

* Create the schema to MySql

    ``` mysql
    >
    ```

* Add configuration to `application.properties`

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA>>?serverTimezone=UTC
    spring.datasource.username=<<dbuser>>
    spring.datasource.password=<<dbpassword>>
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    ```

* __Dont forget to update__ `<<YOUR_SCHEMA>>`, `<<dbuser>>`, `<<dbpassword>>`.

* __Note__ ?serverTimezone=UTC is to fix the time zone.

* __Note__ we may safely remove this setting (Line 4)*

## Step 6 - Make our Model

* We also need to include spring-boot-starter-validations as of June 2020 to `pom.xml`.

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>  
    ```

* Go to `/src/main/java/` and add a new package inside your project example `com.username.first.models`

* Inside the new `...models` package create a new `Java Class` called `Book`

* In our `Book.java` file add the following...

    ```java
    package com.mamutawah.first.models;

    import java.util.Date;
    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;
    import javax.validation.constraints.Min;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Size;


    @Entity
    @Table(name="books")
    public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @NotNull
        @Size(min = 5, max = 200)
        private String title;
        
        @NotNull
        @Size(min = 5, max = 200)
        private String description;
        
        @NotNull
        @Size(min = 3, max = 40)
        private String language;
        
        @NotNull
        @Min(100)
        private Integer numberOfPages;
        
        // This will not allow the createdAt column to be updated after creation
        @Column(updatable=false)
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date createdAt;
        
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date updatedAt;
        
        public Book() {
        }
        public Book(String title, String desc, String lang, int pages) {
            this.title = title;
            this.description = desc;
            this.language = lang;
            this.numberOfPages = pages;
        }
        
        // other getters and setters removed for brevity <Auto Generated>

        @PrePersist
        protected void onCreate(){
            this.createdAt = new Date();
        }
        @PreUpdate
        protected void onUpdate(){
            this.updatedAt = new Date();
        }
    }
    ```

    __Validation Annotations__

    The annotations do almost exactly what they say:

    `@Entity`: represents an entity model for our application

    `@Table`: sets this as a table in the database

    `@Id`: sets this as the primary key

    `@GeneratedValue`: sets this as an auto-incrementing value

    `@Size`: adds validation that the column must be in the specified range

    `@Min`: adds validation that the column must be at least the specified value

    `@NotNull`: adds validation that the column must be null

    `@PrePersist`: runs the method right before the object is created

    `@PreUpdate`: runs a method when the object is modified

## Step 7 - Make our Repository

* Go to `/src/main/java/` and add a new package inside your project example `com.username.first.repositories`

* Inside the new `...repositories` package create a new `Java interface` called `BookRepository` extend the `CrudRepository`

* In our `BookRepository.java` file add the following...

    ```java
    // ...
    @Repository
    public interface BookRepository extends CrudRepository<Book, Long>{
        // this method retrieves all the books from the database
        List<Book> findAll();
        // this method finds books with descriptions containing the search string
        List<Book> findByDescriptionContaining(String search);
        // this method counts how many titles contain a certain string
        Long countByTitleContaining(String search);
        // this method deletes a book that starts with a specific title
        Long deleteByTitleStartingWith(String search);
    }
    ```

* [How to write Queries](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)

## Step 8 - Make our Service

* Go to `/src/main/java/` and add a new package inside your project example `com.username.first.services`

* Inside the new `...services` package create a new `Java class` called `BookService`

* In our `BookService.java` file add the following...

    ```java
    // ...
    import org.springframework.stereotype.Service;
    import com.username.mvc.models.Book;
    @Service
    public class BookService {
        // adding the book repository as a dependency
        private final BookRepository bookRepository;
        
        public BookService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }
        // returns all the books
        public List<Book> allBooks() {
            return bookRepository.findAll();
        }
        // creates a book
        public Book createBook(Book b) {
            return bookRepository.save(b);
        }
        // retrieves a book
        public Book findBook(Long id) {
            Optional<Book> optionalBook = bookRepository.findById(id);
            if(optionalBook.isPresent()) {
                return optionalBook.get();
            } else {
                return null;
            }
        }
    }

    ```

## T
