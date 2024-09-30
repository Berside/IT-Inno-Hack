FROM openjdk:17

WORKDIR /project

COPY backend/mvnw .
COPY backend/.mvn .mvn
COPY backend/pom.xml .
COPY backend/src src

RUN ./mvnw -B package -DskipTests

EXPOSE 7070

RUN cp /project/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
