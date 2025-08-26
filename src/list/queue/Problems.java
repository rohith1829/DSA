package list.queue;

import java.util.*;

public class Problems {

    // 1. Implement Stack Using Queues
    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            int top = q1.remove();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return top;
        }

        public int top() {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            int top = q1.peek();
            q2.add(q1.remove());
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return top;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    // 2. Circular Queue
    static class CircularQueue {
        int[] arr;
        int front, rear, size, capacity;

        CircularQueue(int k) {
            capacity = k;
            arr = new int[k];
            front = rear = size = 0;
        }

        public boolean enQueue(int val) {
            if (isFull()) return false;
            arr[rear] = val;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : arr[front];
        }

        public int Rear() {
            return isEmpty() ? -1 : arr[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() { return size == 0; }
        public boolean isFull() { return size == capacity; }
    }

    // 3. Generate Binary Numbers 1..n
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for (int i = 0; i < n; i++) {
            String s = q.remove();
            result.add(s);
            q.add(s + "0");
            q.add(s + "1");
        }
        return result;
    }

    // 4. First Non-Repeating Character in a stream
    public static List<Character> firstNonRepeating(String stream) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        List<Character> result = new ArrayList<>();
        for (char c : stream.toCharArray()) {
            freq[c - 'a']++;
            q.add(c);
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            result.add(q.isEmpty() ? '#' : q.peek());
        }
        return result;
    }

    // 5. Interleave Queue
    public static void interleaveQueue(Queue<Integer> q) {
        if (q.size() % 2 != 0) return;
        int half = q.size() / 2;
        Queue<Integer> firstHalf = new LinkedList<>();
        for (int i = 0; i < half; i++) {
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    // 6. Sliding Window Maximum
    public static int[] slidingWindowMax(int[] arr, int k) {
        if (arr.length == 0 || k <= 0) return new int[0];
        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = arr[dq.peekFirst()];
        }
        return result;
    }
}

