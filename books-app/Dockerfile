#FROM consul:1.15.4
#EXPOSE 8500
#
#
#FROM postgres:latest AS books-db
#EXPOSE 5432

#FROM eclipse-temurin:17.0.8_7-jre AS builder
#EXPOSE 9090
#WORKDIR /opt/app
#COPY build/libs/*.jar app.jar
#CMD gradle clean build
#ENTRYPOINT ["java", "-jar", "app.jar"]



#
#FROM gradle:8.11.1 AS TEMP_BUILD_IMAGE
#ENV APP_HOME=/opt/app/
#WORKDIR $APP_HOME
#
#COPY build.gradle settings.gradle $APP_HOME
#COPY gradle $APP_HOME/gradle
#COPY --chown=gradle:gradle . /home/gradle/src
#RUN chown -R gradle /home/gradle/src
#COPY . .
#RUN gradle --stop
#RUN gradle clean
#RUN gradle build
#
#
#
#
#FROM openjdk:17-jdk-slim
#ENV ARTIFACT_NAME=books-app-0.0.1-SNAPSHOT.jar
#ENV APP_HOME=/opt/app/
#WORKDIR $APP_HOME
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
#EXPOSE 9090
#EXPOSE 8080
#EXPOSE 5432
#EXPOSE 8500
#ENTRYPOINT exec java -jar ${ARTIFACT_NAME}
#







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
#FROM openjdk:17-jdk-slim
#ENV ARTIFACT_NAME=books-app-0.0.1-SNAPSHOT.jar
#ENV APP_HOME=/opt/app/
#
#WORKDIR $APP_HOME
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
##EXPOSE 9090
#ENTRYPOINT exec java -jar ${ARTIFACT_NAME}



FROM openjdk:17-jdk-slim
ENV ARTIFACT_NAME=books-app-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/opt/app/
EXPOSE 9090
WORKDIR $APP_HOME
COPY build/libs/$ARTIFACT_NAME $APP_HOME/build/libs/$ARTIFACT_NAME

ENTRYPOINT exec java -jar ${APP_HOME}/build/libs/${ARTIFACT_NAME}











#FROM openjdk:17-jdk-slim
##ENV SPRING_DATASOURCE_USER="postgres" SPRING_DATASOURCE_PASSWORD=" pgadmin" SPRING_DATASOURCE_URL="jdbc:postgresql://postgres:5432/InternshipITexus"
#WORKDIR /opt/app
#EXPOSE 9090
#EXPOSE 5432
#EXPOSE 8500
#EXPOSE 8888
#COPY build/libs/*.jar /opt/app/*.jar
#
#ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]

