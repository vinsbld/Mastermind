package com.company;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    static Scanner nb = new Scanner(System.in);

    /************************************************************************************/
    /************************** fonctions pour Mastermind *******************************/

    public static int[] initialiseTableauRandomMaster(int longueurDelaCombinaison, int nombreDeChiffre) {

        Random nbAleatoire = new Random();
        int[] tabSaisieOrdinateur = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabSaisieOrdinateur.length; i++) {
            tabSaisieOrdinateur[i] = nbAleatoire.nextInt(nombreDeChiffre);
        }
        return tabSaisieOrdinateur;
    }

    public static String saisieUtilisateurMaster(int longueurDelaCombinaison, int nbChiffreAleatoire) {

        boolean isUnNombre;
        String nbSecretUtilisateur;

        do {
            Utils.etoileDecorationPourMaster();
            System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à " + nbChiffreAleatoire);
            Utils.etoileDecorationPourMaster();
            System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
            nbSecretUtilisateur = nb.next();
            isUnNombre = nbSecretUtilisateur.matches("[0-" + nbChiffreAleatoire + "]*");
        } while (!isUnNombre || nbSecretUtilisateur.length() != longueurDelaCombinaison);
        return nbSecretUtilisateur;
    }

    public static String essaiUtilisateurMaster(int longueurDelaCombinaison, int nbChiffreAleatoire) {

        boolean isUnNombre;
        String nbSecretUtilisateur;

        do {
            Utils.etoileDecorationPourMaster();
            System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à " + nbChiffreAleatoire);
            Utils.etoileDecorationPourMaster();
            System.out.print("saisisez votre proposition : ");
            nbSecretUtilisateur = nb.next();
            Utils.etoileDecorationPourMaster();
            isUnNombre = nbSecretUtilisateur.matches("[0-" + nbChiffreAleatoire + "]*");
        } while (!isUnNombre || nbSecretUtilisateur.length() != longueurDelaCombinaison);
        return nbSecretUtilisateur;
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
        System.out.println(bienPlace + " bien placé");
    }

    //décoration * pour Maestermind
    public static void etoileDecorationPourMaster() {
        for (int i = 1; i <= 60; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    //renvoie un message d'erreur quand le chiffre n'est pas conforme
    public static void exceptionNbAleatoireMaster(int nbChiffreAleatoire) {

        if (nbChiffreAleatoire < 0 || nbChiffreAleatoire > 10) {
            //logger.warn("le nombre de chiffre utilisable n'est pas conforme ([4-10])")
            Utils.etoileDecorationPourMaster();
            System.out.println("Les chiffres utilisables vont de (0 - 4 à 10)");
            System.out.println("Merci de saisir une valeur correct dans le fichier config.properties");
            Utils.etoileDecorationPourMaster();
        }
    }

    /************************************************************************************/
    /******************************* fonctions communes *********************************/

    public static int[] initialiseTableauUtilisateur(int longueurDelaCombinaison, String saisieUtilisateur){

        int[] tabNbSecretUtil = new int[longueurDelaCombinaison];
        for (int j = 0; j < tabNbSecretUtil.length; j++) {
            int converter = Integer.parseInt(String.valueOf(saisieUtilisateur.charAt(j)));
            tabNbSecretUtil[j] = converter;
        }
        return tabNbSecretUtil;
    }

    public static void algoComportementRandom(int tabSaisieAttaquant[], int tabSaisieDefenseur[]) {
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
            if (tabSaisieAttaquant[i] > tabSaisieDefenseur[i]) {
                tabSaisieAttaquant[i] = r.nextInt((tabSaisieAttaquant[i] - 0) + 1) + 0;
            }
            if (tabSaisieAttaquant[i] == tabSaisieDefenseur[i]) {
                tabSaisieAttaquant[i] = tabSaisieAttaquant[i];
            }
        }
    }

    /************************************************************************************/
    /**************************** fonctions Recherche +/- *******************************/

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

    //décoration * pour menus et recherche +/-
    public static void etoileDecoration() {
        for (int i = 1; i <= 47; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    //décoration # pour menus et recherche +/-
    public static void hastagDecoration() {
        for (int i = 1; i <= 47; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    public static int[] initialiseTableauRandomRecherche(int longueurDelaCombinaison) {

        Random nbAleatoire = new Random();
        int[] tabSaisieOrdinateur = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabSaisieOrdinateur.length; i++) {
            tabSaisieOrdinateur[i] = nbAleatoire.nextInt(10);
        }
        return tabSaisieOrdinateur;
    }

}