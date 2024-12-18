FROM openjdk:21-jdk-slim AS build
WORKDIR /app

COPY --chown=gradle:gradle . .

RUN ./gradlew bootjar

FROM amazoncorretto:21

COPY --from=build /app/build/libs/EventGather-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
