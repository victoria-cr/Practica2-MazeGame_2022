package com.liceu.practica2.services;

import com.liceu.practica2.model.*;

public class StandardMazeBuilder implements MazeBuilder {
    private Maze maze = new Maze();

    @Override
    public void buildRoom(int nroom) {
        Room room = new Room(nroom);
        room.setSide(Maze.Directions.NORTH, new Wall());
        room.setSide(Maze.Directions.SOUTH, new Wall());
        room.setSide(Maze.Directions.WEST, new Wall());
        room.setSide(Maze.Directions.EAST, new Wall());
        maze.addRoom(nroom, room);
    }

    @Override
    public void setTarget(int nroom) {
        this.maze.getRoom(nroom).setTarget(true);
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Maze.Directions dir) {
        Door door = buildDoorInternal(roomFrom, roomTo, dir);
        door.open();
    }

    private Door buildDoorInternal(int roomFrom, int roomTo, Maze.Directions dir) {
        Room r1 = maze.getRoom(roomFrom);
        Room r2 = maze.getRoom(roomTo);
        Door door = new Door(r1, r2);
        r1.setSide(dir, door);
        r2.setSide(getOppositeSide(dir), door);
        return door;
    }

    private Maze.Directions getOppositeSide(Maze.Directions dir) {
        switch(dir) {
            case NORTH: return Maze.Directions.SOUTH;
            case SOUTH: return Maze.Directions.NORTH;
            case WEST: return Maze.Directions.EAST;
            case EAST: return Maze.Directions.WEST;
        }
        throw new RuntimeException("Direcció no reconeguda");
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Maze.Directions dir, Key key) {
        Door d = buildDoorInternal(roomFrom, roomTo, dir);
        key.addDoor(d);
    }

    @Override
    public void putKeyInRoom(int nroom, Key key) {
        maze.getRoom(nroom).setItem(key);
        maze.getRoom(nroom).setHaveKey(true);
    }

    @Override
    public void putCoinInRoom(int nroom, Coin coin) {
        maze.getRoom(nroom).setItem(coin);
        maze.getRoom(nroom).setHaveCoin(true);
    }

    @Override
    public Maze getMaze() {
        return this.maze;
    }
}