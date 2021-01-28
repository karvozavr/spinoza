![Deploy to Amazon ECS](https://github.com/karvozavr/spinoza/workflows/Deploy%20to%20Amazon%20ECS/badge.svg?branch=main)

# spinoza backend

Spinoza — is a web service currently capable of giving you the "hello" page. Yet, there is more to come 😄.

## Build

Build and run with gradle:
```bash
./gradlew bootRun
```

Build and run with Docker:
```bash
docker-compose up
```

## Deploy

AWS deployment described in `.github/workflows/aws_production_deploy.yml`
