import java.util.Scanner;

class UserMainCode {
  static boolean validatePlayer(String player) {
    boolean Validity = false;

    // no Occurences of 'a'

    if(!player.contains("a")) {
      Validity = true;
    }

    // System.out.println("Initial Validity" + Validity);

    // odd Occurences

    StringBuffer oddOccurences = new StringBuffer();
    for(int i = 0; i <= player.length(); i++) {
      if(i % 2 != 0) {
        // System.out.println(player.charAt(i));
        oddOccurences.append(player.charAt(i));
}
}
boolean oddOccurencesValidity = false;
Integer oddOccurencesLength = oddOccurences.toString().length();
String oddOccurencesString = oddOccurences.toString();

for(int j = 0; j < oddOccurencesLength; j++) {
  oddOccurencesValidity = Character.toString(oddOccurencesString.charAt(j)).contains("a");
  // System.out.println("Odd" + Character.toString(oddOccurencesString.charAt(j)).contains("a"));
}
// System.out.println("odd" + oddOccurences);

// even Occurences

 StringBuffer evenOccurences = new StringBuffer();

    // System.out.println(player.length());
    for(int k = 0; k < player.length() ; k++) {
      if(k % 2 == 0) {
        // System.out.println(player.charAt(k));
        evenOccurences.append(player.charAt(k));
}
}

boolean evenOccurencesValidity = false;

Integer evenOccurencesLength = evenOccurences.toString().length();

//System.out.println("EvenOccurencesLength" + evenOccurences.toString().length());

String evenOccurencesString = evenOccurences.toString();
// System.out.println("Evenlength" + evenOccurencesLength);
for(int l = 0; l < evenOccurencesLength; l++) {
  evenOccurencesValidity = Character.toString(evenOccurencesString.charAt(l)).contains("a");
  //System.out.println("Even" + Character.toString(evenOccurencesString.charAt(l)).contains("a"));
}
//System.out.println("evenValidity" + evenOccurencesValidity);

if(!Validity) {
  if(oddOccurencesValidity && evenOccurencesValidity) {
   Validity = true;
} else {
   Validity = false;
}
}
return Validity;
}
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Player:");
    String player = sc.nextLine();
    boolean valid = UserMainCode.validatePlayer(player);
    String validity = valid ? "Valid" : "Invalid";
    System.out.println(validity);
}
}