// Implementation of a singly linked list
public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // insert new node at the end of the linked list
    public static LinkedList insert(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            //iterate to the last node of the list
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    //remove the last node of the linked list
    public static Node remove(LinkedList list) {
        Node node = list.head;
        Node removedNode = node;
        if (node.next == null) {
            list.head = null;
        }

        Node prevNode = node;
        while (node.next != null) {
            prevNode = node;
            node = node.next;
        }
        removedNode = node;
        prevNode.next = null;
        return removedNode;
    }

    public static void printList(LinkedList list) {
        Node curr = list.head;
        System.out.println("LinkedList: ");
        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.next;
            if (curr != null) {
                System.out.print(" -> ");
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // Testing
        LinkedList list = new LinkedList();
        insert(list, 1);
        insert(list, 2);
        insert(list, 3);
        insert(list, 4);
        printList(list);
        remove(list);
        printList(list);
        remove(list);
        printList(list);
    }
}
