
# Explications 

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
    1. Exemple : http://localhost:8080/pilote/

1. **Update** => Permet de modifier un pilote déjà existant
    1. Exemple : http://localhost:8080/pilote/629859a76dee6a05ce365a10
    1. Objet : 

{
    "id": "629859a76dee6a05ce365a10",
    "nom": "Julien Le Bg",
    "dateNaissance": "2000-02-24T23:00:00.000+00:00",
    "nationalite": "Francais"
}
