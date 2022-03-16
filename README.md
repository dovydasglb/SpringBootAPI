# Rest API using Spring Boot, MySQL, H2 and JPA

This application builds a simple REST API with CRUD functionality which persists customer details in a database.

The project showcases the use of Spring Boot, MySQL, H2 Database, JPA Data, Input Validation, Spring Web, Lombok, JUnit and Mockito tools to create a REST API application.

The application allows for interaction with the database using web requests in JSON format using tools such as Postman or Swagger.

The API uses multi-tier architecture and uses data transfer objects to decouple service layer from the database layer.

<p align="center">
<img src=https://i.postimg.cc/g2QZ8HV1/ERD-and-flow-drawio.png>
</p>

## Application Setup

You can run this application either by cloning this repository and executing the application .jar file or by running the application on your IDE.

By default, the application will run in test mode which connects to the H2 database. You can change this by modifying application properties file (explained in database setup section).

<details>
<summary><b>Run the application as a .jar file</b></summary>

Download the .zip archive of the project files

Open SpringBootProject-0.0.1-SNAPSHOT.jar file from the root directory. Open cmd or bash terminal and run jps command to see if the application is running:

```
jps
```

To exit the application, run jps command in terminal again:

```
jps
```

Check the running application's ID and run taskkill command with the ID:

```
taskkill -f /PID <Application ID here>
```

This will terminate the application.
</details>

<details>
<summary><b>Run the application from your IDE</b></summary>

Clone the application:

```
git clone https://github.com/dovydasglb/SpringBootAPI.git
```

Open a bash terminal in project folder and run:

```
mvn spring-boot:run
```

By default this will run the application on <http://localhost:8080>.

</details>

## Making REST API requests

This application allows basic CRUD queries to persist customer data into the database and also queries to find customer details by id, first name and last name. You can create JSON requests using tools such as Postman or Swagger.

Swagger's interface detailing the API's REST requests can be accessed through <http://localhost:8080/api>.

<p align="center">
<img src=https://i.postimg.cc/855DPd2n/Opera-Snapshot-2022-03-15-162952-localhost.png>
</p>

## Sample JSON requests

The API uses field validation and will return custom error messages if incorrect JSON body is passed on.

Field validations include:

+ All fields are required
+ First name and last name length between 2 and 30 characters
+ Valid UK post code structure and length
+ Valid email address structure

All fields are of string data type.

<p align="center">
<img src=https://i.postimg.cc/W4HhqQKM/Postman.jpg>
</p>

### Some valid JSON bodies for API exploration:

```
{
"firstName":"Albert",
"lastName":"Einstein",
"emailAddress":"einstein@gmail.com",
"postCode":"EC1 2AA"
}
```

```
{
"firstName":"Charles",
"lastName":"Darwin",
"emailAddress":"darwin@mail.com",
"postCode":"SW2 5JZ"
}
```

```
{
"firstName":"Nicola",
"lastName":"Tesla",
"emailAddress":"tesla@tesla.com",
"postCode":"NW2 5AS"
}
```

```
{
"firstName":"Charles",
"lastName":"Dickens",
"emailAddress":"dickens@gmail.com",
"postCode":"RH2 2EE"
}
```

```
{
"firstName":"Alfred",
"lastName":"Dickens",
"emailAddress":"adickens@mail.com",
"postCode":"SW1 4AD"
}
```

## Database setup

By default, this application uses create-drop schema settings. This will use Hibernate to create a new schema when the application is started and to drop it when application is terminated.

### H2 database console

H2 database can be accessed through the H2 console at <http://localhost:8080/h2-console>

Use the default login details using `sa` as user name and blank password. Use default JDBC URL `jdbc:h2:mem:testdb` and click Connect.

<p align="center">
<img src=https://i.postimg.cc/0j8DW5HS/Opera-Snapshot-2022-03-16-105252-localhost.png>
</p>

If encountering any issues, check Spring Boot console for any information. If the launch was successful, you should see a message in your console similar to: `H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'`.

You can run SQL queries within the H2 console to retrieve and display the data, such as:
 ```
 SELECT * FROM CUSTOMERS
 ```

<p align="center">
<img src=https://i.postimg.cc/Ss4MRN4P/Opera-Snapshot-2022-03-16-105221-localhost.png>
</p>

### MySQL database setup

Alternatively, you can connect the application to MySQL database.

Go to `src/main/resources/application.properties` and change the active profile to `spring.profiles.active=dev`.

Then go to `src/main/resources/application-dev.properties` and change `spring.datasource.username=root` and `spring.datasource.password=root` to access your MySQL server.

Open cmd or bash terminal and run mysq command to login. Change `root` to your username if different:

```
mysql -u root -p
```

To create active database run the following in your terminal:

```
create database springbootproject;
```

```
use springbootproject;
```

You can now use your REST API requests to persist data into your MySQL database.

## Testing

The application uses unit and integration tests to ensure code base integrity. Main test coverage is 82.9%.

<p align="center">
<img src=https://i.postimg.cc/d3HTtbJZ/Tests.jpg>
</p>

## Project management and documentation

This application was built adhering to the Agile software development methodology. Jira board was used to plan and organise project activities. The project was completed in a 10-day Sprint for my software development academy final project.

<p align="center">
<img src=https://i.postimg.cc/VsFKygbj/Opera-Snapshot-2022-03-16-120621-dovydasgulbinas-atlassian-net.png>
</p>

<p align="center">
<img src=https://i.postimg.cc/d1YjpZsH/Opera-Snapshot-2022-03-16-120648-dovydasgulbinas-atlassian-net.png>
</p>

<p align="center">
<img src=https://i.postimg.cc/fysbXX7N/Riskassessment.jpg>
</p>

<p align="center">
<img src=https://i.postimg.cc/XNxWxT4F/Riskmatrix.jpg>
</p>