package dsa;

class MyQueue<T extends Comparable<T>> {
    private MyStack<T> stack1 = new MyStack<>();
    private MyStack<T> stack2 = new MyStack<>();

    public void enqueue(T x) {
        stack1.push(x);
    }

    public T dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
