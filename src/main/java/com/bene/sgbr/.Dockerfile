# ===== Build stage =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# copia arquivos de build primeiro (melhora cache)
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw -q -DskipTests dependency:go-offline

# agora copia o resto e builda
COPY src src
RUN ./mvnw -q -DskipTests package

# ===== Run stage =====
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Render injeta PORT; expor 8080 é ok
EXPOSE 8080

# roda usando a porta do Render
CMD ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT:-8080}"]
