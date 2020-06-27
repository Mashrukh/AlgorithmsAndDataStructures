package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoNodes {
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();

        // We use hashset to compare the nodes by their references, not their values

        while (headA != null) {
            if (!visited.contains(headA)) {
                visited.add(headA);
            }
            headA = headA.next;
        }

        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

}
