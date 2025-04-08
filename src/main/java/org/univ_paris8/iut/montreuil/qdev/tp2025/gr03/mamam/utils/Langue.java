package org.univ_paris8.iut.montreuil.qdev.tp2025.gr03.mamam.utils;

public enum Langue {
    FRANÇAIS(1),ANGLAIS(2),ALLMANDS(3),ESPAGNOL(4),ITALIEN(5);

    private Langue(final int choix){
        this.choix=choix;
    }
    private int choix;
}
