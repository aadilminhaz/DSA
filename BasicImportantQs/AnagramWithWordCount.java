import java.util.*;
import java.util.stream.Collectors;

public class AnagramWithWordCount {

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

        /*Length of both the strings must be same to be an Anagram */
        if (s1.length() != s2.length()) {
            return false;
        }

        /**On hackerrank Used int array of 256 to create the word count - char as index logic */
        Map<Character, Integer> wordCountMap = new HashMap<>();

        //Create the wordcount map for first string
        for (Character element : s1.toCharArray()) {
            wordCountMap.merge(element, 1, Integer::sum);
        }

        /*Balance the wordCount as respect to s2
        * - it will match and decrement the count of the character if matches
        */
        for (Character element : s2.toCharArray()) {
            if (wordCountMap.containsKey(element)) {
                wordCountMap.put(element, wordCountMap.get(element)-1);
            }
        }

        for (Character element : wordCountMap.keySet()) {
            if (wordCountMap.get(element) != 0) {
                return false;
            }
        }

        boolean result = wordCountMap.keySet().stream()
                        .allMatch(element -> wordCountMap.get(element) == 0);

        return result;
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