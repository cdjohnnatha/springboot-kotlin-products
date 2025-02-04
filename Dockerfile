# Use the official OpenJDK 23 image
FROM eclipse-temurin:23-jdk
LABEL authors="cdjohnnatha"

# Set the working directory inside the container
WORKDIR /app

# Copy build files from Gradle or Maven
COPY . .

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "./build/libs/product-0.0.1-SNAPSHOT.jar"]