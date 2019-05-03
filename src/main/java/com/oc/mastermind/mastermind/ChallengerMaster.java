package com.oc.mastermind.mastermind;


import com.oc.mastermind.Config;
import com.oc.mastermind.Menu;
import com.oc.mastermind.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class ChallengerMaster {

   public static Logger logger = LogManager.getLogger();

    /**
     * Méthode mode challenger pour jeu mastermind
     * crée un nombre "secret" aléatoire
     * permet à l'utiliateur d'entrer une proposotion
     * compare la proposition utilisateur et le nombre "secret" aléatoire
     */
  public static void algoChallengerMaster() {

        logger.info("l'utilisateur joue à mastermind en mode challenger");
      /*
       * charge les paramètres de jeu
       */
      Config myConfig = Config.getInstance();

        int longueurDeLaCombinaisonMaster = myConfig.longueurDeLaCombinaisonMaster;
        int nbEssaiMaster = myConfig.nbEssaiMaster;
        int modeDev = myConfig.modeDev;

      /*
       * exceptions pour les paramètres de jeux
       */
        Utils.exceptionLongueurMaster(longueurDeLaCombinaisonMaster);
        Utils.exceptionNbEssais(nbEssaiMaster);

      /*
       * crée un nombre aléatoire dans un tableau int
       */
      int[] tabSaisieOrdinateur = Utils.initialiseTableauRandom(longueurDeLaCombinaisonMaster);

      Utils.etoileDecorationPourMaster();
      System.out.println("l'ordinateur a créé un nombre mystère !");
      Utils.etoileDecorationPourMaster();
      System.out.println();
      /*
       * si le mode developpeur est activé
       */
        if (modeDev == 1){
            System.out.println("le code de l'odinateur est : "+Arrays.toString(tabSaisieOrdinateur));
        }

        for (int y =1; y <= nbEssaiMaster; y++){

            /*
             * demande au joueur de saisir un nombre String
             */
            String saisieUtilisateur = Utils.essaiUtilisateur(longueurDeLaCombinaisonMaster);

            /*
             * convertie la saisie String utilisateur en un tableau int
             */
            int[] tabSaisieUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonMaster, saisieUtilisateur);

            /*
             * compare les tableaux tabSaisieOrdinateur et tabSaisieUtilisateur
             */
            System.out.print("Essai n°"+ y +" Proposition : " + Arrays.toString(tabSaisieUtilisateur) + " | Réponse : ");
            Utils.algoMaster(tabSaisieOrdinateur, tabSaisieUtilisateur);
            System.out.println();

            if (y == nbEssaiMaster && !Arrays.equals(tabSaisieOrdinateur, tabSaisieUtilisateur)) {

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

            if (y == nbEssaiMaster - 1) {

                logger.info("le joueur n'a plus qu'un essai");
                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinMaster();
    }
}