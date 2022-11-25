package com.liceu.practica2.model;

import com.liceu.practica2.services.MapSite;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private int number;
    private Item item;

    private boolean target = false;

    private Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public Room(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public void setItem(Item it) {
        this.item = it;
    }

    public MapSite getSide(Maze.Directions dir) {
        return this.sides.get(dir);
    }

    public void setSide(Maze.Directions dir, MapSite ms) {
        this.sides.put(dir, ms);
    }

    public void enter(Player player) {
        if (this.item != null) {
            System.out.println("Has obtingut un ítem: " + this.item.toString());
            player.addItem(this.item);
            this.item = null;
        }
    }
}
