FROM gradle:jdk21 as builder


COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle clean build -x test --stacktrace

FROM openjdk:21-jdk-slim as appRuntime

ENTRYPOINT ["sudo", "mkdir", "/app/"]

WORKDIR app

COPY --from=builder /home/gradle/src/build/libs/aidemo-0.0.1-SNAPSHOT.jar /app

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/app/aidemo-0.0.1-SNAPSHOT.jar"]