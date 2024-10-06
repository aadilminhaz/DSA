package BasicImportantQs.sorting;

import java.util.*;
import java.util.stream.Stream;

public class MergeSort {

    //Break down into individual two elements
    public static void mergeSort(Integer[] input, int l, int h) {
        if (l <  h) {

            int mid = (l+h)/2;

            mergeSort(input, l, mid);
            mergeSort(input, mid+1, h);

            sort(input, l, mid, h);

        }
    }

    //Sort and merge two parts
    public static void sort(Integer[] input, int l, int m, int h) {

      
        int[] temp = new int[input.length]; // to save the original content
        int k = l;

        int index1 = l;
        int index2 = m+1;

        while (index1 <=m && index2 <=h) {
            if (input[index1] < input[index2]) {
                temp[k] = input[index1];
                index1++;          
            } else {
                temp[k] = input[index2];
                index2++;
            }
            k++;
        }

        if (index1 > m) {
            while(index2 <=h) {
                temp[k] = input[index2];
                index2++;
                k++;
            }
        } else {
            while(index1 <=m) {
                temp[k] = input[index1];
                index1++;
                k++;
            }
        
        }
        
        //Now replace input content with temp - already sorted
        for(int i=l; i<k; i++) {
            input[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] scannerInput = scan.next().split(",");
        scan.close();

        Integer[] input = new Integer[scannerInput.length];

        for (int i=0; i<scannerInput.length; i++) {
            input[i] = Integer.parseInt(scannerInput[i]);
        }

       // Stream.of(input).forEach(System.out::println);
        mergeSort(input, 0, input.length-1);
        System.out.println("sorted");
        Stream.of(input).forEach(System.out::println);

    }
    
    
}
