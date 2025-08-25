package dsa;

public class LL_Problems<T> {
	// Reverse
    public void reverse(Node<T> head) {
        Node<T> prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Detect cycle
    public boolean hasCycle(Node<T> head) {
        Node<T> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    
    //sort


    void sort(Node<T> head) {
        if (head == null || head.next == null) return;

        // Check if data type is Comparable
        if (!(head.data instanceof Comparable)) {
            throw new IllegalStateException("Cannot sort: elements are not comparable");
        }

        head = mergeSort(head);
    }

    
    private Node<T> mergeSort(Node<T> h) {
        if (h == null || h.next == null) return h;

        Node<T> mid = getMiddle(h);
        Node<T> nextToMid = mid.next;
        mid.next = null;

        Node<T> left = mergeSort(h);
        Node<T> right = mergeSort(nextToMid);

        return merge(left, right);
    }



    @SuppressWarnings("unchecked")
	private Node<T> merge(Node<T> l1, Node<T> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Comparable c1 = (Comparable) l1.data;
        Comparable c2 = (Comparable) l2.data;

        if (c1.compareTo(c2) <= 0) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    // Helper to find middle
    private Node<T> getMiddle(Node<T> h) {
        if (h == null) return h;
        Node<T> slow = h, fast = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //merge
    
    @SuppressWarnings("unchecked")
    public Node<T> mergeTwoSortedLists(Node<T> l1, Node<T> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // check both implement Comparable
        if (!(l1.data instanceof Comparable) || !(l2.data instanceof Comparable)) {
            throw new IllegalArgumentException("Elements must implement Comparable to merge");
        }

        Node<T> result;

        Comparable c1 = (Comparable) l1.data;
        Comparable c2 = (Comparable) l2.data;

        if (c1.compareTo(c2) <= 0) {
            result = l1;
            result.next = mergeTwoSortedLists(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoSortedLists(l1, l2.next);
        }
        return result;
    }


}
