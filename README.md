# Spring AI GPT

## Overview
Spring AI GPT is a Java-based REST API built with Spring Boot that exposes a simple jokes API. The codebase implements a JokeController with a /top-10/cities/indian%20food and ne-liner-joke/dad%20joke endpoint that returns a sample joke string. The system uses externalized templates for prompts to help format AI interactions. The prompts are managed in the template files.

## Endpoints
- GET /api/joke/random - returns a joke string (sample)

## Sample Response
Why did the developer go broke? Because he used up all his cache.

## Templates and Prompt Externalization
Prompts and templates are stored outside the application logic in src/main/resources/templates (e.g., dad_joke.st, top10.st). These templates are used to format prompts for AI interactions and can be edited without touching Java code.

## Build and Run
- Build: mvn clean install
- Run: mvn spring-boot:run
- Access: http://localhost:8080/one-liner-joke/dad%20joke
- http://localhost:8080/top-10/cities/indian%20food

## Code Structure
- JokeController.java (package com.dev.spring_ai_gpt)
- SpringAiGptApplication.java (Spring Boot entry point)

## Testing
- mvn test
- mvn -Dtest=*Joke* test

## Observability
- No observability configured in this baseline. Consider adding metrics, logs, and tracing in future iterations.

## License
This project is licensed under the MIT License.

---
Note: This README reflects the current code path implemented in JokeController. Additional endpoints and features can be added in future iterations.