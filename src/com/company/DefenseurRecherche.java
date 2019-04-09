package com.company;

import java.util.Arrays;

import java.util.Scanner;

public class DefenseurRecherche {
    static Scanner nb = new Scanner(System.in);

    static void algoDefenseurRecherche() {

        int longueurDeLaCombinaison = Integer.parseInt(System.getProperty("defenseur_recherche.nombre_case"));
        int nbEssai = Integer.parseInt(System.getProperty("defenseur_recherche.nombre_essai"));

        int[] tabSaisieAttaquant = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaison);

        String saisieDefenseur = Utils.saisieUtilisateurRecherche(longueurDeLaCombinaison);

        int[] tabSaisieDefenseur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaison, saisieDefenseur);

        Utils.etoileDecoration();
        System.out.println("Votre code secret est " + Arrays.toString(tabSaisieDefenseur));
        Utils.etoileDecoration();

        for (int y = nbEssai; y >= 0; y--) {

            Utils.algoComportementRandom(tabSaisieAttaquant, tabSaisieDefenseur);
            Utils.etoileDecoration();
            System.out.print("Proposition : " + Arrays.toString(tabSaisieAttaquant) + " | Réponse : ");
            Utils.algoPlusMoins(tabSaisieAttaquant, tabSaisieDefenseur);
            Utils.etoileDecoration();
            System.out.println();

            if (y == 1) {

                Utils.etoileDecoration();
                System.out.println("Attention dernier essai");
                Utils.etoileDecoration();
                System.out.println();
            }

            if (y == 0) {
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur n'a pas trouver le code secret");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }

            if (Arrays.equals(tabSaisieAttaquant, tabSaisieDefenseur)) {
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur a trouver la combinaison secrete");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinRecherchePlusMoins();
    }
}



