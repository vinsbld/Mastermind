package com.company;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Logger.getLogger(Main.class).info("Démarrage de l'application");
        Config.load("resources/config.properties");
        Menu.menuDemarrer();
    }
}