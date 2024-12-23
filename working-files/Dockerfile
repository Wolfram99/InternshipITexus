FROM openjdk:17-jdk-slim
ENV ARTIFACT_NAME=working-files-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/opt/app/
EXPOSE 9292
WORKDIR $APP_HOME
COPY build/libs/$ARTIFACT_NAME $APP_HOME/build/libs/$ARTIFACT_NAME

ENTRYPOINT exec java -jar ${APP_HOME}/build/libs/${ARTIFACT_NAME}
