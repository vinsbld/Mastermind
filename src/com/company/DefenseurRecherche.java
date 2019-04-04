package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DefenseurRecherche {
    static Scanner nb = new Scanner(System.in);

    static void algoDefenseurRecherche() {

        int nbEssai = 10;
        int longueurDelaCombinaison = 3;
        System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
        String saisieDefenseur = nb.next();
        int[] tabSaisieDefenseur = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabSaisieDefenseur.length; i++) {
            int converter = Integer.parseInt(saisieDefenseur.charAt(i) + "");
            tabSaisieDefenseur[i] = converter;
        }
        Random saisieAttaquant = new Random();
        int[] tabSaisieAttaquant = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabSaisieAttaquant.length; i++) {
            tabSaisieAttaquant[i] = saisieAttaquant.nextInt(9);
        }

        for (int y = nbEssai; y >= 0; y--) {

            Utils.algoComportementRandom(tabSaisieAttaquant, tabSaisieDefenseur);

            System.out.print("Proposition : "+Arrays.toString(tabSaisieAttaquant)+" | Réponse : ");
            Utils.algoPlusMoins(tabSaisieAttaquant, tabSaisieDefenseur);
            System.out.println();

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
                System.out.println("                    GAGNé !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur n'a pas trouver la combinaison secrete");
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


