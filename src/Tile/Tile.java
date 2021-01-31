package Tile;

import Entities.*;

import java.util.ArrayList;

public class Tile {
    private Entity entity;
    private boolean hasPlayer;

    public Tile() {

    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setHasPlayer(boolean b) {
        hasPlayer = b;
    }

    public boolean hasPlayer() {
        return hasPlayer;
    }

    public boolean isOccupied() {
        return (hasPlayer || (entity != null));
    }

    public Player entityAction(Player player) {
        if (entity != null) {
            return entity.action(player);
        }
        return player;
    }

    public Player entityInteraction(String str, Player player) {
        if (entity != null) {
            return entity.interact(str, player);
        }
        return player;
    }

    public void availableInteractions(Player player) {
        System.out.print("Interactions available: ");
        ArrayList<String> arr = player.availableMoves();
        if (entity != null) {
            ArrayList<String> arr2 = entity.availableMoves();
            arr.addAll(arr2);
        }
        for (String x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        if (entity != null) {
            if (hasPlayer()) {
                return "P " + entity.toString();
            }
            return " " + entity.toString() + " ";
        }
        if (hasPlayer()) {
            return " P ";
        }
        return "   ";
    }
}
