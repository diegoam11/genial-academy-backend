# Etapa de construcción
FROM ubuntu:latest AS build

# Instala Maven y JDK en la imagen base
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Crea un directorio para la aplicación
WORKDIR /app

# Copia los archivos de la aplicación al directorio de trabajo
COPY . .

# Compila y empaqueta la aplicación usando Maven
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-jdk-slim

# Exponer el puerto 8080 para la API
EXPOSE 8080

# Copia el archivo JAR generado desde la etapa de construcción
COPY --from=build /app/target/backend-genial-academy.jar app.jar

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
