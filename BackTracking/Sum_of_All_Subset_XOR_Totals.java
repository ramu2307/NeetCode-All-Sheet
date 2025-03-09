package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sum_of_All_Subset_XOR_Totals {

    private static void recurXORSubset(int idx, int n, ArrayList<Integer> list, int[] nums, int[] ans) {

        if(idx == n) {
            int xor = 0;
            for(int num : list) {
                xor = xor ^ num;
            }
            ans[0] = ans[0] + xor;

            return;
        }

        list.add(nums[idx]);
        recurXORSubset(idx + 1, n, list, nums, ans);

        list.remove(list.size() - 1);
        recurXORSubset(idx + 1, n, list, nums, ans);
    }

    public static int subsetXORSum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] ans = new int[1];
        recurXORSubset(0, n, list, nums, ans);
        return ans[0];

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int ans = subsetXORSum(nums);
        System.out.println(ans);
        br.close();
    }
}