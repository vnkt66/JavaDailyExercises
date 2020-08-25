// This is the Hello program in Java

// args are passed via command line if args are empty length is 0 and if we try to loop and access it will throw ArrayIndexOutOfBoundsException
// loop goes like this if empty 0 <= 0 so it should be like 0 < 0

class HelloArgs {
      public static void main (String args[ ]) {    
                    int i;    
                    System.out.print("Hello ");       // Say Hello
               i = 0;                               // Initialize loop counter
                       while (i <= args.length) {    // Test and Loop
                    System.out.print(args[i] + " ");  
                     i = i + 1;                     // Increment Loop Counter
                     }
                        System.out.println();             // Finish the line
         }
}
