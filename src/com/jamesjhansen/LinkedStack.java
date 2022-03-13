package com.jamesjhansen;

/**
 * linked implementation of stack ADT
 * @param <T> generically-typed
 */
public class LinkedStack<T> implements StackInterface<T> {

    /**
     * instance variables
     */
    private Node topNode;

    /**
     * default constructor
     */
    public LinkedStack() {
        topNode = null;
    }

    private class Node {
        /**
         * Node instance variables
         */
        private T data;
        private Node next;

        /**
         * Node constructor, data only
         */
        private Node(T dataPortion)
        {
            this(dataPortion, null);
        }

        /**
         * Node constructor, includes nextNode
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * Node getters and setters
         */
        private T getData() {
            return data;
        }

        private void setData(T newData) {
            data = newData;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
        }

    /**
     * adds new entry to the top of the stack
     * @param newEntry an object to be added to the stack
     */
    @Override
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    }

    /**
     * removes top entry from stack
     * @return the entry removed
     */
    @Override
    public T pop() {
        T top = peek();
        if (topNode != null)
            topNode = topNode.getNextNode();
        return top;
    }

    /**
     * retrieves data from top entry of stack
     * @return data associated with top entry
     */
    @Override
    public T peek() {
        T top = null;
        if (topNode != null)
            top = topNode.getData();
        return top;
    }

    /**
     * checks whether the stack is empty
     * @return true if stack empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * clears all entries from stack
     */
    @Override
    public void clear() {
        topNode = null;
    }
}
