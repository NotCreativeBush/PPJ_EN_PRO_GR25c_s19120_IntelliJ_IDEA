package Entities;

import java.util.ArrayList;

public class Trader extends NPC {
    public Trader(int health, int dosh, int strength) {
        super(health, dosh, strength);
    }

    @Override
    public void action(Player player) {
        if (isFainted()) {
            System.out.println("Trader is unconscious. You'd feel regret if you were a good person.");
        } else if (isAggression()) {
            System.out.println("Trader is angry. Rightfully so. He punched you.");
            player.damageOrHeal(-this.getStrength());
        } else {
            System.out.println("You've encountered a trader. You can buy useful items from them such as:\n Extinguisher: 10 dosh \n Booze: 1 dosh");
        }
    }

    public void friendlyInteract(String str, Player player) {
        if (str.equalsIgnoreCase("Extinguisher")) {
            if (player.getDosh() >= 10) {
                player.acquireOrUseExtinguisher(1);
                player.acquireOrLoseDosh(-10);
                System.out.println("You've acquired an extinguisher.");
            } else {
                System.out.println("Not enough dosh");
            }
        } else if (str.equalsIgnoreCase("Booze")) {
            if (player.getDosh() >= 1) {
                player.acquireBooze(1);
                player.acquireOrLoseDosh(-1);
                this.acquireOrLoseDosh(1);
                System.out.println("You've acquired booze.");
            } else {
                System.out.println("Not enough dosh");
            }
        } else if (str.equalsIgnoreCase("punch")) {
            punch(str, player);
        }

    }

    private void punch(String str, Player player) {

        this.setAggression(true);
        this.damageOrHeal(-player.getStrength());
        System.out.println("You've punched the trader");
        if (this.checkFaint()) {
            System.out.println("The trader fainted, they had some dosh. You borrow it. He wouldn't mind. Probably.");
            player.acquireOrLoseDosh(this.getDosh());
            this.acquireOrLoseDosh(-this.getDosh());
            player.gainEXP(11);
        }

    }


    public void angryInteract(String str, Player player) {
        if (!isFainted()) {
            if (str.equalsIgnoreCase("punch")) {
                punch(str, player);
            }
        }

    }

    @Override
    public void interact(String str, Player player) {
        if (!isAggression()) {
            friendlyInteract(str, player);
        }
        else angryInteract(str, player);
    }

    @Override
    public ArrayList<String> availableMoves() {
        ArrayList<String> arr = new ArrayList<>();
        if (!isFainted()) {
            if (!isAggression()) {
                arr.add("extinguisher");
                arr.add("booze");
            }
            arr.add("punch");
        }
        return arr;
    }

    @Override
    public String toString() {
        return "T";
    }
}
