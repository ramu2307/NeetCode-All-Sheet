package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Subsets {

    private static void recurSubsets(int idx, int n, List<List<Integer>> ans, List<Integer> list, int[] nums) {

        if(idx == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        recurSubsets(idx + 1, n, ans, list, nums);
        list.add(nums[idx]);
        recurSubsets(idx + 1, n, ans, list, nums);
        list.remove(list.size() - 1);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        recurSubsets(0, n, ans, list, nums);
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
        List<List<Integer>> ans = subsets(nums);
        for(List<Integer> out : ans) {
            System.out.println(out);
        }
    }
}
