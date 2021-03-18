package listsStacksNQueues;

public class LinkedList {

    Node head;
    Node tail;

    public static class Node {
        int data;
        Node next;
        Node prev;

        // constructor
        Node(int d) {
            this.data=d;
            this.next=null;
            this.prev=null;
        }

        // constructor
        Node () {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

    }
    // returns last instance of a node with data 'key'
    static Node nodeSearchLastSingle(LinkedList list, int key) {
        Node nodePointer = new Node();
        Node prevMatch = null;


        // if empty
        if(list.head == null) {
            return null;
        }

        // search through linked list; keep track of most recent match
        while(nodePointer.next != null) {
            nodePointer = nodePointer.next;
            if(nodePointer.data == key) {
                prevMatch = nodePointer;
            }
        }
        return prevMatch;
    }


}
