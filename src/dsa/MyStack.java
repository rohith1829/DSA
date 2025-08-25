package dsa;

class MyStack<T extends Comparable<T>> {
    private SinglyLinkedList<T> list = new SinglyLinkedList<>();

    // Push -> insert at beginning
    public void push(T x) {
        list.insertFirst(x);
    }

    // Pop -> remove from beginning
    public T pop() {
        return list.deleteFirst();
    }

    // Peek -> see top element
    public T peek() {
        return list.getFirst();
    }

    // Check if empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Display stack
    public void display() {
        System.out.print("Stack (top → bottom): ");
        list.display();
    }
}
