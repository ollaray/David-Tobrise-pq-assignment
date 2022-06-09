FROM openjdk:8
EXPOSE 8085
ADD target/payconiq-david-tobrise.jar payconiq-david-tobrise.jar
ENTRYPOINT ["java", "-jar", "/payconiq-david-tobrise.jar"]