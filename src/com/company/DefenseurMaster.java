package com.company;

import java.util.Arrays;


public class DefenseurMaster {

    static void algoDefenseurMaster() {

        int nbEssai = Integer.parseInt(System.getProperty("defenseur_master.nombre_essai"));
        int longueurDelaCombinaison = Integer.parseInt(System.getProperty("defenseur_master.nombre_case"));
        int nbAleatoireAttaquant = Integer.parseInt(System.getProperty("defenseur_master.nombre_de_chiffre"));

        Utils.exceptionNbAleatoireMaster(nbAleatoireAttaquant);

        int[] tabSaisieAttaquant = Utils.initialiseTableauRandomMaster(longueurDelaCombinaison, nbAleatoireAttaquant);

        String saisieDefenseur = Utils.saisieUtilisateurMaster(longueurDelaCombinaison, nbAleatoireAttaquant);

        int[] tabSaisieDefenseur = Utils.initialiseTableauUtilisateur(longueurDelaCombinaison, saisieDefenseur);

        Utils.etoileDecorationPourMaster();
        System.out.println("Votre code secret est " + Arrays.toString(tabSaisieDefenseur));
        Utils.etoileDecorationPourMaster();

        for (int y = nbEssai; y >= 0; y--) {

            Utils.algoComportementRandom(tabSaisieAttaquant, tabSaisieDefenseur);

            Utils.etoileDecorationPourMaster();
            System.out.print("Proposition : " + Arrays.toString(tabSaisieAttaquant) + " | Réponse : ");
            Utils.algoMaster(tabSaisieDefenseur, tabSaisieAttaquant);
            Utils.etoileDecorationPourMaster();
            System.out.println();

            if (y == 1) {

                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }
            if (y == 0) {

                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur n'a pas trouver le code secret");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }

            if (Arrays.equals(tabSaisieAttaquant, tabSaisieDefenseur)) {
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur a trouver le code secret");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinMaster();
    }
}


