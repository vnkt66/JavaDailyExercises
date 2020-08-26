import java.util.Scanner;

class UserMainCode {
  static boolean validateDate(String date) {
    return date.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}");    
}
  
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Date:");
    String date = sc.nextLine();
    boolean valid = UserMainCode.validateDate(date);
    String validity = valid ? "Valid" : "Invalid";
    System.out.println(validity);
}
}