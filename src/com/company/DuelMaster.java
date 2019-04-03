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

        String nbSecretUtilisateur = nb.next();
        int[] tabNbSecretUtil = new int[longueurDelaCombinaison];
        for (int j = 0; j < tabNbSecretUtil.length; j++) {
            int converter = Integer.parseInt(nbSecretUtilisateur.charAt(j) + "");
            tabNbSecretUtil[j] = converter;
        }
        System.out.println(Arrays.toString(tabNbSecretUtil));

        for (int i = nbEssai; i >= 0; i--) {

            String essaiUtilisateur = nb.next();
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
            System.out.print("Réponse pour joueur : ");

            Utils.algoMaster(tabEssaiUtilisateur, tabNbSecretCpu);

            System.out.println();
            System.out.print("Réponse pour ordinateur " + Arrays.toString(tabEssaiCpu) + " : ");

            Utils.algoMaster(tabEssaiCpu, tabNbSecretUtil);

            System.out.println();
            if (i == 1) {
                System.out.println("Attention dernier essai");
            }
            if (i == 0) {
                System.out.println("Perdu ! nombre de tentatives écoulées");
                System.out.println("La combinaison secrete de l'ordinateur était : " + Arrays.toString(tabNbSecretCpu));
                System.out.println("La combinaison secrete du joueur était : " + Arrays.toString(tabNbSecretUtil));
                break;
            }
            if (Arrays.equals(tabEssaiCpu, tabNbSecretUtil)) {
                System.out.println("L'ordinateur a gagné ! l'ordinateur a trouver la combinaison secrete");
                System.out.println("La combinaison été : " + Arrays.toString(tabEssaiUtilisateur));
                break;
            }
            if (Arrays.equals(tabEssaiUtilisateur, tabNbSecretCpu)) {
                System.out.println("Gagné ! vous avez trouver la combinaison secrete !");
                System.out.println("La combinaison secrete de l'ordinateur était : " + Arrays.toString(tabNbSecretCpu));
            }
        }
    }
}

