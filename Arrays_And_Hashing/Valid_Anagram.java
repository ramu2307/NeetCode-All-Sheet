package Arrays_And_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Valid_Anagram {

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        for(int num : freq) {
            if(num != 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(isAnagram(s, t) ? "YES" : "NO");
        
    }
}
