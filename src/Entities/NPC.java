package Entities;

public class NPC extends Entity {
    private int health = 10, dosh = 10, strength = 10;

    public NPC() {

    }

    public NPC(int health, int dosh, int strength) {
        this.health = health;
        this.dosh = dosh;
        this.strength = strength;
    }
    public void damageOrHeal(int amount){
        health+=amount;
    }

    public int getHealth() {
        return health;
    }

    public int getDosh() {
        return dosh;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString(){
        return "N";
    }
}
