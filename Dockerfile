FROM azul/zulu-openjdk-alpine:11-latest
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]