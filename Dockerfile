
FROM openjdk:17

# Install MySQL client
RUN apk add --no-cache mysql-client

WORKDIR /app
COPY target/spe-major-backend.jar /app/spe-major-backend.jar
EXPOSE 8081
#ADD target/devops-integration-jar-with-dependencies.jar devops-integration-jar-with-dependencies.jar
CMD ["java","-jar","spe-major-backend.jar"]
