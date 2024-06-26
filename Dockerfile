# Use the official OpenJDK 21 JDK slim image as the base image
FROM openjdk:21-jdk-slim

# Copy the JAR file from the target directory to the container's root 
#directory and rename it to app.jar
COPY target/*.jar app.jar

# Inform Docker that the container listens on port 5000
EXPOSE 8080

# Set the default command to run when the container starts
ENTRYPOINT ["java","-jar","/app.jar"]
