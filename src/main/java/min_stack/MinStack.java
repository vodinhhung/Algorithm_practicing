package min_stack;

import java.util.ArrayDeque;
import java.util.Deque;
public class MinStack {

    /** initialize your data structure here. */
    Deque<Integer> min;
    Deque<Integer> stack;
    public MinStack() {
        this.min = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() > x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
        if (!min.isEmpty()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}