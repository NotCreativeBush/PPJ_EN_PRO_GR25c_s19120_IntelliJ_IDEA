package Tile;

import Entities.*;

public class Tile {
    private Entity entity;
    private boolean hasPlayer;

    public Tile() {

    }

    public void setHasPlayer(boolean b) {
        hasPlayer = b;
    }

    public boolean hasPlayer() {
        return hasPlayer;
    }

    @Override
    public String toString() {

        if (hasPlayer()) {
            return " P ";
        }
        return "   ";
    }
}
