FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/app-deploy-1.0.0.jar app-deploy-1.0.0.jar
EXPOSE 8080
CMD ["java", "-jar", "app-deploy-1.0.0.jar"]