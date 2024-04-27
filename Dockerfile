FROM ubuntu:latest
LABEL authors="egorgladkikh"
FROM arm64v8/openjdk:23-slim-bullseye

WORKDIR /app
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]

ENTRYPOINT ["java","-jar","/app/demo-0.0.1-SNAPSHOT.jar"]