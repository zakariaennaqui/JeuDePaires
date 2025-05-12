# 🎮 Jeu de Paires - Projet Java (S6)

Mini projet Java desktop - GI S6 - utilisant :

- Java Swing (interface)
- MVC (architecture)
- JDBC + MySQL (base de données)
- Chronomètre + Scores

## 🧠 Objectif du jeu

Retourner les cartes et retrouver toutes les paires avec un nombre d’essais limité.

## 📸 Capture d’écran

(ajoute une capture ici)

## 📦 Lancer le projet

1. Compiler le projet dans Eclipse
2. Ajouter les images dans `/src/images/`
3. Lancer `Main.java`
4. S’assurer que XAMPP/MySQL tourne avec une base `jeu_paires` contenant :

```sql
CREATE DATABASE IF NOT EXISTS jeu_paires;
USE jeu_paires;
CREATE TABLE IF NOT EXISTS scores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50),
    temps INT
);```

# Présentation

Ce dépôt contient une présentation accessible via le lien suivant :  
👉 [Voir la présentation sur Canva](https://www.canva.com/design/DAGnEi5glsM/s88q1SNn6aB5TgVOD6Q9UA/edit?utm_content=DAGnEi5glsM&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

## Auteur

Nom : *[Votre Nom]*  
GitHub : [https://github.com/zakariaennaqui](https://github.com/zakariaennaqui)
