import Entities.*;
import Tile.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean wishToContinue;
        Map map;
        Scanner scanner=new Scanner(System.in);
        do {
            map = new Map(20, 20);
            map.gameplay();
            System.out.println("Game over, do you wish to continue? Type Yes or No.");
            wishToContinue=scanner.nextLine().equalsIgnoreCase("yes");
        } while (wishToContinue);
    }
}
