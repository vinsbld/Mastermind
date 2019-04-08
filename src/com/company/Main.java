package com.company;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.getProperties().load(new FileInputStream("resources/config.properties"));
        DuelMaster.algoDuelMaster();
    }
}
