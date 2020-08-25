import java.util.Scanner;

class Main {
  public static void main(String[] args) {
  Scanner sc= new Scanner(System.in); 
  System.out.println("Enter the number of wickets");
  Integer wickets = sc.nextInt();
  sc.nextLine();
  Wicket[] wicketObjectsArray = new Wicket[wickets]; 
  for(int i = 0; i < wickets; i++) {
    System.out.println("Enter the details of wicket " + (i + 1));
    String wicket = sc.nextLine();
    String[] wicketArray= wicket.split(",");
    Integer over = Integer.parseInt(wicketArray[0]);
    Long longOver = new Long(over);
    Integer ball = Integer.parseInt(wicketArray[1]);
    Long longBall = new Long(ball);
    wicketObjectsArray[i] = new Wicket(longOver, longBall, wicketArray[2], wicketArray[3], wicketArray[4]);
}
Integer i = 0;
while(wicketObjectsArray.length > i) {
   System.out.println("Wicket Details");
   System.out.println("Over : " + wicketObjectsArray[i].getOver());
   System.out.println("Ball : " + wicketObjectsArray[i].getBall());
   System.out.println("WicketType : " + wicketObjectsArray[i].getWicketType());
   System.out.println("PlayerName : " + wicketObjectsArray[i].getPlayerName());
   System.out.println("BowlerName : " + wicketObjectsArray[i].getBowlerName());
   i++;
}
}
}