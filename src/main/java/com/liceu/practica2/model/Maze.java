package com.liceu.practica2.model;

import java.util.HashMap;
import java.util.Map;

public class Maze {
    public enum Directions {
        NORTH, SOUTH, EAST, WEST
    }
    Map<Integer, Room> rooms = new HashMap<>();

    public void addRoom(int nroom, Room room) {
        this.rooms.put(nroom, room);
    }

    public Room getRoom(int nroom) {
        return this.rooms.get(nroom);
    }
}
