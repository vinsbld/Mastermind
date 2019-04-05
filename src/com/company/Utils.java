package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Utils {

    static Scanner nb = new Scanner(System.in);

    public static void algoDefenseur(int []tabSaisieDefenseur, int[]tabSaisieAttaquant, int longueurDelaCombinaison, int nbEssai){

        System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
        String saisieDefenseur = nb.next();
        tabSaisieDefenseur = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabSaisieDefenseur.length; i++) {
            int converter = Integer.parseInt(saisieDefenseur.charAt(i) + "");
            tabSaisieDefenseur[i] = converter;
        }
        Random saisieAttaquant = new Random();
        tabSaisieAttaquant = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabSaisieAttaquant.length; i++) {
            tabSaisieAttaquant[i] = saisieAttaquant.nextInt(9);
        }
    }

    public static void algoChallenger(int[] tabSaisieOrdinateur, int[] tabSaisieUtilisateur, int longueurDeLaCombaison, int nbEssai) {

        Random nbAleatoire = new Random();
        tabSaisieOrdinateur = new int[longueurDeLaCombaison];
        for (int i = 0; i < tabSaisieOrdinateur.length; i++) {
            tabSaisieOrdinateur[i] = nbAleatoire.nextInt(9 + 1);
        }
        System.out.print(Arrays.toString(tabSaisieOrdinateur));
        System.out.println();

        for (int y = nbEssai; y >= 0; y--) {

            String saisieUtilisateur = nb.next();
            tabSaisieUtilisateur = new int[longueurDeLaCombaison];
            for (int i = 0; i < tabSaisieUtilisateur.length; i++) {
                int converter = Integer.parseInt(saisieUtilisateur.charAt(i) + "");
                tabSaisieUtilisateur[i] = converter;
            }
        }
    }

    public static void algoPlusMoins(int[] tab1, int[] tab2) {

        for (int i = 0; i < tab1.length; i++) {
            if (tab1[i] < tab2[i]) {
                System.out.print("+");
            } else if (tab1[i] > tab2[i]) {
                System.out.print("-");
            } else if (tab1[i] == tab2[i]) {
                System.out.print("=");
            }
        }
        System.out.println();
    }

    public static void algoMaster(int[] combinaisonSecrete, int[] attaque) {

        int present = 0;
        int bienPlace = 0;
        for (int i = 0; i < combinaisonSecrete.length; i++) {
            if (attaque[i] == combinaisonSecrete[i]) {
                bienPlace = bienPlace + 1;
            } else {
                for (int y = 0; y < combinaisonSecrete.length; y++) {
                    if (attaque[i] == combinaisonSecrete[y] && attaque[y] != combinaisonSecrete[y]) {
                        present = present + 1;
                        break;
                    }
                }
            }
        }
        System.out.print(present + " present, ");
        System.out.println(bienPlace+ " bien placé" );
    }


        public static void algoComportementRandom ( int tabSaisieAttaquant[], int tabSaisieDefenseur[]){
            Random r = new Random();
            for (int i = 0; i < tabSaisieDefenseur.length; i++) {

                /*si le nombre generé et inferieur ou supereieur à la valeur cible
                   l'ordinateur génére un chiffre entre la valeur [i] et 9 si resultat est +.
                   l'ordinateur génére un chiffre entre la valeur [i] et 0 si resultat est -.
                   En ajoutant +1 dans le random on offre une chance à l'ordinateur
                   de réutiliser le même chiffre plusieurs fois à la même place
                   si il n'a pas trouver sa place.
                 */
                if (tabSaisieAttaquant[i] < tabSaisieDefenseur[i]) {
                    tabSaisieAttaquant[i] = r.nextInt((9 - tabSaisieAttaquant[i]) + 1) + tabSaisieAttaquant[i];
                }
                if (tabSaisieAttaquant[i] > tabSaisieDefenseur[i] ){
                    tabSaisieAttaquant[i] = r.nextInt((tabSaisieAttaquant[i] - 0) + 1) + 0;
                }
                if (tabSaisieAttaquant[i] == tabSaisieDefenseur[i]) {
                    tabSaisieAttaquant[i] = tabSaisieAttaquant[i];
                }
            }
        }

    static void etoileDecoration() {
        for (int i = 1; i <= 47; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    static void hastagDecoration() {
        for (int i = 1; i <= 47; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    static void etoileDecorationPourMaster() {
        for (int i = 1; i <= 60; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}


