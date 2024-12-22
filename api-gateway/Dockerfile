#FROM openjdk:17-jdk-slim
##ENV SPRING_DATASOURCE_USER="postgres" SPRING_DATASOURCE_PASSWORD=" pgadmin" SPRING_DATASOURCE_URL="jdbc:postgresql://postgres:5432/InternshipITexus"
#WORKDIR /opt/app
#EXPOSE 8888
#EXPOSE 8500
#COPY build/libs/*.jar /opt/app/*.jar
#
#ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]


#FROM gradle:8.11.1 AS TEMP_BUILD_IMAGE
#ENV APP_HOME=/opt/app/
#WORKDIR $APP_HOME
#
#COPY build.gradle settings.gradle $APP_HOME
#COPY gradle $APP_HOME/gradle
#COPY --chown=gradle:gradle . /home/gradle/src
#RUN chown -R gradle /home/gradle/src && gradle build || return 0
#COPY . .
#RUN gradle --stop
#RUN gradle clean
#RUN gradle build


#FROM adoptopenjdk/openjdk11:alpine-jre
FROM openjdk:17-jdk-slim
ENV ARTIFACT_NAME=api-gateway-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/opt/app/
EXPOSE 8888
WORKDIR $APP_HOME
COPY build/libs/$ARTIFACT_NAME $APP_HOME/build/libs/$ARTIFACT_NAME

ENTRYPOINT exec java -jar ${APP_HOME}/build/libs/${ARTIFACT_NAME}




