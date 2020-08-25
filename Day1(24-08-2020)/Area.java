import java.util.*;
public class Area {
      public static void main(String[] args){
      double a;
      double r;
      // const 
      final double pi = Math.PI;

      r = 1.0;
      a = pi * r * r;
      // calling static method to display output
      display(r,a);

      r = 1.5;
      a = pi * r * r;
      // calling static method to display output
      display(r,a);

      r = 2.0;
      a = pi * r * r;
      // calling static method to display output
      display(r,a);
      }
      static void display(double r, double a){
           System.out.println("For radius = " + r +
                                ", area = " + a);
      }
}

// output
// For radius = 1.0, area = 3.141592653589793
// For radius = 1.5, area = 7.0685834705770345
// For radius = 2.0, area = 12.566370614359172
