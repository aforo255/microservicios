FROM openjdk:13
EXPOSE 8090
ADD ./target/ms-gateway-0.0.1-SNAPSHOT.jar    micro-gateway.jar
ENTRYPOINT ["java","-jar","/micro-gateway.jar"]
