package Tile;

import Entities.*;

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
        if(entity!=null){
            return entity.action(player);
        }
        return player;
    }
    public Player entityInteraction(String str,Player player) {
        if(entity!=null){
            return entity.interact(str,player);
        }
        return player;
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
