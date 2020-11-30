FROM openjdk:11-jre-slim

COPY target/starwars*.jar /opt/app/starwars.jar

ENTRYPOINT ["java", "-jar", "/opt/app/starwars.jar"]
