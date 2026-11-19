public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA;

        while (tempA != null) {

            ListNode tempB = headB;

            while (tempB != null) {

                if (tempA == tempB) {
                    return tempA;
                }

                tempB = tempB.next;
            }

            tempA = tempA.next;
        }

        return null;
    }
}