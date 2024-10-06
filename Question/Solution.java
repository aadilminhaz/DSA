//Example 2:
 
//Input: nums = [3,2,3,1,2,4,5,5,6], k = 4

//Output: 4
import java.util.*;
import java.util.Collections.*;

public class Solution {

    public static int kthLargest(int[] nums, int k) {
        
        Queue<Integer> queue = new PriotityQueue<>();

        for (int i =0 ; i<nums.length; i++) {
            queue.offer(nums[i]);

            if (queue.size() > k+1) {
                queue.remove();
            }
        }
        return queue.peek(); //kth larget element   
    }

    public static void main(String[] args) {

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(kthLargest(nums, k));

    }
}