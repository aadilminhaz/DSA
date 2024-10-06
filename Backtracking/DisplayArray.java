package Backtracking;

public class DisplayArray {

    /* for input array - 10, 20, 30, 40
    *
        Expectation - display(arr, 0) = print P 10, P 20, P 30, P 40   P- print
        Faith - display(arr, 1) = print P 20, P 30, P 40
     *  Expection + Faith =     dispaly(arr, 0) = P 10, Invoke display(arr, 1) 
     */
    public static void displayArr(int[] arr, int index) {

        if (index == arr.length) {
            return;
        }

        //print
        System.out.println(arr[index]);

        //Invoke
        displayArr(arr, index+1);
        

    }
    
    public static void main(String[] args) {
        
        int[] arr = {10, 20, 30, 40, 50};
        displayArr(arr, 0);

    }
}
