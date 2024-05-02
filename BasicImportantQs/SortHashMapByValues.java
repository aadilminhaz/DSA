package BasicImportantQs;

import java.util.*;
import java.util.stream.Collectors;


public class SortHashMapByValues {

    public static void sortHashMap(Map<String, Integer> inputMap) {

        Map<String, Integer> sortedResult = inputMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(e -> e.getKey(), e->e.getValue(), (e1, e2)->e1,LinkedHashMap::new));

        System.out.println(sortedResult);

    }

    public static void main(String[] args) {
        
        Map<String, Integer> inputMap = new HashMap<>();

        inputMap.put("a", 1);
        inputMap.put("w", 9);
        inputMap.put("c", 7);
        inputMap.put("d", 5);
        inputMap.put("b", 4);
        inputMap.put("n", 1);

        sortHashMap(inputMap);
    }
    
}

