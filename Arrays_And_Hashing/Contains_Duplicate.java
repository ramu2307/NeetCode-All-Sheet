package Arrays_And_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Contains_Duplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            
            if(set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(containsDuplicate(nums) ? "YES" : "NO");
        
    }
}