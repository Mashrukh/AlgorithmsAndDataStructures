package LinkedList;

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int l = 1;
        ListNode tail = head;
        while (tail.next != null) {
            l++;
            tail = tail.next;
        }

        k = k % l;
        int stepsToTail = l - k;

        if (k == 0) {
            return head;
        }

        ListNode newTail = tail;
        tail.next = head;
        for (int i = stepsToTail; i > 0; i--) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
