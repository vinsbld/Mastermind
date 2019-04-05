package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DuelMaster {
    static Scanner nb = new Scanner(System.in);

    static void algoDuelMaster() {
        int longueurDelaCombinaison = 3;
        int nbEssai = 10;

        Random nbAleatoire = new Random();
        int[] tabNbSecretCpu = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabNbSecretCpu.length; i++) {
            tabNbSecretCpu[i] = nbAleatoire.nextInt(9);
        }
        System.out.print(Arrays.toString(tabNbSecretCpu));
        System.out.println();

        System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
        String nbSecretUtilisateur = nb.next();
        int[] tabNbSecretUtil = new int[longueurDelaCombinaison];
        for (int j = 0; j < tabNbSecretUtil.length; j++) {
            int converter = Integer.parseInt(nbSecretUtilisateur.charAt(j) + "");
            tabNbSecretUtil[j] = converter;
        }
        Utils.etoileDecorationPourMaster();
        System.out.println("Votre code secret est : " + Arrays.toString(tabNbSecretUtil));
        Utils.etoileDecorationPourMaster();
        System.out.println();


        for (int i = nbEssai; i >= 0; i--) {

            Utils.etoileDecorationPourMaster();
            System.out.print("saisisez votre proposition : ");
            String essaiUtilisateur = nb.next();
            Utils.etoileDecorationPourMaster();
            int[] tabEssaiUtilisateur = new int[longueurDelaCombinaison];
            for (int k = 0; k < tabEssaiUtilisateur.length; k++) {
                int convEassaiUtilisateur = Integer.parseInt(essaiUtilisateur.charAt(k) + "");
                tabEssaiUtilisateur[k] = convEassaiUtilisateur;
            }

            Random essaiCpu = new Random();
            int[] tabEssaiCpu = new int[longueurDelaCombinaison];
            for (int l = 0; l < tabEssaiCpu.length; l++) {
                tabEssaiCpu[l] = essaiCpu.nextInt(9);
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
                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
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
        Menu.menuFinMaster();
    }
}

