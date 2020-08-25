import java.util.Scanner;

class ExtraType {
 private String name;
 private Long runs;
 ExtraType(String name, Long runs) {
   this.name = name;
   this.runs = runs;
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}
public Long getRuns() {
  return runs;
}
public void setRuns(Long runs) {
  this.runs = runs;
}
}

class Main {
  public static void main(String[] args) {
  Scanner sc= new Scanner(System.in); 
  System.out.println("Enter the extratype details");
  String details = sc.nextLine();
  String[] detailsArray = details.split("#");
  Integer runs = Integer.parseInt(detailsArray[1]);
  Long longRuns = new Long(runs);
  // instead of this we can default constructor and set instance variables using setters.
  ExtraType extraType = new ExtraType(detailsArray[0], longRuns); // converting string to int and then int to long
  System.out.println("ExtraType Details :");
  System.out.println("ExtraType : " + extraType.getName());
  System.out.println("Runs : " + extraType.getRuns());
}
}