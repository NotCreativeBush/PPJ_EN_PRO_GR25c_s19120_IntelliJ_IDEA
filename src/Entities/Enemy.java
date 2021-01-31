package Entities;

public class Enemy extends NPC {
    @Override
    public Player action(Player player) {
        return player;
    }
    @Override
    public Player interact(String str, Player player){
        return player;
    }
}
