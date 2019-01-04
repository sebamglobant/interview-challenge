FROM alpine:edge
MAINTAINER sebamglobant
RUN apk add --no-cache openjdk8
COPY build/libs/interview-0.0.1-SNAPSHOT.jar /opt/interview/libs/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/interview/libs/interview-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080