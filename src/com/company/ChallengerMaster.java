package com.company;

import org.apache.log4j.Logger;

import java.util.Arrays;


public class ChallengerMaster {

    static void algoChallengerMaster() {

        Logger.getLogger(ChallengerRecherche.class).info("l'utilisateur joue à mastermind en mode challenger");

        int longueurDeLaCombinaison = Config.longueurDeLaCombinaison;
        int nbEssai = Config.nbEssai;
        int nbChiffreAleatoire = Config.nbChiffreAleatoire;

        Utils.exceptionNbAleatoireMaster(nbChiffreAleatoire);

        int[] tabSaisieOrdinateur = Utils.initialiseTableauRandomMaster(longueurDeLaCombinaison, nbChiffreAleatoire);

        for (int y = nbEssai; y >= 0; y--) {

            String saisieUtilisateur = Utils.essaiUtilisateurMaster(longueurDeLaCombinaison, nbChiffreAleatoire);

            int[] tabSaisieUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaison, saisieUtilisateur);

            if (y == 1) {

                System.out.println();
                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }
            if (y == 0) {

                Utils.etoileDecorationPourMaster();
                System.out.println();
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("vous n'avez pas trouver la combinaison secrete");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }
            if (Arrays.equals(tabSaisieOrdinateur, tabSaisieUtilisateur)) {

                Utils.etoileDecorationPourMaster();
                System.out.println();
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous avez trouver la combinaison secrete !");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinMaster();
    }
}