FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY /build/libs/AppDemo-0.0.1-SNAPSHOT.jar appdemo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "appdemo.jar"]
