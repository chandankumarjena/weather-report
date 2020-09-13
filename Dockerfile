FROM openjdk:8
ADD target/weather-report.jar weather-report.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","weather-report.jar"]