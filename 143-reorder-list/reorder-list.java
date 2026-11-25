class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        int size = stack.size();
        curr = head;

        for (int i = 0; i < size / 2; i++) {
            ListNode last = stack.pop();

            ListNode next = curr.next;

            curr.next = last;
            last.next = next;

            curr = next;
        }

        curr.next = null;
    }
}