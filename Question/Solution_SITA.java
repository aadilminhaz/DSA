import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;


public class Solution {

    //String 
    //String str = "My name is mohammad";


    //-m,a

    public static void main(String[] args) {
        String input = "my name is mohammad";

        System.out.println(getRepeatedAlphabet(input));


    }

    public static String getRepeatedAlphabet(String input) {

        Map<char[], Long> countMap = Stream.of(input.toCharArray()).
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        //<m : 4>
        //<a : 3>

        List<Character> result = countMap.entrySet().stream()
            .filter(e-> e.getValue() > 1)
            .map(e -> e.getKey())
            .collect(Collectors.toList());

        return result;
    }


    
}
