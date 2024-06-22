FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} st_questionbank.jar
ENTRYPOINT ["java","-jar","st_questionbank.jar"]
