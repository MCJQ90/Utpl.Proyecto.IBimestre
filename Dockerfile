# Importing JDK and copying required files
FROM openjdk:21-jdk AS build
WORKDIR /app
COPY contador/pom.xml .
COPY contador/src src

# Copy Maven wrapper
COPY contador/mvnw .
COPY contador/.mvn .mvn

# Set execution permission for the Maven wrapper
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the final Docker image using OpenJDK 19
FROM openjdk:21-jdk
VOLUME /tmp

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar
RUN ls -al
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080