FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/dronedemo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} all.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/all.jar"]