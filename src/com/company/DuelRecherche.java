package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DuelRecherche {
    static Scanner nb = new Scanner(System.in);

    static void algoDuelRecherche() {
        int longueurDelaCombinaison = 3;
        int nbEssai = 10;

        Random nbAleatoire = new Random();
        int[] tabNbSecretCpu = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabNbSecretCpu.length; i++) {
            tabNbSecretCpu[i] = nbAleatoire.nextInt(9);
        }

        System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
        String nbSecretUtilisateur = nb.next();

                /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
            envoie un message d'erreur
             */
        boolean isUnNombre = nbSecretUtilisateur.matches("[0-9]*");

        while (!isUnNombre) {
            Utils.etoileDecoration();
            System.out.println("Vous n'avez pas saisi un nombre !");
            Utils.etoileDecoration();
            System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
            nbSecretUtilisateur = nb.next();
            isUnNombre = nbSecretUtilisateur.matches("[0-9]*");
        }

        int[] tabNbSecretUtil = new int[longueurDelaCombinaison];
        for (int j = 0; j < tabNbSecretUtil.length; j++) {
            int converter = Integer.parseInt(nbSecretUtilisateur.charAt(j) + "");
            tabNbSecretUtil[j] = converter;
        }

        /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
          y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai*/
        while (nbSecretUtilisateur.length() < tabNbSecretCpu.length || nbSecretUtilisateur.length() > tabNbSecretCpu.length) {
            Utils.etoileDecoration();
            System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres.");
            Utils.etoileDecoration();
            System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
            nbSecretUtilisateur = nb.next();
            break;
        }
        if (nbSecretUtilisateur.length() == tabNbSecretCpu.length) {

            Utils.etoileDecoration();
            System.out.println("Votre code secret est : " + Arrays.toString(tabNbSecretUtil));
            Utils.etoileDecoration();
            System.out.println();

            for (int i = nbEssai; i >= 0; i--) {

                Utils.etoileDecoration();
                System.out.print("saisisez votre proposition : ");
                String essaiUtilisateur = nb.next();
                Utils.etoileDecoration();

                /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
                envoie un message d'erreur */
                isUnNombre = essaiUtilisateur.matches("[0-9]*");

                while (!isUnNombre) {
                    Utils.etoileDecoration();
                    System.out.println("Vous n'avez pas saisi un nombre !");
                    Utils.etoileDecoration();
                    System.out.print("saisisez votre proposition : ");
                    essaiUtilisateur = nb.next();
                    isUnNombre = essaiUtilisateur.matches("[0-9]*");
                    i++;
                }

                int[] tabEssaiUtilisateur = new int[longueurDelaCombinaison];
                for (int k = 0; k < tabEssaiUtilisateur.length; k++) {
                    int convEassaiUtilisateur = Integer.parseInt(essaiUtilisateur.charAt(k) + "");
                    tabEssaiUtilisateur[k] = convEassaiUtilisateur;
                }

                /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
                y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai*/
                while (essaiUtilisateur.length() < tabNbSecretCpu.length || essaiUtilisateur.length() > tabNbSecretCpu.length) {

                    Utils.etoileDecoration();
                    System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres.");
                    Utils.etoileDecoration();
                    System.out.print("saisisez votre proposition : ");
                    essaiUtilisateur = nb.next();
                    i++;
                }
                if (essaiUtilisateur.length() == tabNbSecretCpu.length) {

                    Utils.etoileDecoration();
                    System.out.print("saisisez votre proposition : ");
                    essaiUtilisateur = nb.next();
                    Utils.etoileDecoration();

                      /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
                      envoie un message d'erreur */

                    isUnNombre = essaiUtilisateur.matches("[0-9]*");

                    while (!isUnNombre) {
                        Utils.etoileDecoration();
                        System.out.println("Vous n'avez pas saisi un nombre !");
                        Utils.etoileDecoration();
                        System.out.print("saisisez votre proposition : ");
                        essaiUtilisateur = nb.next();
                        isUnNombre = essaiUtilisateur.matches("[0-9]*");
                        i++;
                    }

                    tabEssaiUtilisateur = new int[longueurDelaCombinaison];
                    for (int k = 0; k < tabEssaiUtilisateur.length; k++) {
                        int convEassaiUtilisateur = Integer.parseInt(essaiUtilisateur.charAt(k) + "");
                        tabEssaiUtilisateur[k] = convEassaiUtilisateur;
                    }

                    /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
                    y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai*/
                    while (essaiUtilisateur.length() < tabNbSecretCpu.length || essaiUtilisateur.length() > tabNbSecretCpu.length) {

                        Utils.etoileDecoration();
                        System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres.");
                        Utils.etoileDecoration();
                        System.out.print("saisisez votre proposition : ");
                        essaiUtilisateur = nb.next();
                        i++;
                    }

                    Random essaiCpu = new Random();
                    int[] tabEssaiCpu = new int[longueurDelaCombinaison];
                    for (int l = 0; l < tabEssaiCpu.length; l++) {
                        tabEssaiCpu[l] = essaiCpu.nextInt(9 + 1);
                    }

                    Utils.algoComportementRandom(tabEssaiCpu, tabEssaiUtilisateur);

                    System.out.println();
                    Utils.etoileDecorationPourMaster();
                    System.out.print(Arrays.toString(tabEssaiUtilisateur) + " Réponse pour joueur : ");
                    Utils.algoMaster(tabEssaiUtilisateur, tabNbSecretCpu);
                    Utils.etoileDecorationPourMaster();

                    System.out.println();
                    Utils.etoileDecorationPourMaster();
                    System.out.print(Arrays.toString(tabEssaiCpu) + " Réponse pour ordinateur : ");
                    Utils.algoMaster(tabEssaiCpu, tabNbSecretUtil);
                    Utils.etoileDecorationPourMaster();
                    System.out.println();

                    if (i == 1) {

                        System.out.println();
                        Utils.etoileDecoration();
                        System.out.println("Attention dernier essai");
                        Utils.etoileDecoration();
                        System.out.println();
                    }

                    if (i == 0) {

                        Utils.etoileDecoration();
                        Utils.hastagDecoration();
                        System.out.println("                     PERDU !");
                        Utils.hastagDecoration();
                        Utils.etoileDecoration();
                        System.out.println("Le code secret de l'ordinateur était : " + Arrays.toString(tabNbSecretCpu));
                        System.out.println("Le code secret du joueur était : " + Arrays.toString(tabNbSecretUtil));
                        break;
                    }

                    if (Arrays.equals(tabEssaiCpu, tabNbSecretUtil)) {
                        Utils.etoileDecoration();
                        Utils.hastagDecoration();
                        System.out.println("             L'ordinateur a GAGNé !");
                        Utils.hastagDecoration();
                        Utils.etoileDecoration();
                        System.out.println("L'ordinateur a trouvé votre code secret");
                        System.out.println("La combinaison été : " + Arrays.toString(tabEssaiUtilisateur));
                        break;
                    }

                    if (Arrays.equals(tabEssaiUtilisateur, tabNbSecretCpu)) {
                        Utils.etoileDecoration();
                        Utils.hastagDecoration();
                        System.out.println("                    GAGNé !");
                        Utils.hastagDecoration();
                        Utils.etoileDecoration();
                        System.out.println("Vous avez trouver le code secret de l'ordinateur !");
                        System.out.println("Le code secret de l'ordinateur était : " + Arrays.toString(tabNbSecretCpu));
                    }
                }
                Utils.etoileDecoration();
                Menu.menuFinRecherchePlusMoins();
            }
        }
    }
}