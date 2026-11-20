class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;

        // Calculate the length
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // If head needs to be removed
        if (length == n) {
            return head.next;
        }

        // Find the node before the target
        temp = head;
        int steps = length - n - 1;

        while (steps > 0) {
            temp = temp.next;
            steps--;
        }

        // Remove the target node
        temp.next = temp.next.next;

        return head;
    }
}