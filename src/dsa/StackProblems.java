package dsa;

import java.util.Arrays;

class StackProblems {

    // 1. Valid Parentheses
    public static boolean isValidParentheses(String s) {
        MyStack<Character> stack = new MyStack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 2. Next Greater Element
    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        MyStack<Integer> stack = new MyStack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    // 3. Sort a Stack using another Stack
    public static MyStack<Integer> sortStack(MyStack<Integer> input) {
        MyStack<Integer> tempStack = new MyStack<>();
        while (!input.isEmpty()) {
            int temp = input.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                input.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        return tempStack; // sorted stack
    }

    // 4. Evaluate Postfix Expression
    public static int evaluatePostfix(String expr) {
        MyStack<Integer> stack = new MyStack<>();
        for (String token : expr.split(" ")) {
            if (isInteger(token)) { // number check without regex
                stack.push(Integer.parseInt(token));
            } else { // operator
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    private static boolean isInteger(String s) {
        if (s == null || s.isEmpty()) return false;
        int start = 0;
        if (s.charAt(0) == '-' && s.length() > 1) {
            start = 1; // allow negative numbers
        }
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 1. Valid Parentheses
        String s1 = "([{}])";
        String s2 = "([)]";
        System.out.println("Valid Parentheses:");
        System.out.println(s1 + " -> " + isValidParentheses(s1)); // true
        System.out.println(s2 + " -> " + isValidParentheses(s2)); // false
        System.out.println();

        // 2. Next Greater Element
        int[] arr = {13, 7, 6, 12};
        System.out.println("Next Greater Element:");
        System.out.println(Arrays.toString(nextGreater(arr))); // [-1, 12, 12, -1]
        System.out.println();

        // 3. Sort a Stack using another Stack
        MyStack<Integer> s = new MyStack<>();
        s.push(6);
        s.push(3);
        s.push(8);
        s.push(2);
        MyStack<Integer> sorted = sortStack(s);
        System.out.println("Sorted Stack:");
        sorted.display();
        System.out.println("\n");

        // 4. Evaluate Postfix Expression
        String expr = "5 6 2 + * 12 4 / -";
        System.out.println("Evaluate Postfix:");
        System.out.println(expr + " -> " + evaluatePostfix(expr)); // 37
        System.out.println();

        // 5. Min Stack
        System.out.println("Min Stack:");
        MinStack<Integer> ms = new MinStack<>();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);
        ms.push(8);

        System.out.println("Current Min: " + ms.getMin()); // 2
        ms.pop(); // removes 8
        System.out.println("Current Min: " + ms.getMin()); // 2
        ms.pop(); // removes 2
        System.out.println("Current Min: " + ms.getMin()); // 3
    }
}
