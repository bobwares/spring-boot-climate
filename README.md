# spring-boot-climate
A simple application to demonstrate implement a simple REST API to perform CRUD operations on a table.  

- Technology Stack:
    - Spring Boot 2.0
    - Spring 5
        - Spring MVC
        - Spring Data JPA
        - Spring Validation
    - Java 8
    - Hibernate Validator with support for JSR 380 - Bean Validation 2.0
    - Flyway
    - JUnit 5
    - Mockito
    - H2 in Memory Database
    - Lombok
    - Swagger
     
# Running Application 

Clone app
build app
run app
test




curl localhost:8080/climate-crud-demo/user/1

    
# Post Data
~~~~
    {
      "birthDate": "11/22/1970",
      "email": "chad.smith@climate.com",
      "locale": "CA",
      "name": "Chad Smith",
      "phoneNumber": "555-555-5555"
    }    
~~~~


#References
- Bean Validation 2.0
    - http://beanvalidation.org/2.0/
    - [Hibernate Validator 6.0.8](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#preface)
    - http://andreinc.net/2017/10/02/writing-an-unified-validation-mechanism-for-rest-apis-using-spring-boot-and-jsr-380/
    - [Java Bean Validation Basics](http://www.baeldung.com/javax-validation)
    
- Junit 5
    - [Run JUnit 5 with Spring Boot Applications](https://howtoprogram.xyz/2017/09/12/junit-5-spring-boot-example/)
    - [Using JUnit 5 with Spring Boot 2, Kotlin and Mockito](https://medium.com/@dSebastien/using-junit-5-with-spring-boot-2-kotlin-and-mockito-d5aea5b0c668)
    - [Mockito and JUnit 5 – Using ExtendWith](http://www.baeldung.com/mockito-junit-5-extension)
    - [How to use Mockito with JUnit5](https://stackoverflow.com/questions/40961057/how-to-use-mockito-with-junit5?noredirect=1&lq=1)