FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.war"]