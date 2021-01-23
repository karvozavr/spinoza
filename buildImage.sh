#!/bin/bash

set -e

imageTag=$1

if [ -z "$1" ]
  then
    echo 'No imageTag provided. Latest will be used.'
    imageTag=latest
fi

repositoryName='891417887833.dkr.ecr.us-east-2.amazonaws.com/spinoza'
imageFullName="$repositoryName:$imageTag"

echo [Spinoza App STARTING] building $imageFullName...

echo [Spinoza App] creating jar...
(exec "${BASH_SOURCE%/*}/gradlew" bootJar --no-daemon)

echo [Spinoza App] creating docker image...
docker build -t $imageFullName ${BASH_SOURCE%/*}

echo [Spinoza App FINISHED] image built sucessfully