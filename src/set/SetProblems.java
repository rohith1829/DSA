package set;

import java.util.*;

public class SetProblems {

    // 1. Class-Specific Set Behavior
    public static void classSpecificSetBehavior(List<Integer> list) {
        HashSet<Integer> hashSet = new HashSet<>(list);
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(list);
        TreeSet<Integer> treeSet = new TreeSet<>(list);

        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);
    }

    // 2. Maintaining Insertion Order
    public static LinkedHashSet<String> maintainInsertionOrder(List<String> list) {
        return new LinkedHashSet<>(list);
    }

    // 3. Finding First Non-Duplicate Element
    public static Integer firstNonDuplicate(List<Integer> list) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : list) {
            if (!set.add(num)) duplicates.add(num);
        }

        for (int num : set) {
            if (!duplicates.contains(num)) return num;
        }
        return null;
    }

    // 4. Sorted Unique Elements
    public static TreeSet<Integer> sortedUniqueElements(List<Integer> list) {
        return new TreeSet<>(list);
    }

    // 5. Custom Object Set Operations
    static class Person implements Comparable<Person> {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void customObjectSetOperations() {
        Set<Person> people = new HashSet<>();
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 25);
        people.add(p1);
        people.add(p2);

        System.out.println("Contains Alice(30)? " + people.contains(new Person("Alice", 30)));
    }

    // 6. Set Operations with Subsets
    public static boolean isSubset(Set<Integer> setA, Set<Integer> setB) {
        return setB.containsAll(setA);
    }

    // 7. Performance Comparison
    public static void performanceComparison() {
        int n = 1000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i);

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        long start = System.currentTimeMillis();
        list.forEach(hashSet::add);
        long end = System.currentTimeMillis();
        System.out.println("HashSet add: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        list.forEach(linkedHashSet::add);
        end = System.currentTimeMillis();
        System.out.println("LinkedHashSet add: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        list.forEach(treeSet::add);
        end = System.currentTimeMillis();
        System.out.println("TreeSet add: " + (end - start) + " ms");
    }
    
    
    // Main method to demonstrate
    public static void main(String[] args) {
        System.out.println("1. Class-Specific Set Behavior:");
        classSpecificSetBehavior(Arrays.asList(5, 3, 5, 1, 2));

        System.out.println("\n2. Maintaining Insertion Order:");
        System.out.println(maintainInsertionOrder(Arrays.asList("apple", "banana", "apple", "orange")));

        System.out.println("\n3. First Non-Duplicate:");
        System.out.println(firstNonDuplicate(Arrays.asList(4, 5, 6, 4, 7, 8, 5)));

        System.out.println("\n4. Sorted Unique Elements:");
        System.out.println(sortedUniqueElements(Arrays.asList(7, 2, 9, 1, 2, 9)));

        System.out.println("\n5. Custom Object Set Operations:");
        customObjectSetOperations();

        System.out.println("\n6. Subset Check:");
        System.out.println(isSubset(new HashSet<>(Arrays.asList(1,2,3)), new HashSet<>(Arrays.asList(1,2,3,4))));

        System.out.println("\n7. Performance Comparison:");
        performanceComparison();
    }
}
