package Entities;

public class Trader extends NPC{
    @Override
    public Player action(Player player) {
        System.out.println("You've encountered a trader. You can buy useful items from them such as:\n Extinguisher: 10 dosh \n Booze: 1 dosh");
        return player;
    }
    @Override
    public Player interact(String str, Player player){
        return player;
    }
    @Override
    public String toString(){
        return "T";
    }
}
