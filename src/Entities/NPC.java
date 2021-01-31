package Entities;

public class NPC extends Entity {
    private int health = 1, dosh = 10, strength = 1;
    private boolean aggression = false;
    private boolean fainted = false;

    public NPC() {

    }

    public NPC(int health, int dosh, int strength) {
        this.health = health;
        this.dosh = dosh;
        this.strength = strength;
    }

    public NPC(int health, int dosh, int strength, boolean aggression) {
        this(health, dosh, strength);
        this.aggression = aggression;
    }

    public void damageOrHeal(int amount) {
        health += amount;
    }

    public int getHealth() {
        return health;
    }

    public int getDosh() {
        return dosh;
    }

    public void acquireOrLoseDosh(int amount) {
        dosh += amount;
    }

    public boolean isAggression() {
        return aggression;
    }

    public boolean checkFaint() {
        if (health <= 0) {
            fainted = true;
            return true;
        }
        return false;
    }

    protected void setAggression(boolean aggression) {
        this.aggression = aggression;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isFainted() {
        return fainted;
    }


    protected void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "N";
    }
}
