package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Reorder_Linked_List {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // TC : O(n)
    // SC : O(n)
    class Solution {
        public void reorderList(ListNode head) {
            if(head == null || head.next == null) {
                return;
            }

            List<ListNode> nodes = new ArrayList<>();
            ListNode curr = head;
            while(curr != null) {
                nodes.add(curr);
                curr = curr.next;
            }

            int i = 0;
            int j = nodes.size() - 1;
            ListNode ans = new ListNode(-1);
            curr = ans;
            while(i <= j) {
                curr.next = nodes.get(i);
                i++;
                curr = curr.next;

                if(i > j) {
                    break;
                }

                curr.next = nodes.get(j);
                j--;
                curr = curr.next;
            }
            curr.next = null;
            head = ans.next;
        }
    }
}
