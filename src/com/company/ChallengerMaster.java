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
        System.out.print(Arrays.toString(tabSaisieOrdinateur));
        System.out.println();

        for (int y = nbEssai; y >= 0; y--) {
            String saisieUtilisateur = nb.next();
            int[] tabSaisieUtilisateur = new int[longueurDeLaCombaison];
            for (int i = 0; i < tabSaisieUtilisateur.length; i++) {
                int converter = Integer.parseInt(saisieUtilisateur.charAt(i) + "");
                tabSaisieUtilisateur[i] = converter;
            }
            Utils.algoMaster(tabSaisieOrdinateur,tabSaisieUtilisateur);
        }



    }
}