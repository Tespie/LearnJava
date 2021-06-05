package gfg;
//import java.util.Arrays;

import java.util.*;

/**
 * One programming language has the following keywords that cannot be used as identifiers -
 * break, case, continue, default, defer else, for, func, goto, if, return, struct, type.
 * Now write a program to check if the given word is a keyword or not.
 */
class IdentifierKeyword {
   
   public static void main(String[] args) {
      
      System.out.print("Enter word : ");
      Scanner scan = new Scanner(System.in);
      String word = scan.nextLine();
      
      String[] allkeys = {
              "break", "case", "continue", "default", "defer", "else", "for", "func", "goto", "if", "return", "struct", "type"
      };
      
      int res = Arrays.binarySearch(allkeys, word);
      
      if (res > 0) {
         System.out.print("Its RESERVED KEYWORD");
      } else {
         System.out.print("Its all yours");
      }
      
   }
}

