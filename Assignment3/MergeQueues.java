package com.company;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class MergeQueues {
    // Return true if v is less than w and false otherwise.
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Merge and return the two sorted queues as a single sorted queue.
    private static Queue<Comparable> merge(Queue<Comparable> q1,
                                           Queue<Comparable> q2) {
        Queue<Comparable> res = new Queue<>();

        while(!q1.isEmpty() || !q2.isEmpty()) {
            if(q1.isEmpty())  res.enqueue(q2.dequeue());
            else if(q2.isEmpty()) res.enqueue(q1.dequeue());
            else if(q1.peek().compareTo(q2.peek()) < 0)
                res.enqueue(q1.dequeue());
            else
                res.enqueue(q2.dequeue());
        }
        return res;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", 
                      "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
                      "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Queue<Comparable> q1 = new Queue<Comparable>();
        Queue<Comparable> q2 = new Queue<Comparable>();
        for (String s : a) {
            if (StdRandom.bernoulli(0.5)) {
                q1.enqueue(s);
            }
            else {
                q2.enqueue(s);
            }
        }
        int s1 = q1.size(), s2 = q2.size();
        StdOut.println(merge(q1, q2));
        assert q1.size() == s1 && q2.size() == s2;
    }
}
