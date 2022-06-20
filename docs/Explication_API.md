### <a name="top"></a>
# Explications

1. [Pilote](#pilote)
2. [Ecurie](#ecurie)
3. [Competition](#pilote)
4. [Podium](#podium)

## Pilote

1. **Get All** => Retourne tout les pilotes.
    1. Exemple : http://localhost:8080/pilote/

1. **Find By ID** => Retourne le pilote recherché avec son id en paramètre. 
    1. Exemple : http://localhost:8080/pilote/62a30c56d141556cdd21c297

1. **Find By Nationalite** => Retourne tout les pilotes avec la nationalité passé en paramètre. 
    1. Exemple : http://localhost:8080/pilote/nation/FR

1. **Find All Naissance after Date** => Retourne tout les pilotes qui sont nés après la date de naissance donnée. 
    1. Exemple : http://localhost:8080/pilote/naissance/?day=12&month=6&years=2000

1. **Get Nombre of Pilote With Nationalite** => Retourne le nombre de pilote par Pays.
    1. Exemple : http://localhost:8080/pilote/nationalite/Sum/DU

1. **Create** => Permet de crée un objet.
    1. Exemple : http://localhost:8080/pilote/
    1. Objet : 

{
        "nom": "Tristan",
        "dateNaissance": "1997-12-08T00:00:00.000+00:00",
        "nationalite": "FR"
}

1. **Delete** => Permet de supprimer un pilote
    1. Exemple : http://localhost:8080/pilote/62a30ac6d141556cdd21c296

1. **Update** => Permet de modifier un pilote déjà existant
    1. Exemple : http://localhost:8080/pilote/629859a76dee6a05ce365a10
    1. Objet : 

{
    "id": "629859a76dee6a05ce365a10",
    "nom": "Julien Le Bg",
    "dateNaissance": "2000-02-24T23:00:00.000+00:00",
    "nationalite": "Francais"
}

## Ecurie 

1. **Get All** => Retourne toutes les écuries.
    1. Exemple : http://localhost:8080/ecurie/

1. **Find By ID** => Retourne l'ecurie recherché avec son id en paramètre. 
    1. Exemple : http://localhost:8080/ecurie/62986b1487be757e3ba1e905

1. **Find By Name** => Retourne l'ecurie recherché avec son nom passé en paramètre
    1. Exemple : http://localhost:8080/ecurie/name/Mercedes

1. **Find By Nationalite** => Retourne toutes les écuries avec la nationalité passé en paramètre. 
    1. Exemple : http://localhost:8080/ecurie/nationalite/Allemande

1. **Find By Lieu** => Retourne l'ecurie recherché avec son lieu passé en paramètre
    1. Exemple : http://localhost:8080/ecurie/lieu/Berlin

1. **Create** => Permet de crée un objet.
    1. Exemple : http://localhost:8080/ecurie/
    1. Objet : 

{
    "nom": "Mercedes",
    "lieu": "Berlin",
    "nationalite": "Allemande",
    "pilotes": []
}

1. **Delete** => Permet de supprimer un pilote
    1. Exemple : http://localhost:8080/ecurie/6299cd652ed4b1751c16146c

1. **Update** => Permet de modifier une écurie déjà existante
    1. Exemple : http://localhost:8080/ecurie/62a1f058d1f80a27499d2d0f
    1. Objet : 

{
    "nom": "Mercedes",
    "lieu": "Berlin",
    "nationalite": "DU",
    "pilotes": []
}

1. **Add Pilote in Ecurie** => Permet d'ajouter un pilote dans une écurie déjà existante, On passe en premier l'id de l'écurie puis l'id du Pilote
    1. Exemple : http://localhost:8080/ecurie/addPilote/62986b1487be757e3ba1e905/6298598d6dee6a05ce365a0e

## Competition

1. **Get All** => Retourne toutes les Competitions.
    1. Exemple : http://localhost:8080/competition/

1. **Find By ID** => Retourne a Competition recherché avec son id en paramètre. 
    1. Exemple : http://localhost:8080/competition/62986c830c858276ddfcead5

1. **Find By Nom** => Retourne toutes les competition avec le nom passé en paramètre. 
    1. Exemple : http://localhost:8080/competition/nom/LeMans

1. **Find By Annee** => Retourne toutes les competition qui se déroule dans l'année passé en paramètre. 
    1. Exemple : http://localhost:8080/competition/annee/2021

1. **Create** => Permet de crée un objet.
    1. Exemple : http://localhost:8080/competition/
    1. Objet : 

{
    "nom": "Le Mans",
    "annee": 2023,
    "type":"F1",
    "edition": 2,
    "organisateur":"Gouvernement"
}

1. **Delete** => Permet de supprimer une competition
    1. Exemple : http://localhost:8080/competition/62ac749d1175bd6954abb2aa

1. **Update** => Permet de modifier une competition déjà existant
    1. Exemple : http://localhost:8080/competition/62b02ee48756cc1e721cb8e7
    1. Objet : 

    {
        "id": "62b02ee48756cc1e721cb8e7",
        "nom": "Le Mans",
        "annee": 2023,
        "podium": null,
        "type": "F1",
        "edition": 2,
        "organisateur": "Gouvernement"
    }


1. **Set Podium** => Permet d'assigner un podium à une compétition. Le podium doit être crée au préalable. ( une compétition ne peut avoir de podium si elle ne c'est pas encore déroulé : une compétition qui aura lieu l'année prochaine par exemple).

    1. Exemple : http://localhost:8080/competition/setPodium/62ac75ffaee0ea5453733876?idPodium=62ac765aaee0ea5453733877

## Podium

1. **Get All** => Retourne toutes les Competitions.
    1. Exemple : http://localhost:8080/podium/

1. **Find By ID** => Retourne a Competition recherché avec son id en paramètre. 
    1. Exemple : http://localhost:8080/podium/62ac720be096b512ab43ba95

1. **Create** => Permet de crée un objet. :warning: la recherche des pilote ce fait en fonction du nom du pilote, donc il faut écrire le bon nom du pilote. ( on part du principe qu'il n'y a pas 2 pilotes avec le même nom)
    1. Exemple : http://localhost:8080/podium/
    1. Objet : 

{
    "premier":{
        "nom": "Hugo",
        "dateNaissance": "2000-12-08T00:00:00.000+00:00",
        "nationalite": "FR"
    },
    "deuxieme":{
        "nom": "Julien",
        "dateNaissance": "2000-12-08T00:00:00.000+00:00",
        "nationalite": "FR"
    },
    "troisieme":{
        "nom": "Tristan",
        "dateNaissance": "2000-12-08T00:00:00.000+00:00",
        "nationalite": "FR"
    }
}

1. [TOP](#top)
