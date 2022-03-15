# Rest API using Spring Boot, MySQL, H2 and JPA

This application builds a simple REST API with CRUD functionality which persists customer details in a database.

The project showcases the use of Spring Boot, MySQL, H2 Database, JPA Data, Input Validation, Spring Web, Lombok, JUnit and Mockito tools to create a REST API application.

The application allows for interaction with the database using web requests in JSON format using tools such as Postman or Swagger.

## Application Setup

You can run this application either by cloning this repository and executing the application .jar file or by running the application on your IDE.

By default, the application will run in test mode which connects to the H2 database. You can change this by modifying application properties file (explained in database setup section).

<details>
<summary>**Run the application as a .jar file**</summary>
**1. Download a .zip of the project files**

Download the zip archive of the project files.

**2. Run the application**

Open SpringBootProject-0.0.1-SNAPSHOT.jar file from the root directory. Open cmd or bash terminal and run jps command to see if the application is running:

```bash
jps
```

**3. Exit the application**

To exit the application, run jps command in terminal again:

```bash
jps
```

Check the running application's ID and run taskkill command with the <ID>:

```bash
taskkill -f /PID <Your application's ID here>
```

This will terminate the application
</details>


**1. Clone the application**

Clone the application or download a .zip

```bash
git clone https://github.com/dovydasglb/SpringBootAPI.git
```
**2. **