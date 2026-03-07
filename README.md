# 🏥 MediCore EMR - API
This project serves as the central nervous system of the MediCore healthcare platform. Built from the ground up with high scalability in mind, it currently provides the robust core infrastructure for daily clinic management and patient data operations.
As the platform evolves into a distributed **microservices ecosystem**, this EMR API will act as the foundational hub, seamlessly integrating with upcoming independent modules such as **LIS** (Laboratory Information System) and **PIMS** (Pharmacy Information Management System).

---

## 🚀 Core Domain Features

* 👨‍⚕️ **Patient Management**
* 📅 **Visit Management**
* 📝 **Electronic Medical Records (EMR)**

---

## ⚙️ Tech Stack

<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>
<a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a>
<a href="https://www.postgresql.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg" alt="postgresql" width="40" height="40"/> </a>
<a href="https://hibernate.org/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/hibernate/hibernate-original.svg" alt="hibernate" width="40" height="40"/> </a>
<a href="https://www.liquibase.com/" target="_blank" rel="noreferrer"> <img src="https://dashboard.snapcraft.io/site_media/appmedia/2020/08/liquibase.jpeg.png" alt="liquibase" width="40" height="40"/> </a>

---

## 🛠️ Local Setup (Installation)

Before running the application, ensure you have **Java 21+** installed and a running **PostgreSQL** server.

**1. Clone the repository**
```bash
git clone [https://github.com/your-profile/medicore-emr-api.git](https://github.com/your-profile/medicore-emr-api.git)
cd medicore-emr-api
```

---

## Configure the database
Create an empty database in PostgreSQL (e.g., emr_db). Then, update your src/main/resources/application.properties with your credentials:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/emr_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

---

## Build the Shared Library
You need to clone and install the [medicore-common-lib-api](https://github.com/brexus/medicore-common-lib-api) repository into your local Maven workspace before building the main project:
```bash
# Navigate out of the current project directory
cd ..

# Clone the shared library
git clone [https://github.com/brexus/medicore-common-lib-api](https://github.com/brexus/medicore-common-lib-api)

# Navigate into the library folder and install it
cd medicore-common-lib-api
mvn clean install

# Return to the main API directory
cd ../medicore-emr-api
```

---

## Run the application
Spring Boot will automatically trigger Liquibase to create tables and inject initial data.

