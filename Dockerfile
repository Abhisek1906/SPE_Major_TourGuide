
FROM openjdk:17
COPY ./target/spe-major-backend.jar ./
WORKDIR ./
#ADD target/devops-integration-jar-with-dependencies.jar devops-integration-jar-with-dependencies.jar
CMD ["java","-jar","/spe-major-backend.jar"]