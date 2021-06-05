package CodeWars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * https://www.codewars.com/kata/5266876b8f4bf2da9b000362/java
 *
 * Who likes it?
 *
 * You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.
 *
 * Implement a function likes :: [String] -> String, which must take in input array, containing the names of people who like an item. It must return the display text as shown in the examples:
 *
 * likes {} // must be "no one likes this"
 * likes {"Peter"} // must be "Peter likes this"
 * likes {"Jacob", "Alex"} // must be "Jacob and Alex like this"
 * likes {"Max", "John", "Mark"} // must be "Max, John and Mark like this"
 * likes {"Alex", "Jacob", "Mark", "Max"} // must be "Alex, Jacob and 2 others like this"
 */
public class WhoLikesItVarArgs {
   
   public static void main(String[] args) {
      
      //
      /**
       * TestCases to check
       */
//      assertEquals("Peter likes this", Solution.whoLikesIt("Peter"));
//      assertEquals("Jacob and Alex like this", Solution.whoLikesIt("Jacob", "Alex"));
//      assertEquals("Max, John and Mark like this", Solution.whoLikesIt("Max", "John", "Mark"));
//      assertEquals("Alex, Jacob and 2 others like this", Solution.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
      
      whoLikesIt();
//      whoLikesIt("Peter");
//      whoLikesIt("Jacob", "Alex");
//      whoLikesIt("Max", "John", "Mark");
//      whoLikesIt("Alex", "Jacob", "Mark", "Max");
   }
   
   /**
    * GENERATE LIKES Statement from Names
    *
    * @param names names args
    * @return like statement based on names
    */
   public static String whoLikesIt(String... names) {
      
      if (names.length != 0) {
         if (names.length == 1) {
            return names[0] + " likes this";
         } else if (names.length == 2) {
            return names[0] + " and " + names[1] + " like this";
         } else if (names.length == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
         } else {
            return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
         }
      } else {
         return "no one likes this";
      }
      
   }
   
   /**
    * USING Switch case with %s
    *
    * @param names names args
    * @return like statement based on names
    */
   public static String whoLikesIt2(String... names) {
      switch (names.length) {
         case 0:
            return "no one likes this";
         case 1:
            return String.format("%s likes this", names[0]);
         case 2:
            return String.format("%s and %s like this", names[0], names[1]);
         case 3:
            return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
         default:
            return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
      }
   }
   
   /**
    * USING Switch case with Template %s
    *
    * @param names names args
    * @return like statement based on names
    */
   public static String whoLikesIt3(String... names) {
      final String Template1 = "%s likes this";
      final String Template2 = "%s and %s like this";
      final String Template3 = "%s, %s and %s like this";
      final String TemplateN = "%s, %s and %d others like this";
      return
              names.length == 0 ? "no one likes this" :
                      names.length == 1 ? String.format(Template1, names[0]) :
                              names.length == 2 ? String.format(Template2, names[0], names[1]) :
                                      names.length == 3 ? String.format(Template3, names[0], names[1], names[2]) :
                                              String.format(TemplateN, names[0], names[1], names.length - 2);
   }
   
   /**
    * USING HashMap
    *
    * @param names names args
    * @return like statement based on names
    */
   private static Map<Integer, String> choices = new HashMap<>();
   
   static {
      choices.put(0, "no one likes this");
      choices.put(1, "%s likes this");
      choices.put(2, "%s and %s like this");
      choices.put(3, "%s, %s and %s like this");
   }
   
   public static String whoLikesIt4(String... names) {
      int namesCount = names.length;
      return namesCount <= 3 ?
              String.format(choices.get(namesCount), names) :
              String.format("%s, %s and %s others like this", names[0], names[1], namesCount - 2);
   }
   
   /**
    * Single line solution
    *
    * @param names names args
    * @return like statement based on names
    */
   public static String whoLikesIt5(String... names) {
      //Do your magic here
      return names.length == 0 ? "no one likes this" :
              names.length == 1 ? names[0] + " likes this" :
                      names.length == 2 ? names[0] + " and " + names[1] + " like this" :
                              names.length == 3 ? names[0] + ", " + names[1] + " and " + names[2] + " like this" :
                                      names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
      
   }
   
   
   /**
    * USING StringBuilder
    *
    * @param names names args
    * @return like statement based on names
    */
   public static String whoLikesIt6(String... names) {
      //Do your magic here
      
      StringBuilder output = new StringBuilder();
      
      List<String> values = Arrays.asList(names);
      
      if (values.isEmpty()) {
         output.append("no one likes this");
      } else if (values.size() == 1) {
         output.append(values.get(0))
                 .append(" likes this");
      } else if (values.size() == 2) {
         output.append(values.get(0))
                 .append(" and ")
                 .append(values.get(1))
                 .append(" like this");
      } else if (values.size() == 3) {
         output.append(values.get(0))
                 .append(", ")
                 .append(values.get(1))
                 .append(" and ")
                 .append(values.get(2))
                 .append(" like this");
      } else {
         output.append(values.get(0))
                 .append(", ")
                 .append(values.get(1))
                 .append(" and ")
                 .append(values.size() - 2)
                 .append(" others like this");
      }
      
      return output.toString();
   }
   
   /**
    * USING String array
    *
    * @param names names args
    * @return like statement based on names
    */
   public static String whoLikesIt7(String... names) {
      String[] msgFormat = {"no one likes this", "- likes this",
              "- and - like this", "-, - and - like this", "-, - and -- others like this"};
      String msg = msgFormat[Math.min(names.length, 4)];
      for (int i = 0; i < names.length; i++) {
         msg = msg.replaceFirst("-", names[i]);
         msg = msg.replaceFirst("--", "" + (names.length - 2));
      }
      return msg;
   }
   
   /**
    * USING StringBuilder 2
    *
    * @param names names args
    * @return like statement based on names
    */
   public static String whoLikesIt8(String... names) {
      int likeCount = names.length;
      StringBuilder sb = new StringBuilder();
      if (likeCount == 0)
         sb.append("no one");
      else {
         sb.append(names[0]);
         if (likeCount > 1) {
            sb.append(likeCount == 2 ? " and " : ", ").append(names[1]);
            if (likeCount > 2) {
               sb.append(" and ");
               if (likeCount == 3)
                  sb.append(names[2]);
               else
                  sb.append(likeCount - 2).append(" others");
            }
         }
      }
      sb.append(" like");
      if (likeCount < 2)
         sb.append('s');
      sb.append(" this");
      return sb.toString();
   }
   
   /**
    * LOGIC
    *
    * @param names names args
    * @return like statement based on names
    */
   static String whoLikesIt9(String... names) {
      if (names.length < 2) {
         return (names.length > 0 ? names[0] : "no one") + " likes this";
      } else if (names.length == 2) {
         return names[0] + " and " + names[1] + " like this";
      }
      return names[0] + ", " + names[1] + " and " + (names.length > 3 ? names.length - 2 + " others" : names[2]) + " like this";
   }
   
   
}
