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


**1. Download a the .zip archive of the project files**

**2. Run the application**

Open SpringBootProject-0.0.1-SNAPSHOT.jar file from the root directory. Open cmd or bash terminal and run jps command to see if the application is running:

```
jps
```

**3. Exit the application**

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

**1. Clone the application**

Clone the application:

```
git clone https://github.com/dovydasglb/SpringBootAPI.git
```
**2. Run the application**

Open a bash terminal in project folder and run:

```
mvn spring-boot:run
```

By default this will run the application on <http://localhost:8080>.
</details>

## Making REST API requests

This application allows basic CRUD queries to persist customer data into the database and also queries to find customer details by name. You can create JSON requests using tools such as Postman or Swagger.

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

Use the default login details using `sa` as user name and blank password and default JDBC URL `jdbc:h2:mem:testdb` and click Connect.

<p align="center">
<img src=https://i.postimg.cc/0j8DW5HS/Opera-Snapshot-2022-03-16-105252-localhost.png>
</p>

If encountering any issues, check Spring Boot console for any information. If the launch was successful, you should see a message similar to: `H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'`.

You can run SQL queries within the H2 console to retrieve and display the data, such as `SELECT * FROM CUSTOMERS`

<p align="center">
<img src=https://i.postimg.cc/Ss4MRN4P/Opera-Snapshot-2022-03-16-105221-localhost.png>
</p>

### MySQL database setup

## Testing

Main test coverage 83%.