FROM openjdk:8
MAINTAINER hyl/2546615650@qq.com
VOLUME /tmp
ADD *.jar /graduation-fastdfs.jar
EXPOSE 8800
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/graduation-fastdfs.jar"]