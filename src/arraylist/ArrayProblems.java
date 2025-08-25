package arraylist;

import java.util.*;

public class ArrayProblems {

    // 1. Find Duplicate Elements
    public static void findDuplicates(ArrayList<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : list) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Duplicates: " + duplicates);
    }

    // 2. Remove Duplicates (maintaining order)
    public static void removeDuplicates(ArrayList<Integer> list) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        System.out.println("After removing duplicates: " + new ArrayList<>(set));
    }

    // 3. Find Intersection
    public static void intersection(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : list1) {
            if (list2.contains(num) && !result.contains(num)) {
                result.add(num);
            }
        }
        System.out.println("Intersection: " + result);
    }

    // 4. Find Union
    public static void union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list1);
        set.addAll(list2);
        System.out.println("Union: " + new ArrayList<>(set));
    }

    // 5. Reverse ArrayList without built-in reverse
    public static void reverse(ArrayList<Integer> list) {
        ArrayList<Integer> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        System.out.println("Reversed: " + reversed);
    }

    // 6. Rotate ArrayList k positions to the right
    public static void rotate(ArrayList<Integer> list, int k) {
        int n = list.size();
        k = k % n; 
        ArrayList<Integer> rotated = new ArrayList<>();
        for (int i = n - k; i < n; i++) {
            rotated.add(list.get(i));
        }
        for (int i = 0; i < n - k; i++) {
            rotated.add(list.get(i));
        }
        System.out.println("Rotated by " + k + ": " + rotated);
    }

    // 7. Sort ArrayList using custom sorting (Bubble Sort)
    public static void sort(ArrayList<Integer> list) {
        ArrayList<Integer> sorted = new ArrayList<>(list);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                if (sorted.get(j) > sorted.get(j + 1)) {
                    int temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sorted: " + sorted);
    }

    // 8. Find Largest and Smallest
    public static void findMinMax(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : list) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        System.out.println("Smallest: " + min + ", Largest: " + max);
    }

    // 9. Check Palindrome
    public static void checkPalindrome(ArrayList<Character> list) {
        int i = 0, j = list.size() - 1;
        boolean isPalindrome = true;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }
        System.out.println("Is Palindrome? " + isPalindrome);
    }

    // 10. First Non-Repeated Element
    public static void firstNonRepeated(ArrayList<Integer> list) {
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int num : list) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First Non-Repeated: " + entry.getKey());
                return;
            }
        }
        System.out.println("No Non-Repeated Element Found");
    }

    // Main Method for Testing
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 7, 8, 1));

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);

        findDuplicates(list1);
        removeDuplicates(list1);
        intersection(list1, list2);
        union(list1, list2);
        reverse(list1);
        rotate(list1, 3);
        sort(list1);
        findMinMax(list1);

        ArrayList<Character> charList = new ArrayList<>(Arrays.asList('r', 'a', 'd', 'a', 'r'));
        checkPalindrome(charList);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(9, 3, 4, 3, 9, 5, 4));
        firstNonRepeated(list3);
    }
}

