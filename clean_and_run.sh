#!/bin/bash

set -e

imageFullName="spinoza:latest"

echo [Spinoza App STARTING] building $imageFullName...

echo [Spinoza App] creating jar...
(exec "${BASH_SOURCE%/*}/gradlew" clean build --no-daemon)

echo [Spinoza App] cleaning up old images...
docker-compose rm -f

echo [Spinoza App] building docker image and starting app using docker-compose...
docker-compose up --build