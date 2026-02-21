# ⚙️ JobFinder - Backend API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)

This is the robust, scalable RESTful API that powers the **JobFinder** ecosystem. It handles authentication, job management, application workflows, and data persistence with a focus on security and performance.

🌐 **Frontend Repository:** [JobFinder-Frontend](https://github.com/Raman0tushar/JobFinder-Frontend)

---

## 🚀 Core Features

* **Secure Authentication:** Implementation of JWT (JSON Web Tokens) or Spring Security for protected routes.
* **Role-Based Access Control (RBAC):** Distinct permissions for `JOB_SEEKER` and `EMPLOYER`.
* **Job Management API:** Full CRUD operations for posting and managing job vacancies.
* **Application System:** Endpoints for submitting applications and updating status (Pending, Shortlisted, Rejected).
* **Advanced Filtering:** Server-side search and filtering for job listings.
* **Database Integration:** Powered by MySQL with Hibernate/JPA for Object-Relational Mapping.

---

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot (Web, Data JPA, Security)
* **Database:** MySQL
* **Build Tool:** Maven
* **API Documentation:** Swagger / OpenAPI (Optional)
* **Authentication:** JWT (Json Web Token)

---

## 📂 Project Structure

```text
src/main/java/com/jobfinder/
├── config/          # Security and Bean configurations
├── controller/      # REST Endpoints
├── model/           # JPA Entities (Job, User, Application)
├── repository/      # Spring Data JPA Repositories
├── service/         # Business Logic Layer
└── dto/             # Data Transfer Objects for API requests/responses
