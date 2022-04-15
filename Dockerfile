# Build the application first using Maven
FROM maven:3.8-openjdk-8 as build
WORKDIR /
COPY . .
RUN mvn clean install

# Inject the JAR file into a new container to keep the file small
FROM openjdk:8-jre-alpine
WORKDIR /
COPY --from=build /app/target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar app.jar"]