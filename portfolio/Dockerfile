# Étape 1 : Build avec Gradle
FROM gradle:8.11-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon

# Étape 2 : Image finale (Changement ici)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# On utilise un wildcard pour attraper le jar quel que soit son nom exact
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]