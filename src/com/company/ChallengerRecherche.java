package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengerRecherche {
    static Scanner nb = new Scanner(System.in);

    static void algoChalengerRecherche() {

        int longueurDeLaCombinaison = Integer.parseInt(System.getProperty("challenger_recherche.nombre_case"));
        int nbEssai = Integer.parseInt(System.getProperty("challenger_recherche.nombre_essai"));

        int[] tabSaisieOrdinateur = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaison);


        for (int y = nbEssai; y >= 0; y--) {

            String saisieUtilisateur = Utils.essaiUtilisateurRecherche(longueurDeLaCombinaison);

            int[] tabSaisieUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaison, saisieUtilisateur);

            System.out.print("Proposition : " + Arrays.toString(tabSaisieUtilisateur) + " | Réponse : ");
            Utils.algoPlusMoins(tabSaisieUtilisateur, tabSaisieOrdinateur);

            if (y == 1) {

                System.out.println();
                Utils.etoileDecoration();
                System.out.println("Attention dernier essai");
                Utils.etoileDecoration();
                System.out.println();
            }
            if (y == 0) {

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

