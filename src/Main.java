import Entities.*;
import Tile.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Map map=new Map(20,20);

        //Player player=new Player();
        map.setPlayer((int)(Math.random()*20),(int)(Math.random()*20));




       // Scanner scanner=new Scanner(System.in);

        map.gameplay();
    }
}
