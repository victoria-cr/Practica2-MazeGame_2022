package com.liceu.practica2.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> itemList = new ArrayList<>();

    public void setCurrentRoom(Room currentRoom) {
        System.out.println("Ets a l'habitació: " + currentRoom.getNumber());
        this.currentRoom = currentRoom;
        currentRoom.enter(this);
    }

    public void addItem(Item it) {
        this.itemList.add(it);
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }
}
