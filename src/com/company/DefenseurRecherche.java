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

            System.out.print("Proposition : "+Arrays.toString(tabSaisieAttaquant)+" | Réponse : ");

            System.out.println();
            System.out.print("Réponse : ");
            Utils.algoPlusMoins(tabSaisieDefenseur, tabSaisieAttaquant);
            System.out.println();

            if (y == 1) {
                System.out.println("Attention dernier essai");
            }
            if (y == 0) {
                System.out.println("Gagné ! l'ordinateur n'a pas trouver la combinaison secrete");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }
            if (Arrays.equals(tabSaisieAttaquant, tabSaisieDefenseur)) {
                System.out.println("Perdu ! l'ordinateur a trouver la combinaison secrete");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }
        }
    }
}


