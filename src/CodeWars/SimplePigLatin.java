package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isAlphabetic;

/**
 * https://www.codewars.com/kata/520b9d2ad5c005041100000f/solutions/java
 * <p>
 * Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
 * <p>
 * Examples
 * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 * pigIt('Hello world !');     // elloHay orldway !
 */
public class SimplePigLatin {
   public static void main(String[] args) {
      
      pigIt("Pig latin is cool");   // returns "igPay atinlay siay oolcay"
      pigIt("This is my string");   // returns "hisTay siay ymay tringsay"
      pigIt("Hello world !");       // returns "elloHay orldway !"
      
   }
   
   /**
    * @param str String
    * @return expected result string
    */
   public static String pigIt(String str) {
      // Write code here
      
      String sarry[] = str.split(" ");
      
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < sarry.length; i++) {
         if (!sarry[i].equals("!") && !sarry[i].equals("?")) {
            if (i != (sarry.length - 1)) {
               sb.append(sarry[i].substring(1)).append(sarry[i].charAt(0)).append("ay").append(" ");
            } else {
               sb.append(sarry[i].substring(1)).append(sarry[i].charAt(0)).append("ay");
            }
            
         } else {
            sb.append(sarry[i]);
         }
      }
      return sb.toString();
   }
   
   /**
    * USING REGEX
    *
    * @param str string
    * @return result string
    */
   public static String pigIt2(String str) {
      return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
   }
   
   public static String pigIt3(String str) {
      return str != null ? str.replaceAll("(\\w{1})(\\w*)", "$2$1ay") : null;
   }

//   private static final Pattern regex = Pattern.compile("(\\w)(\\w*)");
   
   public static String pigIt4(String str) {
      Pattern regex = Pattern.compile("(\\w)(\\w*)");
      return regex.matcher(str).replaceAll("$2$1ay");
   }
   
   public static String pigIt5(String str) {
      str = str.replaceAll("([a-zA-Z])([a-zA-Z]*)", "$2$1ay");
      return str;
   }
   
   /**
    * USING REGEX + LAMBDAS
    *
    * @param str string
    * @return result string
    */
   public static String pigIt6(String str) {
      return Arrays.stream(str.trim().split(" "))
              .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
              .collect(Collectors.joining(" "));
   }
   
   public static String pigIt7(String str) {
      return Arrays.stream(str.split(" "))
              .map(x -> x.matches("[\\?\\!]") ? x : x.substring(1) + x.substring(0, 1) + "ay")
              .collect(Collectors.joining(" "));
   }
   
   public static String pigIt8(String str) {
      String[] words = str.split("\\s+");
      String out = "";
      
      for (String word : words)
         out += (word.matches("[!?.,;:]+")) ? (" " + word) : (" " + word.substring(1) + word.charAt(0) + "ay");
      return out.substring(1);
   }
   
   
   public static String pigIt9(String str) {
      return Stream.of(str.split(" "))
              .map(word -> word.matches("^[a-zA-Z]+$")
                      ? (new StringBuilder(word)).append(word.charAt(0)).deleteCharAt(0).append("ay").toString()
                      : word)
              .collect(Collectors.joining(" "));
   }
   
   /**
    * DIFFERENT LOGICS
    *
    * @param str string
    * @return result string
    */
   
   public static String pigIt10(String str) {
      String puncuation = "!?,.";
      List<String> words = new ArrayList<String>(Arrays.asList(str.split(" ")));
      List<String> pigLatinWords = new ArrayList<String>();
      
      for (String word : words) {
         String newWord = !puncuation.contains(word) ? word.substring(1) + word.charAt(0) + "ay" : word;
         pigLatinWords.add(newWord);
      }
      
      return String.join(" ", pigLatinWords);
   }
   
   public static String pigIt11(String str) {
      StringBuilder result = new StringBuilder();
      
      for (String s : str.split(" ")) {
         char firstLetter = s.charAt(0);
         
         result.append(s, 1, s.length())
                 .append(firstLetter)
                 .append(isAlphabetic(firstLetter) ? "ay" : "")
                 .append(" ");
      }
      
      return result.substring(0, result.length() - 1);
   }
   
   
}
