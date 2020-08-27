import java.util.Scanner;

class CustomException extends Exception {
  private String message;

  CustomException(String message) {
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
    System.out.println("Enter the player name");
    String name = sc.nextLine();
    System.out.println("Enter the player age");
    Integer age = sc.nextInt();
    if(age < 19) {
      throw new CustomException("CustomException: InvalidAgeRangeException");
   }
    System.out.println("Player name : " + name);
    System.out.println("Player age : " + age);
} catch(Exception e) {
    System.out.println(e);
}
}    
}