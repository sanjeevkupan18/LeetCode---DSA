class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Skip middle node in odd-length list
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse the second half
        ListNode secondHalf = reverse(slow);

        ListNode firstHalf = head;
        ListNode second = secondHalf;

        // Compare both halves
        while (second != null) {
            if (firstHalf.val != second.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            second = second.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}