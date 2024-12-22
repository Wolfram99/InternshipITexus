#FROM gradle:latest AS TEMP_BUILD_IMAGE
#ENV APP_HOME=/opt/app/
#WORKDIR $APP_HOME
#
#COPY build.gradle settings.gradle $APP_HOME
#COPY gradle $APP_HOME/gradle
#COPY --chown=gradle:gradle . /home/gradle/src
#RUN chown -R gradle /home/gradle/src
#RUN gradle build || return 0
#COPY . .
#RUN gradle --stop
#RUN gradle clean
#RUN gradle build

#
#COPY build.gradle /temp/
#COPY settings.gradle /temp/
#COPY gradlew.bat /temp/
#COPY gradle.properties /temp/
#COPY gradlew /temp/
#COPY gradle /temp/gradle
#
#RUN gradle clean build


#FROM openjdk:17-jdk-slim
#WORKDIR /temp
#COPY --from=build temp/build/libs/*.jar  /temp/*jar
#ENTRYPOINT ["java", "-jar", "/temp/libs/config-server-0.0.1-SNAPSHOT.jar", "--server.port=8888"]




#FROM adoptopenjdk/openjdk11:alpine-jre
#FROM openjdk:17-jdk-slim
#ENV ARTIFACT_NAME=config-server-0.0.1-SNAPSHOT.jar
#ENV APP_HOME=/opt/app/
#VOLUME $APP_HOME/config
#WORKDIR $APP_HOME
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
##EXPOSE 8888
##EXPOSE 8080
##EXPOSE 8500
#ENTRYPOINT exec java -jar ${ARTIFACT_NAME}
FROM openjdk:17-jdk-slim
ENV ARTIFACT_NAME=config-server-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/opt/app/
WORKDIR $APP_HOME
COPY build/libs/$ARTIFACT_NAME $APP_HOME/build/libs/$ARTIFACT_NAME

ENTRYPOINT exec java -jar ${APP_HOME}/build/libs/${ARTIFACT_NAME}





#FROM gradle:5.3.0-jdk-alpine AS TEMP_BUILD_IMAGE
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY build.gradle settings.gradle $APP_HOME
#
#COPY gradle $APP_HOME/gradle
#COPY --chown=gradle:gradle . /home/gradle/src
#USER root
#RUN chown -R gradle /home/gradle/src
#
#RUN gradle build || return 0
#COPY . .
#RUN gradle clean build
#
## actual container
#FROM adoptopenjdk/openjdk11:alpine-jre
#ENV ARTIFACT_NAME=pokerstats-0.0.1-SNAPSHOT.jar
#ENV APP_HOME=/usr/app/
#
#WORKDIR $APP_HOME
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
#
#EXPOSE 8080
#ENTRYPOINT exec java -jar ${ARTIFACT_NAME}