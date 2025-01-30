
/*
 * *** WILLIAM MORRIS / 002 ***
 *
 * Homework # 1 (Programming Assignment). This Java class defines some basic
 * manipulation operations on Linked-Lists and Stacks.
 *
 * Additionally, there are two algorithm analysis methods where you need
 * to return a specified number as provided in comments of each method indicating
 * the complexity of the code shown. The testing routine will be looking for a
 * specific number returned.
 */

 import java.util.Stack;

/**
 * HW1 - Linked Lists and Stacks
 * 
 * This class provides basic operations for manipulating singly linked lists and utilizing Java's Stack class.
 * Additionally, it contains methods for algorithm complexity analysis.
 */
public class HW1 {

    /**
     * Class LinkedList
     * 
     * Implements a singly linked list supporting insertion in sorted order
     * and removal of specific elements based on conditions.
     */
    public static class LinkedList {
        /**
         * Inner class representing a node in the linked list.
         */
        public static class Node {
            int data;
            Node next;

            /**
             * Constructor to initialize a node with given data.
             * @param d The integer data to store in the node.
             */
            public Node(int d) { data = d; next = null; }
        }

        Node head; // Head pointer for the linked list

        /**
         * Inserts a new node in sorted order.
         * @param data The value to insert.
         */
        public void sortedInsert(int data) {
            Node new_node = new Node(data);
            if (this.head == null || head.data >= new_node.data) {
                new_node.next = head;
                head = new_node;
            } else {
                Node current = this.head;
                while (current.next != null && current.next.data < data) {
                    current = current.next;
                }
                new_node.next = current.next;
                current.next = new_node;
            }
        }

        /**
         * Removes all nodes with values less than the given threshold.
         * @param ltValue The threshold value.
         */
        public void removeElementsLT(int ltValue) {
            while (head != null && head.data < ltValue) {
                head = head.next; // Remove leading nodes less than ltValue
            }
            Node current = head;
            while (current != null && current.next != null) {
                if (current.next.data < ltValue) {
                    current.next = current.next.next; // Remove the node
                } else {
                    current = current.next; // Move to next node
                }
            }
        }

        /**
         * Removes all nodes that match the specified value.
         * @param value The value to remove from the list.
         */
        public void removeElement(int value) {
            while (head != null && head.data == value) {
                head = head.next; // Remove leading nodes equal to value
            }
            Node current = head;
            while (current != null && current.next != null) {
                if (current.next.data == value) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }

        /**
         * Converts the linked list into a string representation.
         * @return String representation of the linked list.
         */
        public String toString() {
            StringBuilder output = new StringBuilder("[");
            Node currNode = this.head;
            while (currNode != null) {
                output.append(currNode.data).append(" ");
                currNode = currNode.next;
            }
            return output.toString().trim() + "]";
        }
    }

    /**
     * Class Stacks
     * 
     * Implements stack-based algorithms utilizing Java's Stack class.
     */
    public static class Stacks {
        /**
         * Checks if a given string is a palindrome (ignoring spaces and case sensitivity).
         * @param input The string to check.
         * @return True if the input is a palindrome, false otherwise.
         */
        public static boolean isPalindrome(String input) {
            Stack<Character> stack = new Stack<>();
            input = input.toLowerCase().replaceAll("\\s+", "");
            for (char c : input.toCharArray()) {
                stack.push(c);
            }
            for (char c : input.toCharArray()) {
                if (stack.pop() != c) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Finds the largest index where the given value appears in the stack.
         * @param stack The stack to search.
         * @param k The value to find.
         * @return The largest index where k appears, or -1 if not found.
         */
        public static int findLargestK(Stack<Integer> stack, int k) {
            Stack<Integer> tempStack = new Stack<>();
            int index = -1;
            int position = 0; // Start from the bottom (index 0)

            while (!stack.isEmpty()) {
                int value = stack.pop();
                tempStack.push(value);
                if (value == k) {
                    index = position; // Keep updating to store the highest index
                }
                position++;
            }

            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop()); // Restore original stack
            }
            return index;
        }
    }

    public static int algorithmAnalysis1(int n, int m) {
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) a += Math.random();
        for (int j = 0; j < m; j++) b += Math.random();
        return 3; // O(N + M) time, O(1) space
    }

    public static int algorithmAnalysis2(int n) {
        int k = 0;
        for (int i = n / 2; i <= n; i++) {
            for (int j = 2; j <= n; j *= 2) {
                k += n / 2;
            }
        }
        return 2; // O(N log N) time complexity
    }
}
