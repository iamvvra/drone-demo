FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/drone-demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} drone-demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/drone-demo.jar"]