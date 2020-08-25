import java.util.Scanner;

class Venue {
 String name;
 String city;
 Venue(String name, String city) {
   this.name = name;
   this.city = city;
}
}

class Main {
  public static void main(String[] args) {
  Scanner sc= new Scanner(System.in); 
  System.out.println("Enter the venue name");
  String name = sc.nextLine();
  System.out.println("Enter the city name");
  String city = sc.nextLine();
  Venue venue = new Venue(name, city);
  System.out.println("Venue Details :");
  System.out.println("Venue Name : " + venue.name);
  System.out.println("City Name : " + venue.city);
}
}