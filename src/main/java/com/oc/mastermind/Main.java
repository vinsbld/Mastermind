package com.oc.mastermind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    public static Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws IOException {

        logger.info("Démarrage de l'application");
        Config.load("resources/config.properties");
        Menu.menuDemarrer();
    }
}