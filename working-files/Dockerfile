#FROM openjdk:17-jdk-slim
#LABEL NAME="API_GATEWAY"
##ENV SPRING_DATASOURCE_USER="postgres" SPRING_DATASOURCE_PASSWORD=" pgadmin" SPRING_DATASOURCE_URL="jdbc:postgresql://postgres:5432/InternshipITexus"
#WORKDIR /opt/app
##EXPOSE 8888
##EXPOSE 8500
##EXPOSE 27017
#COPY build/libs/*.jar /opt/app/*.jar
#
#ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]
FROM openjdk:17-jdk-slim
ENV ARTIFACT_NAME=working-files-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/opt/app/
EXPOSE 9292
WORKDIR $APP_HOME
COPY build/libs/$ARTIFACT_NAME $APP_HOME/build/libs/$ARTIFACT_NAME

ENTRYPOINT exec java -jar ${APP_HOME}/build/libs/${ARTIFACT_NAME}
