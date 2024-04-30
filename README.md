# Electric Scooter Renting Application

This project is the final test submission for the Java Web Development course at FTN Informatika. 
The Electric Scooter Renting Application is a Spring Boot-based REST API designed to manage electric scooters.
It utilizes various Spring modules such as Spring Security, Spring Data JPA, and Spring Web to provide a robust solution for scooter rental management.

## Project Overview

The Electric Scooter Renting Application primarily focuses on three main entities:

1. **Adresa**: Defines the location of electric scooters.
2. **Trotinet**: Represents the electric scooter.
3. **Rezervacija**: Contains information about scooter reservations.

## Features

- **CRUD Operations**: The application provides endpoints for creating, reading, updating, and deleting scooter entities.
- **Spring Security**: Implements authentication and authorization to secure the API endpoints.
- **MySQL Database**: Utilizes MySQL for data storage, providing a reliable and scalable solution.
- **Service Repository Layers**: Follows a layered architecture with service and repository layers for separation of concerns.
- **Data Transfer Objects (DTOs)**: Implements DTOs for efficient data transfer between layers.

## Usage

### Prerequisites

- Maven
- MySQL

### Setup

1. Clone the repository:
`git clone https://github.com/mirko0/ElectricScooterRentingApplication.git`
2. Navigate to the project directory:
`cd ElectricScooterRentingApplication`
3. Update the `application.properties` file with your MySQL database configurations.
4. Run the application

