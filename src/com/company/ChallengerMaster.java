package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengerMaster {
    static Scanner nb = new Scanner(System.in);

    static void algoChalengerMaster() {

        int longueurDeLaCombinaison = Integer.parseInt(System.getProperty("challenger_master.nombre_case"));
        int nbEssai = Integer.parseInt(System.getProperty("challenger_master.nombre_essai"));
        int nbChiffreAleatoire = Integer.parseInt(System.getProperty("challenger_master.nombre_de_chiffre"));

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