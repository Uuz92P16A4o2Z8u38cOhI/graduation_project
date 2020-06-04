FROM openjdk:8
MAINTAINER hyl/2546615650@qq.com
VOLUME /tmp
ADD *.jar /graduation-eureka.jar
EXPOSE 7001
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/graduation-eureka.jar"]