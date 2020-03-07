package com.company;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ScheduledExecutorService;

// Deque implementation using a linked list.
public class LinkedDeque<Item> implements Iterable<Item> {
    //CODE HERE
    //field data
    private Node first; // <= beginning of LinkedDequeue
    private Node last; // <= ending of LinkedDequeue
    private int size = 0; //number of elements in LinkedDequeue

    // Helper doubly-linked list class.
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // Construct an empty deque.
    public LinkedDeque() {
        //CODE HERE
        //initializing every field member to null
        first = null;
        last = null;
    }

    // Is the dequeue empty?
    public boolean isEmpty() {
        //CODE HERE
        //return true if size == 0
        return (size == 0);
    }

    // The number of items on the deque.
    public int size() {
        //CODE HERE
        return (size);
    }

    // Add item to the front of the deque.
    public void addFirst(Item item) {
        //CODE HERE
        // if it will be empty we are setting first and last pointers to that element
        // else pointer of first pointing to the new item, first starts pointing to new item
        // throw NullPointerException if user attempts to add null
        if (item == null)
            throw new NullPointerException("Error! Null item cannot be added");
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        newNode.prev = null;
        if (size == 0) {
            first = newNode;
            last = newNode;
        }
        else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
        assert check();
    }

    // Add item to the end of the deque.
    public void addLast(Item item) {
        //CODE HERE
        // same technique as with adding to first but now we using last
        if (item == null)
            throw new NullPointerException("Error! Null item cannot be added");
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        newNode.prev = null;
        if (size == 0) {
            first = newNode;
            last = newNode;
        }
        else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
        assert check();
    }

    // Remove and return item from the front of the deque.
    public Item removeFirst() {
        //CODE HERE
        // removes first and sets first to the next of first
        if (this.isEmpty())
            throw new NoSuchElementException("Error! Removing from empty LinkedQueue is unavailable!");
        Item res = first.item;
        if (size == 1) {
            first = null;
            last = null;
        }
        else {
            
        }
    }

    // Remove and return item from the end of the deque.
    public Item removeLast() {
        //CODE HERE
    }

    // An iterator over items in the queue in order from front to end.
    public Iterator<Item> iterator() {
        //CODE HERE
    }
    
    // An iterator, doesn't implement remove() since it's optional.
    private class DequeIterator implements Iterator<Item> {
        //CODE HERE
        
        DequeIterator() {
            //CODE HERE
        }

        public boolean hasNext()  { ... }

        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            //CODE HERE
        }
    }

    // A string representation of the deque.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString().substring(0, s.length() - 1);
    }
    
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        LinkedDeque<Character> deque = new LinkedDeque<Character>();
        String quote = "There is grandeur in this view of life, with its " 
            + "several powers, having been originally breathed into a few " 
            + "forms or into one; and that, whilst this planet has gone " 
            + "cycling on according to the fixed law of gravity, from so " 
            + "simple a beginning endless forms most beautiful and most " 
            + "wonderful have been, and are being, evolved. ~ " 
            + "Charles Darwin, The Origin of Species";
        int r = StdRandom.uniform(0, quote.length());
        for (int i = quote.substring(0, r).length() - 1; i >= 0; i--) {
            deque.addFirst(quote.charAt(i));
        }
        for (int i = 0; i < quote.substring(r).length(); i++) {
            deque.addLast(quote.charAt(r + i));
        }
        StdOut.println(deque.isEmpty());
        StdOut.printf("(%d characters) ", deque.size());
        for (char c : deque) {
            StdOut.print(c);
        }
        StdOut.println();
        double s = StdRandom.uniform();
        for (int i = 0; i < quote.length(); i++) {
            if (StdRandom.bernoulli(s)) {
                deque.removeFirst();
            }
            else {
                deque.removeLast();
            }
        }
        StdOut.println(deque.isEmpty());
    }
}
