class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ArrayList<ListNode> list = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        for (int i = 0; i + 1 < list.size(); i += 2) {
            ListNode temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        list.get(list.size() - 1).next = null;

        return list.get(0);
    }
}