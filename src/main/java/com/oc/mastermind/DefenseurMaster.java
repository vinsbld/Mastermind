package com.oc.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class DefenseurMaster {

    public static Logger logger = LogManager.getLogger();

    static void algoDefenseurMaster() {

        logger.info("L'utilisateur joue à Mastermind en mode Défenseur");

        int longueurDeLaCombinaisonMaster = Config.longueurDeLaCombinaisonMaster;
        int nbEssaiMaster = Config.nbEssaiMaster;
        int nbChiffreAleatoireMaster = Config.nbChiffreAleatoireMaster;
        int modeDev = Config.modeDev;

        Utils.exceptionLongueur(longueurDeLaCombinaisonMaster);
        Utils.exceptionNbEssais(nbEssaiMaster);
        Utils.exceptionNbAleatoireMaster(nbChiffreAleatoireMaster);


        int[] tabSaisieAttaquant = Utils.initialiseTableauRandomMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

        String saisieDefenseur = Utils.saisieUtilisateurMaster(longueurDeLaCombinaisonMaster, nbChiffreAleatoireMaster);

        int[] tabSaisieDefenseur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonMaster, saisieDefenseur);

        //pas de mode developpeur pour ce mode car le code secret de l'utilisateur est affiché par défaut
        
        Utils.etoileDecorationPourMaster();
        System.out.println("Votre code secret est " + Arrays.toString(tabSaisieDefenseur));
        Utils.etoileDecorationPourMaster();

        for (int y = 1; y <= nbEssaiMaster ;y++) {

            Utils.algoComportementRandom(tabSaisieAttaquant, tabSaisieDefenseur);

            Utils.etoileDecorationPourMaster();
            System.out.print("Proposition : " + Arrays.toString(tabSaisieAttaquant) + " | Réponse : ");
            Utils.algoMaster(tabSaisieDefenseur, tabSaisieAttaquant);
            Utils.etoileDecorationPourMaster();
            System.out.println();

            if (y == nbEssaiMaster - 1) {

                logger.info("le joueur n'a plus qu'un essai");
                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }
            if (y == nbEssaiMaster) {

                logger.info("le joueur a gagné !  l'odinateur a fait la proposition : "+ Arrays.toString(tabSaisieAttaquant)+"l'ordinateur n'a pas trouvé : "+ Arrays.toString(tabSaisieDefenseur));
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

                logger.info("le joueur a perdu avec la proposition : "+ Arrays.toString(tabSaisieAttaquant)+" l'odinateur a trouvé : "+ Arrays.toString(tabSaisieDefenseur));
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


