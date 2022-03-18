package com.jamesjhansen;

import java.util.Arrays;

/**
 * resizeable array implementation of stack ADT
 * @param <T> generically-typed
 */
public class ArrayStack<T> implements StackInterface<T> {

    /**
     * instance variables
     */
    private T[] stack; // array of stack entries
    private int topIndex; // index of top entry
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    /**
     * default constructor
     */
    public ArrayStack() { this(DEFAULT_INITIAL_CAPACITY); }

    /**
     * parameterized constructor
     * @param initialCapacity capacity of new array
     */
    public ArrayStack(int initialCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
    }

    /**
     * doubles capacity of array if full
     */
    private void ensureCapacity()
    {
        if (topIndex == stack.length - 1)
            stack = Arrays.copyOf(stack, 2 * stack.length);
    }

    /**
     * adds new entry to the top of the stack
     * @param newEntry an object to be added to the stack
     */
    @Override
    public void push(T newEntry) {
        ensureCapacity();
        topIndex++;
        stack[topIndex] = newEntry;
    }

    /**
     * removes top entry from stack
     * @return the entry removed
     */
    @Override
    public T pop() {
        T top = null;
        if (!isEmpty()) {
            top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
        }
        return top;
    }

    /**
     * retrieves data from top entry of stack
     * @return data associated with top entry
     */
    @Override
    public T peek() {
        T top = null;
        if (!isEmpty())
            top = stack[topIndex];
        return top;
    }

    /**
     * checks whether the stack is empty
     * @return true if stack empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    /**
     * clears all entries from stack
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    /**
     * pretty-prints stack contents
     */
    @Override
    public String toString() {
        String output = "";
        if (!isEmpty()) {
            for (int i=0; i<this.stack.length; i++) {
                if (this.stack[i] != null)
                    output += this.stack[i] + ", ";
            }
        } else
            System.out.println("Stack empty");

        return output;
    }
}
