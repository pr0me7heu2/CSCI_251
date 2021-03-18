package listsStacksNQueues;

public class aQueueWithTwoStacks {
    stack stackIn = new stack();
    stack stackOut = new stack();

    public void push(int data) {
        stackIn.push(data);
    }

    public int pop() {
        int data;
        while(stackIn.top!=null) {
            stackOut.push(stackIn.pop());
        }
        data = stackOut.pop();
        while(stackOut.top!=null) {
            stackIn.push(stackOut.pop());
        }
        return data;
    }

}
