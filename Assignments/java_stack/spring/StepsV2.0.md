
# Check List v2.0

## Step1: Start Project

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

## Step2: Add Configuration

### Packages

* Use JSP

  ```xml
  <dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
  </dependency>
  ```

* Use C & Form tags

  ```xml
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    </dependency>
  ```


* Bootstrap

  ```xml
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

* MySQL

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

* Validations

  ```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>  
  ```

* __All__

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
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>
  ```

### Properties

* jsp Configurations
  
  ```properties
  spring.mvc.view.prefix=/WEB-INF/
  ```

* MySql Configurations
  
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/relationships?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC
  spring.datasource.username=root
  spring.datasource.password=root
  spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  spring.jpa.hibernate.ddl-auto=update
  ```

* Enable embedded Requests in form (PUT, DELETE)

  ```properties
  # // other properties here (removed for brevity)
  spring.mvc.hiddenmethod.filter.enabled=true
  ```

* All (Default to me)

  ```properties
  spring.mvc.view.prefix=/WEB-INF/

  spring.datasource.url=jdbc:mysql://localhost:3306/relationships?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC
  spring.datasource.username=root
  spring.datasource.password=root
  spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  spring.jpa.hibernate.ddl-auto=update
  ```

### Folders

* Create `WEB-INF` folder with `index.jsp` file (TBD)

  ```bash
  touch src/main/webapp/WEB-INF/index.jsp
  ```

* Create `models`, `controllers`, `repositories`, and `services` inside main package
  
  ```bash
  mkdir controllers models repositories services
  ```

## Step3: Views (jsp files)

* Java

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  ```

* C

  ```jsp
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  ```

* Form

  ```jsp
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  ```

* All

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  ```

* Bootstrap

  ```html
  <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
  <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
  <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  ```

* Default JSP layout

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
      <title>Insert title here</title>
    </head>
    <body></body>
  </html>
  ```

## Step4: Models

* Table

  ```java
  @Entity
  @Table(name="categories")
  public class Category {
  }
  ```

* Id

  ```java
  // code ... 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  // code ...
  ```

* Strings

  ```java
  // code ... 
  @Size(min=1, max=20)
  @NotEmpty()
  private String name;
  // code ...
  ```

* Numbers

  ```java
  // code ... 
  @Min(0)
  @Max(150)
  private int age;

  @Min(0)
  private float price;
  // code ...
  ```

* One to One

  ```java
  // code ... // One End (License.java)
  @NotNull
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  private Person person;

  // Other End (Person.java)
  @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private License license;

  // code ...
  ```

* One to Many

  ```java
  // code ... // One Side !
  @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
  private List<Ninja> ninjas;
  // code ...
  ```

* Many to One

  ```java
  // code ... // Many Size
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dojo_id")
  private Dojo dojo;
  // code ...
  ```

* Many to Many

  ```java
  // code ... First End (Product.java)
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  private List<Category> categories;

  // Middle ware (Optional) (CategoryProduct.java (Middle Table))
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  // code ... The other End (Category.java)
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;

  // code ...
  ```

* Timestamps

  ```java
  // code ... 
  @Column(updatable = false)
  private Date createdAt;
  private Date updatedAt;

  // code ...

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }
  // code ...
  ```

## Step5: Repositories

* Create it as interface

* Extend CrudRepository

  ```java
  public interface Repository extends CrudRepository<License, Long> {
  public List<License> findAll();
  }
  ```

## Step6: Controllers

* First Route
  
  ```java
    @RequestMapping("/")
      public String index() {
        return "index.jsp";
      }
  ```

* For using url parameters
  
  ```java
  @RequestMapping("/{id}")
  public String viewPerson(@PathVariable("id") Long id, Model model) {
    model.addAttribute("person", this.personService.getOne(id));
    return "/persons/view.jsp";
  }
  ```

* For using ModelAttribute
  
  ```java
  @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
  public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
    if (result.hasErrors()) {
      return "categories/new.jsp";
    }
    categoryService.create(category);
    return "redirect:/";
  }
  ```
