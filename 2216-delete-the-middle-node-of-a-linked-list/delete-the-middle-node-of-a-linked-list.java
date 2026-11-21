class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ArrayList<ListNode> list = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        int mid = list.size() / 2;

        ListNode prev = list.get(mid - 1);
        prev.next = list.get(mid).next;

        return head;
    }
}