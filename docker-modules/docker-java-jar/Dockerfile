FROM openjdk:17-jdk-alpine
MAINTAINER taketoday.com
COPY target/docker-java-jar-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
