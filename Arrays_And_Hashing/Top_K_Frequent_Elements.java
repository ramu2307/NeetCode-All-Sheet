package Arrays_And_Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Top_K_Frequent_Elements {

    // // TC : O ( n * log(n) )
    // public static int[] topKFrequent(int[] nums, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for(int i = 0; i < nums.length; i++) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //     }

    //     List<int[]> list = new ArrayList<>();
    //     for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         list.add(new int[]{entry.getValue(), entry.getKey()});
    //     }

    //     list.sort((a, b) -> b[0] - a[0]);

    //     int[] ans = new int[k];
    //     for(int i = 0; i < k; i++) {
    //         ans[i] = list.get(i)[1];
    //     }

    //     return ans;
    // }

    //--------------------------------------------------------------


    // // TC : O ( n*log(k) )
    //@SuppressWarnings("unchecked")
    // public static int[] topKFrequent(int[] nums, int k) {
        
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     List<Integer>[] bucket = new ArrayList[nums.length + 1];

    //     for(int i = 0; i < nums.length; i++) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //     }

    //     PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    //     for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

    //         heap.offer(new int[]{entry.getValue(), entry.getKey()});

    //         if(heap.size() > k) {
    //             heap.poll();
    //         }
    //     }

    //     int[] ans = new int[k];
    //     for(int i = 0; i < k; i++) {
    //         ans[i] = heap.poll()[1];
    //     }

    //     return ans;
    // }

    //---------------------------------------------------------------


    //TC : O(n)
    @SuppressWarnings("unchecked")
    public static int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : map.keySet()) {
            int freq = map.get(key);

            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int cnt = 0;

        for(int i = bucket.length - 1; i >= 0 && cnt < k; i--) {

            if(bucket[i] != null) {
                for(Integer integer : bucket[i]) {
                    ans[cnt++] = integer;

                    if(cnt == k) {
                        break;
                    }
                }
            }
        }

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
        int k = Integer.parseInt(br.readLine());
        int[] ans = topKFrequent(nums, k);
        for(int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
        
    }
}
