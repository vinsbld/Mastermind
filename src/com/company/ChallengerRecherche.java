package com.company;

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
            tabSaisieOrdinateur[i] = nbAleatoire.nextInt(9);
        }
        System.out.print(Arrays.toString(tabSaisieOrdinateur));
        System.out.println();

        for (int y = nbEssai; y >= 0; y--) {

            String saisieUtilisateur = nb.next();
            int[] tabSaisieUtilisateur = new int[longueurDeLaCombaison];
            for (int i = 0; i < tabSaisieUtilisateur.length; i++) {
                int converter = Integer.parseInt(saisieUtilisateur.charAt(i) + "");
                tabSaisieUtilisateur[i] = converter;
            }
                System.out.print("Réponse : ");

                Utils.algoPlusMoins(tabSaisieUtilisateur, tabSaisieOrdinateur);

                System.out.println();

                if (y == 1) {
                    System.out.println("Attention dernier essai");
                }
                if (y == 0) {
                    System.out.println("Perdu ! vous n'avez pas trouver la combinaison secrete");
                    System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieOrdinateur));
                    break;
                }
                if (Arrays.equals(tabSaisieOrdinateur, tabSaisieUtilisateur)) {
                    System.out.println("Bravo vous avez trouver la combinaison secrete !");
                    System.out.println("La combinaison été : " + Arrays.toString(tabSaisieOrdinateur));
                }
            }
        }
    }

