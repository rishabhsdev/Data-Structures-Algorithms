package DataStructures.Queues;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack_a = new Stack<>();
    private Stack<Integer> stack_b = new Stack<>();

    public void add(int value) {
        stack_a.push(value);
    }

    public int peek() {

        while (!stack_a.isEmpty()) {
            stack_b.push(stack_a.pop());
        }

        return stack_b.peek();
    }

    public void remove() {
        while (!stack_a.isEmpty()) {
            stack_b.push(stack_a.pop());
        }

        stack_b.pop();

        while (!stack_b.isEmpty()) {
            stack_a.push(stack_b.pop());
        }
    }
}
