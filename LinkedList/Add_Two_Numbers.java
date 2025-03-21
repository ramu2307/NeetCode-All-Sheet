package LinkedList;

public class Add_Two_Numbers {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(-1);
            ListNode curr = res;
            int carry = 0;
            while(l1 != null || l2 != null) {
                int sum = carry;
    
                if(l1 != null) {
                    sum = sum + l1.val;
                }
    
                if(l2 != null) {
                    sum = sum + l2.val;
                }
    
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                carry = sum/10;
    
                if(l1 != null) {
                    l1 = l1.next;
                }
    
                if(l2 != null) {
                    l2 = l2.next;
                }
    
            }
            if(carry != 0) {
                curr.next = new ListNode(carry);
            }
    
            return res.next;
        }
    }
}