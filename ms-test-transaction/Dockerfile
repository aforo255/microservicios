FROM adoptopenjdk/openjdk11
EXPOSE 8082
ADD ./target/ms-test-transaction-0.0.1-SNAPSHOT.jar    app-transaction.jar
ENTRYPOINT ["java","-jar","/app-transaction.jar"]