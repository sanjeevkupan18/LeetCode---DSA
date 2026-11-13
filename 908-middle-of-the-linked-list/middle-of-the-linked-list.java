class Solution {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        return list.get(list.size() / 2);
    }
}