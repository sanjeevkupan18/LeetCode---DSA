class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        int i = left - 1;
        int j = right - 1;

        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);

            i++;
            j--;
        }

        curr = head;
        i = 0;

        while (curr != null) {
            curr.val = list.get(i++);
            curr = curr.next;
        }

        return head;
    }
}