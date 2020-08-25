import java.util.Scanner;

class Delivery {
 public Long over;
 public Long ball;
 public Long runs;
 public String batsman;
 public String bowler;
 public String nonStriker;
 Delivery(Long over, Long ball, Long runs, String batsman, String bowler, String nonStriker) {
   this.over = over;
   this.ball = ball;
   this.runs = runs;
   this.batsman = batsman;
   this.bowler = bowler;
   this.nonStriker = nonStriker;
}
void displayDeliveryDetails() {
  System.out.println("Delivery Details:\n" + "Over : " + over + "\n" + "Ball : " + ball + "\n" + "Runs : " + runs + "\n" + "Batsman : " + batsman + "\n" + "Bowler : " + bowler + "\n" + "NonStriker : " + nonStriker);
}
}

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
  delivery.displayDeliveryDetails();
}
}