FROM eclipse-temurin:21
WORKDIR /app
COPY target/pizza-vote-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
