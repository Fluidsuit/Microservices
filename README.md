# 🚀 Microservices Project
Spring Boot Microservices project using Eureka Server, MySQL, and Docker for service discovery and containerized deployment.
---

## 📌 Overview
This project demonstrates a **Microservices Architecture** using:
- Spring Boot  
- Eureka Server (Service Discovery)  
- Feign Client (Service-to-Service Communication)  
- MySQL Database  
- Docker & Docker Compose  
It consists of multiple services communicating with each other and registered via Eureka.
---

## 🏗️ Architecture
### 🔹 Services Included
- **Eureka Server** → Service registry  
- **Student Service** → Handles student data  
- **Course Service** → Handles course data  
- **MySQL Database** → Stores data  
---

## ⚙️ Tech Stack
- Java 17  
- Spring Boot  
- Spring Cloud (Eureka)  
- Spring Cloud OpenFeign (Service-to-Service calls)  
- Spring Data JPA (Repository layer)  
- MySQL  
- Docker  
- Maven  
---

## 📂 Project Structure
```bash
Microservices/
│
├── eureka-server/
├── student-service/
│   └── src/main/java/.../
│       ├── controller/
│       ├── model/          ← @Entity (JPA)
│       ├── repository/     ← extends JpaRepository
│       └── service/
├── course-service/
│   └── src/main/java/.../
│       ├── controller/
│       ├── model/          ← @Entity (JPA)
│       ├── repository/     ← extends JpaRepository
│       ├── service/
│       └── feign/          ← StudentClient (Feign Client)
├── docker-compose.yml
```

Build & Run
docker-compose up --build
Stop Services
docker-compose down
Stop and remove volumes (clears MySQL data)
docker-compose down -v

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

🔗 API Endpoints
Student Service — http://localhost:8080
Method	Endpoint	Description
GET	/students	Get all students
GET	/students/{id}	Get student by ID
POST	/students	Add a new student
DELETE	/students/{id}	Delete a student
Course Service — http://localhost:8081
Method	Endpoint	Description
GET	/courses	Get all courses
GET	/courses/{id}	Get course by ID
POST	/courses	Add a new course
GET	/courses/{id}/student	Get course + student info (Feign call)

🧪 Sample Requests
Add a student
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{"name": "Rahul Sharma", "email": "rahul@example.com"}'
Add a course
curl -X POST http://localhost:8081/courses \
  -H "Content-Type: application/json" \
  -d '{"title": "Spring Boot", "studentId": 1}'
Get course with student info (Feign call in action)
curl http://localhost:8081/courses/1/student
🛠️ Configuration Notes

✅ Important
Inside Docker:
mysql → database host
eureka-server → service registry
Do NOT use localhost inside Docker
Example DB Config
spring.datasource.url=jdbc:mysql://mysql:3306/student_db
spring.datasource.username=root
spring.datasource.password=123

🔄 Service Communication
Services register with Eureka
Feign Client looks up service name from Eureka
No hardcoded URLs — just service names
Example Feign flow:
Course Service → asks Eureka → "Where is STUDENT-SERVICE?"
Eureka → returns actual IP:port
Feign → makes HTTP call automatically

🗄️ Database Info
Each service has its own separate database:
Service	Database Name
Student Service	student_db
Course Service	course_db
Both run inside the same MySQL container.
In production, each service would have its own database server.

🔹 Eureka Dashboard
<img width="1842" height="824" alt="Screenshot 2026-04-08 165451" src="https://github.com/user-attachments/assets/3b0e3577-265b-4277-a1ca-0aad9dff5ed9" />
🔹 Docker Running Containers
<img width="1919" height="1020" alt="Screenshot 2026-04-08 165536" src="https://github.com/user-attachments/assets/7d86f733-4afd-492f-86a5-cf7d45b2a78a" />
