/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
Understand:

Do not modify the linked list
O(1) space complexity

[3,2,0,-4], pos = 1

[1,2], pos = 0

[1], pos = -1

[], pos = -1

Match:

Linkedlists
Two-pointer, Cycle-detection

Plan:
Detect cycle
Find cycle position

1. Iterate list using fast and slow pointers
2. If fast and slow pointers equals each other then cycle exists
3. Reset fast pointer and let it increment (once at a time) until fast == slow
4. Resulting position is the start of the cycle

*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean cycle = false;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        
        if (cycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }
        
        return null;
    }
}