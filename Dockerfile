FROM gradle:jdk11 as builder

WORKDIR /home/app
COPY --chown=gradle:gradle . .
RUN gradle build -x test --no-daemon

FROM openjdk:11-jre-slim as runtime

EXPOSE 8080
COPY --from=builder /home/app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]