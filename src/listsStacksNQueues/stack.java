package listsStacksNQueues;

public class stack {

    LinkedList.Node top;
    int size;

    public void push(int data) {
        LinkedList.Node newNode = new LinkedList.Node(data);
        // empty stack
        if(top == null) {
            top = newNode;
            size++;
        }
        // not empty
        else {
            newNode.next = top;
            top = newNode;
            size++;
        }
    }

    public int pop() {
        int data;
        // empty stack
        if(this.top == null) {
            return -1;
        }
        // not empty
        data = top.data;
        top = top.next;
        size--;

        return data;
    }

}
