class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        int length = 0;
        ListNode curr = head;

        // First pass: Calculate length
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int mid = length / 2;

        curr = head;

        // Second pass: Reach node before middle
        for (int i = 0; i < mid - 1; i++) {
            curr = curr.next;
        }

        // Delete middle node
        curr.next = curr.next.next;

        return head;
    }
}