import java.util.Scanner;
import java.util.Arrays;

class TeamNameNotFoundException extends Exception {
  private String message;
 
  TeamNameNotFoundException(String message) {
    this.message = message;
}
  
  public String toString() {
    return message;
}

}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try{
    String[] teams = {"Chennai Super Kings", "Deccan Chargers", "Delhi Daredevils", "Kings XI Punjab", "Kolkata Knight Riders", "Mumbai Indians", "Rajasthan Royals", "Royal Challengers Bangalore"};
    System.out.println("Enter the expected winner team of IPL Season 4");
    String winner = sc.nextLine();
    if(!Arrays.asList(teams).contains(winner)) {
      throw new TeamNameNotFoundException("TeamNameNotFoundException: Entered team is not a part of IPL Season 4");
   }
    System.out.println("Enter the expected runner team of IPL Season 4");
    String runner = sc.nextLine();
   if(!Arrays.asList(teams).contains(runner)) {
      throw new TeamNameNotFoundException("TeamNameNotFoundException: Entered team is not a part of IPL Season 4");
   }
    System.out.println("Expected IPL Season 4 winner: " + winner);
    System.out.println("Expected IPL Season 4 runner: " + runner);
} catch(Exception e) {
    System.out.println(e);
}
}    
}