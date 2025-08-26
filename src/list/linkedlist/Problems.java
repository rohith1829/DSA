package list.linkedlist;

public class Problems {

    // Standard List Node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Random pointer node (for problem 6)
    static class RandomNode {
        int val;
        RandomNode next, random;
        RandomNode(int val) { this.val = val; }
    }

    // Multilevel list node (for problem 8)
    static class ChildNode {
        int val;
        ChildNode next, child;
        ChildNode(int val) { this.val = val; }
    }

 // 1. Detect Cycle and find start node
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        // Step 1: Detect if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // cycle found
                // Step 2: Find length of cycle
                int cycleLen = 1;
                slow = slow.next; // move once
                while (slow != fast) {
                    slow = slow.next;
                    cycleLen++;
                }

                // Step 3: Move one pointer cycleLen ahead
                slow = head;
                fast = head;
                for (int i = 0; i < cycleLen; i++) {
                    fast = fast.next;
                }

                // Step 4: Move both until they meet at start node
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // cycle start
            }
        }
        return null; // no cycle
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast reached null, we need to delete the head
        if (fast == null) {
            return head.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete nth from end
        slow.next = slow.next.next;

        return head;
    }


    // 3. Intersection of Two LinkedLists
    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) return null;
        ListNode p1 = a, p2 = b;
        while (p1 != p2) {
            p1 = (p1 == null) ? b : p1.next;
            p2 = (p2 == null) ? a : p2.next;
        }
        return p1;
    }

    // 4. Palindrome Check
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow);
        ListNode first = head;
        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    // Helper for reverse
    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 5. Merge Two Sorted Lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // 6. Clone LinkedList with Random Pointers
    public static RandomNode cloneRandomList(RandomNode head) {
        if (head == null) return null;
        // Step 1: Insert cloned nodes
        RandomNode curr = head;
        while (curr != null) {
            RandomNode copy = new RandomNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        // Step 2: Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        // Step 3: Separate cloned list
        curr = head;
        RandomNode newHead = head.next;
        while (curr != null) {
            RandomNode copy = curr.next;
            curr.next = copy.next;
            if (copy.next != null) copy.next = copy.next.next;
            curr = curr.next;
        }
        return newHead;
    }
}
