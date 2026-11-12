class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // Store next node
            ListNode next = curr.next;

            // Reverse the link
            curr.next = prev;

            // Move pointers forward
            prev = curr;
            curr = next;
        }

        return prev;
    }
}