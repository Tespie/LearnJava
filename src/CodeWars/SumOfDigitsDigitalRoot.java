package CodeWars;

/**
 * https://www.codewars.com/kata/541c8630095125aba6000c00/train/java
 * <p>
 * Digital root is the recursive sum of all the digits in a number.
 * <p>
 * Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way
 * until a single-digit number is produced. The input will be a non-negative integer.
 * <p>
 * EXAMPLES:
 * 16  -->  1 + 6 = 7
 * 942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 */
public class SumOfDigitsDigitalRoot {
   
   public static void main(String[] args) {
      
      int print = digital_root2(4588767);
      System.out.println(print);
      System.out.println(digital_root(456));
      System.out.println(digital_root(132189));
      System.out.println(digital_root(493193));
      
   }
   
   /**
    * USING 2 CONDITIONS
    *
    * @param n number
    * @return sum of digits of number till 1 digit
    */
   public static int digital_root(int n) {
      
      int sum = 0;
      while (n > 0) {
         sum = sum + (n % 10);   // sum+=(n%10);
         n = n / 10;
      }
      
      if (sum > 9) {
         return digital_root(sum);
      } else {
         return sum;
      }
   }
   
   /**
    * USING MODULO
    *
    * @param n number
    * @return sum of digits of number till 1 digit
    */
   public static int digital_root2(int n) {
      return (n != 0 && n % 9 == 0) ? 9 : n % 9;
   }
   
   /**
    * USING MODULO
    *
    * @param n number
    * @return sum of digits of number till 1 digit
    */
   public static int digital_root3(int n) {
      return n < 10 ? n : digital_root(digital_root(n / 10) + n % 10);
   }
   
   /**
    * SABSE ALAG
    *
    * @param n number
    * @return sum of digits of number till 1 digit
    */
   public static int digital_root4(int n) {
      return (1 + (n - 1) % 9);
   }
   
}
