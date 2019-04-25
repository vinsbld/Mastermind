package com.oc.mastermind.recherche;

import com.oc.mastermind.Config;
import com.oc.mastermind.Menu;
import com.oc.mastermind.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import java.util.Scanner;

public class DuelRecherche {

    static Scanner nb = new Scanner(System.in);

    public static Logger logger = LogManager.getLogger();

    /**
     * Méthode pour mode duel jeu mastermind
     * propose au joueur et d'entrer un nombre "secret"
     * l'odinateur crée un nombre "secret" aléatoire
     * à chaque tour :
     * -propose au joueur et d'entrer un nombre
     * -l'odinateur crée un nombre aléatoire
     * compare le nombre aléatoire au nombre "secret" du joueur
     * compare le nombre proposé par le joueur au nombre "secret aléatoire"
     */
    public static void algoDuelRecherche() {

        logger.info("L'utilisateur joue à Recherche +/- en mode Duel");

        Config myConfig = Config.getInstance();

        int longueurDeLaCombinaisonRecherche = myConfig.longueurDeLaCombinaisonRecherche;
        int nbEssaiRecherche = myConfig.nbEssaiRecherche;
        int modeDev = myConfig.modeDev;

        Utils.exceptionLongueur(longueurDeLaCombinaisonRecherche);
        Utils.exceptionNbEssais(nbEssaiRecherche);

        int[] tabNbSecretCpu = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaisonRecherche);

        if (modeDev == 1) {
            System.out.println("le code secret ordinateur est : " + Arrays.toString(tabNbSecretCpu));
        }

        String nbSecretUtilisateur = Utils.saisieUtilisateurRecherche(longueurDeLaCombinaisonRecherche);

        int[] tabNbSecretUtil = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonRecherche, nbSecretUtilisateur);

        //pas de mode developpeur pour l'utilisateur car son code secret et affiché par défaut
        Utils.etoileDecoration();
        System.out.println("l'ordinateur a créé un code secret !");
        Utils.etoileDecoration();
        System.out.println();

        Utils.etoileDecoration();
        System.out.println("Votre code secret est : " + Arrays.toString(tabNbSecretUtil));
        Utils.etoileDecoration();
        System.out.println();

        for (int i = 1; i <= nbEssaiRecherche; i++) {

            String essaiUtilisateur = Utils.essaiUtilisateurRecherche(longueurDeLaCombinaisonRecherche);

            int[] tabEssaiUtilisateur = Utils.initialiseTableauUtilisateur(longueurDeLaCombinaisonRecherche, essaiUtilisateur);

            int[] tabEssaiCpu = Utils.initialiseTableauRandomRecherche(longueurDeLaCombinaisonRecherche);

            Utils.algoComportementRandomRecherhe(tabEssaiCpu, tabEssaiUtilisateur);

            Utils.etoileDecorationPourMaster();
            System.out.print("Essai n°" + i + " " + Arrays.toString(tabEssaiUtilisateur) + " Réponse pour joueur : ");
            Utils.algoPlusMoins(tabEssaiUtilisateur, tabNbSecretCpu);
            Utils.etoileDecorationPourMaster();

            System.out.println();
            Utils.etoileDecorationPourMaster();
            System.out.print("Essai n°" + i + " " + Arrays.toString(tabEssaiCpu) + " Réponse pour ordinateur : ");
            Utils.algoMaster(tabEssaiCpu, tabNbSecretUtil);
            Utils.etoileDecorationPourMaster();
            System.out.println();

            if (i == nbEssaiRecherche - 1) {

                logger.info("le joueur et l'ordinateur n'ont plus qu'un essai");
                Utils.etoileDecoration();
                System.out.println("Attention dernier essai");
                Utils.etoileDecoration();
                System.out.println();
            }

            if (i == nbEssaiRecherche && !Arrays.equals(tabNbSecretCpu, tabNbSecretUtil)) {

                logger.info("le joueur et l'odinateur ont tous deux perdu");

                logger.info("le joueur devait trouver : " + Arrays.toString(tabNbSecretCpu) + " sa dernière proposition est : " + Arrays.toString(tabEssaiUtilisateur));
                logger.info("l'ordinateur devait trouver : " + Arrays.toString(tabNbSecretUtil) + " sa dernière proposition est : " + Arrays.toString(tabEssaiCpu));

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

                logger.info("l'odinateur a gagné avec la proosition : " + Arrays.toString(tabEssaiCpu) + " la combinaison a troouver été : " + Arrays.toString(tabNbSecretUtil));
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

                logger.info("l'utilisateur a gagné avec la combinaison : " + Arrays.toString(tabEssaiUtilisateur) + " la combianison a trouver été bien : " + Arrays.toString(tabNbSecretCpu));
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous avez trouvé le code secret de l'ordinateur !");
                System.out.println("Le code secret de l'ordinateur était : " + Arrays.toString(tabNbSecretCpu));
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinRecherchePlusMoins();
    }
}
