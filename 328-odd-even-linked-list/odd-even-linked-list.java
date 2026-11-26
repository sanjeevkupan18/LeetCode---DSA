class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        int index = 1;

        ListNode curr = head;

        while (curr != null) {

            if (index % 2 == 1) {
                odd.add(curr.val);
            } else {
                even.add(curr.val);
            }

            curr = curr.next;
            index++;
        }

        curr = head;

        for (int val : odd) {
            curr.val = val;
            curr = curr.next;
        }

        for (int val : even) {
            curr.val = val;
            curr = curr.next;
        }

        return head;
    }
}