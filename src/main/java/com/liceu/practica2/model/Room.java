package com.liceu.practica2.model;

import com.liceu.practica2.services.MapSite;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private int number;
    private Item item;

    private boolean target = false;
    private boolean hayLlave = false;
    private boolean hayMoneda = false;

    private Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public Room(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Item getItem() {
        return item;
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public boolean isHayLlave() {
        return hayLlave;
    }

    public void setHayLlave(boolean hayLlave) {
        this.hayLlave = hayLlave;
    }

    public boolean isHayMoneda() {
        return hayMoneda;
    }

    public void setHayMoneda(boolean hayMoneda) {
        this.hayMoneda = hayMoneda;
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
}
