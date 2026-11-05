# TP2 - Conception Orientée-Objet : Mini-Editeur

**Binôme :** DANIEL Timothé & ROULLE Goulven

**Groupe :** ESIR 2 Informatique option IoT

**Année :** 2026-2027

## Description du projet
Ce projet consiste en la conception et la réalisation d'un mini-éditeur de texte en appliquant les principes de la programmation orientée-objet. Le développement est réalisé "en spirale" avec plusieurs versions successives. 

L'interface homme-machine (IHM) choisie pour ce projet est de type textuelle (console).

### État d'avancement
- [x] **Version 1 :** Implémentation des actions d'édition de base (insérer, sélectionner, copier, couper, coller) sans gestion d'historique.
- [x] **Version 2 :** Intégration du patron de conception *Commande* pour permettre l'enregistrement (scripts) et l'annulation (défaire/refaire) jusqu'au début.

---

## Organisation du dépôt

Le projet est structuré pour séparer clairement les itérations et la documentation métier.

```text
📁 TP2/
├── 📄 README.md                  # Ce fichier (Présentation et Dossier développeur)
├── 📁 v1/                        # Itération 1 (Actions de base)
│   ├── 📁 code_Java/             # Fichiers sources Java (.java) de la V1
│   └── 📁 PlantUML/              # Dossier de conception V1
│       ├── 📁 code_diagramme/    # Fichiers texte PlantUML (.txt)
│       └── 📁 image_diagramme/   # Diagrammes générés (.png)
└── 📁 v2/                        # Itération 2 (Patron Commande & Historique)
    ├── 📁 code_Java/             # Fichiers sources Java (.java) de la V2
    └── 📁 PlantUML/              # Dossier de conception V2
        ├── 📁 code_diagramme/    # Fichiers texte PlantUML (.txt)
        └── 📁 image_diagramme/   # Diagrammes générés (.png)
```

---

## Dossier de Conception (UML)

L'ensemble des modèles statiques et dynamiques a été réalisé avec l'outil PlantUML. 
- **Conception V1 :** Les diagrammes modélisant les actions de base (COLLER, COPIER, COUPER, INSERER, SELECT) sont disponibles sous forme de code brut (`.txt`) et d'images exportées (`.png`) dans `v1/PlantUML/`.
- **Conception V2 :** Les diagrammes illustrant l'intégration du patron Commande (Diagramme de classe, séquence d'exécution des commandes, séquence du UNDO) se trouvent dans `v2/PlantUML/`.

---

## Dossier Développeur (Workspaces V1 & V2)

### Environnement de travail
- **OS :** Windows avec sous-système Linux (WSL: Ubuntu)
- **IDE :** Visual Studio Code (VSCode)
- **Langage :** Java (JDK standard)

### Compilation et Exécution
Toutes les commandes sont à exécuter dans le terminal intégré de VSCode (sous WSL/Ubuntu).

**Pour tester la Version 1 :**
1. Se placer dans le répertoire du code :
   ```bash
   cd v1/code_Java
   ```
2. Compiler l'ensemble des fichiers source Java :
   ```bash
   javac *.java
   ```
3. Lancer l'application :
   ```bash
   java MiniEditeurApp
   ```

**Pour tester la Version 2 :**
1. Se placer dans le répertoire du code :
   ```bash
   cd v2/code_Java
   ```
2. Compiler l'ensemble des fichiers source Java :
   ```bash
   javac *.java
   ```
3. Lancer l'application :
   ```bash
   java MiniEditeurApp
   ```

### Commandes supportées (Console)
Une fois l'application lancée, un prompt `>` apparaît. Vous pouvez saisir les commandes suivantes :

*Commandes communes (V1 & V2) :*
- `INSERER <texte>` : Insère le texte à la position de début de la sélection actuelle.
- `SELECT <debut> <fin>` : Déplace les curseurs de sélection.
- `COPIER` : Copie le texte sélectionné dans le presse-papier.
- `COUPER` : Copie puis efface le texte sélectionné du buffer.
- `COLLER` : Remplace la sélection actuelle par le contenu du presse-papier.
- `QUITTER` : Arrête l'éditeur.

*Commandes exclusives à la V2 :*
- `UNDO` : Annule la dernière action effectuée et restaure l'état précédent.
- `REDO` : Rétablit la dernière action annulée par un `UNDO`.
