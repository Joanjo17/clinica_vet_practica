# -- Construcción --
# Usa una imagen de Maven con Java 21
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# Copia los archivos del proyecto a la imagen
COPY pom.xml .
COPY src ./src

# Compila el proyecto y genera el JAR
RUN mvn clean package -DskipTests


# -- Despliegue --
# Usa una imagen ligera de OpenJDK 21
FROM openjdk:21-jdk-slim
# Copia el JAR generado en la etapa de construcción a esta nueva imagen
COPY --from=build /app/target/ClinicaVeterinaria-0.0.1-SNAPSHOT.jar app_veterinaria.jar

# Expone el puerto por el que la aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor inicie
ENTRYPOINT ["java","-jar","/app_veterinaria.jar"]