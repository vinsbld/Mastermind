package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DefenseurMaster {

    static Scanner nb = new Scanner(System.in);

    static void algoDefenseurMaster() {

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

            Utils.etoileDecorationPourMaster();
            System.out.print("Proposition : " + Arrays.toString(tabSaisieAttaquant) + " | Réponse : ");
            Utils.algoMaster(tabSaisieDefenseur, tabSaisieAttaquant);
            Utils.etoileDecorationPourMaster();
            System.out.println();


            if (y == 1) {

                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }
            if (y == 0) {
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNé !");
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
                System.out.println("l'ordinateur a trouver le code secret");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinMaster();
    }
}

