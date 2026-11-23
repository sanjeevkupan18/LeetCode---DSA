class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();

        ListNode curr = head;

        // Count frequency of each value
        while (curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        curr = head;

        // Keep only nodes appearing once
        while (curr != null) {
            if (map.get(curr.val) == 1) {
                tail.next = new ListNode(curr.val);
                tail = tail.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}