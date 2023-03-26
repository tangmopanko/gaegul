FROM --platform=linux/x86_64 openjdk:17-jdk-alpine
# deprecated -> MAINTAINER
LABEL MAINTAINER=tangmopanko@gmail.com
COPY build/libs/gaegul-bot.jar gaegul.jar

ENTRYPOINT ["java", "-jar", "/gaegul.jar"]
