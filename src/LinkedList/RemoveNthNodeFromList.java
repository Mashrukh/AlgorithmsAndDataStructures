package LinkedList;

public class RemoveNthNodeFromList {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;
        dummy.next = head;

        // iterate the first pointer so that it is n ahead of the second pointer
        for (int i = 1; i < n + 1; i++) {
            firstPtr = firstPtr.next;
        }


        // iterate both the first and second pointer together
        while (firstPtr.next != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        secondPtr.next = secondPtr.next.next;
        return dummy.next;
    }
}
