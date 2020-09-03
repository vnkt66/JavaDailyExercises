import java.util.*;

class Csk {
  public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   Integer matches = sc.nextInt();
   int total = 0;
   double average = 0;
   int i = matches;
   sc.nextLine();
   List<Integer> runs = new ArrayList<>();
   while(i > 0) {
     runs.add(sc.nextInt()); 
     sc.nextLine();
     i--;
}
//System.out.println(runs);
for(int j = 0; j < matches; j++) {
  total += runs.get(j);
}
average = ((double)total / (double)matches);

System.out.println("\n" + total);
System.out.println("\n" + average);
}
}