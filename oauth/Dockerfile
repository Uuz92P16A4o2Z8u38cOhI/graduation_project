FROM openjdk:8
MAINTAINER hyl/2546615650@qq.com
VOLUME /tmp
ADD *.jar /graduation-oauth.jar
EXPOSE 9055
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/graduation-oauth.jar"]