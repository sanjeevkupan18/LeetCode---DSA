import java.util.Stack;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();

        ListNode temp = head;

        // Push all nodes into stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // Remove n nodes from stack
        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        // If head needs to be removed
        if (stack.isEmpty()) {
            return head.next;
        }

        // Get previous node
        ListNode prev = stack.peek();

        // Remove the target node
        prev.next = prev.next.next;

        return head;
    }
}