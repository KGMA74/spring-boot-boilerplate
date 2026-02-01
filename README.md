# Spring Boot Boilerplate

Un boilerplate Spring Boot moderne avec pipeline CI/CD automatisée via GitHub Actions.

## Fonctionnalités

- Spring Boot 3.x - Framework Java moderne
- JDK 21 - Dernière LTS
- Gradle - Build automation
- Docker - Containerisation
- GitHub Actions - CI/CD pipeline complète
- Auto-deployment - Déploiement automatique sur VPS
- DockerHub - Registre d'images

## Pipeline CI/CD

La pipeline s'exécute automatiquement à chaque push sur main :

```
Code Push
  ↓
Compile (Gradle)
  ↓
Unit Tests
  ↓
Build JAR
  ↓
Build Docker Image → Push DockerHub
  ↓
SSH Deploy → VPS (port 8081)
```

### Jobs

| Job | Étape | Description |
|-----|-------|-------------|
| compile | Build | Compilation du code |
| unit-tests | Test | Exécution des tests |
| build | Package | Construction du JAR |
| build-image | Docker | Build et push vers DockerHub |
| deploy | Deploy | Déploiement sur VPS via SSH |

## Configuration

### Variables d'environnement (.env)
```properties
PROFILE=dev|prod
JAVA_OPTS=-Xmx512m
```

### Secrets GitHub requises

- DOCKERHUB_USERNAME - Username DockerHub
- DOCKERHUB_TOKEN - Token d'accès DockerHub
- VPS_USERNAME - User SSH VPS
- VPS_HOSTNAME - IP/Domaine VPS
- SSH_PRIVATE_KEY - Clé SSH pour authentification

## Déploiement

### Sur VPS
```bash
docker pull VOTRE_USERNAME/spring-boot-boilerplate:latest
docker run -d --name spring-app -p 8081:8080 VOTRE_USERNAME/spring-boot-boilerplate:latest
```

### Statut
Accessible sur : http://VPS_IP:8081

## Prochaines étapes

- Authentification (OAuth2/JWT)
- Intégration Keycloak
- Base de données (PostgreSQL/MongoDB)
- Logging (ELK Stack)
- Monitoring & Alertes

## Ressources

- Spring Boot Docs: https://spring.io/projects/spring-boot
- Docker Docs: https://docs.docker.com/
- GitHub Actions: https://docs.github.com/en/actions
