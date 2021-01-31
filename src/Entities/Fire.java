package Entities;

import java.util.ArrayList;

public class Fire extends Entity {
    private boolean extinguished = false;

    public Fire() {

    }

    @Override
    public Player action(Player player) {
        if (extinguished) {
            System.out.println("You've stepped into some ashes. You remember the times when there was fire here. You want to forget these times.");
        } else {
            System.out.println("You're in the fire. Fire is hot. Fire dealt damage. Fire will deal damage if you stay in it. Maybe you should step off the fire.");
            player.damageOrHeal(-1);
        }
        return player;
    }

    @Override
    public Player interact(String str, Player player) {
        if (str.equalsIgnoreCase("extinguish") && !extinguished) {
            if (player.getExtinguisher() > 0) {
                player.acquireOrUseExtinguisher(-1);
                extinguished = true;
                System.out.println("Fire has been extinguished. It has left a lot of ashes. In the ashes you can find several coins of dosh.");
                player.acquireOrLoseDosh(10);

            } else {
                System.out.println("You have forgotten an extinguisher. You are still standing in the fire. It's still very hot");
                player.damageOrHeal(-1);
            }
        }
        return player;
    }

    @Override
    public ArrayList<String> availableMoves() {
        ArrayList<String> arr= new ArrayList<>();
        if(!extinguished){
            arr.add("extinguish");
        }
        return arr;
    }

    @Override
    public String toString() {
        if (extinguished) {
            return "A";
        }
        return "F";
    }
}
