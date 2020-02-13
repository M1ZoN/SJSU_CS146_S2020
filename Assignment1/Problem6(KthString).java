package com.company;// KthString.java: Takes a command-line argument k and prints
// the kth string from the end found on standard input, 
// assuming that standard input has k or more strings.

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KthString {
    public static void main(String[] args) {
        int k = Integer.parseInt(StdIn.readLine());
        Queue<String>input = new Queue<>();
        boolean finish = false;
        String res = "";

        String[] in = StdIn.readLine().split(" ");

        for (int i = 0; i < in.length; i++)
            input.enqueue(in[i]);

        int p = input.size() - k;

        for (int i = 0; !finish; i++) {
            res = input.dequeue();
            if (i == p - 1)
                finish = true;
        }

        StdOut.println(res);
    }
}
