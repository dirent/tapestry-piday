# Tapestry Pi Day 2020

Searching for digits in Pi, inspired from [The Coding Traing](https://youtu.be/AkySW5uy7rU)

Implemented with [Spring-Boot](https://spring.io/spring-boot) and [Tapestry](https://tapestry.apache.org)

## Instructions

Download digits of pi, e.g. from [archive.org](https://archive.org/details/Math_Constants)

Set path to digits file in
[application.properties](src/main/resources/application.properties)
```
piday.pathtodigits=[insert_your_path]
```

Start development environment
```
./mvnw spring-boot:dev
```

Open in [browser](http://localhost:8080/)