FROM openjdk:11.0.6-jre-buster as build

WORKDIR /

RUN mkdir app

COPY . /app/

FROM maven:3-alpin as base

WORKDIR /app/

RUN mvn clean compile package  

#COPY  target/demo-0.0.1-SNAPSHOT.jar /app.jar
 
FROM build AS final

COPY entrypoint.sh /app/entrypoint.sh

RUN chmod 755 /app/entrypoint.sh

ENTRYPOINT [ "/app/entrypoint.sh" ]  

EXPOSE 8080