# Lemonade App 🍋

Une application Android interactive réalisée avec Jetpack Compose dans le cadre d'un cours de développement mobile.

## 📝 Description

Petit jeu inspiré du principe "Lemonade" : l'utilisateur clique sur l'image pour faire avancer le citron à travers différentes étapes, jusqu'à obtenir un verre de limonade, puis recommencer le cycle.

Le nombre de clics nécessaires pour presser le citron est généré de manière aléatoire à chaque partie (entre 2 et 4 tapotements), rendant chaque parcours unique.

## 🔄 Étapes de l'application

1. **Citronnier** — Un clic génère un nombre aléatoire de tapotements requis pour l'étape suivante.
2. **Citron** — Exige plusieurs clics (selon le nombre généré) pour être pressé.
3. **Verre de limonade** — Un clic permet de boire la limonade.
4. **Verre vide** — Un clic ramène au citronnier de départ.

## 🛠️ Technologies utilisées

* **Langage :** Kotlin
* **UI Framework :** Jetpack Compose
* **Design System :** Material 3

## 📁 Organisation du code

* `MainActivity.kt` : Point d'entrée de l'application. Initialise le thème et affiche le composable `LemonadeApp`.
* `LemonadeApp()` : Composable principal. Gère l'état de l'étape en cours (`etapeActuelle`) et le compteur de tapotements (`nbrDeTapotage`) à l'aide de `remember` et `mutableStateOf`.
* `res/` : Stocke les ressources graphiques et textuelles :
  * `res/drawable` : Images du citronnier, du citron, du verre plein et du verre vide.
  * `res/values/strings.xml` : Textes de l'interface et descriptions d'accessibilité.

## 🚀 Lancer le projet

1. Cloner le dépôt :
   ```bash
   git clone <url-du-depot>
