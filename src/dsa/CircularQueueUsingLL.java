package dsa;

public class CircularQueueUsingLL<T> {
    Node<T> front, rear;
    int size, capacity;

    public CircularQueueUsingLL(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = this.rear = null;
    }

    // Enqueue
    public void enqueue(T data) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        size++;
    }

    // Dequeue
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }

        T value = front.data;

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        size--;
        return value;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node<T> temp = front;
        System.out.print("Queue: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
