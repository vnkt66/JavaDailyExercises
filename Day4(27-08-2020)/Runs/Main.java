import java.util.Scanner;

class Main {
  public static void main(String[] args) {
   try{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of overs");
    Integer overs = sc.nextInt();
    System.out.println("Enter the number of runs for each over");
    int[] runs = new int[overs];
    for(int i = 0; i < overs; i++) {
      runs[i] = sc.nextInt();
    }
    System.out.println("Enter the over number");
    Integer overNumber = sc.nextInt();
    Integer runsScored = runs[overNumber - 1];
    System.out.println("Runs scored in this over : " + runsScored);
} catch(Exception e) {
   System.out.println(e);   
}
}

}