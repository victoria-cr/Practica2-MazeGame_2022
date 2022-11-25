package com.liceu.practica2.services;

import com.liceu.practica2.model.*;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MazeGame {
    private Maze maze;
    private Player player;
    private static Scanner scanner = new Scanner(System.in);

    public Player main() {
        this.maze = createMaze();
        this.player = new Player();
        play(maze, player);
        return player;
    }

    private static void play(Maze maze, Player player) {
        player.setCurrentRoom(maze.getRoom(1));
//        while(!player.getCurrentRoom().isTarget()) {
//            Maze.Directions dir = askUser();
//            go(player, dir);
//        }
    }

   public void go(Player player, Maze.Directions dir) {
        Room room = player.getCurrentRoom();
        MapSite ms = room.getSide(dir);
        ms.enter(player);
    }

    public Maze.Directions askUser(String c) {
        switch(c) {
            case "N": return Maze.Directions.NORTH;
            case "S": return Maze.Directions.SOUTH;
            case "E": return Maze.Directions.EAST;
            case "W": return Maze.Directions.WEST;
        }
        return null;
    }

    private static Maze createMaze() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();
        IntStream
                .range(1,7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Level1 Key");
        Key k2 = new Key("Level2 Key");

        Coin coin1 = new Coin();

        mazeBuilder.buildDoor(1,2, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(1,4, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(1,5, Maze.Directions.EAST);

        mazeBuilder.buildDoor(1,3, Maze.Directions.WEST, k2);
        mazeBuilder.buildDoor(5,6, Maze.Directions.EAST, k1);

        mazeBuilder.putKeyInRoom(6, k2);
        mazeBuilder.putKeyInRoom(2, k1);

        mazeBuilder.putCoinInRoom(4, coin1);

        mazeBuilder.setTarget(3);

        return mazeBuilder.getMaze();
    }

    public JSONObject json(Player player) {
        Room room = player.getCurrentRoom();
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("room", room.getNumber());

        jsonObject.put("N", comprovarPuerta(room, Maze.Directions.NORTH));
        jsonObject.put("S", comprovarPuerta(room, Maze.Directions.SOUTH));
        jsonObject.put("E", comprovarPuerta(room, Maze.Directions.EAST));
        jsonObject.put("W", comprovarPuerta(room, Maze.Directions.WEST));

        jsonObject.put("coins", contarMonedas(player));
        jsonObject.put("keys", contarLlaves(player));

        jsonObject.put("tieneLlave", room.isHayLlave());
        jsonObject.put("tieneMoneda", room.isHayMoneda());

        return jsonObject;
    }

    private static String comprovarPuerta(Room room, Maze.Directions direction) {
        if (room.getSide(direction) instanceof Door) {
            if (((Door) room.getSide(direction)).isOpen()) {
                return "open";
            } else {
                return "closed";
            }
        }
        return "wall";
    }

    private static int contarMonedas(Player player) {
        int contador = 0;
        for (int i = 0; i < player.getItemList().size(); i++) {
            if (player.getItemList().get(i) instanceof Coin) {
                contador++;
            }
        }
        return contador;
    }

    private static List<String> contarLlaves(Player player) {
        List<String> llaves = new ArrayList<>();
        for (int i = 0; i < player.getItemList().size(); i++) {
            if (player.getItemList().get(i) instanceof Key) {
                llaves.add(((Key) player.getItemList().get(i)).getName());
            }
        }
        return llaves;
    }
}
