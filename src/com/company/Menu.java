package com.company;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Menu {
    static Scanner nb = new Scanner(System.in);


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
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur a choisi de jouer au jeu Recherche +/-");
            if (saisieUtilisateurJeux != "1") {
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur ne devrait pas jouer au jeu Recherche +/-");
            }
        } else if (saisieUtilisateurJeux.equals("2")) {
            menuModeDeJeuMaster();
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur a choisi de jouer au jeu Mastermind");
            if (saisieUtilisateurJeux != "2") {
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ saisieUtilisateurJeux +" l'utilisateur ne devrait pas jouer jeu Mastermind");
            }
        } else {
            Menu.menuDemarrer();
            Logger.getLogger(Menu.class).warn(saisieUtilisateurJeux +" n'est pas un choix valide, l'utilisateur retourne au menu principal");
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
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode challenger");
            if (saisieUtilisateurMode != "1"){
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utiisateur ne devrait pas jouer au jeu Recherche +/- en mode challenger");
            }

        }
        else if (saisieUtilisateurMode.equals("2")) {
            DefenseurRecherche.algoDefenseurRecherche();
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode défenseur");
            if (saisieUtilisateurMode != "2"){
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utiisateur ne devrait pas jouer au jeu Recherche +/- en mode défenseur");
            }

        }
        else if (saisieUtilisateurMode.equals("3")) {
            DuelRecherche.algoDuelRecherche();
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Recherche +/- en mode duel");
            if (saisieUtilisateurMode != "3"){
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utiisateur ne devrait pas jouer au jeu Recherche +/- en mode duel");
            }

        }
        else {
            Menu.menuModeDeJeuRecherchePlusMoins();
            Logger.getLogger(Menu.class).warn(saisieUtilisateurMode +" n'est pas un choix valide, l'utilisateur retourne au menu principal");

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
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Mastermind en mode challenger");
            if (saisieUtilisateurMode != "1"){
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utiisateur ne devrait pas jouer au jeu Mastermind en mode challenger");
            }
        }
        else if (saisieUtilisateurMode.equals("2")) {
            DefenseurMaster.algoDefenseurMaster();
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ saisieUtilisateurMode +" l'utilisateur a choisi de jouer au jeu Mastermind en mode défenseur");
            if (saisieUtilisateurMode != "2"){
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ saisieUtilisateurMode + " l'utiisateur ne devrait pas jouer au jeu Mastermind en mode défenseur");
            }
        }
        else if (saisieUtilisateurMode.equals("3")) {
            DuelMaster.algoDuelMaster();
            Logger.getLogger(Menu.class).info("l'utilisateur veut jouer à Mastermind en mode duel");
            if (saisieUtilisateurMode != "3"){
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ saisieUtilisateurMode + " l'utiisateur ne devrait pas jouer au jeu Mastermind en mode duel");
            }
        }
        else {
            Menu.menuModeDeJeuMaster();
            Logger.getLogger(Menu.class).warn(saisieUtilisateurMode +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
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
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de rejouer au jeu Recherche +/-");
            if (sasisieUtilisateur != "1") {
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur ne devrait pas jouer au jeu Recherche +/-");
            }

        } else if (sasisieUtilisateur.equals("2")) {
            Menu.menuDemarrer();
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de revenir au menu principal");
            if (sasisieUtilisateur != "2") {
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur ne devrait pas revenir au menu principal");
            }

        } else if (sasisieUtilisateur.equals("3")) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi "+ sasisieUtilisateur +"l'utilisateur a mis fin au jeu");
            if (sasisieUtilisateur != "3") {
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ sasisieUtilisateur +"l'utilisateur ne devrait pas avoir mis fin au jeu");
            }

        } else {
            Menu.menuFinRecherchePlusMoins();
            Logger.getLogger(Menu.class).warn(sasisieUtilisateur +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
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
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de rejouer au jeu Mastermind");
            if (sasisieUtilisateur != "1") {
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur ne devrait pas jouer au jeu Mastermind");
            }

        } else if (sasisieUtilisateur.equals("2")) {
            Menu.menuDemarrer();
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur a choisi de revenir au menu principal");
            if (sasisieUtilisateur != "2") {
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ sasisieUtilisateur +" l'utilisateur ne devrait pas revenir au menu principal");
            }

        } else if (sasisieUtilisateur.equals("3")) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
            Logger.getLogger(Menu.class).info("l'utilisateur a saisi "+ sasisieUtilisateur +"l'utilisateur a mis fin au jeu");
            if (sasisieUtilisateur != "3") {
                Logger.getLogger(Menu.class).error("l'utilisateur a saisi : "+ sasisieUtilisateur +"l'utilisateur ne devrait pas avoir mis fin au jeu");
            }


        } else {
            Menu.menuFinMaster();
            Logger.getLogger(Menu.class).warn(sasisieUtilisateur +" n'est pas un choix valide, l'utilisateur retourne au menu choix du mode de jeu");
        }
    }

}