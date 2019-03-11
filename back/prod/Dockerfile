FROM adoptopenjdk/openjdk11
VOLUME /tmp
ARG JAR_FILE
COPY ./cdb.jar app.jar
COPY ./application.properties application.properties
ENTRYPOINT ["java","-jar","-Dspring.config.location=/","/app.jar"]
