import java.util.*;

class CskFrequency {
  public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   Integer matches = sc.nextInt();
   sc.nextLine();
   int i = matches;
   List<String> runs = new ArrayList<>();
   while(i > 0) {
     runs.add(sc.nextLine()); 
     i--;
}
//System.out.println("runs" + runs);
String find = sc.nextLine();
//System.out.println(find);
Integer times = Collections.frequency(runs, find);
System.out.println("\n" + times);
}
}