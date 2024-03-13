FROM openjdk:21-slim as build

WORKDIR /app
COPY /src ./src
COPY pom.xml ./pom.xml
COPY .mvn ./.mvn
COPY mvnw ./

RUN ./mvnw clean package -Dmaven.test.skip

FROM build

ENTRYPOINT ["java", "-jar", "target/VK-Test-Task-1.0.jar"]