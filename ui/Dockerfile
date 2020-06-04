FROM openjdk:8
MAINTAINER hyl/2546615650@qq.com
VOLUME /tmp
ADD *.jar /graduation-ui.jar
EXPOSE 9050
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/graduation-ui.jar"]