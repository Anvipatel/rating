#!/bin/sh

iptables -F
echo "y" | docker system prune

cd $HOME/rating

#building maven command
echo "run maven clean/install"
mvn clean install


echo "building revrep docker image"
docker build -t rating .

echo "Renaming docker image"
docker tag rating:latest rating:v1.0

echo "Running revrep application"
docker run -ti --net=host rating:v1.0