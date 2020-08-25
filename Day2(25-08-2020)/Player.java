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
  System.out.println("Enter the player name");
  String name = sc.nextLine();
  System.out.println("Enter the country name");
  String country = sc.nextLine();
  System.out.println("Enter the skill");
  String skill = sc.nextLine();
  Player player = new Player(name, country, skill);
  System.out.println("Player Details :");
  System.out.println("Player Name : " + player.name);
  System.out.println("Country Name : " + player.country);
  System.out.println("Skill : " + player.skill);
}
}