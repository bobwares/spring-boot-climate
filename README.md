# spring-boot-climate
An application to demonstrate implementation of a simple REST API that performs CRUD operations on a table.  

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
     
## Running Application 

 - Clone the application
 ~~~~
    git clone https://github.com/bobwares/spring-boot-climate.git
 ~~~~
 - Run this project as a Spring Boot app, e.g. import into IDE and run main method, or use Maven:
~~~~
    $ ./mvnw spring-boot:run
    or
    
    $ ./mvnw package
    $ java -jar target/climate.jar
~~~~

 - Execute the REST APIs with curl
~~~~
    Endpoint: get user by id.
        curl localhost:8080/climate-crud-demo/user/1
        
        Should return:
           {"id":1,"name":"ANTHONY KIEDIS","email":"kiedis@rhcp.com","phoneNumber":"555-555-5555","locale":"CA","birthDate":"1962-11-01T06:00:00.000+0000"}

    Endpoint: add user
        
        curl -H "Content-Type: application/json" -X POST  -d @body.json localhost:8080/climate-crud-demo/user
        
        Should return:
           {"id":51,"name":"Chad Smith","email":"chad.smith@climate.com","phoneNumber":"555-555-5555","locale":"CA","birthDate":"1970-11-22T00:00:00.000+0000"}

        Note: body.json is located in the root of the project.
         
~~~~
 - Execute REST APIs with Swagger
   
   Note: I have encountered a problem running this on IE for the version 2.8 of the Spring Fox libraries.   
~~~~
    Endpoint: get user by id.
        Navigate in your browser to http://localhost:8080/climate-crud-demo/swagger-ui.html and click on user-endpoint and then the GET /user/{id} link.
        Click try it, enter value 1 for the id and click execute.
        This should return: 
        {
          "id": 1,
          "name": "ANTHONY KIEDIS",
          "email": "kiedis@rhcp.com",
          "phoneNumber": "555-555-5555",
          "locale": "CA",
          "birthDate": "1962-11-01T06:00:00.000+0000"
        }
        
    Endpoint: add user
        Navigate in your browser to http://localhost:8080/climate-crud-demo/swagger-ui.html and click on user-endpoint and then the POST /user link.
        Click try it, add the JSON to post, and click execute. 
        
        You can use the example below.
                
        {
          "birthDate": "11/22/1970",
          "email": "chad.smith@climate.com",
          "locale": "CA",
          "name": "Chad Smith",
          "phoneNumber": "555-555-5555"
        } 
           
        This should return: 
        {
          "id": 51
          "birthDate": "11/22/1970",
          "email": "chad.smith@climate.com",
          "locale": "CA",
          "name": "Chad Smith",
          "phoneNumber": "555-555-5555"
        }
~~~~


##References

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