# ClientServeurNoSQL

## Présentation ## 

Ce projet à pour but de lister les différents pilotes de F1, d'énumérer leurs palmarès au cours du temps et de faire l'historique de chaque écurie.

## Model ## 

```mermaid
classDiagram
      class Pilote{
      +String name
      +Date dateNaissance
      +String nationalite
      }
      
      class Competition{
          +String name
          +Integer annee
          +List:Pilote podium
      }
      
      class Ecurie{
        +String name
        +String Lieu
        +String nationalite
        +List:Pilote pilotes
      }
```
