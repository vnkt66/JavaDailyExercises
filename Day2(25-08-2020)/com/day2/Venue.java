import java.util.Scanner;

class Venue {
 private String name;
 private String city;
 Venue(String name, String city) {
   this.name = name;
   this.city = city;
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}
public String getCity() {
  return city;
}
public void setCity(String city) {
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
  System.out.println("Venue Name : " + venue.getName());
  System.out.println("City Name : " + venue.getCity());
  boolean drop = false;
  while(!drop) {
   
  System.out.println("Verify and Update Venue Details" + "\n" + "Menu" + "\n" + "1.Update Venue Name\n" + "2.Update City Name\n" + "3.All informations Correct/Exit\n" + "Type 1 or 2 or 3\n");
  Integer choice = sc.nextInt();
  sc.nextLine();

  switch(choice) {
    case 1:
    System.out.println("Enter the venue name");
    String modifiedVenue = sc.nextLine();
    venue.setName(modifiedVenue);
    System.out.println("Venue Details :");
    System.out.println("Venue Name : " + venue.getName());
    System.out.println("City Name : " + venue.getCity());
    break;
   case 2:
    System.out.println("Enter the city name");
    String modifiedCity = sc.nextLine();
    venue.setCity(modifiedCity);
    System.out.println("Venue Details :");
    System.out.println("Venue Name : " + venue.getName());
    System.out.println("City Name : " + venue.getCity());
    break;
   case 3:
    drop = true;
    break;
}
}
}
}