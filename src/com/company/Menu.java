package com.company;

import java.util.Scanner;

public class Menu {
    static Scanner nb = new Scanner(System.in);

    static void etoileDecoration() {
        for (int i = 1; i <= 47; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    static void menuDemarrer() {
        etoileDecoration();
        System.out.println();
        System.out.println("*              MASTER MIND                    *");
        System.out.println();
        etoileDecoration();
        System.out.println("*          CHOISISSEZ VOTRE JEUX              *");
        etoileDecoration();
        System.out.println();
        System.out.println("* 1. Recherche +/-                            *");
        System.out.println("* 2. Mastermind                               *");
        System.out.println();
        etoileDecoration();
        System.out.print("* Pour choisir un jeu entrer 1 ou 2 : ");
        int saisieUtilisateurJeux = nb.nextInt();
        etoileDecoration();
        if (saisieUtilisateurJeux == 1) {
            menuModeDeJeuRecherchePlusMoins();
        } else if (saisieUtilisateurJeux == 2) {
                    menuModeDeJeuMaster();
        }
    }

    static void menuModeDeJeuRecherchePlusMoins() {
        System.out.println("*         CHOISISSEZ UN MODE DE JEUX          *");
        etoileDecoration();
        System.out.println();
        System.out.println("1. ChallengerRecherche");
        System.out.println("Le joueur jour contre l'ordinateur");
        System.out.println();
        System.out.println("2. Défenseur");
        System.out.println("L'ordinateur joue contre le joueur");
        System.out.println();
        System.out.println("3. Duel");
        System.out.println("Le joueur et l'ordinateur jouent à tour de rôle");
        System.out.println();
        etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");
        int saisieUtilisateurMode = nb.nextInt();
        etoileDecoration();
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
        etoileDecoration();
        System.out.println();
        System.out.println("1. ChallengerRecherche");
        System.out.println("Le joueur jour contre l'ordinateur");
        System.out.println();
        System.out.println("2. Défenseur");
        System.out.println("L'ordinateur joue contre le joueur");
        System.out.println();
        System.out.println("3. Duel");
        System.out.println("Le joueur et l'ordinateur jouent à tour de rôle");
        System.out.println();
        etoileDecoration();
        System.out.println("Pour choisir un Mode entrer 1, 2 ou 3 : ");
        int saisieUtilisateurMode = nb.nextInt();
        etoileDecoration();
        if (saisieUtilisateurMode == 1) {
            ChallengerMaster.algoChalengerMaster();
        } else if (saisieUtilisateurMode == 2) {
            DefenseurMaster.algoDefenseurMaster();
        } else if (saisieUtilisateurMode == 3) {
            DuelMaster.algoDuelMaster();
        }
    }
}