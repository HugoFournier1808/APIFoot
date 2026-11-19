# APIFoot - Projet Spring Boot (Sprint 1)

**Équipe de développement :**
* Hugo Fournier
* Golliot Bastian

##  Présentation du projet
Ce projet est une API REST CRUD développée avec Spring Boot sur le thème du football.
Elle permet de gérer des équipes et des joueurs avec une relation de base de données (One-to-Many / Many-to-One).

##  Technologies utilisées
* Java 21
* Spring Boot 3.3.4 (Web, Data JPA, Validation)
* Base de données H2 (en mémoire)
* Lombok

##  Endpoints de l'API
L'API tourne par défaut sur `http://localhost:8085`.

### Équipes
* `GET /api/equipes` : Récupérer toutes les équipes
* `POST /api/equipes` : Créer une équipe

### Joueurs
* `GET /api/joueurs` : Récupérer tous les joueurs
* `GET /api/joueurs/{id}` : Récupérer un joueur spécifique
* `POST /api/joueurs` : Créer un joueur (nécessite un `equipeId`)
* `PUT /api/joueurs/{id}` : Modifier un joueur
* `DELETE /api/joueurs/{id}` : Supprimer un joueur