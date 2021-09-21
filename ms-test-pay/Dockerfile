FROM adoptopenjdk/openjdk11
EXPOSE 8006
ADD ./target/ms-test-pay-0.0.1-SNAPSHOT.jar    app-pay.jar
ENTRYPOINT ["java","-jar","/app-pay.jar"]
