package Backtracking;

public class MaxInArray {
    
    /*
     * for input arr - 40, 20, 10, 30, output - 40
     * 
     * Expectation - findMax(arr, 0) - 40
     * 
     * Faith - findMax(arr, 1) - 30
     * 
     * Expectation + Faith  -  findMax(arr, 0) = Max (40, findMax(1))
     * 
     */
    public static int findMax(int[] arr, int index) {

        if (index == arr.length) {
            return Integer.MIN_VALUE;
        }

        return Math.max(arr[index], findMax(arr, index+1));

    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 10, 30};

        System.out.println("Max : "+findMax(arr, 0));
    }
}
