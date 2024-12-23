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




FROM openjdk:17-jdk-slim
ENV ARTIFACT_NAME=books-app-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/opt/app/
EXPOSE 9090
WORKDIR $APP_HOME
COPY build/libs/$ARTIFACT_NAME $APP_HOME/build/libs/$ARTIFACT_NAME

ENTRYPOINT exec java -jar ${APP_HOME}/build/libs/${ARTIFACT_NAME}





