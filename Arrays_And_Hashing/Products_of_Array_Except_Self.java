package Arrays_And_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Products_of_Array_Except_Self {


    // // TC : O(n * n)
    // // SC : O(1)
    // public static int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int[] res = new int[n];

    //     for(int i = 0; i < n; i++) {
    //         int prod = 1;
    //         for(int j = 0; j < n; j++) {
    //             if(i != j) {
    //                 prod *= nums[j];
    //             }
    //         }
    //         res[i] = prod;
    //     }

    //     return res;
    // }
    
    //----------------------------------------------------------

    // //TC : O(n)
    // //SC : O(n)
    // public static int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int[] res = new int[n];

    //     int[] left = new int[n];
    //     int[] right = new int[n];

    //     left[0] = 1;
    //     right[n - 1] = 1;

    //     for(int i = 1; i < n; i++) {
    //         left[i] = left[i - 1] * nums[i - 1];
    //     }

    //     for(int i = n - 2; i >= 0; i--) {
    //         right[i] = right[i + 1] * nums[i + 1];
    //     }

    //     for(int i = 0; i < n; i++) {
    //         res[i] = left[i] * right[i];
    //     }

    //     return res;
    // }

    //-------------------------------------------------------

    // //TC : O(n)
    // //SC : O(1)
    // public static int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int[] res = new int[n];

    //     int prod = 1;
    //     int zeroCnt = 0;
    //     for(int i = 0; i < n; i++) {
    //         if(nums[i] != 0) {
    //             prod *= nums[i];
    //         }
    //         else {
    //             zeroCnt++;
    //         }
    //     }

    //     if(zeroCnt > 1) {
    //         return new int[n];
    //     }

    //     for(int i = 0; i < n; i++) {
    //         if(zeroCnt > 0) {
    //             res[i] = (nums[i] == 0) ? prod : 0;
    //         }
    //         else {
    //             res[i] = prod / nums[i];
    //         }
    //     }
    //     return res;
    // }

    //------------------------------------------------

    //TC : O(n)
    //SC : O(1)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for(int i = n - 1; i >= 0; i--) {

            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = productExceptSelf(nums);
        for(int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
        
    }
}
