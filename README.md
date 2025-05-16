# 🎮 Jeu de Paires - Mini Projet Java S6

Projet académique réalisé dans le cadre du module Java (GI S6 - 2024/2025).  
Ce jeu de mémoire consiste à retrouver toutes les paires d'images en un temps limité, avec 3 essais.

---

## ⚙️ Technologies utilisées

- Java Swing (interface)
- JDBC + MySQL (base de données, connexion MySQL)
- Modèle MVC (architecture)
- Interface graphique desktop
- Gestion de scores avec base de données

---

## 🧠 Objectif du jeu

Retourner les cartes et retrouver toutes les paires avec un nombre d’essais limité.
- Une grille 4x4 de cartes retournées
- Chaque image est présente en double
- Le joueur doit retrouver toutes les paires
- 3 essais sont autorisés en cas d’erreur
- Le temps est chronométré
- Si le joueur réussit, son score est enregistré en base s’il est dans le top 3

---

## 📁 Structure du projet

- jeu-de-paires-java/
- ├── assets/
- ├── src/
- │ ├── model/
- │ ├── view/
- │ ├── controller/
- │ └── images/
- ├── README.md
- └── db.sql

---

## 📸 Démonstration

Voici quelques captures d’écran illustrant les principales fonctionnalités de l'application :

<table>
  <tr>
    <td><img src="assets/img1.png" alt="Capture 1" width="300"/></td>
    <td><img src="assets/img2.png" alt="Capture 2" width="300"/></td>
  </tr>
  <tr>
    <td><img src="assets/img3.png" alt="Capture 3" width="300"/></td>
    <td><img src="assets/img4.png" alt="Capture 4" width="300"/></td>
  </tr>
</table>

---

## Présentation
- 👉 [S](https://jeudepaires.my.canva.site/v1)
- 👉 [Voir la présentation](https://www.canva.com/design/DAGnEi5glsM/s88q1SNn6aB5TgVOD6Q9UA/edit?utm_content=DAGnEi5glsM&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

---

## Auteur

- Nom : *Achraf Abdelfadel* [https://github.com/abdelfadelAchraf](https://github.com/abdelfadelAchraf)
- Nom : *Samir Ait said* [https://github.com/username](https://github.com/username)
- Nom : *Saad El Aroui* [https://github.com/Saadar0](https://github.com/Saadar0)
- Nom : *zakaria ennaqui* [https://github.com/zakariaennaqui](https://github.com/zakariaennaqui)

---

## 🛠 Installation and Usage

### 1. Clone the Repository

Start by cloning the repository to your local machine:

```bash
git clone https://github.com/zakariaennaqui/JeuDePaires.git
cd mini-compiler

### 2. 📦 Lancer le projet

1. Compiler le projet dans Eclipse
2. Lancer `Main.java`
3. S’assurer que XAMPP/MySQL tourne avec une base `jeu_paires` (db.sql) contenant :

```sql
CREATE DATABASE IF NOT EXISTS jeu_paires;
USE jeu_paires;
CREATE TABLE IF NOT EXISTS scores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50),
    temps INT
);

