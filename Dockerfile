FROM openjdk
EXPOSE 8686
ADD target/Restaurant-0.0.1-SNAPSHOT.jar restaurant.jar
ENTRYPOINT ["java","-jar","/restaurant.jar"]