package BasicImportantQs.Anagrams;

import java.io.*;

public class AnagramUsingAsciiMap {

    public AnagramUsingAsciiMap(){}

    public static boolean isAnagram(String s1, String s2) {
        
        /**Basic null check and black check with isBlank in java 11 */
        if (s1.isBlank() && s2.isBlank()) {
            return false;
        }

        /**Length of both string must be same */
        if (s1.length() != s2.length()) {
            return false;
        }

        /**Creating a countMap, that will store, occurence on the index of asci of the character */
        /**Really helpful technique, in countMap creating based on asci as index and value as count without using hasmaps */
        int[] countMap = new int[256];    //256 to support 256 characters

        /**Populate the map with elements/char count of s1 */
        for (char element : s1.toCharArray()) {
            countMap[element] = countMap[element] + 1;
        }

        /**Decremenet the count if the char matches from s2 */
        for (char element : s2.toCharArray()) {
            countMap[element] = countMap[element] -1;
        }

        /**At last all the values in the countMap must be zero to balance ANAGRAM properties */
        for (int value : countMap) {
            if (value != 0){
                return false;
            }
        }

        
        return true;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String s1 = input.readLine();
        String s2 = input.readLine();

        boolean result = isAnagram(s1, s2);
        System.out.println("Aanagram : "+result );
        
    }
    
}
