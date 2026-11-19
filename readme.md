# APIFoot — API REST Spring Boot

## Membres du groupe
* Hugo Fournier
* Golliot Bastian

## Présentation du projet
APIFoot est une API REST en Java / Spring Boot permettant de gérer des équipes de football et leurs joueurs via des opérations CRUD complètes.
Le modèle repose sur une relation **One-to-Many / Many-to-One** : une équipe regroupe plusieurs joueurs et chaque joueur est rattaché à une équipe.

## Architecture
Le projet suit un découpage en couches strict :
`Controller (DTO)` -> `Service (Interface / Implémentation)` -> `Repository (Entity)`

## Technologies utilisées
* Java 21
* Spring Boot 3.3.4 (Web, Data JPA, Validation)
* Lombok (constructeurs, getters et setters générés par annotations)
* Base de données H2 / PostgreSQL
* Collection **Bruno** incluse à la racine pour tester les routes CRUD

## Endpoints principaux (`http://localhost:8085`)
* **Équipes :** `GET /api/equipes`, `GET /api/equipes/{id}`, `POST /api/equipes`, `PUT /api/equipes/{id}`, `DELETE /api/equipes/{id}`
* **Joueurs :** `GET /api/joueurs`, `GET /api/joueurs/{id}`, `POST /api/joueurs`, `PUT /api/joueurs/{id}`, `DELETE /api/joueurs/{id}`