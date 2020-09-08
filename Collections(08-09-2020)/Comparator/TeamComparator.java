import java.util.Comparator;

public class TeamComparator implements Comparator<Team> {
  public int compare(Team t1, Team t2) {
    if(t1.getNumberOfMatches() > t2.getNumberOfMatches()) {
      return 1;
} else if(t1.getNumberOfMatches() < t2.getNumberOfMatches()) {
    return -1;
} else {
    return 0;
}
}
}