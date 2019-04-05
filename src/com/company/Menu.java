package com.company;

import javax.swing.plaf.synth.SynthOptionPaneUI;
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
        } else if (saisieUtilisateurJeux.equals("2")) {
            menuModeDeJeuMaster();
        } else {
            Menu.menuDemarrer();
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
        }
        else if (saisieUtilisateurMode.equals("2")) {
            DefenseurRecherche.algoDefenseurRecherche();
        }
        else if (saisieUtilisateurMode.equals("3")) {
            DuelRecherche.algoDuelRecherche();
        }
        else {
            Menu.menuModeDeJeuRecherchePlusMoins();
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
            ChallengerMaster.algoChalengerMaster();
        }
        else if (saisieUtilisateurMode.equals("2")) {
            DefenseurMaster.algoDefenseurMaster();
        }
        else if (saisieUtilisateurMode.equals("3")) {
            DuelMaster.algoDuelMaster();
        }
        else {
            Menu.menuModeDeJeuMaster();
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
        }
        else if (sasisieUtilisateur.equals("2")) {
            Menu.menuDemarrer();
        }
        else if (sasisieUtilisateur.equals("3")) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
        }
        else {
            Menu.menuFinRecherchePlusMoins();
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
        }
        else if (sasisieUtilisateur.equals("2")) {
            Menu.menuDemarrer();
        }
        else if (sasisieUtilisateur.equals("3")) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
        }
        else {
            Menu.menuFinMaster();
        }
    }

}