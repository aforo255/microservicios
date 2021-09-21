FROM adoptopenjdk/openjdk11
EXPOSE 8005
ADD ./target/ms-test-invoice-0.0.1-SNAPSHOT.jar   app-invoices.jar
ENTRYPOINT ["java","-jar","/app-invoices.jar"]
