import java.util.Scanner;

class Player {
 String name;
 String country;
 String skill;
 Player(String name, String country, String skill) {
   this.name = name;
   this.country = country;
   this.skill = skill;
}
}

class Main {
  public static void main(String[] args) {
  Scanner sc= new Scanner(System.in); 
  System.out.println("Enter the player details");
  String playerDetails = sc.nextLine();
  String[] detailsArray = playerDetails.split(",");
  if(detailsArray.length < 4) {
  Player player = new Player(detailsArray[0], detailsArray[1], detailsArray[2]);
  System.out.println("Player Details :");
  System.out.println("Player Name : " + player.name);
  System.out.println("Country Name : " + player.country);
  System.out.println("Skill : " + player.skill);
} else {
  System.out.println("Your Input Should be 3 Values By Comma Seperated: MS Dhoni,India,All Rounder");
}
}
}