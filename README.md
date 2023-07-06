# Assignment
This project implements a backend REST API with user login and signup functionality. It uses Spring Boot framework, MySQL database for data storage, and JSON Web Tokens (JWT) for authentication and authorization.

## Features
- User signup: Allows users to create new accounts and securely store their information in the MySQL database.
- User login: Verifies user credentials and generates a web token (JWT) upon successful authentication.
- Security and web tokens: Implements appropriate security measures to protect user data and prevent unauthorized access.
- JWT authentication: Uses JSON Web Tokens for user authentication and authorization.
- Database storage: Utilizes the MySQL database to securely store user account information.

## Tech Stack
- Java
- Hibernate
- Spring Framework
- Spring Boot with JPA
- MySQL
- Maven
- Lombok

## Installation
git clone https://github.com/Kapil7982/Assignment.git

## MySql database details

Install and connect with the database

```bash
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:8888/green
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=port
```
## Dependencies
The project uses the following major dependencies:

- Spring Boot
- Spring Security
- MySQL Connector
- JSON Web Tokens (JWT)

## Testing the API:

- Use an API testing tool like Postman or Swagger-UI to send requests to the API endpoints.
- You can start by creating a new user account using the /signup endpoint and then use the /login endpoint to authenticate and obtain a JWT.
- Include the JWT token in the Authorization header of subsequent requests to access protected resources.

# After running the application just hit the below URL to check the API's.
http://localhost:8888/swagger-ui/index.html

## Swagger-UI
![WhatsApp Image 2023-05-17 at 3 44 21 PM](https://github.com/Kapil7982/GreenStitch/assets/103938868/00255cb5-43a7-4ccf-b7ec-8778f769d289)

![image](https://github.com/Kapil7982/GreenStitch/assets/103938868/2cd24cf6-1bb3-42fe-996f-ab19d6e368ce)

