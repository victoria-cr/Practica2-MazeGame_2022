package com.liceu.practica2.services;

import com.liceu.practica2.model.Key;
import com.liceu.practica2.model.Maze;
import com.liceu.practica2.model.Player;
import com.liceu.practica2.model.Room;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MazeGame {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Maze maze = createMaze();
        Player player = new Player();
        play(maze, player);
    }

    private static void play(Maze maze, Player player) {
        player.setCurrentRoom(maze.getRoom(1));
        while(!player.getCurrentRoom().isTarget()) {
            Maze.Directions dir = askUser();
            go(player, dir);
        }
    }

    private static void go(Player player, Maze.Directions dir) {
        Room room = player.getCurrentRoom();
        MapSite ms = room.getSide(dir);
        ms.enter(player);
    }

    private static Maze.Directions askUser() {
        System.out.println("Cap a on vols anar? (N,S,E,W)");
        while(true) {
            String line = scanner.nextLine();
            if (line.length() > 0) {
                char c = line.toUpperCase().charAt(0);
                switch(c) {
                    case 'N': return Maze.Directions.NORTH;
                    case 'S': return Maze.Directions.SOUTH;
                    case 'E': return Maze.Directions.EAST;
                    case 'W': return Maze.Directions.WEST;
                }
            }
        }
    }

    private static Maze createMaze() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();
        IntStream
                .range(1,7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Level1 Key");
        Key k2 = new Key("Level2 Key");

        mazeBuilder.buildDoor(1,2, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(1,4, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(1,5, Maze.Directions.EAST);

        mazeBuilder.buildDoor(1,3, Maze.Directions.WEST, k2);
        mazeBuilder.buildDoor(5,6, Maze.Directions.EAST, k1);

        mazeBuilder.putKeyInRoom(6, k2);
        mazeBuilder.putKeyInRoom(2, k1);

        mazeBuilder.setTarget(3);

        return mazeBuilder.getMaze();
    }
}
