# Besant Technology Course Registration System
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; This application is a robust and user-friendly Full-Stack Course Registration System designed to streamline course enrollment and management for Besant Technology(where I completed my Full stack coourses). 
 This application integrates a dynamic frontend with a scalable Spring Boot backend, emphasizing clean architecture, data validation, and seamless user interaction.

## Tech Used
- Front-end (HTML5, CSS3, JS)
- Backend (Java 21, Spring/SpringBoot, Spring Data JPA, MySQL Driver, Lombok, Bean Validation)
- Database (MySQL)

 ## Overview
 This project enables users to:
- Register for available courses through an intuitive, responsive form.
- Browse and view detailed information about available courses.
- Review and manage enrolled courses with real-time updates.

The system is engineered with best practices in both frontend and backend development to ensure maintainability, performance, and scalability.

## Frontend
- Responsive and accessible UI featuring navigation, forms, and data tables.
- Dynamic content rendering powered by asynchronous fetch API calls to backend services.
- Client-side validation coupled with user-friendly alert messages for successful submissions or errors.
- Interactive features such as deletion of enrolled course entries without page reload.
- Utilizes Font Awesome for clean, modern iconography.

# Backend
- Implements a RESTful API with a Controller-Service-Repository layered architecture for modularity and testability.
- Uses Data Transfer Objects (DTOs) to enforce strict input validation and maintain data integrity.
- Robust server-side validation using Jakarta Bean Validation annotations and custom logic (e.g., regex-based email validation, mobile number length checks).
- Duplicate user prevention by verifying unique email and mobile number combinations before registration.
- Configured CORS policy to enable secure cross-origin requests from the frontend.
- Data persistence with MySQL, seamlessly integrated through Spring Data JPA.
- Comprehensive error handling providing meaningful HTTP status codes and descriptive messages.

# Database
- This project uses Spring Data JPA, which simplifies database operations by abstracting most of the SQL queries using Hibernate ORM.
- For local development and testing, database connection details were provided in the application.properties file.
- These include essential credentials such as:
  - HOST_NAME
  - PORT
  - DB_USERNAME
  - DB_PASSWORD
- Before committing the project to GitHub, all sensitive credentials were removed and replaced with dummy placeholders to prevent exposure.
- You must update these placeholders with your actual local MySQL credentials to run the backend on your machine.

# Steps to Implement locally
- Clone the repository >> Create a DB on ur machine >> Update application.properties with your actual DB credentials.
