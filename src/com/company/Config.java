package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

   static int longueurDeLaCombinaisonMaster;
    static int nbEssaiMaster;
    static int nbChiffreAleatoireMaster;

    static int longueurDeLaCombinaisonRecherche;
    static int nbEssaiRecherche;


    static void load (String fileName){

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(fileName);

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            longueurDeLaCombinaisonMaster = Integer.parseInt(prop.getProperty("master.nombre_case"));
            nbEssaiMaster = Integer.parseInt(prop.getProperty("master.nombre_essai"));
            nbChiffreAleatoireMaster = Integer.parseInt(prop.getProperty("master.nombre_de_chiffre"));

            longueurDeLaCombinaisonRecherche = Integer.parseInt(prop.getProperty("recherche.nombre_case"));
            nbEssaiRecherche = Integer.parseInt(prop.getProperty("recherche.nombre_essai"));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
