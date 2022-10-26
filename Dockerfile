FROM openjdk:8-jdk-alpine
COPY target/twelve_factor_microservice-0.0.1-SNAPSHOT.jar twelve_factor-0.0.1.jar
ENTRYPOINT ["java","-jar","/twelve_factor-0.0.1.jar"]