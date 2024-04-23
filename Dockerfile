FROM openjdk:17-oracle
USER root
WORKDIR /
COPY target/onlinebookstore-1.0.0.jar onlinebookstore.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/onlinebookstore.jar"]