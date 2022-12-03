package com.liceu.practica2.services;

import com.liceu.practica2.model.Coin;
import com.liceu.practica2.model.Key;
import com.liceu.practica2.model.Maze;

public interface MazeBuilder {
    void buildRoom(int nroom);

    void setTarget(int nroom);

    void buildDoor(int roomFrom, int roomTo, Maze.Directions dir);

    void buildDoor(int roomFrom, int roomTo, Maze.Directions dir, Key key);

    void putKeyInRoom(int nroom, Key key);

    void putCoinInRoom(int nroom, Coin coin);

    Maze getMaze();
}
