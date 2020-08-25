class Pattern {
  static void patternOne() {
    for(int i = 0; i < 4; i++) {
   for(int j = 0; j < 5; j++) {
   System.out.print("* "); 
}
System.out.println("\n\n");
}
}

static void patternTwo() {
  int star = 0;
        a:
        for(int i = 1; i <= 5; ++i, star = 0) { 
        b:
        for(int j = 1; j <= 5 - i; ++j) {
                System.out.print(" ");
            }
            c:
            while(star != i) {
                if(i == 4) {
                break c;
}
               System.out.print("* ");
                ++star;
            }
            if(i != 4) {
            System.out.println("\n\n");
}
        }
}
 
  public static void main(String[] args) {
         Pattern.patternOne();
         Pattern.patternTwo();
    }
}