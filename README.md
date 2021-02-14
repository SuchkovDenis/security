# HH Security

Демонстрация уязвимости SQL Injection и XSS для приложения на Spring Boot + Hibernate для школы программистов HeadHunter

## Requirements

- Java 11
- Docker

## Запуск

Поднятие базы данных Postgres:

```
cd docker
docker-compose up
```

Запуск приложения Spring Boot:

```
./mvnw spring-boot:run
```

## API

### SQL Injection

Получение списка вакансий по названию (параметр `title` не обязателен)

```
http://localhost:8080/vacancy?title=Грузчик
```

### XSS

Главная страница

```
http://localhost:8080
```

Страница создания вакансии

```
http://localhost:8080/add
```
