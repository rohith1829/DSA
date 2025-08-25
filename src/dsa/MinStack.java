package dsa;

class MinStack<T extends Comparable<T>> {
    private MyStack<T> stack;     // main stack
    private MyStack<T> minStack;  // keeps track of minimums

    public MinStack() {
        stack = new MyStack<>();
        minStack = new MyStack<>();
    }

    public void push(T x) {
        stack.push(x);
        if (minStack.isEmpty() || x.compareTo(minStack.peek()) <= 0) {
            minStack.push(x);
        }
    }

    public T pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow!");
            return null;
        }
        T removed = stack.pop();
        if (removed.equals(minStack.peek())) {
            minStack.pop();
        }
        return removed;
    }

    public T top() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public T getMin() {
        return minStack.isEmpty() ? null : minStack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
