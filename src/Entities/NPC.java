package Entities;

public class NPC extends Entity{
    private int health=10,dosh=10,strength=10;
    public NPC(){

    }
    public NPC(int health, int dosh, int strength){
        this.health=health;
        this.dosh=dosh;
        this.strength= strength;
    }
}
