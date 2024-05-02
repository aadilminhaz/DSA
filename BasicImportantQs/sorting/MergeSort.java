package BasicImportantQs.sorting;

import java.util.Scanner;
import java.util.stream.Stream;

public class MergeSort {

    //Sorted parted sections of the array
    void sort(Integer[] number, int l, int m, int r) {

        int n1 = m-l+1;
        int n2 = r-m;

        Integer[] tempArray1 = new Integer[n1];
        Integer[] tempArray2 = new Integer[n2];


        //Create two temp arrays
        for (int i=0; i<n1; i++) {
            tempArray1[i] = number[l+i];
        }
        for (int j=0; j<n2; j++) {
            tempArray2[j] = number[m+1+j];
        }

        //Merge with sequence in original array
        int index1 = 0;
        int  index2 = 0;
        int k = l;
        while(index1 < n1 && index2 < n2) {
            if (tempArray1[index1] > tempArray2[index2]) {
                number[k] = tempArray2[index2];
                index2++;
            } else {
                number[k] = tempArray1[index1];
                index1++;
            }
            k++;
        }

        //take care of the remaining items in either of the temp lists, if any

        while (index1 < n1) {
            number[k] = tempArray1[index1];
            index1++;
            k++;
        }

        while(index2 < n2) {
            number[k] = tempArray2[index2];
            index2++;
            k++;
        }
    }


    public void mergeSort(Integer[] numbers, int l, int r) {

        if (l < r) {
            
            //partition the array
            int mid = l + (r-l) /2;
            
            //sort the first half
            mergeSort(numbers, l, mid);

            //sort the second half
            mergeSort(numbers, mid+1, l);

            //finally merge the both sorted arrays
            sort(numbers, l, mid, r);
        }

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] inputValues = scan.next().split(",");
        
        Integer[] input = new Integer[inputValues.length];
        
        int index = 0;
        for (String element : inputValues) {
            input[index] = Integer.parseInt(element);
            index++;
        }
        Stream.of(input).forEach(System.out::println);

        MergeSort obj1 = new MergeSort();
        obj1.mergeSort(input, 0, input.length-1);

        System.out.println("Sorted : ");
        Stream.of(input).forEach(System.out::println);

    }
}
    

