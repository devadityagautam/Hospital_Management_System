🏥 Hospital Management System (HMS)
A backend-based Hospital Management System built using Spring Boot that manages patients, doctors, appointments, and billing operations with RESTful APIs.

🚀 Features
👤 Patient Management (Create, Update, Delete, View)
👨‍⚕️ Doctor Management
📅 Appointment Scheduling (Patient ↔ Doctor)
💰 Billing System (Patient-wise bills)
🔗 Entity Relationships using JPA (One-to-Many, Many-to-One)
🔄 RESTful APIs tested with Postman

🛠️ Tech Stack
Backend: Spring Boot, Spring Data JPA
Database: MySQL
Tools: IntelliJ IDEA, Postman
Build Tool: Maven
Language: Java

🔗 Relationships
Patient ↔ Appointment → One-to-Many
Doctor ↔ Appointment → One-to-Many
Patient ↔ Bill → One-to-Many

📌 Future Enhancements
🔐 Add JWT Authentication
📊 Dashboard & Analytics
📅 Appointment filtering by date
💳 Payment status (Paid/Unpaid)
🌐 Frontend Integration (React)
