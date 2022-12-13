package com.liceu.practica2.services;

import com.liceu.practica2.model.Player;

public interface MapSite {
    void enter(Player player);

    void openDoor(Player player);
}