package com.oc.mastermind;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Menu {
    static Scanner nb = new Scanner(System.in);
    
    public static Logger logger = LogManager.getLogger();
    
    static void menuDemarrer() {

        Utils.etoileDecoration();
        System.out.println();
        System.out.println("*              MASTER MIND                    *");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("*          CHOISISSEZ VOTRE JEUX              *");
        Utils.etoileDecoration();
        System.out.println();
        System.out.println("* 1. Recherche +/-                            *");
        System.out.println("* 2. Mastermind                               *");
        System.out.println();
        Utils.etoileDecoration();
        System.out.print("* Pour choisir un jeu entrer 1 ou 2 : ");
        String saisieUtilisateurJeux = nb.nextLine();

        Utils.etoileDecoration();
        if (saisieUtilisateurJeux.equals("1")) {
            menuModeDeJeuRecherchePlusMoins();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur a choisi de jouer au jeu Recherche +/-");
            if (!saisieUtilisateurJeux.equals("1")) {
                logger.error("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur ne devrait pas jouer au jeu Recherche +/-");
            }
        } else if (saisieUtilisateurJeux.equals("2")) {
            menuModeDeJeuMaster();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur a choisi de jouer au jeu Mastermind");
            if (!saisieUtilisateurJeux.equals("2")) {
                logger.error("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur ne devrait pas jouer jeu Mastermind");
            }
        } else {
            Menu.menuDemarrer();
            logger.warn(saisieUtilisateurJeux +" n'est pas un choix valide, l'utilisateur retourne au menu principal");
        }
    }

    static void menuModeDeJeuRecherchePlusMoins() {

        System.out.println("*         CHOISISSEZ UN MODE DE JEUX          *");
        Utils.etoileDecoration();
        System.out.println();
        System.out.println("1. ChallengerRecherche");
        System.out.println("Le joueur joue contre l'ordinateur");
        System.out.println();
        System.out.println("2. Défenseur");
        System.out.println("L'ordinateur joue contre le joueur");
        System.out.println();
        System.out.println("3. Duel");
        System.out.println("Le joueur et l'ordinateur jouent à tour de rôle");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");

        String saisieUtilisateurMode = nb.nextLine();
        Utils.etoileDecoration();

        if (saisieUtilisateurMode.equals("1")) {
            ChallengerRecherche.algoChalengerRecherche();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode challenger");
            if (!saisieUtilisateurMode.equals("1")){
                logger.error("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utiisateur ne devrait pas jouer au jeu Recherche +/- en mode challenger");
            }

        }
        else if (saisieUtilisateurMode.equals("2")) {
            DefenseurRecherche.algoDefenseurRecherche();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode défenseur");
            if (!saisieUtilisateurMode.equals("2")){
                logger.error("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utiisateur ne devrait pas jouer au jeu Recherche +/- en mode défenseur");
            }

        }
        else if (saisieUtilisateurMode.equals("3")) {
            DuelRecherche.algoDuelRecherche();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode duel");
            if (!saisieUtilisateurMode.equals("3")){
                logger.error("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utiisateur ne devrait pas jouer au jeu Recherche +/- en mode duel");
            }

        }
        else {
            Menu.menuModeDeJeuRecherchePlusMoins();
            logger.warn(saisieUtilisateurMode +" n'est pas un choix valide, l'utilisateur retourne au menu principal");

        }
    }

    static void menuModeDeJeuMaster() {

        System.out.println("*         CHOISISSEZ UN MODE DE JEUX          *");
        Utils.etoileDecoration();
        System.out.println();
        System.out.println("1. ChallengerRecherche");
        System.out.println("Le joueur joue contre l'ordinateur");
        System.out.println();
        System.out.println("2. Défenseur");
        System.out.println("L'ordinateur joue contre le joueur");
        System.out.println();
        System.out.println("3. Duel");
        System.out.println("Le joueur et l'ordinateur jouent à tour de rôle");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");

        String saisieUtilisateurMode = nb.nextLine();
        Utils.etoileDecoration();

        if (saisieUtilisateurMode.equals("1")) {
            ChallengerMaster.algoChallengerMaster();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Mastermind en mode challenger");
            if (!saisieUtilisateurMode.equals("1")){
                logger.error("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utiisateur ne devrait pas jouer au jeu Mastermind en mode challenger");
            }
        }
        else if (saisieUtilisateurMode.equals("2")) {
            DefenseurMaster.algoDefenseurMaster();
            logger.info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Mastermind en mode défenseur");
            if (!saisieUtilisateurMode.equals("2")){
                logger.error("l'utilisateur a saisi : "+ saisieUtilisateurMode + " l'utiisateur ne devrait pas jouer au jeu Mastermind en mode défenseur");
            }
        }
        else if (saisieUtilisateurMode.equals("3")) {
            DuelMaster.algoDuelMaster();
            logger.info("l'utilisateur veut jouer à Mastermind en mode duel");
            if (!saisieUtilisateurMode.equals("3")){
                logger.error("l'utilisateur a saisi : "+ saisieUtilisateurMode + " l'utiisateur ne devrait pas jouer au jeu Mastermind en mode duel");
            }
        }
        else {
            Menu.menuModeDeJeuMaster();
            logger.warn(saisieUtilisateurMode +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
        }
    }

    static void menuFinRecherchePlusMoins() {

        Utils.hastagDecoration();
        System.out.println();
        System.out.println("Pour rejouer au même jeu tapez : 1");
        System.out.println();
        System.out.println("Pour revenir au menu principal tapez : 2");
        System.out.println();
        System.out.println("Pour quitter tapez : 3");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");

        String sasisieUtilisateur = nb.nextLine();
        Utils.etoileDecoration();

        if (sasisieUtilisateur.equals("1")) {
            Menu.menuModeDeJeuRecherchePlusMoins();
            logger.info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de rejouer au jeu Recherche +/-");
            if (!sasisieUtilisateur.equals("1")) {
                logger.error("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur ne devrait pas jouer au jeu Recherche +/-");
            }

        } else if (sasisieUtilisateur.equals("2")) {
            Menu.menuDemarrer();
            logger.info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de revenir au menu principal");
            if (!sasisieUtilisateur.equals("2")) {
                logger.error("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur ne devrait pas revenir au menu principal");
            }

        } else if (!sasisieUtilisateur.equals("3")) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
            logger.info("l'utilisateur a saisi "+ sasisieUtilisateur +"l'utilisateur a mis fin au jeu");
            if (!sasisieUtilisateur.equals("3")) {
                logger.error("l'utilisateur a saisi : "+ sasisieUtilisateur +"l'utilisateur ne devrait pas avoir mis fin au jeu");
            }

        } else {
            Menu.menuFinRecherchePlusMoins();
            logger.warn(sasisieUtilisateur +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
        }
    }

    static void menuFinMaster() {

        Utils.hastagDecoration();
        System.out.println();
        System.out.println("Pour rejouer au même jeu tapez : 1");
        System.out.println();
        System.out.println("Pour revenir au menu principal tapez : 2");
        System.out.println();
        System.out.println("Pour quitter tapez : 3");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");

        String sasisieUtilisateur = nb.nextLine();
        Utils.etoileDecoration();

        if (sasisieUtilisateur.equals("1")) {
            Menu.menuModeDeJeuMaster();
            logger.info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de rejouer au jeu Mastermind");
            if (!sasisieUtilisateur.equals("1")) {
                logger.error("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur ne devrait pas jouer au jeu Mastermind");
            }

        } else if (sasisieUtilisateur.equals("2")) {
            Menu.menuDemarrer();
            logger.info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de revenir au menu principal");
            if (!sasisieUtilisateur.equals("2")) {
                logger.error("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur ne devrait pas revenir au menu principal");
            }

        } else if (sasisieUtilisateur.equals("3")) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
            logger.info("l'utilisateur a saisi "+ sasisieUtilisateur +"l'utilisateur a mis fin au jeu");
            if (!sasisieUtilisateur.equals("3")) {
                logger.error("l'utilisateur a saisi : "+ sasisieUtilisateur +"l'utilisateur ne devrait pas avoir mis fin au jeu");
            }


        } else {
            Menu.menuFinMaster();
            logger.warn(sasisieUtilisateur +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
        }
    }

}