package listsStacksNQueues;

public class LSQDriver {
    public static void main(String[] args) {
        aQueueWithTwoStacks twoStacks = new aQueueWithTwoStacks();
        
        for (int i = 0; i < 10; i++) {
            twoStacks.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(twoStacks.pop());
        }

    }
}
