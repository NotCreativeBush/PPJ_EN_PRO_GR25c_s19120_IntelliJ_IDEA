package Entities;


public class Player extends NPC {
    private int x = 0, y = 0;
    private int extinguisher = 0, booze = 0;

    public Player() {

    }

    public Player(int health, int dosh, int strength, int x, int y) {
        super(health, dosh, strength);
        this.x = x;
        this.y = y;
    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getExtinguisher() {
        return extinguisher;
    }

    public int getBooze() {
        return booze;
    }

    public void acquireOrUseBooze(int amount){
        booze+=amount;

    }

    public void acquireOrUseExtinguisher(int amount) {
        extinguisher += amount;
    }

    public void movePlayer(String str) {
        if (str.equalsIgnoreCase("up")) {
            x--;
        } else if (str.equalsIgnoreCase("down")) {
            x++;
        } else if (str.equalsIgnoreCase("left")) {
            y--;
        } else if (str.equalsIgnoreCase("right")) {
            y++;
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean checkBounds(int height, int width) {
        return (x < 0 || x >= height || y < 0 || y >= width);
    }
}
