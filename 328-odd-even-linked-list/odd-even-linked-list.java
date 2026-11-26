class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);

        ListNode odd = oddDummy;
        ListNode even = evenDummy;

        ListNode curr = head;

        int index = 1;

        while (curr != null) {

            if (index % 2 == 1) {
                odd.next = curr;
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }

            curr = curr.next;
            index++;
        }

        odd.next = evenDummy.next;
        even.next = null;

        return oddDummy.next;
    }
}