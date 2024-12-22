#FROM openjdk:17-jdk-slim
##ENV SPRING_DATASOURCE_USER="postgres" SPRING_DATASOURCE_PASSWORD=" pgadmin" SPRING_DATASOURCE_URL="jdbc:postgresql://postgres:5432/InternshipITexus"
#WORKDIR /opt/app
#
#COPY build/libs/*.jar /opt/app/*.jar
#
#ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]
FROM openjdk:17-jdk-slim
ENV ARTIFACT_NAME=Authetication-users-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/opt/app/
EXPOSE 9191
WORKDIR $APP_HOME
COPY build/libs/$ARTIFACT_NAME $APP_HOME/build/libs/$ARTIFACT_NAME

ENTRYPOINT exec java -jar ${APP_HOME}/build/libs/${ARTIFACT_NAME}
