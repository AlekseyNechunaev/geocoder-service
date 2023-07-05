FROM gradle:7.4.0-jdk17
ARG JAR_FILE=build/libs/geocoder-service.jar
COPY ${JAR_FILE} geocoder-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "geocoder-service.jar"]