package CodeWars;

/**
 * https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/solutions
 *
 * Given the triangle of consecutive odd numbers:
 *
 *              1
 *           3     5
 *        7     9    11
 *    13    15    17    19
 * 21    23    25    27    29
 * ...
 *
 * Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:
 *
 * rowSumOddNumbers(1); // 1
 * rowSumOddNumbers(2); // 3 + 5 = 8
 */
public class SumOfOddNumbers {
   
   public static void main(String[] args){
      
      System.out.println(rowSumOddNumbers(4));
      
   }
   
   /**
    * Mathematically, the sum of the nth line of odd numbers is (n*n*n)
    * @param n row number
    * @return sum of all numbers in that row
    */
   public static int rowSumOddNumbers(int n){
      return n*n*n;
   }
   
   
   /**
    * USING FOR LOOP
    * @param n row number
    * @return sum of all numbers in that row
    */
   public static int rowSumOddNumbers2(int n){
      if(n == 1) return 1;
      int firstValue = n*(n-1)+ 1;
      int sum = 0;
      int lastValue = firstValue + (2*(n-1));
      for(int i =firstValue; i <= lastValue;i+=2){
         sum = sum + i;
      }
      return sum;
   }
   
   /**
    * NOT WORKING
    * @param n
    * @return
    */
   public static int rowSumOddNumbers33(int n) {

//       return (n*n*n);
      //TODO
      if(n == 1) return 1;
      int firstValue = n*(n-1)+ 1;
      int sum = 0;
      int lastValue = firstValue + (2*(n-1));
      for(int i =firstValue; i <= lastValue;){
//       for(int i =firstValue; i <= (firstValue + (2*(n-1))) ;i+=2){
//         int addThis = firstvalue + 2;
//         sum = sum  addThis;
//         sum = i + 2;
         sum = sum + i;
         i = i+ 2;
         /*         i++; */
      }
      int last = sum + firstValue;
      return last;

//       for(int i = 2;i<=n;i++){
//         sum = sum +
//       }
   
   }
}
