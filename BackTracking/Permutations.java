package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Permutations {

    private static void recurPermute(int n, List<List<Integer>> ans, List<Integer> list, boolean[] vis, int[] nums) {

        if(list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                vis[i] = true;
                list.add(nums[i]);
                recurPermute(n, ans, list, vis, nums);
                vis[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        boolean[] vis = new boolean[n];
        recurPermute(n, ans, list, vis, nums);
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
        List<List<Integer>> ans = permute(nums);
        for(List<Integer> output : ans) {
            System.out.println(output);
        }
    }
}
