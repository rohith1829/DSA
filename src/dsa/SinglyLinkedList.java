package dsa;

class SinglyLinkedList<T> {
    private Node<T> head;

    // Insert at beginning
    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Delete first node
    public T deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return null;
        }
        T value = head.data;
        head = head.next;
        return value;
    }

    // Delete last node
    public T deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return null;
        }
        if (head.next == null) {
            T value = head.data;
            head = null;
            return value;
        }
        Node<T> curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        T value = curr.next.data;
        curr.next = null;
        return value;
    }

    // Display list
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node<T> curr = head;
        System.out.print("List: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Check if empty
    public boolean isEmpty() {
        return head == null;
    }

    // Get first element
    public T getFirst() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return null;
        }
        return head.data;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
