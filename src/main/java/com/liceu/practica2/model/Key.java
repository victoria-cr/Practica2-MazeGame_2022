package com.liceu.practica2.model;

import java.util.ArrayList;
import java.util.List;

public class Key implements Item {
    private List<Door> doors = new ArrayList<>();
    private String name;
    private int valor;

    public Key(String name, int valor) {
        this.name = name;
        this.valor = valor;
    }

    public void addDoor(Door d) {
        this.doors.add(d);
    }

    public void open(Door door) {
        this.doors
                .stream()
                .filter(d -> d.equals(door))
                .forEach(Door::open);
    }

    public String getName() {
        return name;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Key{" +
                "name='" + name + '\'' +
                '}';
    }
}
