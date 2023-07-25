package stack;

import java.util.Stack;

public class Practice1 {
    public static void main(String[] args) {
        MyStack s = new MyStack();

        // Function calls
        s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
        s.getMin();
    }
}

class MyStack {
    Stack<Integer> s;
    Stack<Integer> minVals;
    Integer minEle;

    // Constructor
    MyStack() {
        s = new Stack<Integer>();
        minVals = new Stack<Integer>();
    }

    // Prints minimum element of MyStack
    void getMin()
    {
        // Get the minimum number in the entire stack
        if (s.isEmpty())
            System.out.println("Stack is empty");

            // variable minEle stores the minimum element
            // in the stack.
        else
            System.out.println("Minimum Element in the "
                    + " stack is: " + minEle);
    }

//     prints top element of MyStack
    void peek()
    {
        if (s.isEmpty()) {
            System.out.println("Stack is empty");
        }

        else {
            Integer t = s.peek(); // Top element.

            System.out.print("Top Most Element is: ");
            System.out.println(t);
        }
    }

    // Removes the top element from MyStack
    void pop()
    {
        if (s.isEmpty()) {
            System.out.println("Stack is empty");
        }

        System.out.print("Top Most Element Removed: ");
        Integer t = s.pop();

        // Minimum will change as the minimum element
        // of the stack is being removed.
        if (t.equals(minEle)) {
            minVals.pop();
            System.out.println(t);
            minEle = minVals.peek();
        }

        else
            System.out.println(t);
    }

    // Insert new number into MyStack
    void push(Integer x)
    {
        if (s.isEmpty()) {
            s.push(x);
            minVals.push(x);
            minEle = minVals.peek();
            System.out.println("Number Inserted: " + x);
            return;
        }

        // If new number is less than original minEle
        if (x < minEle) {
            s.push(x);
            minVals.push(x);
            minEle = minVals.peek();
        }

        else
            s.push(x);

        System.out.println("Number Inserted: " + x);
    }
};
