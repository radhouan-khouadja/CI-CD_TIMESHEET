FROM openjdk:8
EXPOSE 8055
ADD /target/timesheet-1.0.war timesheet.jar
ENTRYPOINT ["java","-jar","timesheet.jar"]