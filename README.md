# masterMind

le joueur a le choix entre deux jeux : 

.Recherche +/-

    Le joueur doit découvrir la combinaison à x chiffres de l'adversaire (le défenseur).
    Pour ce faire l'attaquant fait une proposition. 
    Le défenseur indique pour chaque chiffre de la combinaison proposée 
    si le chiffre de sa combinaison est plus grand (+) 
    si le chiffre est plus petit (-), 
    si c'est le bon chiffre (=).

.Mastermind

    Le but : découvrir la combinaison à x chiffres/couleurs de l'adversaire(le défenseur). 
    Pour ce faire, l'attaquant fait une proposition. 
    Le défenseur indique pour chaque proposition le nombre dechiffre/couleur 
    de la proposition qui apparaissent à la bonne place et à la mauvaise place dans la combinaison secrète.
    L'attaquant doit deviner la combinaison secrète en un nombre limitéd'essais.

.Chaque jeu pourra être joué selon 3 modes :

    1.Mode ​challenger​ où vous devez trouver la combinaison secrètede l'ordinateur
    2.Mode ​défenseur​ où c'est à l'ordinateur de trouver votrecombinaison secrète
    3.Mode ​duel​ où l'ordinateur et vous jouez tour à tour, le premier àtrouver la combinaison secrète de l'autre a gagné

Project 3 - JDK 11

Lancer l'application en mode console : 

    en mode debug :
        java -jar "\mastMind.jar" dev

    en mode joueur :
        java -jar "\mastMind.jar"
        
    *vous pouvez entrer "java -java" puis faire glisser le fichier .jar dans la console
    appuyez sur entrer pour le mode joueur,
    ajouter "dev" puis entrer pour le mode developpeur.
        
Modifiez les paramètres des jeux grace au fichier : 

    config.properties : 
    \mastMind\src\main\resources

Récurérez le fichier "log" :

    C:\logs
    