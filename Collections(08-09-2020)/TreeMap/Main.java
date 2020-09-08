import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

class Main {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter number of players");
   Integer count = Integer.parseInt(sc.nextLine());
   Map<String, Player> playerList = new TreeMap<>();
   Player player = null;
   Integer loop = 1;
   while(count > 0) {
    System.out.println("Enter details of the player " + loop);
    String capNumber = sc.nextLine();
    player = new Player(sc.nextLine(), sc.nextLine(), sc.nextLine());
    playerList.put(capNumber, player);
    loop++;
    count--;
}
    System.out.println("Player Details");
    playerList.forEach((k, v) -> {
      System.out.print(k+ "--" + v);
      System.out.println();
    });
}
}