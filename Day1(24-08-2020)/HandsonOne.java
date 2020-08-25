class HandsonOne {
// since we keep on incrementing x the while loop won't stop.
public static void main(String[] args) {
      int x = 5;
      while (x > 1) { 
          // decrement to make it work
          x--;
          // prints small x two times (2 < 3) & (1 < 3)
          if (x < 3) {
               System.out.println("small x");
          }
      }
 }
}