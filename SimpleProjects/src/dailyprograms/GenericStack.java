package dailyprograms;

import java.util.ArrayList;

public class GenericStack<T> {
    private ArrayList<T> stack; // Using ArrayList for dynamic sizing

    public GenericStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        
        System.out.println("Top item: " + intStack.peek()); // Should print 3
        System.out.println("Stack size: " + intStack.size()); // Should print 3
        
        System.out.println("Popped item: " + intStack.pop()); // Should print 3
        System.out.println("Is stack empty? " + intStack.isEmpty()); // Should print false
    }
}