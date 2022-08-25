FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/naming-server-0.0.1-SNAPSHOT.jar namingserver.jar
EXPOSE 8761
ENTRYPOINT exec java $JAVA_OPTS -jar namingserver.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
# ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar namingserver.jar
