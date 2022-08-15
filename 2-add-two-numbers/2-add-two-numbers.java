/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*

Understand:

l1 = [2,4,3], l2 = [5,6,4]
[7,0,8]

l1 = [9,9] l2 = [1]
[0,0,1]

l1 = [0] l2 = [8,1]
[8,1]

Match:

Linkedlists
Two-pointer

Plan:
1. Iterate over both lists
2. Add digits + carry at each place and set carry bit if the sum exceeds 10

*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode tail = l3;
        
        int carry = 0;
        int sum = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            carry = 0;
            
            if (sum >= 10) {
                carry = 1;
                sum %= 10;
            }
            
            tail.next = new ListNode(sum);
            tail = tail.next;
            sum = 0;
        }
        return l3.next;
    }
}