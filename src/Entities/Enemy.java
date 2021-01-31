package Entities;

import java.util.ArrayList;

public class Enemy extends NPC {
    private boolean firstEncounter = true;

    public Enemy(int health, int dosh, int strength) {
        super(health, dosh, strength, true);
    }

    @Override
    public void action(Player player) {
        if (firstEncounter) {
            System.out.println("You've encountered an angry person. They demand dosh.");
            firstEncounter = false;
        } else if (isFainted()) {
            System.out.println("They appear to be knocked out.");

        } else if (isAggression()) {
            System.out.println("The person doesn't like you. He punches you.");
            player.damageOrHeal(-getStrength());
        } else {
            System.out.println("'Thanks for the dosh'");
        }
    }

    public void angryInteract(String str, Player player) {
        if (!isFainted()) {
            punch(str, player);
            if (str.equalsIgnoreCase("bribe")) {
                if (player.getDosh() >= 5) {
                    System.out.println("'Thanks'. They seem to calm down.");
                    player.acquireOrLoseDosh(-5);
                    this.acquireOrLoseDosh(5);
                } else {
                    System.out.println("'Not enough'");
                }
            }
        }

    }

    private void punch(String str, Player player) {
        if (str.equalsIgnoreCase("punch")) {
            this.setAggression(true);
            System.out.println("You've punched an angry person. He said something, you didn't understand");
            this.damageOrHeal(-player.getStrength());
            if (checkFaint()) {
                System.out.println("The angry person gets knocked out. Good.");
                player.acquireOrLoseDosh(this.getDosh());
                this.acquireOrLoseDosh(-this.getDosh());
                player.gainEXP(11);
            }
        }
    }

    public void friendlyInteract(String str, Player player) {
        if (!isFainted()) {
            punch(str, player);

        }

    }

    @Override
    public ArrayList<String> availableMoves() {
        ArrayList<String> arr = new ArrayList<>();
        if (!isFainted()) {
            if (isAggression()) {
                arr.add("bribe");
            }
            arr.add("punch");
        }
        return arr;
    }

    @Override
    public void interact(String str, Player player) {
        if (!isAggression()) {
            friendlyInteract(str, player);
        } else angryInteract(str, player);
    }

    @Override
    public String toString() {
        return "E";
    }
}
