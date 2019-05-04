<!--ts-->
   * [Docker](#docker)
      * [Running a containerized Java application](#running-a-containerized-java-application)
      * [Network and ports](#network-and-ports)
         * [List network types](#list-network-types)
         * [Create a new network](#create-a-new-network)
         * [inspect a network](#inspect-a-network)
         * [Run Apache Tomcat for the newly created network](#run-apache-tomcat-for-the-newly-created-network)
         * [Run a busybox with the same network as myTomcat container](#run-a-busybox-with-the-same-network-as-mytomcat-container)
         * [Check if we can reach the tomcat webserver from the busybox](#check-if-we-can-reach-the-tomcat-webserver-from-the-busybox)
         * [Bind your host port to the container](#bind-your-host-port-to-the-container)
         * [Map a random port to the exposed container port](#map-a-random-port-to-the-exposed-container-port)
         * [Find out the randomly allocated port](#find-out-the-randomly-allocated-port)
      * [Volumes](#volumes)
         * [Specify a local path for container volume](#specify-a-local-path-for-container-volume)
         * [Create a standalone named volume](#create-a-standalone-named-volume)
         * [Map the volume to containers](#map-the-volume-to-containers)
         * [Remove a volume](#remove-a-volume)
      * [Dockerfile](#dockerfile)
         * [Build the docker with the Dockerfile provided in this repository](#build-the-docker-with-the-dockerfile-provided-in-this-repository)
         * [Run the newly built image (rest-example)](#run-the-newly-built-image-rest-example)
         * [Build the ping-example container from Dockerfile](#build-the-ping-example-container-from-dockerfile)
         * [Run container in detached mode](#run-container-in-detached-mode)
         * [Attach to the detached container](#attach-to-the-detached-container)
         * [View logs of the running container](#view-logs-of-the-running-container)
         * [Specify the log driver to write logs to](#specify-the-log-driver-to-write-logs-to)
         * [Inspect a container](#inspect-a-container)
         * [Inspect containers using Go template engine](#inspect-containers-using-go-template-engine)
         * [Fetch the IP address from the metadata of the container](#fetch-the-ip-address-from-the-metadata-of-the-container)
         * [Get stats of all (not only running) the containers](#get-stats-of-all-not-only-running-the-containers)
         * [Fetch container events](#fetch-container-events)
         * [Restart a container after it is shut down (in every case)](#restart-a-container-after-it-is-shut-down-in-every-case)
         * [Restart a container after it is shut down (with a non-zero exit status)](#restart-a-container-after-it-is-shut-down-with-a-non-zero-exit-status)
         * [Get the number of restarts of a container](#get-the-number-of-restarts-of-a-container)
         * [Discover the last time the container was started again](#discover-the-last-time-the-container-was-started-again)
         * [Updating a restart policy on a running container](#updating-a-restart-policy-on-a-running-container)
         * [Restrict the memory to 512 MB for the container](#restrict-the-memory-to-512-mb-for-the-container)
         * [Set memory reservation without setting the hard memory limit](#set-memory-reservation-without-setting-the-hard-memory-limit)
         * [Set the Kernel memory limit](#set-the-kernel-memory-limit)
         * [Setting user memory and kernel memory for a container](#setting-user-memory-and-kernel-memory-for-a-container)
         * [Set memory swappiness constraint for a container (0 to disable swaps, 100 all anonymous pages to swap out)](#set-memory-swappiness-constraint-for-a-container-0-to-disable-swaps-100-all-anonymous-pages-to-swap-out)
         * [Set the CPU usage limit for a container to 50\x of the CPU resource](#set-the-cpu-usage-limit-for-a-container-to-50-of-the-cpu-resource)
         * [Constraint the container to get 50\x of the CPU usage every 50ms](#constraint-the-container-to-get-50-of-the-cpu-usage-every-50ms)
         * [Set the number of CPU cores to be used by the container](#set-the-number-of-cpu-cores-to-be-used-by-the-container)
         * [Updating constrains of a running container](#updating-constrains-of-a-running-container)
   * [Java Microservices](#java-microservices)
      * [Maven Automation](#maven-automation)
         * [Using Maven to generate Docker images (without Dockerfile)](#using-maven-to-generate-docker-images-without-dockerfile)
         * [Using Maven to start a container](#using-maven-to-start-a-container)
         * [Using Maven to run a container](#using-maven-to-run-a-container)
   * [Kubernetes](#kubernetes)
      * [Minikube](#minikube)
         * [Install Minikube to use Kubernetes locally](#install-minikube-to-use-kubernetes-locally)
         * [Start minikube](#start-minikube)
         * [Show Kubernetes dashboard](#show-kubernetes-dashboard)
         * [List the available minikube addons](#list-the-available-minikube-addons)
         * [disable an addon](#disable-an-addon)
         * [enable an addon](#enable-an-addon)
      * [Kubectl](#kubectl)
         * [Install kubectl on your platform](#install-kubectl-on-your-platform)
         * [Test if minikube and kubectl are correctly installed](#test-if-minikube-and-kubectl-are-correctly-installed)
      * [Services](#services)
         * [Create a service for the rest-example app](#create-a-service-for-the-rest-example-app)
         * [Display the services](#display-the-services)
         * [Display the services of all the namespaces](#display-the-services-of-all-the-namespaces)
         * [Display the details of a particular service](#display-the-details-of-a-particular-service)
      * [Deployments](#deployments)
         * [Create a deployment for the rest-example app](#create-a-deployment-for-the-rest-example-app)
         * [Display all the eployments](#display-all-the-eployments)
         * [Get the service address](#get-the-service-address)
         * [Test if you can get the list of books](#test-if-you-can-get-the-list-of-books)
         * [Read the logs of the running container](#read-the-logs-of-the-running-container)
         * [Get the shell of the running container](#get-the-shell-of-the-running-container)
      * [ReplicaSets](#replicasets)
         * [Scaling deployments manually](#scaling-deployments-manually)
         * [Automatically scaling up and down the deployment](#automatically-scaling-up-and-down-the-deployment)
      * [Events](#events)
         * [Viewing cluster events](#viewing-cluster-events)
      * [Cleaning up](#cleaning-up)
         * [Delete a deployment](#delete-a-deployment)
         * [Delete a service](#delete-a-service)
      * [API-Server](#api-server)
         * [Setup a proxy for kubectl to communicate with minikube](#setup-a-proxy-for-kubectl-to-communicate-with-minikube)
         * [Check if our api-server is running](#check-if-our-api-server-is-running)
         * [Create a service using api-server](#create-a-service-using-api-server)
         * [Create a deployment using api-server](#create-a-deployment-using-api-server)
         * [Check the running pod](#check-the-running-pod)
         * [Delete a deployment using curl](#delete-a-deployment-using-curl)
         * [Delete the service using curl](#delete-the-service-using-curl)

<!-- Added by: dawan, at: Sat  4 May 2019 12:38:49 BST -->

<!--te-->

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

Windows: `docker run -v d:/docker_volumes/volume1:/volume -it busybox`

Mac:`docker run -v ~/volume1:/volume -it busybox`

### Create a standalone named volume 

`docker volume create --name myVolume`

### Map the volume to containers

`docker run -it -v myVolume:/volume --name myBusybox3 busybox`

`docker run -it -v myVolume:/volume --name myBusybox4 busybox`

OR use -volumes-from

`docker run -it -volumes-from myBusybox4 --name myBusybox5 busybox`

### Remove a volume

`docker volume rm myVolume`

## Dockerfile

### Build the docker with the Dockerfile provided in this repository
`docker build . -t rest-example`

### Run the newly built image (rest-example)

`docker run -p 8080:8080 -it rest-example `

### Build the ping-example container from Dockerfile

`cd ping-example`

`docker build -t ping-example .`

`docker run ping-example`

for sending ping to localhost

`docker run ping-example www.google.com`

to ping Google

### Run container in detached mode

`docker run -d -p 8080:8080 rest-example`

### Attach to the detached container

`docker attach rest-example`

### View logs of the running container

`docker logs -f rest-example`

### Specify the log driver to write logs to

`docker run log-driver=syslog rest-example`

You can use `journald`, `splunk`, `fluentd`, `awslogs`, etc

### Inspect a container

`docker inspect rest-example`

### Inspect containers using Go template engine

`docker inspect -f '{{.State.ExitCode}}' jboss.wildfly`

### Fetch the IP address from the metadata of the container

`docker inspect rest-example | jq -r '.[0].NetworkSettings.IPAddress'`

### Get stats of all (not only running) the containers

`docker stats -a`

### Fetch container events

`docker events`

### Restart a container after it is shut down (in every case)

`docker run --restart=always rest-example`

### Restart a container after it is shut down (with a non-zero exit status)

`docker run --restart=on-failure:5 rest-example`

### Get the number of restarts of a container

`docker inspect -f "{{ .RestartCount }}" rest-example`

### Discover the last time the container was started again

`docker inspect -f "{{ .State.StartedAt }}" rest-example`

### Updating a restart policy on a running container

`docker run -d -t rest-example`

`docker update --restart=always rest-example`

### Restrict the memory to 512 MB for the container

`docker run -it -m 512m ubuntu`

### Set memory reservation without setting the hard memory limit

`docker run -it --memory-reservation 1G ubuntu /bin/bash`

### Set the Kernel memory limit

`docker run -it --kernel-memory 100M ubuntu /bin/bash`

### Setting user memory and kernel memory for a container

`docker run -it -m 1G --kernel-memory 100M ubuntu /bin/bash`

### Set memory swappiness constraint for a container (0 to disable swaps, 100 all anonymous pages to swap out)

`docker run -it --memory-swappiness=0 ubuntu /bin/bash`

### Set the CPU usage limit for a container to 50% of the CPU resource

`docker run -it --cpu-quota=50000 ubuntu /bin/bash`

### Constraint the container to get 50% of the CPU usage every 50ms

`docker run -it --cpu-quota=25000 --cpu-period=50000 ubuntu /bin/bash`

### Set the number of CPU cores to be used by the container

`docker run -it --cpuset 2 ubuntu`

### Updating constrains of a running container

`docker update --cpu-shares 512 -m 500M rest-example`

# Java Microservices

## Maven Automation

### Using Maven to generate Docker images (without Dockerfile)

`cd dokuja`

`mvn clean package docker:build`

### Using Maven to start a container

`mvn clean package docker:start`

Or to stop the container

`mvn docker:stop`

### Using Maven to run a container

`mvn clean package docker:run`

# Kubernetes

## Minikube

### Install Minikube to use Kubernetes locally

Mac: `brew cask install minikube`

Linux: `curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 \
  && chmod +x minikube`
`sudo cp minikube /usr/local/bin && rm minikube`

Windows: `choco install minikube kubernetes-cli`

### Start minikube

`minikube start`

### Show Kubernetes dashboard

`minikube dashboard`

### List the available minikube addons

`minikube addons list`

### disable an addon

`minikube addons disable dashboard`

### enable an addon

`minikube addons enable heapster`

## Kubectl

### Install kubectl on your platform

Mac: `brew install kubernetes-cli`
Linux: `sudo snap install kubectl --classic`
Windows: `curl -LO https://storage.googleapis.com/kubernetes-release/release/v1.14.0/bin/windows/amd64/kubectl.exe`

### Test if minikube and kubectl are correctly installed

`kubectl get nodes`

## Services

### Create a service for the rest-example app

`kubectl create -f service.yml`

### Display the services

`kubectl get services`

### Display the services of all the namespaces

`kubectl get services --all-namespaces`

### Display the details of a particular service

`kubectl describe service rest-example`

## Deployments

### Create a deployment for the rest-example app

`kubectl create -f deployment.yml`

### Display all the eployments

`kubectl get depployments`

### Get the service address

`minikube service rest-example --url`

### Test if you can get the list of books

`curl $(minikube service dokuja --url)/books -H {"Content-Type: application/json"}`

### Read the logs of the running container

`kubectl logs $(kubectl get pods | sed -n 2p | awk '{print $1;}')`

### Get the shell of the running container

`kubectl exec -it $(kubectl get pods | sed -n 2p | awk '{print $1;}') -- /bin/bash`

## ReplicaSets

### Scaling deployments manually

`kubectl scale deployment dokuja --replicas=3`

### Automatically scaling up and down the deployment

`kubectl autoscale deployment dokuja --cpu-percent=50 --min=1 --max=5`

## Events

### Viewing cluster events

`kubectl get events`

##  Cleaning up

### Delete a deployment

`kubectl delete deployment dokuja`

### Delete a service

`kubectl delete service dokuja`

## API-Server

### Setup a proxy for kubectl to communicate with minikube

`kubectl proxy --port=8080`

__In a separate bash session:__

### Check if our api-server is running 

`curl http://localhost:8080/api/`

### Create a service using api-server

`curl -s http://localhost:8080/api/v1/namespaces/default/services \`

`-XPOST -H 'Content-Type: application/json' -d@service.json`

### Create a deployment using api-server

`curl -s http://localhost:8080/apis/extensions/v1beta1/namespaces/default/deployments \`

`-XPOST -H 'Content-Type: application/json' -d@deployment.json`

### Check the running pod

`curl -X GET http://localhost:8080/api/v1/namespaces/default/pods`

### Delete a deployment using curl

`curl http://localhost:8080/apis/extensions/v1beta1/namespaces/default/deployments -XDELETE`

### Delete the service using curl

`curl http://localhost:8080/api/v1/namespaces/default/services/dokuja -XDELETE`


