package com.liceu.practica2.model;

import com.liceu.practica2.services.MapSite;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private int number;
    private Item item;
    private boolean target = false;
    private boolean haveKey = false;
    private boolean haveCoin = false;
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

    public void setItem(Item it) {
        this.item = it;
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public boolean isHaveKey() {
        return haveKey;
    }

    public void setHaveKey(boolean haveKey) {
        this.haveKey = haveKey;
    }

    public boolean isHaveCoin() {
        return haveCoin;
    }

    public void setHaveCoin(boolean haveCoin) {
        this.haveCoin = haveCoin;
    }

    public MapSite getSide(Maze.Directions dir) {
        return this.sides.get(dir);
    }

    public void setSide(Maze.Directions dir, MapSite ms) {
        this.sides.put(dir, ms);
    }
}