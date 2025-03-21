package LinkedList;

import java.util.HashSet;

public class Linked_List_Cycle_Detection {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // // TC : O(n)
    // // SC : O(n)
    // public class Solution {
    //     public boolean hasCycle(ListNode head) {
    //         HashSet<ListNode> set = new HashSet<>();
    //         ListNode temp = head;
    //         while(temp != null) {
    //             if(set.contains(temp)) {
    //                 return true;
    //             }

    //             set.add(temp);
    //             temp = temp.next;
    //         }

    //         return false;
    //     }
    // }

    // // <----------------------------------------------->

    // TC : O(n)
    // SC : O(1)

    // Fast and Slow Pointer Method
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(slowPtr != null && fastPtr != null && fastPtr.next != null) {

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }
}
