
# Projet de Gestion d'une Base de Données avec JDBC

## Description
Ce projet Java démontre comment interagir avec une base de données MySQL en utilisant JDBC (Java Database Connectivity).
Il contient plusieurs fonctionnalités pour gérer des utilisateurs, des événements, des réservations, des salles et des terrains.

## Structure du Projet
- **`JDBCExample.java`** : 
  - Contient les méthodes pour sélectionner, insérer, mettre à jour et supprimer des enregistrements dans les tables de la base de données.
  - Gère les opérations sur les tables `users`, `events`, `reservation`, `salles`, et `terrains`.
  
- **`Main.java`** : 
  - Fournit une interface console pour interagir avec les différentes fonctionnalités du programme.
  - Permet de choisir une table et d'effectuer des opérations CRUD (Create, Read, Update, Delete).

- **`Sript.sql`** : 
  - Contient le script SQL pour créer les tables nécessaires dans la base de données et les initialiser.

## Configuration
1. **Base de Données** :
   - **URL** : `jdbc:mysql://localhost:3306/rendu01`
   - **Utilisateur** : `root`
   - **Mot de passe** : vide (à adapter selon votre configuration).

2. **Dépendances** :
   - Assurez-vous d'avoir le connecteur JDBC MySQL dans votre projet.

3. **Création de la Base** :
   - Exécutez le fichier `Sript.sql` pour créer les tables nécessaires.

## Utilisation
1. Compilez le projet en utilisant un IDE ou en ligne de commande.
2. Lancez le fichier `Main.java` pour accéder au menu principal.
3. Suivez les instructions pour manipuler les tables.

## Fonctionnalités Clés
- **Users** : Gérer les utilisateurs avec des champs comme nom, prénom, email, type.
- **Events** : Créer et gérer des événements.
- **Reservations** : Associer des utilisateurs à des événements, salles, ou terrains.
- **Salles** : Ajouter et gérer les salles avec des informations de capacité.
- **Terrains** : Gérer les terrains avec leur type.

## Exigences
- **Java** : Java 8 ou version supérieure.
- **Base de Données** : MySQL 5.7 ou version supérieure.

## Auteurs
Ce projet a été réalisé dans le cadre d'un apprentissage des bases de données avec JDBC par Achtout Moahmed a ESTE 2024/2025.
