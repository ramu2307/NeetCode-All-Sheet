package LinkedList;

import java.util.Arrays;
import java.util.HashSet;

public class Find_the_Duplicate_Number {

    // // TC : O(n * log(n))
    // // SC : O(1)
    // class Solution {
    //     public int findDuplicate(int[] nums) {
    //         Arrays.sort(nums);
    //         for(int i = 0; i < nums.length - 1; i++) {
    //             if(nums[i] == nums[i + 1]) {
    //                 return nums[i];
    //             }
    //         }
    //         return -1;
    //     }
    // }

    // // <---------------------------------------------->

    // // TC : o(n)
    // // TC : O(n) -> HashSet
    // class Solution {
    //     public int findDuplicate(int[] nums) {
    //         HashSet<Integer> set = new HashSet<>();
    //         for(int i = 0; i < nums.length; i++) {
    //             if(set.contains(nums[i])) {
    //                 return nums[i];
    //             }
    //             set.add(nums[i]);
    //         }
    //         return -1;
    //     }
    // }

    // // <------------------------------------------------>

    // // TC : O(n)
    // // SC : O(n) -> Extra Integer Freq Array
    // class Solution {
    //     public int findDuplicate(int[] nums) {
    //         int[] freq = new int[nums.length];
    //         for(int i = 0; i < nums.length; i++) {
    //             if(freq[nums[i]] == 1) {
    //                 return nums[i];
    //             }
    //             freq[nums[i]]++;
    //         }
    //         return -1;
    //     }
    // }

    // // <--------------------------------------------------->

    // TC : O(n)
    // SC : O(n) -> Boolean Array
    class Solution {
        public int findDuplicate(int[] nums) {
            int n = nums.length;
            boolean[] ans = new boolean[n];
            for(int i : nums) {
                if(ans[i]) {
                    return i;
                }
                ans[i] = true;
            }
            return -1;
        }
    }
    

}