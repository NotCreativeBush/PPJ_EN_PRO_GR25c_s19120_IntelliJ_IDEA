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
            System.out.println("You've encountered a person. 'Oi bruv, lend me sum dollarydoos or I'll punch ya'. You didn't understand a word. He does look australian. Seems angry.");
            firstEncounter = false;
        } else if (isFainted()) {
            System.out.println("This mate seems to be sleeping.");

        } else if (isAggression()) {
            System.out.println("'Oh I'll fist ya alright'. Thankfully, he punched you.");
            player.damageOrHeal(-getStrength());
        } else {
            System.out.println("'You's a good bloke mate'. You still don't understand him.");
        }
    }

    public void angryInteract(String str, Player player) {
        if (!isFainted()) {
            punch(str, player);
            if (str.equalsIgnoreCase("bribe")) {
                if (player.getDosh() >= 5) {
                    System.out.println("'Thanks bruv'. He seems to calm down. You think that at least.");
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
            System.out.println("You've punched an angry person. He said something, you didn't understand.");
            this.damageOrHeal(-player.getStrength());
            if (checkFaint()) {
                System.out.println("'Shoulda given me dollarydoos mate'.The person fainted. You think he complemented your strength. He had some dosh.");
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
        }
        else angryInteract(str, player);
    }
    @Override
    public String toString(){
        return "E";
    }
}
