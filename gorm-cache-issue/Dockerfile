FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY build/libs/*-all.jar gorm-cache-issue.jar
CMD java ${JAVA_OPTS} -jar gorm-cache-issue.jar