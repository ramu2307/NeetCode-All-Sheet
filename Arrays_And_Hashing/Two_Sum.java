package Arrays_And_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Two_Sum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if(map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        int[] ans = twoSum(nums, target);
        System.out.println("["+ans[0]+"," + ans[1] + "]");
        
    }
}
