package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 Return the number (count) of vowels in the given string.
 
 We will consider a, e, i, o, u as vowels for this Kata (but not y).
 
 The input string will only consist of lower case letters and/or spaces.
 */
public class VowelCount {
   
   public static void main(String[] args) {
   
//      System.out.println(getCount("abracadabra"));
      System.out.println(getCount2("apple and sons"));
//      getCount2("apple");
   
   }
   
   /**
    * COUNT NUMBER OF VOWELS IN STRING
    * @param str string
    * @return count of vowels in string
    */
   private static int getCount(String str) {
      int vowelsCount = 0;
   
      for(int i = 0;i<str.length();i++){
         if(isVowel(str.charAt(i))){
            vowelsCount++;
         }
      }
      return vowelsCount;
   
   }
   
   /**
    * CHECK CHARACTER IS VOWEL OR NOT
    * @param ch character
    * @return true/false that character is vowel or not
    */
   private static boolean isVowel(char ch) {
      ch = Character.toUpperCase(ch);
      return (ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' );
   }
   
   /**
    * COUNT NUMBER OF VOWELS IN STRING using REGEX
    * @param str string
    * @return count of vowels in string
    */
   private static int getCount2(String str) {
      String mypattern = "(?i)[aeiou]";
      Pattern p = Pattern.compile(mypattern);
      Matcher m = p.matcher(str);
      int count = 0;
      while(m.find()){
         count++;
      }
      return count;
      
   }
   
   /**
    * COUNT NUMBER OF VOWELS IN STRING using REGEX
    * @param str string
    * @return count of vowels in string
    */
   public static int getCount3(String str) {
      return str.replaceAll("(?i)[^aeiou]", "").length();
   }
   
   
   /**
    * COUNT NUMBER OF VOWELS IN STRING using ARRAYS
    * @param str string
    * @return count of vowels in string
    */
   private static List<Character> vowels;
   static {
      vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
   }
   public static int getCount4(String str) {
      int vowelsCount = 0;
      for(int i = 0; i < str.length(); i++) {
         if (vowels.contains(str.charAt(i))) {
            vowelsCount++;
         }
      }
      return vowelsCount;
   }
   
   
   
   
   
}
