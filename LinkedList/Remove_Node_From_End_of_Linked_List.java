package LinkedList;

public class Remove_Node_From_End_of_Linked_List {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // TC : O(n)
    // SC : O(1)
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null) {
                return head;
            }
    
            int N = 0;
            ListNode curr = head;
            while(curr != null) {
                N++;
                curr = curr.next;
            }
    
            int removeIdx = N - n;
            if(removeIdx == 0) {
                return head.next;
            }  
    
            curr = head;
            for(int i = 1; i < removeIdx; i++) {
                curr = curr.next;
            } 
    
            curr.next = curr.next.next;  
            return head;
        }
    }
}
