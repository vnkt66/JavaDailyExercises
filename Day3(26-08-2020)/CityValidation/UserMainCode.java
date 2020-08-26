import java.util.Scanner;

class UserMainCode {
  static boolean validateCity(String city) {
    char[] stars = city.substring(2,city.length()-2).toCharArray();
    System.out.println(city.substring(2,city.length()-2).toCharArray());
    boolean starValidity = false;
    boolean valid = false;
    boolean otherCharsValidity = false;
    for(char star : stars) {
      if(star != '*') {
         otherCharsValidity = true;
         break;
       }
       starValidity = star == '*' ? true : false;
    }
    //System.out.println("str" + starValidity);
    //System.out.println("alp" + otherCharsValidity);
    boolean startingCharsValidity = city.substring(0,2).matches("[a-zA-Z]+");
    //System.out.println(city.substring(0,2));
    //System.out.println(startingCharsValidity);
    boolean endingCharsValidity = city.substring(city.length()-2,city.length()).matches("[a-zA-Z]+");
    //System.out.println(city.substring(city.length()-2,city.length()));
    //System.out.println(endingCharsValidity);
    valid = startingCharsValidity && starValidity && !otherCharsValidity && endingCharsValidity;
    return valid;
}
  
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter City:");
    String city = sc.nextLine();
    boolean valid = UserMainCode.validateCity(city);
    String validity = valid ? "Valid" : "Invalid";
    System.out.println(validity);
}
}