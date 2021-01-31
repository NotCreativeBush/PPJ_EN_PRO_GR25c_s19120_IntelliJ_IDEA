package Tile;


import Entities.*;

import java.util.Scanner;

public class Map {
    private Tile[][] map;
    private int height, width;
    private Player player;
    private boolean gameInProgress = true;
    private Scanner scanner=new Scanner(System.in);

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.map = new Tile[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = new Tile();
            }
        }
        player = new Player((int) (Math.random() * height), (int) (Math.random() * width));
        this.setHasPlayer(true);
        int x, y;
        for (int i = 0; i < 4; i++) {
            do {
                x = (int) (Math.random() * height);
                y = (int) (Math.random() * width);
            } while (map[x][y].isOccupied());
            map[x][y].setEntity(new NPC());
            do {
                x = (int) (Math.random() * height);
                y = (int) (Math.random() * width);
            } while (map[x][y].isOccupied());
            map[x][y].setEntity(new Fire());
            do {
                x = (int) (Math.random() * height);
                y = (int) (Math.random() * width);
            } while (map[x][y].isOccupied());
            map[x][y].setEntity(new Trader());
        }

    }

    public void setHasPlayer(boolean b) {
        map[player.getX()][player.getY()].setHasPlayer(b);
    }

    public void movePlayer(String s) {
        this.setHasPlayer(false);
        player.movePlayer(s);

        if (player.checkBounds(height, width)) {
            System.out.println("It appears you have discovered the edge of the world. You're now falling into the endless abyss. Game over.");
            player.damageOrHeal(-9999);
        }else {
            this.setHasPlayer(true);
        }
    }
    public void checkWinOrLose(){
        if(player.getHealth()<=0){
            gameInProgress=false;
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
        while (gameInProgress) {
            this.drawMap();

            player=map[player.getX()][player.getY()].entityAction(player);
            System.out.println("Your Health is "+player.getHealth());
            this.checkWinOrLose();
            map[player.getX()][player.getY()].availableInteractions();
            String str=scanner.nextLine();
            this.movePlayer(str);
            player=map[player.getX()][player.getY()].entityInteraction(str,player);
            this.checkWinOrLose();
        }
    }

}
