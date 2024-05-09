package Top150;

import java.io.*;

public class MinSubArray {

    public static int findMinSubArray(int[] numbers, int target) {   
        //We are taking a sliding window approach with two pointers
        int l = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i=0; i<numbers.length; i++) {
            currentSum += numbers[i];

            while (currentSum >= target) {   //Not gonna make the complexity ON(N^2)

                minLength = Math.min(i+1-l, minLength);
                currentSum -= numbers[l];
                l++;
            }
        }
        
        return minLength<Integer.MAX_VALUE?minLength:0;
    }

    /**
     * 
     * @param 
     * first line comma separated input arrray - 2,3,1,4,3
     * second line target - 7
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArray = reader.readLine().split(",");
        int[]  numbers = new int[inputArray.length];

        int i = 0;
        for (String element : inputArray) {
            numbers[i] = Integer.parseInt(element);
            i++;
        }
        
        int target = Integer.parseInt(reader.readLine());
        int result = findMinSubArray(numbers, target);

        System.out.println(result);
    }
}
