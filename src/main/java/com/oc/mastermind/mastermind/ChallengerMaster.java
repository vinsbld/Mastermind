package com.oc.mastermind.mastermind;


import com.oc.mastermind.Config;
import com.oc.mastermind.Menu;
import com.oc.mastermind.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class ChallengerMaster {

   public static Logger logger = LogManager.getLogger();

  public static void algoChallengerMaster() {

        logger.info("l'utilisateur joue à mastermind en mode challenger");

        Config myConfig = Config.getInstance();

        int longueurDeLaCombinaisonMaster = myConfig.longueurDeLaCombinaisonMaster;
        int nbEssaiMaster = myConfig.nbEssaiMaster;
        int nbChiffreAleatoireMaster = myConfig.nbChiffreAleatoireMaster;
        int modeDev = myConfig.modeDev;

        Utils.exceptionLongueur(longueurDeLaCombinaisonMaster);
        Utils.exceptionNbEssais(nbEssaiMaster);
        Utils.exceptionNbAleatoireMaster(nbChiffreAleatoireMaster);

        int[] tabSaisieOrdinateur = Utils.initialiseTableauRandomMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

        if (modeDev == 1){
            System.out.println("le code de l'odinateur est : "+Arrays.toString(tabSaisieOrdinateur));
        }

        for (int y =1; y <= nbEssaiMaster; y++){

            String saisieUtilisateur = Utils.essaiUtilisateurMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

            int[] tabSaisieUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonMaster, saisieUtilisateur);

            if (y == nbEssaiMaster - 1) {

                logger.info("le joueur n'a plus qu'un essai");
                System.out.println();
                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }
            if (y == nbEssaiMaster) {

                logger.info("le joueur a perdu avec la proposition : "+ Arrays.toString(tabSaisieUtilisateur) +"  il fallait trouver : "+ Arrays.toString(tabSaisieOrdinateur));
                Utils.etoileDecorationPourMaster();
                System.out.println();
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("vous n'avez pas trouvé la combinaison secrete");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }
            if (Arrays.equals(tabSaisieOrdinateur, tabSaisieUtilisateur)) {

                logger.info("le joueur à gagné avec la combinaison "+ Arrays.toString(tabSaisieUtilisateur) +" il fallait trouver la combinaison : "+Arrays.toString(tabSaisieOrdinateur));
                Utils.etoileDecorationPourMaster();
                System.out.println();
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous avez trouvé la combinaison secrete !");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieOrdinateur));
                break;
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinMaster();
    }
}