# Spring Boot SQL Solver

A Spring Boot application that automatically solves SQL problems and submits solutions via webhook on startup.

## Project Overview

This application is built using Spring Boot. On startup, it automatically:

- Sends a POST request to generate a webhook
- Solves a SQL problem based on the registration number
- Submits the final SQL query to the webhook using JWT authorization

## Tech Stack

- **Java, Spring Boot**
- **RestTemplate/WebClient**
- **JWT** (for Authorization header)

## Project Structure

```
src/main/java/com/example/sqlsolver/
├── SqlSolverApplication.java        # Main Spring Boot application
├── config/
│   └── RestTemplateConfig.java     # HTTP client configuration
├── model/
│   ├── WebhookResponse.java        # API response model
│   └── SubmitRequest.java          # Submission request model
├── service/
│   ├── WebhookService.java         # Webhook generation
│   ├── QuestionService.java        # SQL problem solving
│   └── SubmissionService.java      # Final submission
└── runner/
    └── StartupRunner.java          # Application startup flow
```

## How It Works

The application follows this step-by-step flow:

1. **On startup**, POST request generates webhook + access token
2. **SQL problem is selected** based on regNo last two digits
3. **Final SQL query is submitted** to the webhook with JWT

## Build & Run

### Commands to build:
```bash
mvn clean package
```

### Commands to run JAR:
```bash
java -jar target/sql-solver-0.0.1-SNAPSHOT.jar
```

## Deliverables

- **Public GitHub repo link**: `https://github.com/manno198/spring-boot-sql-solver.git`
- **Downloadable JAR file link**: `https://github.com/manno198/spring-boot-sql-solver/releases/download/v1.0.0/sql-solver-0.0.1-SNAPSHOT.jar`

---

*Built with Spring Boot and Java*
