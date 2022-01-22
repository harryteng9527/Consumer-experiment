#!/bin/bash

s_password=000000
cd ~
echo $s_password | sudo apt-get -y update

sudo apt-get install -y openjdk-11-jdk
echo "jdk 11 has been installed"

mkdir kafka
cd kafka
wget https://downloads.apache.org/kafka/3.0.0/kafka_2.13-3.0.0.tgz 
tar -xzf kafka_2.13-3.0.0.tgz
echo "have installed kafka3.0.0"

mkdir /tmp/zookeeper

cd ~/kafka/Kafka_2.13-3.0.0

