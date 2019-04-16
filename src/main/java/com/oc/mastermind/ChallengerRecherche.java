package com.oc.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ChallengerRecherche {

    public static Logger logger = LogManager.getLogger();

    static void algoChalengerRecherche() {

        logger.info("l'utilisateur joue à Recherche +/- en mode challenger");

        int longueurDeLaCombinaisonRecherche = Config.longueurDeLaCombinaisonRecherche;
        int nbEssaiRecherche = Config.nbEssaiRecherche;
        int modeDev = Config.modeDev;

        Utils.exceptionLongueur(longueurDeLaCombinaisonRecherche);
        Utils.exceptionNbEssais(nbEssaiRecherche);

        int[] tabSaisieOrdinateur = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaisonRecherche);

        if (modeDev == 1){
            System.out.println("le code secret de l'ordinateur est : "+Arrays.toString(tabSaisieOrdinateur));
        }


        for (int y =1; y <= nbEssaiRecherche; y++){

            String saisieUtilisateur = Utils.essaiUtilisateurRecherche(longueurDeLaCombinaisonRecherche);

            int[] tabSaisieUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonRecherche, saisieUtilisateur);

            System.out.print("Proposition : " + Arrays.toString(tabSaisieUtilisateur) + " | Réponse : ");
            Utils.algoPlusMoins(tabSaisieUtilisateur, tabSaisieOrdinateur);

            if (y == nbEssaiRecherche - 1) {

                logger.info("le joueur n'a plus qu'un essai");
                System.out.println();
                Utils.etoileDecoration();
                System.out.println("Attention dernier essai");
                Utils.etoileDecoration();
                System.out.println();
            }
            if (y == nbEssaiRecherche) {

                logger.info("le joueur a perdu avec la proposition : "+ Arrays.toString(tabSaisieUtilisateur)+" il fallait trouver : "+ Arrays.toString(tabSaisieOrdinateur));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous n'avez pas trouver la combinaison secrete");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }
            if (Arrays.equals(tabSaisieOrdinateur, tabSaisieUtilisateur)) {

                logger.info("le joueur à gagné avec la combinaison "+ Arrays.toString(tabSaisieUtilisateur) +" il fallait trouver la combinaison : "+Arrays.toString(tabSaisieOrdinateur));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous avez trouver la combinaison secrete !");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieOrdinateur));
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinRecherchePlusMoins();
    }
}