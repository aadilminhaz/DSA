package Backtracking;

public class DisplayArrayInReverse {

    /*
     * For input arr - 10, 20, 30, 40, output - 40, 30, 20, 10
     * 
     * Expectation - displayRev(arr, 0)  = P 40, P 30, P 20, P 10    P - PRINT
     * Faith - displayRev(arr, 1) = P 40, P 30, P 20
     * 
     * Expectation + Faith - displayRev(arr, 0) = INVOKE displayRev(arr, 1), P 10 
     * 
     */
    public static void displayRev(int[] arr, int index) {

        if (index == arr.length) {
            return;
        }

        //INVOKE
        displayRev(arr, index+1);

        //PRINT
        System.out.print(arr[index]+" ");

    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        displayRev(arr, 0);

    }
    
}
