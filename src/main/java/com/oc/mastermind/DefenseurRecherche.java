package com.oc.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import java.util.Scanner;

public class DefenseurRecherche {

    public static Logger logger = LogManager.getLogger();
    
    static Scanner nb = new Scanner(System.in);

    static void algoDefenseurRecherche() {

        logger.info("L'utilisateur joue à Recherche +/- en mode Défenseur");

        int longueurDeLaCombinaisonRecherche = Config.longueurDeLaCombinaisonRecherche;
        int nbEssaiRecherche = Config.nbEssaiRecherche;

        Utils.exceptionLongueur(longueurDeLaCombinaisonRecherche);
        Utils.exceptionNbEssais(nbEssaiRecherche);


        int[] tabSaisieAttaquant = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaisonRecherche);

        String saisieDefenseur = Utils.saisieUtilisateurRecherche(longueurDeLaCombinaisonRecherche);

        int[] tabSaisieDefenseur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonRecherche, saisieDefenseur);

        //pas de mode developpeur pour ce mode car le code secret de l'utilisateur est affiché par défaut

        Utils.etoileDecoration();
        System.out.println("Votre code secret est " + Arrays.toString(tabSaisieDefenseur));
        Utils.etoileDecoration();

        for (int y = 1; y <= nbEssaiRecherche; y++) {

            Utils.algoComportementRandomRecherhe(tabSaisieAttaquant, tabSaisieDefenseur);
            Utils.etoileDecoration();
            System.out.print("Proposition : " + Arrays.toString(tabSaisieAttaquant) + " | Réponse : ");
            Utils.algoPlusMoins(tabSaisieAttaquant, tabSaisieDefenseur);
            Utils.etoileDecoration();
            System.out.println();

            if (y == nbEssaiRecherche - 1) {

                logger.info("le joueur n'a plus qu'un essai");
                Utils.etoileDecoration();
                System.out.println("Attention dernier essai");
                Utils.etoileDecoration();
                System.out.println();
            }

            if (y == nbEssaiRecherche) {

                logger.info("le joueur a gagné !  l'odinateur a fait la proposition : "+ Arrays.toString(tabSaisieAttaquant)+"l'ordinateur n'a pas trouvé : "+ Arrays.toString(tabSaisieDefenseur));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur n'a pas trouvé le code secret");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }

            if (Arrays.equals(tabSaisieAttaquant, tabSaisieDefenseur)) {

                logger.info("le joueur a perdu avec la combinaison : "+Arrays.toString(tabSaisieAttaquant)+" l'odinateur a trouvé : "+ Arrays.toString(tabSaisieDefenseur));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur a trouvé la combinaison secrete");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinRecherchePlusMoins();
    }
}



