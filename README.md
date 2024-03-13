# Project requirements

- Java 21
- Maven
- Docker
- Postgres (to run locally)

In order to start the application, clone this repository with ```git clone https://github.com/yeeeip/VK-Test-Task``` and open cmd in the root directory of the project. Type ```mvn spring-boot:run``` and wait for the application start in Docker.

If you have updated your docker compose recently, you may encounter the exception that tells you something like that: 
>Cannot invoke "org.springframework.boot.docker.compose.core.DockerCliInspectResponse.hostConfig()" because "inspectResponse" is null

This exception is caused because of docker compose newer versions are incompatible with spring-docker-compose-support dependency

To avoid this exception you should use ```docker compose up``` to start the app without maven.
