class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find the length of the linked list
        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Reduce unnecessary rotations
        k = k % len;

        if (k == 0) {
            return head;
        }

        // Connect tail to head to form a circular list
        tail.next = head;

        // Find the new tail
        int steps = len - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}