package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ChallengerMaster {
    static Scanner nb = new Scanner(System.in);

    static void algoChalengerMaster() {

        int longueurDeLaCombaison = 3;
        int nbEssai = 10;
        Random nbAleatoire = new Random();
        int[] tabSaisieOrdinateur = new int[longueurDeLaCombaison];
        for (int i = 0; i < tabSaisieOrdinateur.length; i++) {
            tabSaisieOrdinateur[i] = nbAleatoire.nextInt(9);
        }
       //System.out.print(Arrays.toString(tabSaisieOrdinateur));

        for (int y = nbEssai; y >= 0; y--) {

            Utils.etoileDecorationPourMaster();
            System.out.println("Entrez votre proposition : ");
            String saisieUtilisateur = nb.next();
            Utils.etoileDecorationPourMaster();

            int[] tabSaisieUtilisateur = new int[longueurDeLaCombaison];
            for (int i = 0; i < tabSaisieUtilisateur.length; i++) {
                int converter = Integer.parseInt(saisieUtilisateur.charAt(i) + "");
                tabSaisieUtilisateur[i] = converter;
            }

            System.out.print("Proposition : "+Arrays.toString(tabSaisieUtilisateur)+" | Réponse : ");

            Utils.algoMaster(tabSaisieOrdinateur, tabSaisieUtilisateur);

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
                System.out.println("                    GAGNé !");
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