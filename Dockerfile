FROM jeanblanchard/java:8
MAINTAINER Dawand Sulaiman

COPY ./dokuja/target/dokuja-0.0.1-SNAPSHOT.jar dokuja-0.0.1-SNAPSHOT.jar
CMD java -jar dokuja-0.0.1-SNAPSHOT.jar

