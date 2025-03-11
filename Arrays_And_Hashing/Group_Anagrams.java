package Arrays_And_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Group_Anagrams {

    // //TC : O(m * (n * lon(n))
    // // m = number of Strings
    // //n = length of longest String
    // public static List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String, List<String>> map = new HashMap<>();

    //     for(String s : strs) {
    //         char[] ch = s.toCharArray();
    //         Arrays.sort(ch);

    //         String sorted = Arrays.toString(ch);

    //         if(!map.containsKey(sorted)) {
    //             map.put(sorted, new ArrayList<>());
    //         }

    //         map.get(sorted).add(s);
    //     }

    //     return new ArrayList<>(map.values());
    // }


    //TC : O(m * n);
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] freq = new char[26];
            for(char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            String key = new String(freq);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            strs[i] = st.nextToken();
        }

        List<List<String>> ans = groupAnagrams(strs);

        System.out.println(ans);
    }
        
}
