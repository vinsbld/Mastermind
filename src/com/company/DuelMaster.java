package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DuelMaster {
    static Scanner nb = new Scanner(System.in);

    static void algoDuelMaster() {

        //logger.info("le jeu commence")
        int longueurDelaCombinaison = Integer.parseInt(System.getProperty("duelMaster.nombre_case"));
        int nbEssai = Integer.parseInt(System.getProperty("duelMaster.nombre_essai"));
        int nbChiffreAleatoire = Integer.parseInt(System.getProperty("duel_master.nombre_de_chiffre"));

        Utils.exceptionNbAleatoireMaster(nbChiffreAleatoire);

        /*creer un chiffre aléatoire à chaque tour de boucle, chaque chiffre crée correspond
         à un index dans le tableau tabNbSecretCpu */
        Random nbAleatoire = new Random();
        int[] tabNbSecretCpu = new int[longueurDelaCombinaison];
        for (int i = 0; i < tabNbSecretCpu.length; i++) {
            tabNbSecretCpu[i] = nbAleatoire.nextInt(nbChiffreAleatoire);
        }

        Utils.etoileDecorationPourMaster();
        System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à "+nbChiffreAleatoire);
        Utils.etoileDecorationPourMaster();

        System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
        String nbSecretUtilisateur = nb.next();

        /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
         envoie un message d'erreur*/

        boolean isUnNombre = nbSecretUtilisateur.matches("[0 - "+ nbChiffreAleatoire +"]*");

        while (!isUnNombre) {
            Utils.etoileDecorationPourMaster();
            System.out.println("Vous n'avez pas saisi un nombre !");
            Utils.etoileDecorationPourMaster();
            System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
            nbSecretUtilisateur = nb.next();
            isUnNombre = nbSecretUtilisateur.matches("[0-" + nbChiffreAleatoire + "]*");
        }

        int[] tabNbSecretUtil = new int[longueurDelaCombinaison];
        for (int j = 0; j < tabNbSecretUtil.length; j++) {
            int converter = Integer.parseInt(String.valueOf(nbSecretUtilisateur.charAt(j)));
            tabNbSecretUtil[j] = converter;
        }

        /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
        y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai*/

        while (nbSecretUtilisateur.length() < tabNbSecretCpu.length || nbSecretUtilisateur.length() > tabNbSecretCpu.length) {
            Utils.etoileDecorationPourMaster();
            System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à "+nbChiffreAleatoire);
            Utils.etoileDecorationPourMaster();
            System.out.println("SAISISSEZ VOTRE CHIFFRE MYSTERE : ");
            nbSecretUtilisateur = nb.next();
        }

        //la condition est respectée, affiche le code secret
        Utils.etoileDecorationPourMaster();
        System.out.println("Votre code secret est : " + Arrays.toString(tabNbSecretUtil));
        Utils.etoileDecorationPourMaster();
        System.out.println();

        for (int i = nbEssai; i >= 0; i--) {

            Utils.etoileDecorationPourMaster();
            System.out.print("saisisez votre proposition : ");
            String essaiUtilisateur = nb.next();
            Utils.etoileDecorationPourMaster();

            /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 4 à 10
            envoie un message d'erreur*/
            isUnNombre = essaiUtilisateur.matches("[0-"+ nbChiffreAleatoire +"]*");

            while (!isUnNombre) {
                Utils.etoileDecorationPourMaster();
                System.out.println("Vous n'avez pas saisi un nombre !");
                Utils.etoileDecorationPourMaster();
                System.out.print("saisisez votre proposition : ");
                essaiUtilisateur = nb.next();
                isUnNombre = nbSecretUtilisateur.matches("[0-" + nbChiffreAleatoire + "]*");
                i++;
            }

            int[] tabEssaiUtilisateur = new int[longueurDelaCombinaison];
            for (int k = 0; k < tabEssaiUtilisateur.length; k++) {
                int convEassaiUtilisateur = Integer.parseInt(essaiUtilisateur.charAt(k) + "");
                tabEssaiUtilisateur[k] = convEassaiUtilisateur;
            }

            /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
            y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai*/
            if (essaiUtilisateur.length() < tabNbSecretCpu.length || essaiUtilisateur.length() > tabNbSecretCpu.length) {

                Utils.etoileDecorationPourMaster();
                System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à "+ nbChiffreAleatoire);
                Utils.etoileDecorationPourMaster();
                System.out.print("saisisez votre proposition : ");
                essaiUtilisateur = nb.next();
                i++;
            }

            Utils.etoileDecorationPourMaster();
            System.out.print("saisisez votre proposition : ");
            essaiUtilisateur = nb.next();
            Utils.etoileDecorationPourMaster();


            isUnNombre = essaiUtilisateur.matches("[0-"+ nbChiffreAleatoire +"]*");
            /*tant que la saisiUtilisateur n'est pas un nombre entre 0 et 9
            envoie un message d'erreur*/
            while (!isUnNombre) {
                Utils.etoileDecorationPourMaster();
                System.out.println("Vous n'avez pas saisi un nombre !");
                Utils.etoileDecorationPourMaster();
                System.out.print("saisisez votre proposition : ");
                essaiUtilisateur = nb.next();
                isUnNombre = nbSecretUtilisateur.matches("[0-"+ nbChiffreAleatoire +"]*");
                i++;
            }

            tabEssaiUtilisateur = new int[longueurDelaCombinaison];

            for (int k = 0; k < tabEssaiUtilisateur.length; k++) {
                int convEassaiUtilisateur = Integer.parseInt(essaiUtilisateur.charAt(k) + "");
                tabEssaiUtilisateur[k] = convEassaiUtilisateur;
            }

                    /*tant que la proposition n'est pas de la bonne taille envoie ce message d'erreur,
                    y++ fait en sorte que chaque mauvaise saisie n'est pas compté comme un essai*/
            if (essaiUtilisateur.length() < tabNbSecretCpu.length || essaiUtilisateur.length() > tabNbSecretCpu.length) {

                Utils.etoileDecorationPourMaster();
                System.out.println("Votre proposition doit comporter " + longueurDelaCombinaison + " chiffres allants de 0 à "+ nbChiffreAleatoire);
                Utils.etoileDecorationPourMaster();
                System.out.print("saisisez votre proposition : ");
                essaiUtilisateur = nb.next();
                i++;
            }

            Random essaiCpu = new Random();
            int[] tabEssaiCpu = new int[longueurDelaCombinaison];
            for (int l = 0; l < tabEssaiCpu.length; l++) {
                tabEssaiCpu[l] = essaiCpu.nextInt(nbChiffreAleatoire);
            }

            Utils.algoComportementRandom(tabEssaiCpu, tabEssaiUtilisateur);

            System.out.println();
            Utils.etoileDecorationPourMaster();
            System.out.print(Arrays.toString(tabEssaiUtilisateur) + " Réponse pour joueur : ");
            Utils.algoMaster(tabEssaiUtilisateur, tabNbSecretCpu);
            Utils.etoileDecorationPourMaster();

            System.out.println();
            Utils.etoileDecorationPourMaster();
            System.out.print(Arrays.toString(tabEssaiCpu) + " Réponse pour ordinateur : ");
            Utils.algoMaster(tabEssaiCpu, tabNbSecretUtil);
            Utils.etoileDecorationPourMaster();
            System.out.println();

            if (i == 1) {

                System.out.println();
                Utils.etoileDecorationPourMaster();
                System.out.println("Attention dernier essai");
                Utils.etoileDecorationPourMaster();
                System.out.println();
            }

            if (i == 0) {

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
                Utils.etoileDecoration();
                Utils.hastagDecoration();
                System.out.println("                    GAGNÉ !");
                Utils.hastagDecoration();
                Utils.etoileDecoration();
                System.out.println("Vous avez trouver le code secret de l'ordinateur !");
                System.out.println("Le code secret de l'ordinateur était : " + Arrays.toString(tabNbSecretCpu));
            }
        }
        Utils.etoileDecoration();
        Menu.menuFinMaster();
    }
}
