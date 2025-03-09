package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Combination_Sum {

    private static void recurCombination(int i, int sum, int[] nums, int target, List<Integer> list, List<List<Integer>> ans) {

        if(sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(; i < nums.length; i++) {
            if(sum + nums[i] <= target) {
                list.add(nums[i]);
                recurCombination(i, sum + nums[i], nums, target, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        recurCombination(0, 0, nums, target, new ArrayList<>(), ans);
        return ans;
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
        List<List<Integer>> ans = combinationSum(nums, target);
        for(List<Integer> output : ans) {
            System.out.println(output);
        }
    }
}
