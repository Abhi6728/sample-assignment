# Request Processing System

A Spring Boot application that demonstrates:
- REST API for submitting and retrieving job requests
- Persistence with MySQL for user authentication and job storage
- Spring Security with Basic Auth and BCrypt password encoding
- Redis caching for fast retrieval of job requests
- Scheduled tasks that asynchronously post queued jobs to an external API
- Centralized error handling with @RestControllerAdvice
- Unit tests with JUnit 5 and MockMvc
- Dockerized deployment
