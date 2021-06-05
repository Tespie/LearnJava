package CodeWars;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5390bac347d09b7da40006f6/solutions/java
 *
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
 * Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is
 * known for almost always capitalizing every word. For simplicity, you'll have to capitalize each word, check out
 * how contractions are expected to be in the example below.
 *
 * Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from
 * Jaden Smith, but they are not capitalized in the same way he originally typed them.
 *
 * EXAMPLE:
 * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 *
 * @Test public void test() {
 * assertEquals("toJadenCase doesn't return a valide JadenCase String! try again please :)", "Most Trees Are Blue", jadenCase.toJadenCase("most trees are blue"));
 * }
 * @Test public void testNullArg() {
 * assertNull("Must return null when the arg is null", jadenCase.toJadenCase(null));
 * }
 * @Test public void testEmptyArg() {
 * assertNull("Must return null when the arg is empty string", jadenCase.toJadenCase(""));
 * }
 */
public class JadenCasingStrings {
   
   public static void main(String[] args) {

//      JadenCase jadenCase = new JadenCase();
//
//      @Test
//      public void test() {
//         assertEquals("toJadenCase doesn't return a valide JadenCase String! try again please :)", "Most Trees Are Blue", jadenCase.toJadenCase("most trees are blue"));
//      }
//
//      @Test
//      public void testNullArg() {
//         assertNull("Must return null when the arg is null", jadenCase.toJadenCase(null));
//      }
//
//      @Test
//      public void testEmptyArg() {
//         assertNull("Must return null when the arg is empty string", jadenCase.toJadenCase(""));
//      }
      
      
      System.out.println(toJadenCase("most trees are blue"));
      System.out.println(toJadenCase(null));
      System.out.println(toJadenCase(" "));
   }
   
   /**
    * @param phrase sentence
    * @return String having all word's first letter captialized
    */
   private static String toJadenCase(String phrase) {
      if (phrase == null || phrase == "") return null;
      
      String[] phraseArray = phrase.split(" ");
      StringBuilder sb = new StringBuilder();
      for (String s : phraseArray) {
         String t = s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
         sb.append(t);
      }
      
      return sb.toString().trim();
   }
   
   /**
    * ANOTHER WAY
    *
    * @param phrase sentence
    * @return String having all word's first letter captialized
    */
   private static String toJadenCase2(String phrase) {
      if (phrase == null || phrase == "") return null;
      
      String[] phraseArray = phrase.split(" ");
      StringBuilder sb = new StringBuilder();
      for (String s : phraseArray) {
         String t = s.substring(0, 1).toUpperCase() + s.substring(1);
         sb.append(t).append(" ");
      }
      
      return sb.substring(0, sb.length() - 1);
   }
}


