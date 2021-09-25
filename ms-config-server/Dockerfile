FROM adoptopenjdk/openjdk11
EXPOSE 8888
ADD ./target/ms-config-server-0.0.1-SNAPSHOT.jar   app-config-server.jar
ENTRYPOINT ["java","-jar","/app-config-server.jar"]
