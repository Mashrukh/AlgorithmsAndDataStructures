package LinkedList;

/*Reverse a singly linked list.

        Example:

        Input: 1->2->3->4->5->NULL
        Output: 5->4->3->2->1->NULL*/

public class ReverseSinglyLinkedList {
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

    public ListNode reverseList(ListNode head) {
        // 1: boundary condition
        if (head == null || head.next == null) {
            return head;
        }

        // 2: recursive step
        //Goes to end of the list
        ListNode p = head;
        head = reverseList(head.next);

        // 3: Change the direction of the pointers
        // Make the next's next pointer back itself
        p.next.next = p;
        //delete the original next pointer
        p.next = null;
        return head;
    }

    private ListNode iterativeReverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
