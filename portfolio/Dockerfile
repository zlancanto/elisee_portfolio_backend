# Étape 1 : Build de l'application avec Gradle
FROM gradle:8.11-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
# On génère le .jar
RUN gradle build -x test --no-daemon

# Étape 2 : Image finale légère pour l'exécution
FROM openjdk:25-slim-bookworm
WORKDIR /app
# On récupère le jar généré à l'étape précédente
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
# Port par défaut pour Render
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]