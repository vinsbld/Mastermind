package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

   static int longueurDeLaCombinaison;
    static int nbEssai;
    static int nbChiffreAleatoire;




    static void load (String fileName){
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(fileName);

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            longueurDeLaCombinaison = Integer.parseInt(prop.getProperty("master.nombre_case"));
            nbEssai = Integer.parseInt(prop.getProperty("master.nombre_essai"));
            nbChiffreAleatoire = Integer.parseInt(prop.getProperty("master.nombre_de_chiffre"));

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
