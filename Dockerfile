#Интересно, в задании предлагается использовать openjdk:8-jdk-alpine
FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

#Я не вполне поняла, почему в дз предлагается использовать ADD вместо COPY.
#According to the Dockerfile best practices guide, we should always prefer COPY over ADD unless we specifically
#need one of the two additional features of ADD.
#Возможно я недопонимаю, но в данной задаче дополнительные возможности команды ADD не требуются.
COPY target/authorization-service-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]