package com.liceu.practica2.model;

import com.liceu.practica2.services.MapSite;

public class Wall implements MapSite {
    @Override
    public void enter(Player player) {
        System.out.println("No pots passar a través d'una paret");
    }

    @Override
    public void abrirPuerta(Player player) {

    }
}
