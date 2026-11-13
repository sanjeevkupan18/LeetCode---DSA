class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;

        ListNode curr = head;

        // First traversal: Calculate length
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int mid = length / 2;

        curr = head;

        // Second traversal: Find middle node
        while (mid > 0) {
            curr = curr.next;
            mid--;
        }

        return curr;
    }
}