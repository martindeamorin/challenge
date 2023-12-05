FROM eclipse-temurin:8-jdk
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests


ENV LANG en_US.UTF-8
ENV LANGUAGE en_US.UTF-8
ENV LC_ALL en_US.UTF-8
ENV TZ="America/Argentina/Buenos_Aires"

EXPOSE 8080
CMD ./mvnw test && java -jar target/weather-0.0.1-SNAPSHOT.jar