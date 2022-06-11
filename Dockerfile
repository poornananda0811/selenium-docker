FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq
# workspace
WORKDIR /usr/share/udemy


#Add all.jar files,libraries from the host to this image
ADD target/selenium-docker.jar       selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs                       libs


# In case of any other dependencies like .xls or .json or any other files add them

# Add suite files

ADD Book-flight-module.xml   Book-flight-module.xml
ADD searchmodule.xml         searchmodule.xml

ADD healthcheck.sh           healthcheck.sh
RUN dos2unix healthcheck.sh
#BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT sh healthcheck.sh
