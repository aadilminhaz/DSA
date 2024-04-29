package Top150;
import java.util.*;

public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2];
        int l = 0;
        int r = numbers.length-1;
        int currentSum = 0;

        /**Validation if input is an empty array */
        if (numbers.length == 0) {
            return result;
        }

        while (l < r) {
            currentSum = numbers[l] + numbers[r];
            if (currentSum == target) {
                result[0] = l;
                result[1] = r;
            }
            if (currentSum < target) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String[] numbersInput = scan.next().split(",");
        int[] numbers = new int[numbersInput.length];
        int i = 0;
        for (String number: numbersInput) {
            numbers[i] = Integer.parseInt(number);
            i++;
        }

        int target = scan.nextInt();
        int[] result = twoSum(numbers, target);

        System.out.println(result[0]+","+result[1]);
    }
}
