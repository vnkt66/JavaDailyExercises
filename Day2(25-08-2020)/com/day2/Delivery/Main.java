import java.util.Scanner;

class Main {
  public static void main(String[] args) {
  Scanner sc= new Scanner(System.in); 
  System.out.println("Enter the over");
  Long over = sc.nextLong();
  System.out.println("Enter the ball");
  Long ball = sc.nextLong();
  System.out.println("Enter the runs");
  Long runs = sc.nextLong();
  sc.nextLine();
  System.out.println("Enter the batsman name");
  String batsman = sc.nextLine();
  System.out.println("Enter the bowler name");
  String bowler = sc.nextLine();
  System.out.println("Enter the nonStriker name");
  String nonStriker = sc.nextLine();
  Delivery delivery = new Delivery(over, ball, runs, batsman, bowler, nonStriker);
  System.out.println("Over : " + delivery.getOver() + "\n" + "Ball : " + delivery.getBall() + "\n" + "Runs : " + delivery.getRuns() + "\n" + "Batsman : " + delivery.getBatsman() + "\n" + "Bowler : " + delivery.getBowler() + "\n" + "NonStriker : " + delivery.getNonStriker());
}
}