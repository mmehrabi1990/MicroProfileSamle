#!/bin/sh
mvn clean package && docker build -t org.mehrabi/MicroProfileSamle .
docker rm -f MicroProfileSamle || true && docker run -d -p 8080:8080 -p 4848:4848 --name MicroProfileSamle org.mehrabi/MicroProfileSamle
