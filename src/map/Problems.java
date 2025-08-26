package map;

import java.util.*;

public class Problems {

    // 1. Frequency Counter
    public static void frequencyCounter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println("Character Frequencies: " + map);
    }

    // 2. Word Occurrence (simple version)
    public static void wordOccurrence(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split("\\s+");
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word Occurrences: " + map);
    }

    // 3. First Non-Repeated Character
    public static void firstNonRepeatedChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeated char: " + entry.getKey());
                return;
            }
        }
        System.out.println("No non-repeated character found.");
    }

    // 4. Sorting HashMap by Values
    public static void sortByValues(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        System.out.println("Sorted by values:");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // 5. Duplicate Elements in Array
    public static void duplicateElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println("Duplicates and counts:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // 6. Phone Book using TreeMap
    public static void phoneBook() {
        TreeMap<String, String> phoneBook = new TreeMap<>();
        phoneBook.put("Rohith", "9999999999");
        phoneBook.put("Varun", "8888888888");
        phoneBook.put("Ravi", "7777777777");

        System.out.println("Phone Book: " + phoneBook);
        System.out.println("Search Ravi: " + phoneBook.get("Ravi"));
    }
}
