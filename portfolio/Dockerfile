# Étape 1 : Build avec une version de Gradle plus récente (9.0)
FROM gradle:9.0-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
# On utilise le wrapper gradle du projet s'il existe, sinon gradle direct
RUN gradle build -x test --no-daemon

# Étape 2 : Image finale légère
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]