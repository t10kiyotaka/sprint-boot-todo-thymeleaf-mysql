# TODO app with 
- Spring Boot
- Thymeleaf
- MySQL

# How to run
## Run MySQL on Docker
```
docker-compose up -d
```
## Create DB
```
docker exec -it todo-thymeleaf_db_1 bash
mysql -uroot -p
create database demodb;
```

## Run Application 
```
./mvnw spring-boot:run
```
