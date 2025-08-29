FROM tomcat:9.0-jdk17
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ch05/dist/ch05.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
