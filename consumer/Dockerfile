FROM openjdk:17-jdk-slim

WORKDIR /app

COPY consumer/build/libs/consumer-0.0.1-SNAPSHOT.jar app.jar

ENV SOCKET_EVENT_BUS_PORT=${SOCKET_EVENT_BUS_PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]