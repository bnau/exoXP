FROM adoptopenjdk/openjdk11
VOLUME /tmp
ARG JAR_FILE
COPY ./cdb.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]