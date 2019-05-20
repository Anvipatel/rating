#!/bin/sh


cd $HOME/revrep

#building maven command
echo "run maven clean/install"
mvn clean
mvn install -Dmaven.test.skip


echo "building revrep docker image"
docker build -t revrep .

echo "Renaming docker image"
docker tag revrep:latest revrep:v1.0

echo "starting zookeeper/kafka server"
docker run -d  -p 2181:2181 --name zookeeper-server --network app-tier -e  ALLOW_ANONYMOUS_LOGIN=yes bitnami/zookeeper:latest
docker run -d -p 9092:9092 --name kafka-server --network app-tier -e KAFKA_ZOOKEEPER_CONNECT=zookeeper-server:2181 --env ALLOW_PLAINTEXT_LISTENER=yes  bitnami/kafka:latest 
docker run -it --rm --network app-tier -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 bitnami/kafka:latest kafka-topics.sh --list  --zookeeper zookeeper-server:2181

echo "Running MongoDB"
docker run --network host -p 27017:27017 mongo:latest

echo "Running revrep application"
docker run -ti --network host -p 8001:8001 revrep:v1.0

