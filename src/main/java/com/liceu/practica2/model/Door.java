package com.liceu.practica2.model;

import com.liceu.practica2.services.MapSite;

import java.util.List;

public class Door implements MapSite {
    private Room r1, r2;
    private boolean open = false;

    public Door(Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public void open() {
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public void enter(Player player) {
        if (this.open) {
            Room r = getOtherRoom(player.getCurrentRoom());
            player.setCurrentRoom(r);
        } else {
            System.out.println("No pots obrir la porta, encara");
        }
    }

    public void openDoor(Player player) {
        if (!this.open) {
            List<Item> items = player.getItemList();
            items.stream()
                    .filter(i -> i instanceof Key)
                    .map(i -> (Key) i)
                    .forEach(k -> k.open(this));
        }
    }

    private Room getOtherRoom(Room currentRoom) {
        if (r1.getNumber() == currentRoom.getNumber()) {
            return r2;
        }
        return r1;
    }
}