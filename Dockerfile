
FROM ubuntu:latest

# Update package lists and install MySQL client
RUN apt-get update && \
    apt-get install -y mysql-client && \
    rm -rf /var/lib/apt/lists/*

# Install OpenJDK
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy the application jar to the container
COPY target/spe-major-backend.jar /app/spe-major-backend.jar

# Expose the application port
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "spe-major-backend.jar"]