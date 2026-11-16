class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == Integer.MIN_VALUE) {
                return true;
            }

            temp.val = Integer.MIN_VALUE;
            temp = temp.next;
        }

        return false;
    }
}