FROM adoptopenjdk:11-jre-hotspot
MAINTAINER taketoday.com

ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]