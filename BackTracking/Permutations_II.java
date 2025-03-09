package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Permutations_II {

    private static void recurPermuteII(int n, int[] nums, List<Integer> list, boolean[] vis, List<List<Integer>> ans) {

        if(list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < n; i++) {

            if(i + 1 < n && nums[i] == nums[i + 1] && !vis[i + 1] && !vis[i]) continue; 

            if(!vis[i]) {
                vis[i] = true;
                list.add(nums[i]);
                recurPermuteII(n, nums, list, vis, ans);
                list.remove(list.size() - 1);
                vis[i] = false;

            }
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] vis = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        recurPermuteII(n, nums, new ArrayList<>(), vis, ans);
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        List<List<Integer>> ans = permuteUnique(nums);
        for(List<Integer> output : ans) {
            System.out.println(output);
        }
    }
}