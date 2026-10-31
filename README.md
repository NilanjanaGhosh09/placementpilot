# PlacementPilot

A student placement management system built with Java and Spring Boot. It tracks students, companies and job applications through a REST API.

## Features

- Add and view students (name, email, branch, CGPA)
- Add and view companies (location, job role, package)
- Track job applications with a status: APPLIED, SHORTLISTED, SELECTED

## Tech Stack

Java 17, Spring Boot, Spring Data JPA, Hibernate, MariaDB/MySQL, REST API, Maven

## API Endpoints

| Method | Endpoint | What it does |
|--------|----------|--------------|
| GET | /students | List all students |
| POST | /students | Add a student |
| GET | /companies | List all companies |
| POST | /companies | Add a company |
| GET | /applications | List all applications |
| POST | /applications | Add an application |
| PUT | /applications/{id}/status | Update an application status |

## Run it

1. Create a database named `placementpilot`
2. Set the database username and password in `src/main/resources/application.properties`
3. Run `mvn spring-boot:run`
4. Open `http://localhost:8080/students`

## Author

Nilanjana Ghosh
