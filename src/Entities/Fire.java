package Entities;

public class Fire extends Entity{
    public Fire(){

    }
    @Override
    public Player action(Player player){
        System.out.println("You're in the fire. Fire is hot. Fire dealt damage. Fire will deal damage if you stay in it. Maybe you should step off the fire.");
        player.damageOrHeal(-1);
        return player;
    }

    @Override
    public String toString() {
        return "F";
    }
}
