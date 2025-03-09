package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Subsets_II {

    private static void recurSubset2(int idx, int n, List<Integer> list, int[] nums, List<List<Integer>> ans) {

        if(idx == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        recurSubset2(idx + 1, n, list, nums, ans);

        list.remove(list.size() - 1);
        while(idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        recurSubset2(idx + 1, n, list, nums, ans);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        recurSubset2(0 , n, new ArrayList<>(), nums, ans);
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
        List<List<Integer>> ans = subsetsWithDup(nums);
        for(List<Integer> output : ans) {
            System.out.println(output);
        }
    }
}
