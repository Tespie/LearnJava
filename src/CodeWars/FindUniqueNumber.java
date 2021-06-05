package CodeWars;

import java.util.Arrays;
import java.util.Map;
import java.util.PrimitiveIterator;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Find the unique number
 * <p>
 * <p>
 * <p>
 * There is an array with some numbers. All numbers are equal except for one. Try to find it!
 * <p>
 * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
 * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
 * It’s guaranteed that array contains at least 3 numbers.
 */
public class FindUniqueNumber {
   
   public static void main(String[] args) {
      
      // Possible test cases:
      findUniq(new double[]{0, 1, 0});
      findUniq(new double[]{3, 3, 5});
      findUniq(new double[]{4, 8, 8});
      findUniq(new double[]{1, 1, 1, 2, 1, 1});
      findUniq(new double[]{8, 8, 8, 8, 8, 8, 8, 7});
      findUniq(new double[]{8, 8, 8, 8, 8, 8, 7, 8});
      
   }
   
   
   /**
    * @param arr input array
    * @return unique value
    */
   public static double findUniq(double arr[]) {
      double unique = 0;
      for (int i = 0; i < arr.length; i++) {
         
         if (arr[arr.length - 3] == arr[arr.length - 2] &&
                 arr[arr.length - 2] != arr[arr.length - 1]) {
            unique = arr[arr.length - 1];
            break;
         }
         
         if (arr[i] != arr[i + 1]) {
            
            if (arr[i] == arr[i + 2]) {
               unique = arr[i + 1];
               break;
            } else {
               unique = arr[i];
               break;
            }
         }
      }
      return unique;
   }
   
   /**
    * FOR ANY SIZE ARRAY
    *
    * @param arr input array
    * @return unique value
    */
   public static double findUniq2(double arr[]) {
      double unique = 0;
      for (int i = 0; i < arr.length; i++) {
         if (arr.length > 2) {
            
            if (arr[arr.length - 3] == arr[arr.length - 2] &&
                    arr[arr.length - 2] != arr[arr.length - 1]) {
               unique = arr[arr.length - 1];
               break;
            }
            
            if (arr[i] != arr[i + 1]) {
               
               if (arr[i] == arr[i + 2]) {
                  unique = arr[i + 1];
                  break;
               } else {
                  unique = arr[i];
                  break;
               }
            } else {
               System.out.println("Else");
            }
            
         } else {
            System.out.println("Invalid Input");
         }
      }
      return unique;
   }
   
   /**
    * USING INBUILT ARRAYS SORT FUNCTION
    *
    * @param arr input array
    * @return unique value
    */
   public static double findUniq3(double[] arr) {
      Arrays.sort(arr);
      return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
   }
   
   /**
    * USING INBUILT ARRAYS SORT FUNCTION
    *
    * @param arr input array
    * @return unique value
    */
   public static double findUniq4(double arr[]) {
      Arrays.sort(arr);
      return arr[0] != arr[1] ? arr[0] : arr[arr.length - 1];
   }
   
   /**
    * USING COLLECTION CLASSES
    *
    * @param arr input array
    * @return unique value
    */
   static double findUniq5(final double[] arr) {
      return Arrays.stream(arr).boxed()
              .collect(groupingBy(identity(), counting()))
              .entrySet().stream()
              .filter(e -> e.getValue() == 1)
              .findFirst()
              .map(Map.Entry::getKey)
              .orElse(0.0);
   }
   
   /**
    * USING INBUILT ARRAYS SORT FUNCTION
    *
    * @param arr input array
    * @return unique value
    */
   public static double findUniq6(double arr[]) {
      double a = Arrays.stream(arr)
              .sorted()
              .skip(1)
              .findFirst()
              .getAsDouble();
      return Arrays.stream(arr)
              .filter(x -> x != a)
              .findFirst()
              .getAsDouble();
   }
   
   
   /**
    * USING WHILE LOOP
    *
    * @param arr input array
    * @return unique value
    */
   public static double findUniq7(double arr[]) {
      PrimitiveIterator.OfDouble it = Arrays.stream(arr).iterator();
      double prev = it.nextDouble();
      while (it.hasNext()) {
         double current = it.nextDouble();
         if (prev != current) {
            return it.hasNext() && it.nextDouble() != prev ? prev : current;
         }
         prev = current;
      }
      
      return prev;
   }
   
   /**
    * USING WHILE LOOP with CONDITION
    * @param arr input array
    * @return unique value
    */
   public static double findUniq8(double arr[]) {
      final double common = arr[0]==arr[1] || arr[0]==arr[2] ? arr[0] : arr[1];
      int i = 0;
      while (arr[i] == common) i++;
      return arr[i];
   }
   
   
   
   
}
