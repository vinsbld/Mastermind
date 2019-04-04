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
        int saisieUtilisateurJeux = nb.nextInt();
        Utils.etoileDecoration();
        if (saisieUtilisateurJeux == 1) {
            menuModeDeJeuRecherchePlusMoins();
        } else if (saisieUtilisateurJeux == 2) {
            menuModeDeJeuMaster();
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
        int saisieUtilisateurMode = nb.nextInt();
        Utils.etoileDecoration();
        if (saisieUtilisateurMode == 1) {
            ChallengerRecherche.algoChalengerRecherche();
        } else if (saisieUtilisateurMode == 2) {
            DefenseurRecherche.algoDefenseurRecherche();
        } else if (saisieUtilisateurMode == 3) {
            DuelRecherche.algoDuelRecherche();
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
        int saisieUtilisateurMode = nb.nextInt();
        Utils.etoileDecoration();

        if (saisieUtilisateurMode == 1) {
            ChallengerMaster.algoChalengerMaster();
        }
        else if (saisieUtilisateurMode == 2) {
            DefenseurMaster.algoDefenseurMaster();
        }
        else if (saisieUtilisateurMode == 3) {
            DuelMaster.algoDuelMaster();
        }
    }

    static void menuFinRecherchePlusMoins() {

        Utils.hastagDecoration();
        System.out.println();
        System.out.println("Pour rejouer au même jeu tapez : 1");
        System.out.println();
        System.out.println("Pour revenir au menu tapez : 2");
        System.out.println();
        System.out.println("Pour quitter tapez : 3");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");
        int sasisieUtilisateur = nb.nextInt();
        Utils.etoileDecoration();

        if (sasisieUtilisateur == 1) {
            Menu.menuModeDeJeuRecherchePlusMoins();
        }
        else if (sasisieUtilisateur == 2) {
            Menu.menuDemarrer();
        }
        else if (sasisieUtilisateur == 3) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
        }
    }

    static void menuFinMaster() {

        Utils.hastagDecoration();
        System.out.println();
        System.out.println("Pour rejouer au même jeu tapez : 1");
        System.out.println();
        System.out.println("Pour revenir au menu tapez : 2");
        System.out.println();
        System.out.println("Pour quitter tapez : 3");
        System.out.println();
        Utils.etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");
        int sasisieUtilisateur = nb.nextInt();
        Utils.etoileDecoration();

        if (sasisieUtilisateur == 1) {
            Menu.menuModeDeJeuMaster();
        }
        else if (sasisieUtilisateur == 2) {
            Menu.menuDemarrer();
        }
        else if (sasisieUtilisateur == 3) {
            Utils.hastagDecoration();
            System.out.println("                      FIN");
            Utils.hastagDecoration();
        }
    }

}