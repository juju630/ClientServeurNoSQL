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

## tests
Des tests ont étés fait sur les compétitions afin de vérifier l'instanciation de leur type ils sont fonctionnels et peuvent être lancés.
Un test vérifie qu'on crée bien une compétition de type F1 et l'autre de type F2.

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
            -Podium podium
            -String type
            -int edition
            -String organisateur
      }
      
      class Ecurie{
             -String name
             -String lieu
             -String nationalite
             -List:Pilote pilotes
      }
      
      class Podium{
            -Pilote premier
            -Pilote deuxieme
            -Pilote troisieme
      }
```
PS : un diagramme uml nommé uml_NoSQL.drawio montre le lien entre les documents. Pour l'ouvrir : https://app.diagrams.net/ 

## CONTACT

1. Bauzil Tristan : tristan.bauzil@etu.uca.fr
2. Beaudoux Julien : julien.beaudoux@etu.uca.fr
3. Peyron Hugo : hugo.peyron@etu.uca.fr

<p align="right">(<a href="#top">back to top</a>)</p>
