package CodeWars;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * https://www.codewars.com/kata/52c31f8e6605bcc646000082/solutions/java
 *
 * Write a function that takes an array of numbers (integers for the tests) and a target number. It should find
 * two different items in the array that, when added together, give the target value. The indices of these items
 * should then be returned in a tuple like so: (index1, index2).
 * <p>
 * For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.
 * <p>
 * The input will always be valid (numbers will be an array of length 2 or greater, and all of the items will be numbers; target will always be the sum of two different items from that array).
 * <p>
 * Based on: http://oj.leetcode.com/problems/two-sum/
 * <p>
 * twoSum [1, 2, 3] 4 === (0, 2)
 */
public class TwoSum {
   
   public static void main(String[] args) {

//      @Test
//      public void basicTests()
//      {
//         doTest(new int[]{1,2,3},          new int[]{0,2});
//         doTest(new int[]{1234,5678,9012}, new int[]{1,2});
//         doTest(new int[]{2,2,3},          new int[]{0,1});
//      }
//      private void doTest(int[] numbers, int[] expected)
//      {
//         int target = numbers[expected[0]] + numbers[expected[1]];
//         int[] actual = Solution.twoSum(numbers, target);
//         if ( null == actual )
//         {
//            System.out.format("Received a null\n");
//            assertNotNull(actual);
//         }
//         if ( actual.length != 2 )
//         {
//            System.out.format("Received an array that's not of length 2\n");
//            assertTrue(false);
//         }
//         int received = numbers[actual[0]] + numbers[actual[1]];
//         assertEquals(target, received);
//      }
   
   }
   
   /**
    * LOGICS
    *
    * @param numbers array of numbers
    * @param target  sum
    * @return indexes which values added and make target number
    */
   public static int[] twoSum(int[] numbers, int target) {
      int[] res = new int[2];
      for (int i = 0; i < numbers.length; i++) {
         
         for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] + numbers[j] == target) {
               res[0] = i;
               res[1] = j;
            }
         }
      }
      return res;
   }
   
   public static int[] twoSum2(int[] numbers, int target) {
      for (int i = 0; i < numbers.length; i++) {
         for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] + numbers[j] == target) {
               return new int[]{i, j};
            }
         }
      }
      return null;
   }
   
   public static int[] twoSum3(int[] numbers, int target) {
      Map<Integer, Integer> numToIndexMapping = new HashMap<>(numbers.length);
      for (int i = 0; i < numbers.length; i++) {
         if (numToIndexMapping.containsKey(target - numbers[i])) {
            return new int[]{i, numToIndexMapping.get(target - numbers[i])};
         } else {
            numToIndexMapping.put(numbers[i], i);
         }
      }
      return new int[0];
   }
   
   public static int[] twoSum4(int[] numbers, int target) {
      Arrays.sort(numbers);
      int j = 0;
      for (int i = 0; i < numbers.length; i++) {
         j = Arrays.binarySearch(numbers, i, numbers.length, target - numbers[i]);
         if (j > -1) {
            return new int[]{i, j};
         }
      }
      return null; // Do your magic!
   }
   
   public static int[] twoSum5(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      int complement = 0, j = 0;
      for (int i = 0; i < nums.length; i++) {
         complement = target - nums[i];
         
         if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
         }
         map.put(nums[i], i);
      }
      return new int[]{map.get(complement), j};
   }
   
   public static int[] twoSum6(int[] numbers, int target) {
      ArrayList<Integer> lst = new ArrayList<>();
      for (int i = 0; i < numbers.length; i++) {
         if (lst.contains(numbers[i]))
            return new int[]{lst.indexOf(numbers[i]), i};
         lst.add(target - numbers[i]);
      }
      return null;
   }
   
   public static int[] twoSum7(int[] numbers, int target) {
      int[] result = new int[]{-1, -1};
      
      Arrays.sort(numbers);
      
      int left = 0;
      int right = numbers.length - 1;
      
      while (left < right) {
         if (numbers[left] + numbers[right] == target) {
            result[0] = left;
            result[1] = right;
            return result;
         } else if (numbers[left] + numbers[right] < target) {
            left++;
         } else {
            right--;
         }
      }
      
      return result;
   }
   
   /**
    * USING STREAM AND COLLECTORS
    *
    * @param numbers array of numbers
    * @param target  sum
    * @return indexes which values added and make target number
    */
   public static int[] twoSum8(int[] numbers, int target) {
      // Store each number of the array in a List.
      List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
      
      // Parse the list in order to check every number and look if there is the other number (difference between the first number and the target).
      for (final Integer number : numbersList) {
         if (numbersList.contains(target - number)) {
            return new int[]{numbersList.indexOf(number), numbersList.indexOf(target - number)};
         }
      }
      return null;
   }
   
   
}
