package com.company;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class DuelMaster {

    static void algoDuelMaster() {

        Logger.getLogger(DuelMaster.class).info("L'utilisateur joue à Mastermind en mode Duel");

        //logger.info("le jeu commence")
        int longueurDelaCombinaison = Integer.parseInt(System.getProperty("duelMaster.nombre_case"));
        int nbEssai = Integer.parseInt(System.getProperty("duelMaster.nombre_essai"));
        int nbChiffreAleatoire = Integer.parseInt(System.getProperty("duel_master.nombre_de_chiffre"));

        Utils.exceptionNbAleatoireMaster(nbChiffreAleatoire);

        int[] tabNbSecretCpu = Utils.initialiseTableauRandomMaster(longueurDelaCombinaison, nbChiffreAleatoire);

        String saisieUtilisateur = Utils.saisieUtilisateurMaster(longueurDelaCombinaison, nbChiffreAleatoire);

        int[] tabNbSecretUtil = Utils.initialiseTableauUtilisateur(longueurDelaCombinaison, saisieUtilisateur);

        //la condition est respectée, affiche le code secret
        Utils.etoileDecorationPourMaster();
        System.out.println("Votre code secret est : " + Arrays.toString(tabNbSecretUtil));
        Utils.etoileDecorationPourMaster();
        System.out.println();

        for (int i = nbEssai; i >= 0; i--) {

            String essaiUtilisateur = Utils.essaiUtilisateurMaster(longueurDelaCombinaison, nbChiffreAleatoire);

            int[] tabEssaiUtilisateur = Utils.initialiseTableauUtilisateur(longueurDelaCombinaison, essaiUtilisateur);

            int[] tabEssaiCpu = Utils.initialiseTableauRandomMaster(longueurDelaCombinaison, nbChiffreAleatoire);

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
        Menu.menuFinMaster();
    }
}
