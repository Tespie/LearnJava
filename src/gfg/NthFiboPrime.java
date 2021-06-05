package gfg;

import java.util.Scanner;

/**
 * Consider the below series:
 * 1, 2, 1, 3, 2, 5, 3, 7, 5, 11, 8, 13, 13, 17, ...
 *
 * This series is a mixture of 2 series - all the odd terms in this series form a Fibonacci series and all the
 * even terms are the prime numbers in ascending order.
 *
 * Write a program to find the Nth term in this series.
 *
 * The value N is a Positive integer that should be read from STDIN. The Nth term that is calculated by the
 * program should be written to STDOUT. Other than the value of Nth term, no other characters/strings or
 * message should be written to STDOUT.
 *
 * For example, when N = 14, the 14th term in the series is 17. So only the value 17 should be printed to STDOUT.
 */
public class NthFiboPrime {
   
   public static void main(String[] args) {
      
      Scanner scan = new Scanner(System.in);
      int ip = scan.nextInt();
      if (ip % 2 == 1) {   // odd
         fibo((ip / 2) + 1);
      } else { // even
         prime(ip / 2);
      }
      
   }
   
   static void prime(int n) {
      int count = 0;
      boolean found;
      for (int i = 2; i <= 1000; i++) {
         System.out.println("n = " + n);
         found = false;
         for (int j = 2; j < i; j++) {
            if (i % j == 0) {
               found = true;
               break;
            }
         }
         if (found == false) {
            if (++count == n) {
               System.out.println(i);
               break;
            }
         }
      }
      
   }
   
   static void fibo(int n) {
      int t1 = 0;
      int t2 = 1;
      int next;
      for (int i = 1; i <= n; i++) {
         next = t1 + t2;
         t1 = t2;
         t2 = next;
         // System.out.print(t1+" "); // to print all fibonaci terms
      }
      System.out.println(t1); // to only print the nth term
   }
   
   // Too much time for execution
   static void prime2(int n) {
      int count = 0;
      int num = 1;
      int i;
      while (count < n) {
         num = num + 1;
         for (i = 2; i <= num; i++) {
            if (n % i == 0) {
               break;
            }
         }
         if (num == i) {
            count = count + 1;
         }
         
      }
      System.out.println(num);
   }
   
   
}
