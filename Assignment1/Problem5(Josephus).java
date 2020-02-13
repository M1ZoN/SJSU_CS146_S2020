package com.company;// Josephus.java: Takes N and M from the command line and prints out the order
// in which people are eliminated (and thus would show Josephus where to sit in 
// the circle).


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        Queue<Integer> it = new Queue<>();
        Queue<Integer> res = new Queue<>();

        for (int i = 0; i < n; i++)
            it.enqueue(i);


        while (!it.isEmpty()) {
            for (int i = 0; i < m; ++i) {
                if (i < m - 1)
                    it.enqueue(it.dequeue());
                else
                    res.enqueue(it.dequeue());
            }
        }

        while (!res.isEmpty())
            StdOut.print(res.dequeue() + " ");
    }
}
