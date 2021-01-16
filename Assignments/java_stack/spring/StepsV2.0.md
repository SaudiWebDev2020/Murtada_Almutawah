
# Check List v2.0

## Step1: Start Project

## Step2: Add Configuration

### Packages

* Use JSP

  ```xml
  <dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
  </dependency>
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

### jsp file configs

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
