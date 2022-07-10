#EXPOSE 8080

FROM openjdk:8
ADD ./target/figures-0.0.1-SNAPSHOT.jar figures-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/figures-0.0.1-SNAPSHOT.jar"]
