class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For even length, slow is at the start of second half
        // For odd length, skip the middle node
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse second half
        ListNode secondHalf = reverse(slow);

        ListNode firstHalf = head;
        ListNode second = secondHalf;

        boolean palindrome = true;

        while (second != null) {
            if (firstHalf.val != second.val) {
                palindrome = false;
                break;
            }

            firstHalf = firstHalf.next;
            second = second.next;
        }

        // Restore the original linked list
        reverse(secondHalf);

        return palindrome;
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