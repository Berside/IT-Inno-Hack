FROM openjdk:17

ARG JAR_FILE=/target/*.jar

EXPOSE 7070

WORKDIR /project

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]