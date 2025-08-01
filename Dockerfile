FROM ubuntu:latest
LABEL authors="oouta"

# 1. Build stage
FROM openjdk:17-jdk-slim AS build
WORKDIR /app

# Copy Maven wrapper and pom
COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copy the source and compile
COPY src src
RUN ./mvnw clean package -DskipTests -B

# 2. Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Pull in the fat JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose your Spring Boot port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
