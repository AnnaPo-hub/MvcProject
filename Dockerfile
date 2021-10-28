FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/spring-mvc-docker-1.0.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]