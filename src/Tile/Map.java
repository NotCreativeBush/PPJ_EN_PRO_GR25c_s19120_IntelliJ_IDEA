package Tile;

import java.util.Scanner;

public class Map {
    private Tile[][] map;
    private int height, width;
    private int playerx, playery;
    private boolean gameInProgress = true;

    public Map(int x, int y) {
        this.height = x;
        this.width = y;
        this.map = new Tile[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = new Tile();
            }
        }
    }


    public void setPlayer(int x, int y) {
        playerx = x;
        playery = y;
        map[x][y].setHasPlayer(true);
    }

    public void movePlayer(String s) {
        map[playerx][playery].setHasPlayer(false);
        if (s.equalsIgnoreCase("up")) {
            playerx--;
        } else if (s.equalsIgnoreCase("down")) {
            playerx++;
        } else if (s.equalsIgnoreCase("left")) {
            playery--;
        } else if (s.equalsIgnoreCase("right")) {
            playery++;
        }
        map[playerx][playery].setHasPlayer(true);
        if (playery < 0 || playery >= width || playerx < 0 || playerx >= height) {
            System.out.println("It appears you have discovered the edge of the world. You're now falling into the endless abyss. Game over.");
            gameInProgress = false;
        }
    }


    public void drawMap() {
        for (int j = 0; j < width; j++) {
            System.out.print("----");

        }
        System.out.println();
        for (int i = 0; i < height; i++) {

            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j] + "|");

            }
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print("----");

            }
            System.out.println();
        }
    }

    public void gameplay() {
        Scanner scanner = new Scanner(System.in);
        while (gameInProgress) {
            this.drawMap();
            this.movePlayer(scanner.nextLine());
        }
    }

}
