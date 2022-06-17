<div id="top"></div>

# ClientServeurNoSQL

## Présentation

Ce projet à pour but de lister les différents pilotes de F1, d'énumérer leurs palmarès au cours du temps et de faire l'historique de chaque écurie.

Cela comprend donc des pilotes (avec nom, date de naissance et nationalité), des écurires (avec nom, lieu où elle est implantée, nationalité et une liste de pilotes présent dans l'écurie) et des compétitions (avec nom, année, et podium de la course)

On souhaite donc stocker les résultats pour accéder aux podiums d'une course recherchée, trouver tous les podiums d'un pilote ou encore quelle écurie a gagnée quelle course.

## Fonctionnement 

Afin de réaliser ce travail, nous avons utilisé une base de données mongo pour stocker toutes nos données. Et pour récuprérer ces données, nous avons fais des API REST classiques, accessibles via 'PostmanCollection.json' à la racine du projet.

## Explications des services

L'application présente un service pour chaque document de l'application.
Le 'Pilote_Service' permet d'obtenir les données des pilotes contenues dans la base de données. Par exemple, il est possible d'obtenir l'ensemble des pilotes, ou de préciser un selecteur pour resserer la recherche (en indiquant l'id, le nom, la nationalité ou la date de naissance).
Le 'Ecurie_Service' permet d'obtenir les données des écuries. Il est possible de récupérer la liste des écuries complètes, ou de filtrer la recherche avec l'id, la nationalité ou le lieu.
Le 'Competition_Service' fait de même pour les compétitions, et le 'Podium_Service' de même pour les podiums.

## Model

```mermaid
classDiagram
      class Pilote{
            -String name
            -Date dateNaissance
            -String nationalite
      }
      
      class Competition{
            -String name
            -Integer annee
            -List:Pilote podium
      }
      
      class Ecurie{
             -String name
             -String lieu
             -String nationalite
             -List:Pilote pilotes
      }
```

## CONTACT

1. Bauzil Tristan : tristan.bauzil@etu.uca.fr
2. Beaudoux Julien : julien.beaudoux@etu.uca.fr
3. Peyron Hugo : hugo.peyron@etu.uca.fr

<p align="right">(<a href="#top">back to top</a>)</p>
