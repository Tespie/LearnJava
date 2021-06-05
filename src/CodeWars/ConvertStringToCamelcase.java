package CodeWars;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConvertStringToCamelcase {
   
   public static void main(String[] args) {
      
      toCamelCase("the-Stealth-Warrior");    // returns "theStealthWarrior"
      toCamelCase("The_Stealth_Warrior");    // returns "TheStealthWarrior"
      
   }
   
   /**
    * USING STRING BUILDER
    *
    * @param s string to convert
    * @return camel cased string
    */
   static String toCamelCase(String s) {
      String[] array;
      if (s.indexOf('_') == -1) {
         array = s.split("-");
      } else {
         array = s.split("_");
      }
      
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < array.length; i++) {
         if (i == 0) {
            sb.append(array[0]);
            continue;
         }
         
         String mystring = array[i].substring(0, 1).toUpperCase() + array[i].substring(1);
         sb.append(mystring);
      }
      return sb.toString();
   }
   
   /**
    * Code to convert each word to camelCase;
    *
    *      for(String str : array){
    *        String  mystring = str.substring(0,1).toUpperCase() + str.substring(1);
    *        sb.append(mystring);
    *      }
    */
   
   /**
    * USING REGEX
    *
    * @param s string to convert
    * @return camel cased string
    */
//   static String toCamelCase2(String s){
//      return Pattern.compile("[-|_](.)").matcher(s).replaceAll(r -> r.group(1).toUpperCase());
//   }
   
   
   private static Pattern pattern = Pattern.compile("(?i)(?<=\\w)([_-])+(\\w)([a-z]*)");
   static String toCamelCase3(String s){
      StringBuffer result = new StringBuffer();
      Matcher matcher = pattern.matcher(s);
      while (matcher.find()) {
         matcher.appendReplacement(result, matcher.group(2).toUpperCase() + matcher.group(3));
      }
      return result.toString();
   }

   static String toCamelCase4(String s){
      Matcher m = Pattern.compile("[_|-](\\w)").matcher(s);
      StringBuffer sb = new StringBuffer();
      while (m.find()) {
         m.appendReplacement(sb, m.group(1).toUpperCase());
      }
      return m.appendTail(sb).toString();
   }
   
   /**
    * USING LAMBDA + REGEX
    *
    * @param str string to convert
    * @return camel cased string
    */
   static String toCamelCase5(String str){
      String[] words = str.split("[-_]");
      return Arrays.stream(words, 1, words.length)
              .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
              .reduce(words[0], String::concat);
   }
   
   static String toCamelCase6(String s){
      String[] stringArray = s.split("[-|_]");
      
      return stringArray[0] + Arrays.stream(stringArray).skip(1).map(i -> i.substring(0,1).toUpperCase()+i.substring(1))
              .collect(Collectors.joining());
   }
   
   static String toCamelCase7(String s){
      String[] words = s.split("[-_]+");
      return Arrays.stream(words)
              .skip(1)
              .map(w -> w.substring(0, 1).toUpperCase().concat(w.substring(1)))
              .reduce(words[0], String::concat);
   }
   
   static String toCamelCase8(String s){
      String[] words = s.split("[_\\-]");
      s=words[0];
      for(int i=1; i<words.length; i++)
         s+=words[i].substring(0,1).toUpperCase()+words[i].substring(1).toLowerCase();
      return s;
   }
   
   static String toCamelCase9(String s) {
      if(s.isEmpty())
         return s;
      String ws[] = s.split("[-_]");
      return ws[0] + Arrays.stream(ws)
              .skip(1)
              .map(wd -> Character.toUpperCase(wd.charAt(0)) + wd.substring(1))
              .collect(Collectors.joining(""));
   }
   
   static String toCamelCase10(String s){
      String a[] = s.split("(-|_)");
      String b = a[0];
      for(int i = 1; i<a.length; i++){
         b+=Character.toUpperCase(a[i].charAt(0)) + a[i].substring(1);
      }
      return b;
   }

   
   static String toCamelCase11(String s){
      StringBuilder result = new StringBuilder();
      boolean capitalize = false;
      
      for(char c : s.toCharArray()){
         if(c == '-' || c == '_'){
            capitalize = true;
         }else{
            if(capitalize){
               c = Character.toUpperCase(c);
               capitalize = false;
            }
            
            result.append(c);
         }
      }
      
      return result.toString();
   }
   
   
}
