package com.company;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DuelRecherche {
    static Scanner nb = new Scanner(System.in);

    static void algoDuelRecherche() {

        Logger.getLogger(DuelRecherche.class).info("L'utilisateur joue à Recherche +/- en mode Duel");

        int longueurDeLaCombinaisonRecherche = Config.longueurDeLaCombinaisonRecherche;
        int nbEssaiRecherche = Config.nbEssaiRecherche;

        int[] tabNbSecretCpu = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaisonRecherche);

        String nbSecretUtilisateur = Utils.saisieUtilisateurRecherche(longueurDeLaCombinaisonRecherche);

        int[] tabNbSecretUtil = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonRecherche, nbSecretUtilisateur);

        Utils.etoileDecoration();
        System.out.println("Votre code secret est : " + Arrays.toString(tabNbSecretUtil));
        Utils.etoileDecoration();
        System.out.println();

        for (int i = nbEssaiRecherche; i >= 0; i--) {

            String essaiUtilisateur = Utils.essaiUtilisateurRecherche(longueurDeLaCombinaisonRecherche);

            int[] tabEssaiUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonRecherche, essaiUtilisateur);

            int[] tabEssaiCpu = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaisonRecherche);

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
                System.out.println("             L'ordinateur a GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("L'ordinateur a trouvé votre code secret");
                System.out.println("La combinaison été : " + Arrays.toString(tabEssaiUtilisateur));
                break;
            }

            if (Arrays.equals(tabEssaiUtilisateur, tabNbSecretCpu)) {
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
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
