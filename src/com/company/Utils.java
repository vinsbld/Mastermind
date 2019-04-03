package com.company;

import java.util.Arrays;

public class Utils {

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

            for (int i = 0; i < tabSaisieAttaquant.length; i++) {
                if (tabSaisieAttaquant[i] < tabSaisieDefenseur[i]) {
                    tabSaisieAttaquant[i] = tabSaisieAttaquant[i] + 1;
                }
                if (tabSaisieAttaquant[i] > tabSaisieDefenseur[i]) {
                    tabSaisieAttaquant[i] = tabSaisieAttaquant[i] - 1;
                }
                if (tabSaisieAttaquant[i] == tabSaisieDefenseur[i]) {
                    tabSaisieAttaquant[i] = tabSaisieAttaquant[i];
                }
            }
        }
    }


