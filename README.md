# Microservices
Spring Boot Microservices project using Eureka Server, MySQL, and Docker for service discovery and containerized deployment.

🚀 Microservices Project with Spring Boot, Eureka & Docker
📌 Overview

This project demonstrates a Microservices Architecture using:

Spring Boot
Eureka Server (Service Discovery)
MySQL Database
Docker & Docker Compose

It consists of multiple services communicating with each other and registered via Eureka.

🏗️ Architecture
Services included:
Eureka Server → Service registry
Student Service → Handles student data
Course Service → Handles course data
MySQL Database → Stores data


⚙️ Tech Stack
Java 17
Spring Boot
Spring Cloud (Eureka)
MySQL
Docker
Maven


📂 Project Structure
Microservices/
│
├── eureka-server/
├── student-service/
├── course-service/
├── docker-compose.yml
🐳 Docker Setup

Build & Run
docker-compose up --build
Stop Services
docker-compose down

🔗 Service Ports
Service	Port
Eureka Server	8082
Student Service	8080
Course Service	8081
MySQL	3307

🌐 Eureka Dashboard

Access Eureka dashboard:

http://localhost:8082

👉 You will see:

student-service
course-service
🛠️ Configuration Notes
✅ Important

Inside Docker:

mysql → database host
eureka-server → service registry
Do NOT use localhost inside Docker
Example DB Config
spring.datasource.url=jdbc:mysql://mysql:3306/student1_db
spring.datasource.username=root
spring.datasource.password=123

🔄 Service Communication
Services register with Eureka
Use service names for communication

Example:

http://student-service:8080

🔹 Eureka Dashboard
<img width="1842" height="824" alt="Screenshot 2026-04-08 165451" src="https://github.com/user-attachments/assets/3b0e3577-265b-4277-a1ca-0aad9dff5ed9" />


🔹 Docker Running Containers
<img width="1919" height="1020" alt="Screenshot 2026-04-08 165536" src="https://github.com/user-attachments/assets/7d86f733-4afd-492f-86a5-cf7d45b2a78a" />
