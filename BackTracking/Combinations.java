package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Combinations {

    private static void recurCombination(int idx, int n, int k, List<Integer> list, List<List<Integer>> ans) {

        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx; i <= n; i++) {
            list.add(i);
            recurCombination(i + 1, n, k, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        recurCombination(1, n, k, new ArrayList<>(), ans);
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<List<Integer>> ans = combine(n, k);
        for(List<Integer> output : ans) {
            System.out.println(output);
        }
    }
}
