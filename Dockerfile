FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . /app

RUN ./mvnw clean install

EXPOSE 8080

CMD ["java", "-jar", "target/spotline-0.0.1-SNAPSHOT.jar"]
