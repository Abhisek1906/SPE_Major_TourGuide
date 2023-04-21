
FROM openjdk:17
COPY ./target/SPE-MAJOR.jar ./
WORKDIR ./
#ADD target/devops-integration-jar-with-dependencies.jar devops-integration-jar-with-dependencies.jar
CMD ["java","-jar","/SPE-MAJOR.jar"]