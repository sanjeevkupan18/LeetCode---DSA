class Solution {
    public ListNode reverseList(ListNode head) {

        // Base condition
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the remaining list
        ListNode newHead = reverseList(head.next);

        // Reverse the current link
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}