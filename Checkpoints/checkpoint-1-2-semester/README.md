Java-Checkpoint-Project

This is a school checkpoint project designed to demonstrate the usage of Spring Boot with Docker and MariaDB.
How to Run the Project

You can easily run this project with Docker and Docker Compose. Follow the steps below:
Prerequisites

    Docker
    Docker Compose

Steps to Run

    Clone the repository to your local machine:
    
    git clone https://github.com/WedSan/Java-Advanced-FIAP.git

    cd Checkpoints/checkpoint-1-2-semester


Build and start the containers:

    docker-compose up --build

    The application will be available at http://localhost:8080.

Docker Compose

The docker-compose.yml file is configured to set up both the Spring Boot application and the MariaDB database. It uses environment variables for the database connection, making it easy to configure without modifying the code.

The database is set up with the following credentials:

    Database: wedsan-database
    Username: wedsan
    Password: security-password

Key Pages


Once the application is running, you can visit the following pages:

    User Register Page
        URL: /user/form
        Allows you to register a new user.

    Cities List Page
        URL: /city
        Displays a list of cities stored in the database.

    Add City Page
        URL: /city/form
        Allows you to add a new city to the database.

Admin Login Information (Important)

To log in as ADMIN, use the following credentials:

    Email: admin@thesystem.com
    Password: securitypassword

Database

The application connects to a MariaDB instance running inside Docker. On the first startup, the application will automatically inject an admin user (with username admin and password adminpassword) into the database if it doesn't exist already.


