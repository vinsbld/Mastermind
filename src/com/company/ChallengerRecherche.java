package com.company;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengerRecherche {
    static Scanner nb = new Scanner(System.in);

    static void algoChalengerRecherche() {

        Logger.getLogger(ChallengerRecherche.class).info("l'utilisateur joue à Recherche +/- en mode challenger");

        int longueurDeLaCombinaisonRecherche = Config.longueurDeLaCombinaisonRecherche;
        int nbEssaiRecherche = Config.nbEssaiRecherche;

        Utils.exceptionLongueur(longueurDeLaCombinaisonRecherche);
        Utils.exceptionNbEssais(nbEssaiRecherche);

        int[] tabSaisieOrdinateur = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaisonRecherche);


        for (int y = nbEssaiRecherche; y >= 0; y--) {

            String saisieUtilisateur = Utils.essaiUtilisateurRecherche(longueurDeLaCombinaisonRecherche);

            int[] tabSaisieUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonRecherche, saisieUtilisateur);

            System.out.print("Proposition : " + Arrays.toString(tabSaisieUtilisateur) + " | Réponse : ");
            Utils.algoPlusMoins(tabSaisieUtilisateur, tabSaisieOrdinateur);

            if (y == 1) {

                Logger.getLogger(ChallengerMaster.class).info("le joueur n'a plus qu'un essai");
                System.out.println();
                Utils.etoileDecoration();
                System.out.println("Attention dernier essai");
                Utils.etoileDecoration();
                System.out.println();
            }
            if (y == 0) {

                Logger.getLogger(DefenseurMaster.class).info("le joueur a perdu avec la proposition : "+ Arrays.toString(tabSaisieUtilisateur)+" il fallait trouver : "+ Arrays.toString(tabSaisieOrdinateur));
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

                Logger.getLogger(ChallengerMaster.class).info("le joueur à gagné avec la combinaison "+ Arrays.toString(tabSaisieUtilisateur) +" il fallait trouver la combinaison : "+Arrays.toString(tabSaisieOrdinateur));
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

