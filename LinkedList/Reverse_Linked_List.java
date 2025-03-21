package LinkedList;

import java.util.Stack;

public class Reverse_Linked_List {               
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {

        // // TC : O(n)
        // // SC : O(n) -> Stack Space
        // public ListNode reverseList(ListNode head) {
        //     if(head == null || head.next == null) {
        //         return head;
        //     }

        //     Stack<ListNode> st = new Stack<>();

        //     ListNode curr = head;
        //     while(curr != null) {
        //         st.push(curr);
        //         curr = curr.next;
        //     }

        //     head = st.pop();
        //     curr = head;

        //     while(!st.isEmpty()) {
        //         curr.next = st.pop();
        //         curr = curr.next;
        //     }
        //     curr.next = null;
        //     return head;
        // }

        // // <----------------------------------------------->

        // TC : O(n)
        // SC : O(1)
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
    
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = head;
    
            while(next != null) {
    
                next = curr.next;
                curr.next = prev;
    
                prev = curr;
                curr = next;
            }
    
            return prev;
        }
    }
}
