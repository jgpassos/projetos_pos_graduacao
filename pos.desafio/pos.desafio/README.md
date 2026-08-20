API de Clientes

API REST desenvolvida em Java + Spring Boot, seguindo a arquitetura MVC, com persistência utilizando Spring Data JPA e H2.

Tecnologias
Java
Spring Boot
Spring Data JPA
H2 Database
Lombok
OpenAPI / Swagger
Documentação da API

A documentação dos endpoints está disponível através do Swagger:

Swagger UI: http://localhost:8080/swagger-ui/index.html

Principais operações
POST /v1/customers — Criar cliente
GET /v1/customers — Listar clientes
GET /v1/customers/{id} — Buscar cliente por ID
GET /v1/customers/search?name={name} — Buscar clientes por nome
GET /v1/customers/count — Consultar quantidade de clientes
PUT /v1/customers/{id} — Atualizar cliente
DELETE /v1/customers/{id} — Excluir cliente