import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

class Usability {
  public static Integer sum(List<Integer> list) {
    Stream<Integer> evenIndexElements = IntStream.range(1, (list.size() + 1)).boxed().filter((i) -> (i % 2 == 0)).map((index) -> list.get(index-1));
    Integer evenSum = evenIndexElements.filter((ele) -> ele % 2 != 0).mapToInt((ele) -> ele).sum();
    return evenSum; 
}
}

class Main {
  public static void main(String[] args) {
   try{
    Scanner sc = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    Integer count = Integer.parseInt(sc.nextLine());
    for(int i = 0; i < count; i++) {
      list.add(Integer.parseInt(sc.nextLine()));
}
    System.out.println("\n" + Usability.sum(list));
    } catch(Exception e) {
      System.out.println(e);
}
}
}