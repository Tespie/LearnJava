package gfg;

import java.util.*;

/**
 * Given a series whose even term creates a separate geometric series and odd term creates another geometric series.
 *
 *
 * Write a program to generate such series.For example,1, 1, 2, 2, 4, 4, 8, 8, 16, 16,......
 *
 * EXAMPLE:
 * Enter the number of terms: 10
 * Enter the common ratio for GP1: 2
 * Enter the common ratio for GP2: 3
 * The series is:
 * 1 1 2 3 4 9 8 27 16 81
 */
public class OddEvenSeriesWithGap {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Enter the number of terms: ");
      int n = scan.nextInt();
      System.out.print("Enter the common ratio for GP1: ");
      int r1 = scan.nextInt();
      System.out.print("Enter the common ratio for GP2: ");
      int r2 = scan.nextInt();
      System.out.println("The series is: ");
      
      int a = 1, b = 1;
      if (n % 2 == 0) {
         
         for (int i = 0; i < (n / 2); i++) {
            System.out.print(a + " ");
            a = a * r1;
            System.out.print(b + " ");
            b = b * r2;
         }
         
      } else {
         
         for (int i = 0; i < (n / 2); i++) {
            System.out.print(a + " ");
            a = a * r1;
            System.out.print(b + " ");
            b = b * r2;
            System.out.print(a + " ");
         }
         
      }
      
   }
   
}

