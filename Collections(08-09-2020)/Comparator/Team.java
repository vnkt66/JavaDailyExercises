class Team {
 private String name;
 private Long numberOfMatches;
 Team(String name, Long numberOfMatches) {
   this.name = name;
   this.numberOfMatches = numberOfMatches;
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}
public Long getNumberOfMatches() {
  return numberOfMatches;
}
public void setNumberOfMatches(Long numberOfMatches) {
  this.numberOfMatches = numberOfMatches;
}
public String toString() {
  return name+" - "+numberOfMatches;
}
}