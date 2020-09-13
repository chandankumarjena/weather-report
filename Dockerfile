# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

# Refer to Maven build -> finalName
ARG JAR_FILE=target/weather-report.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","weather-report.jar"]