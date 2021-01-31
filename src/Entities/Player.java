package Entities;


import java.util.ArrayList;

public class Player extends NPC {
    private int x = 0, y = 0;
    private int extinguisher = 0, booze = 0;
    private int exp = 0;
    private int lvl = 0;

    public Player() {

    }

    public Player(int health, int dosh, int strength, int x, int y, int extinguisher, int booze, int exp) {
        super(health, dosh, strength);
        this.x = x;
        this.y = y;
        this.extinguisher = extinguisher;
        this.booze = booze;
        this.exp = exp;
    }

    public Player(int health, int dosh, int strength, int x, int y) {
        this(health, dosh, strength, x, y, 0, 0, 0);
    }

    public int getExtinguisher() {
        return extinguisher;
    }


    public void acquireBooze(int amount) {
        booze += amount;
    }
    public void useBooze(String str){
        if(str.equalsIgnoreCase("drink")){
            if(booze>0){
                booze--;
                System.out.println("You've drank some booze.");
                gainEXP(4);
                damageOrHeal(20);
            }else{
                System.out.println("No booze.");
            }
        }

    }

    public int getLvl() {
        return lvl;
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
        return !(x < 0 || x >= height || y < 0 || y >= width);
    }

    public void gainEXP(int amount) {
        System.out.println("You've gained " + amount + " EXP!");
        exp += amount;
        setStrength(getStrength() + (exp / 5));
        lvl+=exp/5;
        exp %= 5;
    }

    @Override
    public ArrayList<String> availableMoves() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("left");
        arr.add("right");
        arr.add("up");
        arr.add("down");
        if (booze > 0) {
            arr.add("drink");
        }
        return arr;
    }

    @Override
    public String toString() {
        return "Your Health is: " + getHealth() + "\nYour Dosh is: " + getDosh() + "\nYour Strength is: " + getStrength() + "\nYour Experience is: " + exp + "\nYour Level is: " + lvl + "\nYou have " + extinguisher + " Extinguishers" + "\nYou have " + booze + " Booze";
    }
}
