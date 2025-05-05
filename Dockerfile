FROM openjdk:17
WORKDIR /springContainer
COPY target/jenkinsCiCd.jar /springContainer
EXPOSE 8282
CMD ["java","-jar","jenkinsCiCd.jar"]