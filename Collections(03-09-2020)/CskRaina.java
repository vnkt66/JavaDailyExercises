import java.util.*;

class CskRaina {
  public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   Integer matches = sc.nextInt();
   int i = matches;
   sc.nextLine();
   List<Integer> runs = new ArrayList<>();
   while(i > 0) {
     runs.add(sc.nextInt()); 
     sc.nextLine();
     i--;
}
Collections.sort(runs);
System.out.println();
for(Integer run : runs) {
 System.out.println(run);
}
}
}