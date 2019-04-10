package com.company;

import org.apache.log4j.Logger;

import java.util.Arrays;


public class DefenseurMaster {

    static void algoDefenseurMaster() {

        Logger.getLogger(DefenseurMaster.class).info("L'utilisateur joue à Mastermind en mode Défenseur");

        int longueurDeLaCombinaisonMaster = Config.longueurDeLaCombinaisonMaster;
        int nbEssaiMaster = Config.nbEssaiMaster;
        int nbChiffreAleatoireMaster = Config.nbChiffreAleatoireMaster;

        Utils.exceptionNbAleatoireMaster(nbChiffreAleatoireMaster);

        int[] tabSaisieAttaquant = Utils.initialiseTableauRandomMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

        String saisieDefenseur = Utils.saisieUtilisateurMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

        int[] tabSaisieDefenseur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonMaster, saisieDefenseur);

        Utils.etoileDecorationPourMaster();
        System.out.println("Votre code secret est " + Arrays.toString(tabSaisieDefenseur));
        Utils.etoileDecorationPourMaster();

        for (int y = nbEssaiMaster; y >= 0; y--) {

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


