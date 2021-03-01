package listsStacksNQueues;

public class LinkedList {

    Node head;
    Node tail;

    static class Node {
        int data;
        Node next;
        Node prev;

        // constructor
        Node(int d) {
            this.data=d;
            this.next=null;
            this.prev=null;
        }

    }
}
