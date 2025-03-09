package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Combination_Sum_II {

    
    private static void recurCombinationSumII(int idx, int sum, List<Integer> list, int[] candidates, int target, int n, List<List<Integer>> ans) {
        
        if(sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(idx == n || sum > target) {
            return;
        }

        list.add(candidates[idx]);
        recurCombinationSumII(idx + 1, sum + candidates[idx], list, candidates, target, n, ans);
        list.remove(list.size() - 1);
        while(idx + 1 < n && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        recurCombinationSumII(idx + 1, sum, list, candidates, target, n, ans);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        recurCombinationSumII(0 , 0, new ArrayList<>(), candidates, target, n, ans);
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
        List<List<Integer>> ans = combinationSum2(nums, target);
        for(List<Integer> output : ans) {
            System.out.println(output);
        }
    }
}
