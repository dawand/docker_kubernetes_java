# Docker

## Running a containerized Java application

`docker run milkyway/java-hello-world`

## Network and ports

### List network types

`docker network ls`

### Create a new network

`docker network create myNetwork`

### inspect a network

`docker network inspect myNetwork`

### Run Apache Tomcat for the newly created network

`docker run -it --name myTomcat --net=myNetwork tomcat`

### Run a busybox with the same network as myTomcat container

`docker run -it --net container:myTomcat busybox`

### Check if we can reach the tomcat webserver from the busybox

`wget localhost:8080`

### Bind your host port to the container

`docker run -it --name myTomcat2 --net=myNetwork -p 8080:8080 tomcat`

### Map a random port to the exposed container port

`docker run -it --name myTomcat3 --net=myNetwork -P tomcat`

### Find out the randomly allocated port

`docker port myTomcat3`
OR check in:
`docker inspect myTomcat3`

## Volumes

### Specify a local path for container volume

Windows:
`docker run -v d:/docker_volumes/volume1:/volume -it busybox`
Mac:
`docker run -v ~/volume1:/volume -it busybox`

### Create a standalone named volume 

`docker volume create --name myVolume`

### Map the volume to containers

`docker run -it -v myVolume:/volume --name myBusybox3 busybox`
`docker run -it -v myVolume:/volume --name myBusybox4 busybox`

OR use -volumes-from

`docker run -it -volumes-from myBusybox4 --name myBusybox5 busybox`

### Remove a volume

`docker volume rm myVolume`

## Java Microservices


