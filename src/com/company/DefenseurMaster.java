package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DefenseurMaster {

    static Scanner nb = new Scanner(System.in);

    static void algoDefenseurMaster() {

        int nbEssai = 10;
        int longueurDelaCombinaison = 3;
        int[] tabSaisieDefenseur = new int[0];

        //creer un nombre aléatoire entre 0 et 9 et place ses chiffres dans un tableau
        Random saisieAttaquant = new Random();
        int[] tabSaisieAttaquant = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabSaisieAttaquant.length; i++) {
            tabSaisieAttaquant[i] = saisieAttaquant.nextInt(9 + 1);

            System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
            String saisieDefenseur = nb.next();

        /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
            envoie un message d'erreur
             */
            boolean isUnNombre = saisieDefenseur.matches("[0-9]*");

            while (!isUnNombre) {
                Utils.etoileDecorationPourMaster();
                System.out.println("Vous n'avez pas saisi un nombre !");
                Utils.etoileDecorationPourMaster();
                System.out.println("Entrez votre proposition : ");
                saisieDefenseur = nb.next();
                isUnNombre = saisieDefenseur.matches("[0-9]*");
            }

            tabSaisieDefenseur = new int[longueurDelaCombinaison];
            for (int y = 0; y < tabSaisieDefenseur.length; y++) {
                int converter = Integer.parseInt(saisieDefenseur.charAt(y) + "");
                tabSaisieDefenseur[y] = converter;
            }

        /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
          y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai*/
            while (saisieDefenseur.length() < tabSaisieAttaquant.length || saisieDefenseur.length() > tabSaisieAttaquant.length) {
                System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres.");
                break;
            }
            if (saisieDefenseur.length() == tabSaisieAttaquant.length) {
                System.out.print("Proposition : " + Arrays.toString(tabSaisieAttaquant) + " | Réponse : ");
                Utils.algoMaster(tabSaisieAttaquant, tabSaisieDefenseur);
            }
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

