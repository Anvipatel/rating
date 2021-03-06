# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="anvi.niraj@gmail.com"

# Add a volume pointing to /tmp
#VOLUME /tmp

# Make port 8103 available to the world outside this container
EXPOSE 8103

# The application's jar file
ARG JAR_FILE=target/rating-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} rating-0.0.1-SNAPSHOT.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/rating-0.0.1-SNAPSHOT.jar"]