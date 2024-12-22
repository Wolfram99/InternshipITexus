#FROM gradle:8.8-jdk17 as builder
#WORKDIR /opt/app
#COPY ../build.gradle ../gradlew ../gradlew.bat ../settings.gradle ./
#COPY ../gradle/wrapper/gradle-wrapper.jar ../gradle/wrapper/gradle-wrapper.properties ./gradle/wrapper/
#COPY ../src ./srs
#RUN ./gradlew clean build



#FROM eclipse-temurin:17.0.8_7-jre
#EXPOSE 9090
#WORKDIR /opt/app
#COPY build/libs/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

#RUN ./gradlew clean build

#FROM openjdk:17-jdk-slim
#WORKDIR /opt/app
#EXPOSE 9900
#COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
#ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]
#



#FROM eclipse-temurin:21.0.2_13-jdk-jammy as build
#
#ARG JAR_FILE
#WORKDIR /build
#
#ADD $JAR_FILE application.jar
#RUN java -Djarmode=layertools -jar libls/application.jar extract --destination extracted
#
#FROM eclipse-temurin:21.0.2_13-jdk-jammy
#
#RUN addgroup spring-boot-group && adduser --ingroup spring-boot-group spring-boot
#USER spring-boot:spring-boot-group
#VOLUME /tmp
#WORKDIR /application
#
#COPY --from=build /build/extracted/dependencies .
#COPY --from=build /build/extracted/spring-boot-loader .
#COPY --from=build /build/extracted/snapshot-dependencies .
#COPY --from=build /build/extracted/application .
#
#ENTRYPOINT exec java ${JAVA_OPTS} org.springframework.boot.loader.launch.JarLauncher ${0} ${@}
#
#
#
#FROM hashicorp/consul:1.10.0
#EXPOSE 8500


#FROM consul:1.15.4
##EXPOSE 8500
#RUN docker build
#RUN docker run -p 8500:8500
#
#


#FROM ubuntu:latest
#RUN apt-get update && apt-get install -y wget
#CMD ["wget", "http://d6ad10c9d6e4:34349/api-gateway/default"]

#FROM ubuntu:latest
#RUN apt-get update && apt-get install -y curl
#CMD ["curl", "-I", "http://localhost:8888/api-gateway/default"]