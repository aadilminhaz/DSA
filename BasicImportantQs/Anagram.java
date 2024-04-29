import java.util.*;

public class Anagram {

    private static final Scanner scan = new Scanner(System.in);


     /**
     * 
     * @param s1 - AAB
     * @param s2 -  BBA
     * @return - true - if s1 and s2 are of same lenght and consists of same number of characters
     */
    public static boolean isAnagram(String s1, String s2) {

        if(s1.isBlank() || s2.isBlank()) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        /**Convert into char arrays and 
        *Sort the input string after general validation
        */
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch2);
        Arrays.sort(ch2);
        System.out.println(ch1);
        System.out.println(ch2);

        if (!Arrays.equals(ch1, ch2)) {
            return false;
        }

        return true;
    }



    public static void main(String[] args) {

        System.out.println("Enter String one : ");
        String s1 = scan.nextLine();

        System.out.println("Enter String two : ");
        String s2 = scan.nextLine();

        scan.close();
        
        boolean result = isAnagram(s1, s2);
        System.out.println("isAnagram : "+result);

    }
}