class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Check whether current value is duplicated
            if (curr.next != null && curr.val == curr.next.val) {

                // Skip all nodes with the duplicate value
                while (curr.next != null &&
                       curr.val == curr.next.val) {
                    curr = curr.next;
                }

                // Remove all occurrences of this value
                prev.next = curr.next;

            } else {
                // Current value is unique
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}