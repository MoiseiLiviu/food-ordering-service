FROM openjdk:11
COPY target/food-ordering-service-0.0.1-SNAPSHOT.jar food-ordering-service.jar
EXPOSE ${port}
ENTRYPOINT exec java -jar food-ordering-service.jar