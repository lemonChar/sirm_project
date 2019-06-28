FROM tomcat:latest
WORKDIR /usr/local
RUN rm -rf /usr/local/tomcat/webapps/*
ADD books.war /usr/local/tomcat/webapps/service1.war
#RUN yes|unzip /usr/local/tomcat/webapps/ROOT.war -d /usr/local/tomcat/webapps/ROOT/
#RUN chmod 777 -Rf /usr/local/tomcat/webapps/*
EXPOSE 30683
ENTRYPOINT ["/usr/local/tomcat/bin/catalina.sh","run"]
