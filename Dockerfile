FROM openjdk:17

WORKDIR /app

COPY target/spe-major-backend.jar /app/spe-major-backend.jar

EXPOSE 8081

# Run the application
CMD ["java", "-jar", "spe-major-backend.jar"]