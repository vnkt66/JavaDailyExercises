import java.util.*;
 // worked with weekly wages if hours worked more than 40 per week we can add extra pay which is 1.3 times of normal pay.
class AnnualPay {
 public static void main (String args[ ]) {      
                   Double totalPay;
                   Scanner sc= new Scanner(System.in); 
                   System.out.println("Enter Hours Worked by You:");
                   Integer hours = sc.nextInt(); 
                   System.out.println("Enter Your BasePayRate");
                   Double payRate = sc.nextDouble(); 
                   if(hours > 40) {
                   totalPay = (40 * payRate) + (((hours - 40) * payRate) * 1.3); 
}                  else {
                   totalPay = (hours * payRate);
}
                   System.out.println("Your Total Pay is: " + totalPay);
                    }
}