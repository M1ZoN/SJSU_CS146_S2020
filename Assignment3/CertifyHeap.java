package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CertifyHeap {
    // Return true of v is less than w and false otherwise.
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // Return true if a[] represents a maximum-ordered heap and false 
    // otherwise. Remember to index from 1.
    private static boolean maxOrderedHeap(Comparable[] a) {
        int len = a.length;
        boolean res = true;

        for(int i = 0 ; i <= ((len - 2) / 2); i++) {
            if ((2 * i + 2 < len && less(a[i], a[2 * i + 1])))
                res = false;
            if (2 * i + 2 < len && less(a[i], a[2 * i + 2]))
                res = false;
        }
        return res;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        StdOut.println(maxOrderedHeap(a));
    }
}
