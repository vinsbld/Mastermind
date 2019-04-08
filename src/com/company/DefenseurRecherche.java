package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DefenseurRecherche {
    static Scanner nb = new Scanner(System.in);

    static void algoDefenseurRecherche() {

        int longueurDeLaCombinaison = Integer.parseInt(System.getProperty("defenseur_recherche.nombre_case"));
        int nbEssai = Integer.parseInt(System.getProperty("defenseur_recherche.nombre_essai"));

        //creer un nombre aléatoire entre 0 et 9 et place ses chiffres dans un tableau
        Random saisieAttaquant = new Random();
        int[] tabSaisieAttaquant = new int[longueurDeLaCombinaison];
        for (int i = 0; i < tabSaisieAttaquant.length; i++) {
            tabSaisieAttaquant[i] = saisieAttaquant.nextInt(9 + 1);

            Utils.etoileDecoration();
            System.out.println("Votre proposition doit comporter " + longueurDeLaCombinaison + " chiffres allants de 0 à 9");
            Utils.etoileDecoration();

            System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
            String saisieDefenseur = nb.next();


            boolean isUnNombre = saisieDefenseur.matches("[0-9]*");
            /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
            envoie un message d'erreur*/
            while (!isUnNombre) {
                Utils.etoileDecorationPourMaster();
                System.out.println("Vous n'avez pas saisi un nombre !");
                Utils.etoileDecorationPourMaster();
                System.out.println("Entrez votre proposition : ");
                saisieDefenseur = nb.next();
                isUnNombre = saisieDefenseur.matches("[0-9]*");
            }
            /*creer un tableau int et transforme chaque caractères en un entier
             pour pouvoir comparer la saisi du Scan et le tableau Random */
            int[] tabSaisieDefenseur = new int[longueurDeLaCombinaison];
            for (int y = 0; y < tabSaisieDefenseur.length; y++) {
                int converter = Integer.parseInt(String.valueOf(saisieDefenseur.charAt(y)));
                tabSaisieDefenseur[y] = converter;
            }

            /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
            y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai*/
            if (saisieDefenseur.length() < tabSaisieAttaquant.length || saisieDefenseur.length() > tabSaisieAttaquant.length) {
                System.out.println("Votre proposition doit comporter " + longueurDeLaCombinaison + " chiffres allants de 0 à 9");
            }

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
}


