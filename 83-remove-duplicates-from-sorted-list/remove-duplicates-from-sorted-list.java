class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = curr;
            ListNode next = curr.next;

            while (next != null) {
                if (next.val == curr.val) {
                    prev.next = next.next;
                    next = prev.next;
                } else {
                    prev = next;
                    next = next.next;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}