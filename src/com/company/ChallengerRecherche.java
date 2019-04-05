package com.company;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ChallengerRecherche {
    static Scanner nb = new Scanner(System.in);

    static void algoChalengerRecherche() {

        int longueurDeLaCombaison = 3;
        int nbEssai = 10;
        Random nbAleatoire = new Random();
        int[] tabSaisieOrdinateur = new int[longueurDeLaCombaison];
        for (int i = 0; i < tabSaisieOrdinateur.length; i++) {
            tabSaisieOrdinateur[i] = nbAleatoire.nextInt(9 + 1);
        }
        // System.out.print(Arrays.toString(tabSaisieOrdinateur));

        for (int y = nbEssai; y >= 0; y--) {

            Utils.etoileDecoration();
            System.out.println("Entrez votre proposition : ");
            String saisieUtilisateur = nb.next();

            /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
            envoie un message d'erreur */
            boolean isUnNombre = saisieUtilisateur.matches("[0-9]*");

            while (!isUnNombre) {
                Utils.etoileDecoration();
                System.out.println("Vous n'avez pas saisi un nombre !");
                y++;
                Utils.etoileDecoration();
                System.out.println("Entrez votre proposition : ");
                saisieUtilisateur = nb.next();
                isUnNombre = saisieUtilisateur.matches("[0-9]*");
            }
            Utils.etoileDecoration();

            int[] tabSaisieUtilisateur = new int[longueurDeLaCombaison];
            for (int i = 0; i < tabSaisieUtilisateur.length; i++) {
                int converter = Integer.parseInt(saisieUtilisateur.charAt(i) + "");
                tabSaisieUtilisateur[i] = converter;
            }
            /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
             y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai
            */
            while (saisieUtilisateur.length() < tabSaisieOrdinateur.length || saisieUtilisateur.length() > tabSaisieOrdinateur.length) {
                System.out.println("Votre proposition doit comporter " + longueurDeLaCombaison + " chiffres.");
                y++;
                break;
            }
            if (saisieUtilisateur.length() == tabSaisieOrdinateur.length) {
                System.out.print("Proposition : " + Arrays.toString(tabSaisieUtilisateur) + " | Réponse : ");
                Utils.algoPlusMoins(tabSaisieUtilisateur, tabSaisieOrdinateur);
            }
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
                System.out.println("                    GAGNé !");
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

