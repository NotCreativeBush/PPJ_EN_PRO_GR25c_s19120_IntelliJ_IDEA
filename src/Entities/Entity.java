package Entities;


import java.util.ArrayList;

public class Entity {

    public Entity(){

    }
    public Player action(Player player) {
        return player;
    }
    public Player interact(String str, Player player){
        return player;
    }
    public ArrayList<String> availableMoves(){
        return new ArrayList<>();
    }
}
