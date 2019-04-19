package com.oc.mastermind;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Méthode contenant les différents paramètres des jeux
 */
public class Config {

    public int longueurDeLaCombinaisonMaster;
    public int nbEssaiMaster;
    public int nbChiffreAleatoireMaster;

    public int longueurDeLaCombinaisonRecherche;
    public int nbEssaiRecherche;

    public int modeDev;
    //public static Logger logger = LogManager.getLogger();

    private static Config c = new Config();

   private Config() {

   load("config.properties");
   }

    public static Config getInstance(){
     return c;
    }

    /**
     * récupére les différents paramètres entrés dans le fichier config.properties
     * @param fileName
     */
    void load(String fileName) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            //logger.debug(ClassLoader.getSystemResource(".").getPath()+fileName);
            input = getClass().getClassLoader().getResourceAsStream(fileName);

            // load a properties file
            prop.load(input);
            //logger.debug("normalement c'est 4 ? "+ prop.getProperty("master_nombre_case"));

            // get the property value and print it out
            longueurDeLaCombinaisonMaster = Integer.parseInt(prop.getProperty("master_nombre_case"));
            nbEssaiMaster = Integer.parseInt(prop.getProperty("master_nombre_essai"));
            nbChiffreAleatoireMaster = Integer.parseInt(prop.getProperty("master_nombre_de_chiffre"));

            longueurDeLaCombinaisonRecherche = Integer.parseInt(prop.getProperty("recherche_nombre_case"));
            nbEssaiRecherche = Integer.parseInt(prop.getProperty("recherche_nombre_essai"));

            modeDev = Integer.parseInt(prop.getProperty("mode_dev"));

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