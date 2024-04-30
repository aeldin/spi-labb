
FROM maven:3.9.6-eclipse-temurin-22 AS build


WORKDIR /app
COPY pom.xml ./
COPY . /app
RUN mvn clean package


FROM eclipse-temurin:22-jre-alpine


WORKDIR /app
COPY --from=build /app/service/target/*.jar ./service.jar
COPY --from=build /app/consumer/target/*.jar ./consumer.jar
COPY --from=build /app/provider/target/*.jar ./provider.jar
CMD ["java", "--module-path", "/app/service.jar:/app/consumer.jar:/app/provider.jar", "-m", "org.example.consumer/org.example.consumer.Main"]
