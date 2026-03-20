# ────────────────────────────────────────────────
# Stage 1: Build the application
# ────────────────────────────────────────────────
FROM maven:3.9.9-eclipse-temurin-17-alpine AS builder

WORKDIR /app

# Copy entire project (avoids missing file errors)
COPY . .

# Build JAR
RUN mvn clean package -DskipTests

# ────────────────────────────────────────────────
# Stage 2: Run the application
# ────────────────────────────────────────────────
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy built JAR
COPY --from=builder /app/target/*.jar app.jar

# Render uses dynamic port
EXPOSE 10000

# Start application (correct ENTRYPOINT)
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]