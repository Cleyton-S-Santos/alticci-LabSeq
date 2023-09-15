FROM maven:3.8.4-openjdk-17-slim
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package
RUN mvn clean

EXPOSE 8081
COPY target/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]