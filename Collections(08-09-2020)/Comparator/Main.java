import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter number of teams:");
   Integer count = Integer.parseInt(sc.nextLine());
   List<Team> teamList = new ArrayList<>();
   Team team = null;
   Integer loop = 1;
   while(count > 0) {
    System.out.println("Enter team " + loop + " " + "detail");
    System.out.println("Enter Name");
    String name = sc.nextLine();
    System.out.println("Enter number of matches");
    Long numberOfMatches = Long.parseLong(sc.nextLine());
    team = new Team(name, numberOfMatches);
    teamList.add(team);
    loop++;
    count--;
}
    Collections.sort(teamList, new TeamComparator());
    System.out.println("Team list after sort by number of matches");
    teamList.forEach(System.out::println);
}
}