package CodeWars;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/solutions
 *
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric
 * digits that occur more than once in the input string. The input string can be assumed to contain only
 * alphabets (both uppercase and lowercase) and numeric digits.
 *
 * EXAMPLE:
 * "abcde" -> 0 # no characters repeats more than once
 * "aabbcde" -> 2 # 'a' and 'b'
 * "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
 * "indivisibility" -> 1 # 'i' occurs six times
 * "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
 * "aA11" -> 2 # 'a' and '1'
 * "ABBA" -> 2 # 'A' and 'B' each occur twice
 */
public class CountingDuplicates {
   
   public static void main(String[] args) {
   
      System.out.println(duplicateCount("abcde"));
      System.out.println(duplicateCount("abcdea"));
      System.out.println(duplicateCount("indivisibility"));
   
   }
   
   /**
    * Count the number of Duplicates
    * @param text string
    * @return count of letters which are duplicate in word
    */
   private static int duplicateCount(String text) {
   
      final List<String> letters = new ArrayList<>();
      final List<String> duplicates = new ArrayList<>();
   
      for (int n = 0; n < text.length(); n++) {
         final String value = String.valueOf(text.charAt(n)).toLowerCase();
         if (!letters.contains(value)) {
            letters.add(value);
         } else if (!duplicates.contains(value)) {
            duplicates.add(value);
         }
      }
      return duplicates.size();
   
   }
   
   
   /**
    * Count the number of Duplicates
    * @param text string
    * @return count of letters which are duplicate in word
    */
   private static int duplicateCount2(String text) {
   
      if(text == null || text.length() < 2){
         return 0;
      }
      HashSet<Character> letters = new HashSet<Character>();
      HashSet<Character> dupsFound = new HashSet<Character>();
      for(int i = 0; i < text.length(); i++){
         char letter = Character.toLowerCase(text.charAt(i));
         if(letters.contains(letter)){
            dupsFound.add(letter);
         }else{
            letters.add(letter);
         }
      }
      return dupsFound.size();
      
   }
}
