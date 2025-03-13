
FROM gradle:8.0-jdk17 AS builder


WORKDIR /app


COPY . .


RUN ./gradlew build -x test


FROM eclipse-temurin:17-jdk-alpine


WORKDIR /app


COPY --from=builder /app/build/libs/*.jar /app/


EXPOSE 8080


CMD ["java", "-jar", "Java-checkpoint-1-2-semester-0.0.1-SNAPSHOT.jar"]
