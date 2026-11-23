class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> duplicates = new HashSet<>();

        ListNode curr = head;

        // First pass: identify duplicate values
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                duplicates.add(curr.val);
            }
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        curr = head;

        // Second pass: remove duplicate nodes
        while (curr != null) {
            if (duplicates.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}