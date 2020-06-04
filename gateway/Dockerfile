FROM openjdk:8
MAINTAINER hyl/2546615650@qq.com
VOLUME /tmp
ADD *.jar /graduation-gateway.jar
EXPOSE 9000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/graduation-gateway.jar"]