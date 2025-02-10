# dstore-products

DStore products is API service to products management.

---

## Table of Contents

<!-- vscode-markdown-toc -->
- 0. [Introduction](#introduction)
  - 0.1. [Tecnologies](#tecnologies)
- 1. [Application Files](#application_files)
- 2. [Contributors](#contributors)
- 3. [Next Steps](#next_steps)

## 0. <a name='introduction'></a>Introduction

This project is based on RESTFul Api applying the MVC patterns. The scope is related to products store creation, and only has a basic CRUD with additional functionalities of:

1. List Products
2. Get Product Details
3. Create Product
4. Update Product
5. Delete a Product
6. Find a product by Id
7. Find a product by name.


## 0.1 <a name='tecnologies'></a>Tecnologies.

* Spring Boot framework with Kotlin.
* Swagger to document the API, however, generated automatically with a Springdoc.
* PostgreSQL to the database.
* Docker and Docker Compose.
* Tests: JUnit 5 and Spring MockMvc, Mockk

## 1. <a name='application_files'></a>Application files
    .src/main/kotlin
    ├── /com/dstore/product/kotlin      # Code files.
    │   ├── controller                  # API Controllers.
    │   ├── model                       # Entities
    │   ├── dto                         # Data Transfer Object, data structure and validation.
    │   ├── exception                   # Error Handlers.
    │   ├── mappers                     # Data transformation layer.
    │   ├── repository                  # Database Interface Access (Spring Data JPA)
    │   ├── service                     # Business Logic.
    │   └── ProductApplication.kt       # Main Spring Boot App
    ├── /com/dstore/product/resources   # Project configuration files.
    │   ├── static                      # Migrations.
    │   ├── templates                   # Templates.
    │   └── application.properties      # Application configuration such as database.
    └── README.md


---

## 2. <a name='contributors'></a>Contributors

> Claudio Djohnnatha Duarte Lourenço ([cdjohnnatha](https://github.com/cdjohnnatha)) cdjohnnatha@gmail.com

## 3. <a name='next_steps'></a>Next Steps

To improve a bit more this project it would be nice to have:

* Soft Delete
* Create tests at controller layer.
* Update find by name to find elements with similar names, not only matching exact the name.

---
