package CodeWars;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://www.codewars.com/kata/55c45be3b2079eccff00010f/solutions/java
 * Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * <p>
 * If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
 */
public class YourOrderPlease {

    public static void main(String[] args) {


//        String words = "is2 Thi1s T4est 3a";
//        String wordsResult = "Thi1s is2 3a T4est";

//        @Test
//        public void test1() {
//            assertThat(Order.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
//        }
//
//        @Test
//        public void test2() {
//            assertThat(Order.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
//        }
//
//        @Test
//        public void test3() {
//            assertThat("Empty input should return empty string", Order.order(""), equalTo(""));
//        }

        order("Empty input should return empty string");
        System.out.println(order4("is2 Thi1s T4est 3a"));
        order("4of Fo1r pe6ople g3ood th5e the2");

    }



    /**
     * using while and forEach
     * @param words
     * @return
     */
    public static String order(String words) {

        String[] array = words.split(" ");
        StringBuilder str = new StringBuilder();
        int c = 1;

        if (words.equals("")) return "";
        while (c <= array.length) {
            for (String s : array)
                if (s.contains(String.valueOf(c))) {
                    str.append(s).append(" ");
                    
                    c++;
                }
        }
        return str.toString().trim();
    }

    /**
     * simplified with for each
     *
     * @param words sentence made of strings
     * @return sorted string
     */
    public static String order2(String words) {

        String[] array = words.split(" ");
        StringBuilder str = new StringBuilder();
        int c = 1;

        if (words.equals("")) return "";

        while (c <= array.length) {
            for (int i = 0; i < array.length; i++)
                if (array[i].contains(String.valueOf(c))) {
                    if (array[i] != null)
                        str.append(array[i]).append(" ");
                    else {
                        str.append("");
                    }
                    c++;
                }
        }
        return str.toString().trim();
//7972500 - router change request
    }

    /**
     * vishwa did this
     *
     * @param words sentence
     * @return sorted string
     */
    public static String order3(String words) {

        String[] strArray = words.split(" ");
        int c = 1;
        String finalStr = "";
        String[] s = new String[strArray.length];

        if (words.equals("")) return "";
        while (c <= strArray.length) {
            for (int i = 0; i < strArray.length; i++)
                if (strArray[i].contains(String.valueOf(c))) {
                    s[c - 1] = strArray[i];
                    c++;
                }
        }
        finalStr = String.join(" ", s);
        return finalStr;
    }

    /**
     * Using inbuilt Arrays.sort
     *
     * @param words sentence
     * @return sorted string
     */
    private static String order4(String words) {

        String[] wordsArray = words.split(" ");
//        Arrays.sort(wordsArray, (String s1,String s2)-> s1.replaceAll("[a-zA-Z]","").compareTo(s2.replaceAll("[a-zA-Z]","")));
        Arrays.sort(wordsArray, Comparator.comparing((String s) -> s.replaceAll("[a-zA-Z]", "")));
        String result = "";
        for (String s : wordsArray){
            result = result+s+" ";
        }
        return result.substring(0,result.length()-1);

    }


}


