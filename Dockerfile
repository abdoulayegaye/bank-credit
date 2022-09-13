FROM openjdk:8
ADD target/bank-credit.jar bank-credit.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "bank-credit.jar"]