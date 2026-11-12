class Solution {
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;

        // Store all values
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // Replace values in reverse order
        temp = head;
        int i = list.size() - 1;

        while (temp != null) {
            temp.val = list.get(i);
            i--;
            temp = temp.next;
        }

        return head;
    }
}