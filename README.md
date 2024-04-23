Online Book Store Management System
====================================

## Build and Run
### Maven Build
Make sure you have `Maven` installed. Execute the following maven command from the directory of the
parent project:
```
mvn clean package
```
It will create the Spring Boot executable JAR (onlinebookstore/target/),`onlinebookstore-1.0.0.jar`.

### Run
To run the newly created Spring Boot JAR from the terminal:
```
java -jar onlinebookstore-1.0.0.jar
```
This should start up the example application at port `8080`. The application can be accessed at `http://localhost:8080`

### Docker Build
Before you build the Docker image, make sure Docker is available in your environment.
Execute the following maven command from the directory of the parent project:
```
docker build -t onlinebookstore .
```
This should build a Docker image named `onlinebookstore`.

### Docker Run
Run the newly created Docker image, `onlinebookstore`, by executing the
[`docker run`](https://docs.docker.com/engine/reference/run/) command from the terminal:
```
docker run --rm -p 8080:8080 onlinebookstore
```
##### Options
* `--rm` option automatically clean up the container and remove the file system when the container exit.
* [`-p 8080:8080`](https://docs.docker.com/engine/reference/run/#expose-incoming-ports) option publishes all
  exposed ports to the host interfaces. In our example, it is port `8080` is both `hostPort` and `containerPort`

This should start up the example application and it can be accessed at `http://localhost:8080`

## Swagger URL
http://localhost:8080/swagger-ui/index.html