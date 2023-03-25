FROM --platform=linux/x86_64 tomcat:8.5.46-jdk8-openjdk

LABEL MAINTAINER=tangmopanko@gmail.com
RUN apt-get update
RUN apt-get install -y tzdata
ENV TZ=Asia/Seoul

COPY /build/libs/gaegul-bot.war /usr/local/tomcat/webapps/gaegul.war

CMD ["catalina.sh", "run"]