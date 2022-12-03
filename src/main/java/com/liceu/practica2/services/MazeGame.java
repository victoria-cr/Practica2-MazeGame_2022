package com.liceu.practica2.services;

import com.liceu.practica2.model.*;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MazeGame {
    private Maze maze;
    private Player player;

    public Player main(String map) {
        if (map.equals("map1")) {
            this.maze = createMaze1();
        } else if (map.equals("2")) {
            this.maze = createMaze2();
        }
        this.player = new Player();
        play(maze, player);
        return player;
    }

    private static void play(Maze maze, Player player) {
        player.setCurrentRoom(maze.getRoom(1));
    }

   public void go(Player player, Maze.Directions dir) {
        Room room = player.getCurrentRoom();
        MapSite mapSite = room.getSide(dir);
        mapSite.enter(player);
    }

    public Maze.Directions askUser(String dir) {
        switch(dir) {
            case "N": return Maze.Directions.NORTH;
            case "S": return Maze.Directions.SOUTH;
            case "E": return Maze.Directions.EAST;
            case "W": return Maze.Directions.WEST;
        }
        return null;
    }

    private static Maze createMaze1() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();
        IntStream
                .range(1,7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Key1",1);
        Key k2 = new Key("Key2",2);

        Coin coin1 = new Coin();
        Coin coin2 = new Coin();
        Coin coin3 = new Coin();

        mazeBuilder.buildDoor(1,2, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(1,4, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(1,5, Maze.Directions.EAST);

        mazeBuilder.buildDoor(5,6, Maze.Directions.EAST, k1);
        mazeBuilder.buildDoor(1,3, Maze.Directions.WEST, k2);

        mazeBuilder.putKeyInRoom(2, k1);
        mazeBuilder.putKeyInRoom(6, k2);

        mazeBuilder.putCoinInRoom(1, coin1);
        mazeBuilder.putCoinInRoom(5, coin2);
        mazeBuilder.putCoinInRoom(4, coin3);

        mazeBuilder.setTarget(3);

        return mazeBuilder.getMaze();
    }

    private static Maze createMaze2() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();
        IntStream
                .range(1,7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Level1 Key",1);
        Key k2 = new Key("Level2 Key",2);

        Coin coin1 = new Coin();
        Coin coin2 = new Coin();
        Coin coin3 = new Coin();

        mazeBuilder.buildDoor(1,4, Maze.Directions.WEST);
        mazeBuilder.buildDoor(2,3, Maze.Directions.EAST);
        mazeBuilder.buildDoor(1,5, Maze.Directions.SOUTH);

        mazeBuilder.buildDoor(1,2, Maze.Directions.NORTH, k1);
        mazeBuilder.buildDoor(5,6, Maze.Directions.SOUTH, k2);

        mazeBuilder.putKeyInRoom(4, k1);
        mazeBuilder.putKeyInRoom(1, k2);

        mazeBuilder.putCoinInRoom(5, coin1);
        mazeBuilder.putCoinInRoom(2, coin2);
        mazeBuilder.putCoinInRoom(3, coin3);

        mazeBuilder.setTarget(6);

        return mazeBuilder.getMaze();
    }

    public JSONObject json(Player player) {
        Room currentRoom = player.getCurrentRoom();
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("currentRoom", currentRoom.getNumber());

        jsonObject.put("N", checkDoor(currentRoom, Maze.Directions.NORTH));
        jsonObject.put("S", checkDoor(currentRoom, Maze.Directions.SOUTH));
        jsonObject.put("E", checkDoor(currentRoom, Maze.Directions.EAST));
        jsonObject.put("W", checkDoor(currentRoom, Maze.Directions.WEST));

        jsonObject.put("coins", countCoin(player));
        jsonObject.put("keys", countKey(player));

        jsonObject.put("haveKey", currentRoom.isHaveKey());
        jsonObject.put("haveCoin", currentRoom.isHaveCoin());

        return jsonObject;
    }

    private static String checkDoor(Room room, Maze.Directions direction) {
        if (room.getSide(direction) instanceof Door) {
            if (((Door) room.getSide(direction)).isOpen()) {
                return "open";
            } else {
                return "closed";
            }
        }
        return "wall";
    }

    private static int countCoin(Player player) {
        int count = 0;
        for (int i = 0; i < player.getItemList().size(); i++) {
            if (player.getItemList().get(i) instanceof Coin) {
                count++;
            }
        }
        return count;
    }

    private static List<String> countKey(Player player) {
        List<String> keysList = new ArrayList<>();
        for (int i = 0; i < player.getItemList().size(); i++) {
            if (player.getItemList().get(i) instanceof Key) {
                keysList.add(((Key) player.getItemList().get(i)).getName());
            }
        }
        return keysList;
    }

    public void takeKey(Player player) {
        if (player.getCurrentRoom().getItem() instanceof Key) {
            if (countCoin(player) >= ((Key) player.getCurrentRoom().getItem()).getValor()) {
                removeCoin(player);
                player.addItem(player.getCurrentRoom().getItem());
                player.getCurrentRoom().setHaveKey(false);
            }
        }
    }

    public void removeCoin(Player player) {
        int keyValue = ((Key) player.getCurrentRoom().getItem()).getValor();
        for (int i = 0; i < player.getItemList().size(); i++) {
            if (player.getItemList().get(i) instanceof Coin) {
                if (keyValue > 0) {
                    keyValue--;
                    player.getItemList().remove(i);
                    i--;
                }
            }
        }
    }

    public void takeCoin(Player player) {
        if (player.getCurrentRoom().getItem() instanceof Coin) {
            player.addItem(player.getCurrentRoom().getItem());
            player.getCurrentRoom().setHaveCoin(false);
        }
    }

    public void openDoor(Player player, Maze.Directions direction) {
        player.getCurrentRoom().getSide(direction).openDoor(player);
    }
}
