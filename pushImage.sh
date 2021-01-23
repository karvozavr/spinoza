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

echo [Spinoza App STARTING] pushing image $imageFullName...

echo [Spinoza App] pushing image...
docker push $imageFullName

echo [Spinoza App FINISHED] image $imageFullName pushed