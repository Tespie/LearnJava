package CodeWars;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.
 * <p>
 * Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 * <p>
 * Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?
 * <p>
 * Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment. Otherwise return NO.
 * Examples :
 * Line.Tickets(new int[] {25, 25, 50}) // => YES
 * Line.Tickets(new int[] {25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
 * Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)
 */
public class ClerkTicket {

    public static void main(String[] args) {
        Tickets(new int[]{25, 25, 50});
        System.out.println(Tickets(new int[]{25, 25, 50}));
        System.out.println(Tickets(new int[]{25, 100}));
        System.out.println(Tickets(new int[]{25, 25, 50, 50, 100}));
    }

    /**
     * @param peopleInLine array of people's bill amount (25,50,100)
     * @return String ? YES : NO
     */
    public static String Tickets(int[] peopleInLine) {

        int change = 0;
        int sum = 0;
        int count25 = 0;
        int count50 = 0;
        int count100 = 0;
        boolean flag = true;
        for (int b : peopleInLine) {

            if (b != 25) { // paid 50 0r 100
                change = b - 25;
                if (sum < change) {
                    flag = false;
                    break;
                }

                if (change == 25) { // paid 50
                    if (count25 > 0) {
                        count25--;
                        count50++;
                    } else {
                        flag = false;
                        break;
                    }
                } else { // paid 75
                    if (count50 > 0) {
                        count50--;
                        if (count25 > 0) {
                            count25--;
                            count100++;
                        } else {
                            flag = false;
                            break;
                        }
                    } else if (count25 > 2) {
                        count25 -= 3;
                        count100++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                sum = sum + b - change;
            } else {    // paid 25
                sum = sum + b;
                count25++;
            }

        }
        return flag ? "YES" : "NO";
    }
}
