package com.oc.mastermind.mastermind;

import com.oc.mastermind.Config;
import com.oc.mastermind.Menu;
import com.oc.mastermind.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class DefenseurMaster {

    public static Logger logger = LogManager.getLogger();

    /**
     * Méthode pour mode défenseur jeu mastermind
     * propose au joueur d'entrer un nombre "secret"
     * l'ordinateur crée un nombre aléatoire
     * compare le nombre aléatoire au nombre secret du joueur
     */
    public static void algoDefenseurMaster() {

        logger.info("L'utilisateur joue à Mastermind en mode Défenseur");

        Config myConfig = Config.getInstance();

        int longueurDeLaCombinaisonMaster = myConfig.longueurDeLaCombinaisonMaster;
        int nbEssaiMaster = myConfig.nbEssaiMaster;

        Utils.exceptionLongueurMaster(longueurDeLaCombinaisonMaster);
        Utils.exceptionNbEssais(nbEssaiMaster);

        String saisieDefenseur = Utils.saisieUtilisateurMaster(longueurDeLaCombinaisonMaster);

        int[] tabSaisieDefenseur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonMaster, saisieDefenseur);

        int[] tabSaisieAttaquant = Utils.initialiseTableauRandomMaster(longueurDeLaCombinaisonMaster);

        //pas de mode developpeur pour ce mode car le code secret de l'utilisateur est affiché par défaut

        Utils.etoileDecorationPourMaster();
        System.out.println("Votre code secret est " + Arrays.toString(tabSaisieDefenseur));
        Utils.etoileDecorationPourMaster();
        System.out.println();

        for (int y = 1; y <= nbEssaiMaster; y++) {

            Utils.algoComportementRandom(tabSaisieAttaquant, tabSaisieDefenseur);

            Utils.etoileDecorationPourMaster();
            System.out.print("Essai n°" + y + " Proposition : " + Arrays.toString(tabSaisieAttaquant) + " | Réponse : ");
            Utils.algoMaster(tabSaisieDefenseur, tabSaisieAttaquant);
            Utils.etoileDecorationPourMaster();
            System.out.println();

            if (y == nbEssaiMaster && !Arrays.equals(tabSaisieAttaquant, tabSaisieDefenseur)) {

                logger.info("le joueur a gagné !  l'odinateur a fait la proposition : " + Arrays.toString(tabSaisieAttaquant) + "l'ordinateur n'a pas trouvé : " + Arrays.toString(tabSaisieDefenseur));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur n'a pas trouvé le code secret");
                System.out.println("La combinaison secrette était : " + Arrays.toString(tabSaisieDefenseur));
                break;
            }

            if (Arrays.equals(tabSaisieAttaquant, tabSaisieDefenseur)) {

                logger.info("le joueur a perdu avec la proposition : " + Arrays.toString(tabSaisieAttaquant) + " l'odinateur a trouvé : " + Arrays.toString(tabSaisieDefenseur));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                     PERDU !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("l'ordinateur a trouvé le code secret");
                System.out.println("La combinaison été : " + Arrays.toString(tabSaisieDefenseur));
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


