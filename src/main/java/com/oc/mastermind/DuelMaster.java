package com.oc.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class DuelMaster {

    public static Logger logger = LogManager.getLogger();

    static void algoDuelMaster() {

        logger.info("L'utilisateur joue à Mastermind en mode Duel");

        int longueurDeLaCombinaisonMaster = Config.longueurDeLaCombinaisonMaster;
        int nbEssaiMaster = Config.nbEssaiMaster;
        int nbChiffreAleatoireMaster = Config.nbChiffreAleatoireMaster;
        int modeDev = Config.modeDev;

        Utils.exceptionLongueur(longueurDeLaCombinaisonMaster);
        Utils.exceptionNbEssais(nbEssaiMaster);
        Utils.exceptionNbAleatoireMaster(nbChiffreAleatoireMaster);

        int[] tabNbSecretCpu = Utils.initialiseTableauRandomMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

        if (modeDev == 1){
            System.out.println("le code secret ordinateur est : "+Arrays.toString(tabNbSecretCpu));
        }

        String saisieUtilisateur = Utils.saisieUtilisateurMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

        int[] tabNbSecretUtil = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonMaster, saisieUtilisateur);

        //pas de mode developpeur pour l'utilisateur car son code secret et affiché par défaut

        //la condition est respectée, affiche le code secret
        Utils.etoileDecorationPourMaster();
        System.out.println("Votre code secret est : " + Arrays.toString(tabNbSecretUtil));
        Utils.etoileDecorationPourMaster();
        System.out.println();

        for (int i = 1; i <= nbEssaiMaster; i++) {

            String essaiUtilisateur = Utils.essaiUtilisateurMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

            int[] tabEssaiUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonMaster, essaiUtilisateur);

            int[] tabEssaiCpu = Utils.initialiseTableauRandomMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

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

            if (i == nbEssaiMaster - 1) {

                logger.info("le joueur et l'ordinateur n'ont plus qu'un essai");
                System.out.println();
                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }

            if (i == nbEssaiMaster) {

                logger.info("le joueur et l'odinateur ont tous deux perdu");
                logger.info("le joueur devait trouver : "+Arrays.toString(tabNbSecretCpu)+" sa dernière proposition est : "+Arrays.toString(tabEssaiUtilisateur));
                logger.info("l'ordinateur devait trouver : "+Arrays.toString(tabNbSecretUtil)+" sa dernière proposition est : "+Arrays.toString(tabEssaiCpu));

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

                logger.info("l'odinateur a gagné avec la proosition : "+Arrays.toString(tabEssaiCpu)+" la combinaison a troouver été : "+ Arrays.toString(tabNbSecretUtil));
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

                logger.info("l'utilisateur a gagné avec la combinaison : "+Arrays.toString(tabEssaiUtilisateur)+" la combianison a trouver été bien : "+Arrays.toString(tabNbSecretCpu));
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
